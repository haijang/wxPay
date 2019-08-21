package com.tencent.business;

import com.tencent.common.Configure;
import com.tencent.common.HttpsRequest;
import com.tencent.common.Util;
import com.tencent.protocol.pay_protocol.ScanPayReqData;
import com.tencent.protocol.pay_protocol.ScanPayResData;
import com.tencent.protocol.pay_query_protocol.ScanPayQueryReqData;
import com.tencent.protocol.pay_query_protocol.ScanPayQueryResData;
import com.tencent.protocol.reverse_protocol.ReverseReqData;
import com.tencent.protocol.reverse_protocol.ReverseResData;
import com.tencent.result.ResultStatus;
import com.tencent.result.ScanPayResult;
import com.tencent.service.IServiceRequest;
import com.tencent.service.ReverseService;
import com.tencent.service.ScanPayQueryService;
import com.tencent.service.ScanPayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by WANGHJ on 2017-03-25.
 */
public class SanSanScanPayBusiness {

    private ScanPayService scanPayService;

    private ScanPayQueryService scanPayQueryService;

    private ReverseService reverseService;

    private static final Logger log = LoggerFactory.getLogger(SanSanScanPayBusiness.class);

    public SanSanScanPayBusiness(IServiceRequest serviceRequest) {
        scanPayService = new ScanPayService(serviceRequest);
        scanPayQueryService = new ScanPayQueryService(serviceRequest);
        reverseService = new ReverseService(serviceRequest);
    }


    public ScanPayResult tradePay(ScanPayReqData reqData){
        ScanPayResult result = new ScanPayResult();
        String outTradeNo = reqData.getOut_trade_no();//商户订单号
        String subMchId = reqData.getSub_mch_id();//子商户号
        String responString = scanPayService.request(reqData);
        ScanPayResData resData = (ScanPayResData) Util.getObjectFromXML(responString,ScanPayResData.class);
        if(resData == null){//一般表示连接超时,支付状态未知
            return this.checkPayResult(result,subMchId,outTradeNo);
        }
        if(resData.isReturnSuccess()){//首先判断是否通信成功,
            if(resData.isSuccess()){//如果业务也成功
                result.setStatus(ResultStatus.SUCCESS);
                result.setMsg("支付成功");
                result.setScanPayResData(resData);
                return result;
            }else{//resultCode为FAIL的时候
                if(resData.payFail()){//如果明确支付已经失败
                    result.setStatus(ResultStatus.FAIL);
                    result.setMsg(resData.getErr_code_des());
                    result.setScanPayResData(resData);
                    return result;
                }else{//支付状态未知
                    return this.checkPayResult(result,subMchId,outTradeNo);
                }
            }
        }else{
            result.setStatus(ResultStatus.FAIL);
            result.setMsg(resData.getReturn_msg());
            result.setScanPayResData(resData);
            return result;
        }
    }

    /**
     * 支付状态未知的情况下,进行循环查询。根据查询结果判断是否要做撤销动作
     * @param result
     * @param subMchId
     * @param outTradeNo
     * @return
     */
    private ScanPayResult checkPayResult(ScanPayResult result,String subMchId,String outTradeNo){
        ScanPayQueryResData queryResData = this.doLoopQuery(subMchId,outTradeNo);
        if(queryResData != null && queryResData.isPaySuccess()){
            result.setStatus(ResultStatus.SUCCESS);
            result.setMsg("支付成功");
            return result;
        }else{//如果查询到支付状态为失败,做撤销
            if(this.loopDoReverse(subMchId,outTradeNo)){
                result.setStatus(ResultStatus.CANCEL);
                result.setMsg("支付失败,已经撤销");
                return result;
            }else{
                result.setStatus(ResultStatus.UNKNOW);
                result.setMsg("支付失败,撤销失败");
                return result;
            }
        }
    }


    /**
     * 循环撤销
     * @param subMchId
     * @param outTradeNo
     * @return
     */
    private boolean loopDoReverse(String subMchId,String outTradeNo){
        for (int i=0;i<Configure.maxReverseRetry;i++){
            sleep(Configure.reverseDuration);
            if(doOneReverse(subMchId,outTradeNo)){
                return true;
            }
        }
        return false;
    }


    /**
     * 撤销是否成功
     * @param subMchId
     * @param outTradeNo
     * @return
     */
    private boolean doOneReverse(String subMchId,String outTradeNo){
        ReverseReqData reverseReqData = new ReverseReqData("",outTradeNo,subMchId);
        String reverseResponseString =  reverseService.request(reverseReqData);
        ReverseResData reverseResData = (ReverseResData) Util.getObjectFromXML(reverseResponseString, ReverseResData.class);
        if(reverseResData == null){
            return false;
        }else{
            return reverseResData.isSuccess();
        }
    }

    /**
     * 循环查询
     * @param subMchId
     * @param outTradeNo
     * @return
     */
    private ScanPayQueryResData doLoopQuery(String subMchId,String outTradeNo){
        ScanPayQueryResData resData = null;
        for(int i=0;i< Configure.maxQueryRetry;i++){
            sleep(Configure.queryDuration);//休眠一会
            resData = this.tradeQuery(subMchId,outTradeNo);
            if(resData != null && !"USERPAYING".equals(resData.getTrade_state())){//如果查询到状态不为等待支付则返回
                break;
            }
        }
        return resData;
    }

    /**
     * 休眠当前线程
     * @param time
     */
    private void sleep(Long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 查询支付状态
     * @param subMchId
     * @param outTradeNo
     * @return
     */
    private ScanPayQueryResData tradeQuery(String subMchId,String outTradeNo){
        ScanPayQueryReqData reqData=new ScanPayQueryReqData("",outTradeNo,subMchId);
        ScanPayQueryResData  resData = (ScanPayQueryResData) Util.getObjectFromXML(scanPayQueryService.request(reqData),ScanPayQueryResData.class);
        return resData;
    }


}
