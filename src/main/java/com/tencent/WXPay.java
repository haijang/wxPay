package com.tencent;

import com.tencent.business.RedPackQueryBusiness;
import com.tencent.business.RedPackageBusiness;
import com.tencent.business.RefundBusiness;
import com.tencent.business.ReverseBusiness;
import com.tencent.business.SanSanScanPayBusiness;
import com.tencent.business.ScanPayQueryBusiness;
import com.tencent.business.UnifiedorderBusiness;
import com.tencent.common.Configure;
import com.tencent.common.HttpsRequest;
import com.tencent.protocol.pay_protocol.ScanPayReqData;
import com.tencent.protocol.pay_query_protocol.ScanPayQueryReqData;
import com.tencent.protocol.red_backage_protocol.RedPackQueryReqData;
import com.tencent.protocol.red_backage_protocol.RedPackageReqData;
import com.tencent.protocol.refund_protocol.RefundReqData;
import com.tencent.protocol.reverse_protocol.ReverseReqData;
import com.tencent.protocol.unifiedorder_protocol.UnifiedorderReqData;
import com.tencent.result.RedPackQueryResult;
import com.tencent.result.RedPackageResult;
import com.tencent.result.RefundResult;
import com.tencent.result.ReverseResult;
import com.tencent.result.ScanPayQueryResult;
import com.tencent.result.ScanPayResult;
import com.tencent.result.UnifiedorderResult;

/**
 * 微信支付SDK总入口
 */
public class WXPay {

    /**
     * 支付
     */
    private SanSanScanPayBusiness scanPayBusiness;

    /**
     * 撤单
     */
    private ReverseBusiness reverseBusiness;

    /**
     * 退款
     */
    private RefundBusiness refundBusiness;


    /**
     * 查询
     */
    private ScanPayQueryBusiness scanPayQueryBusiness;

    /**
     *预下单
     */
    private UnifiedorderBusiness unifiedorderBusiness;

    /**
     * 发送红包
     */
    private RedPackageBusiness redPackageBusiness;

    /**
     * 查询红包
     */
    private RedPackQueryBusiness redPackQueryBusiness;

    private HttpsRequest httpsRequest;


    /**
     * 初始化SDK依赖的几个关键配置
     * @param key 签名算法需要用到的秘钥
     * @param appID 公众账号ID
     * @param mchID 商户ID
     * @param certLocalPath HTTP证书在服务器中的路径，用来加载证书用
     * @param certPassword HTTP证书的密码，默认等于MCHID
     * @param isDebug 是否调试模式
     */
    public  void init(String key,String appID,String mchID,String certLocalPath,String certPassword,boolean isDebug){
        Configure.ISDEBUG = isDebug;
        httpsRequest = new HttpsRequest(certLocalPath,certPassword,key,appID,mchID);
        scanPayBusiness = new SanSanScanPayBusiness(httpsRequest);
        reverseBusiness = new ReverseBusiness(httpsRequest);
        refundBusiness = new RefundBusiness(httpsRequest);
        scanPayQueryBusiness = new ScanPayQueryBusiness(httpsRequest);
        unifiedorderBusiness = new UnifiedorderBusiness(httpsRequest);
        redPackageBusiness = new RedPackageBusiness(httpsRequest);
        redPackQueryBusiness = new RedPackQueryBusiness(httpsRequest);

    }


    private boolean isEmpty(String s){
        if(s==null || "".equals(s)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 支付
     * @param scanPayReqData
     * @return
     */
    public ScanPayResult scanPay(ScanPayReqData scanPayReqData){
        return scanPayBusiness.tradePay(scanPayReqData);
    }

    /**
     * 撤销
     * @param reverseReqData
     * @return
     */
    public ReverseResult reverse(ReverseReqData reverseReqData){

        return reverseBusiness.reverse(reverseReqData);
    }

    /**
     * 退款
     * @param refundReqData
     * @return
     */
    public RefundResult refund(RefundReqData refundReqData){
        return refundBusiness.run(refundReqData);
    }

    /**
     * 查询
     * @param scanPayQueryReqData
     * @return
     */
    public ScanPayQueryResult query(ScanPayQueryReqData scanPayQueryReqData){
        return scanPayQueryBusiness.run(scanPayQueryReqData);
    }

    public UnifiedorderResult unifiedorder(UnifiedorderReqData unifiedorderReqData){
        return unifiedorderBusiness.run(unifiedorderReqData);
    }

    public RedPackageResult sendRedPackage(RedPackageReqData redPackageReqData){
        return redPackageBusiness.run(redPackageReqData);
    }

    public RedPackQueryResult queryRedPakcageStatus(RedPackQueryReqData queryReqData){
        return redPackQueryBusiness.run(queryReqData);
    }

    /**
     *
     */
    public boolean  checkSign(String content){
       return  httpsRequest.checkSign(content);
    }

}
