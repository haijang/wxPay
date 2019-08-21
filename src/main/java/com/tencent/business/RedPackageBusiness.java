package com.tencent.business;

import com.tencent.common.Util;
import com.tencent.protocol.red_backage_protocol.RedPackageReqData;
import com.tencent.protocol.red_backage_protocol.RedPackageResData;
import com.tencent.protocol.refund_protocol.RefundReqData;
import com.tencent.protocol.refund_protocol.RefundResData;
import com.tencent.result.RedPackageResult;
import com.tencent.result.RefundResult;
import com.tencent.result.ResultStatus;
import com.tencent.service.IServiceRequest;
import com.tencent.service.RedPackageService;
import com.tencent.service.RefundService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by WANGHJ on 2018-11-08.
 */
public class RedPackageBusiness {
    public RedPackageBusiness(IServiceRequest serviceRequest){
        redPackageService = new RedPackageService(serviceRequest);
    }

    private static final Logger logger = LoggerFactory.getLogger(RefundBusiness.class);

    private RedPackageService redPackageService;

    /**
     * 发红包请求
     * @param redPackageReqData 这个数据对象里面包含了API要求提交的各种数据字段
     *
     */
    public RedPackageResult run(RedPackageReqData redPackageReqData){
        RedPackageResult result = new RedPackageResult();
        String resString = redPackageService.request(redPackageReqData);
        RedPackageResData resData = (RedPackageResData) Util.getObjectFromXML(resString,RedPackageResData.class);
        if(resData==null){
            result.setStatus(ResultStatus.UNKNOW);
            result.setMsg("系统未知错误");
        }else{
            if(resData.isSuccess()){
                result.setStatus(ResultStatus.SUCCESS);
                result.setMsg("发送成功");
            }else{
                result.setStatus(ResultStatus.FAIL);
                result.setMsg(resData.getErrMsg());
            }
        }
        return result;

    }

    public void setRefundService(RedPackageService service) {
        redPackageService = service;
    }
}
