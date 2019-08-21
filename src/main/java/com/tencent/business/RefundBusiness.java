package com.tencent.business;

import com.tencent.common.Util;
import com.tencent.protocol.BaseResData;
import com.tencent.protocol.refund_protocol.RefundReqData;
import com.tencent.protocol.refund_protocol.RefundResData;
import com.tencent.result.RefundResult;
import com.tencent.result.ResultStatus;
import com.tencent.service.IServiceRequest;
import com.tencent.service.RefundService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * User: rizenguo
 * Date: 2014/12/2
 * Time: 17:51
 */
public class RefundBusiness {

    public RefundBusiness(IServiceRequest serviceRequest){
        refundService = new RefundService(serviceRequest);
    }

    private static final Logger logger = LoggerFactory.getLogger(RefundBusiness.class);

    private RefundService refundService;

    /**
     * 调用退款业务逻辑
     * @param refundReqData 这个数据对象里面包含了API要求提交的各种数据字段
     *
     */
    public RefundResult run(RefundReqData refundReqData){
        RefundResult result = new RefundResult();
        String resString = refundService.request(refundReqData);
        RefundResData resData = (RefundResData) Util.getObjectFromXML(resString,RefundResData.class);
        if(resData==null){
            result.setStatus(ResultStatus.UNKNOW);
            result.setMsg("请求失败,请在5秒后在发起退款请求");
        }else{
            if(resData.isSuccess()){
                result.setStatus(ResultStatus.SUCCESS);
                result.setMsg("退款成功");
            }else{
                result.setStatus(ResultStatus.FAIL);
                result.setMsg(resData.getErrMsg());
            }
        }
        return result;

    }

    public void setRefundService(RefundService service) {
        refundService = service;
    }


}
