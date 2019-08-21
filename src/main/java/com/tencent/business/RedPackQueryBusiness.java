package com.tencent.business;

import com.tencent.common.Util;
import com.tencent.protocol.red_backage_protocol.RedPackQueryReqData;
import com.tencent.protocol.red_backage_protocol.RedPackQueryResData;
import com.tencent.protocol.refund_protocol.RefundResData;
import com.tencent.result.RedPackQueryResult;
import com.tencent.result.ResultStatus;
import com.tencent.service.IServiceRequest;
import com.tencent.service.RedPackageQueryService;

/**
 * Created by WANGHJ on 2019-03-12.
 */
public class RedPackQueryBusiness {

    private RedPackageQueryService redPackageQueryService;

    public RedPackQueryBusiness(IServiceRequest serviceRequest){
        redPackageQueryService = new RedPackageQueryService(serviceRequest);
    }

    public RedPackQueryResult run(RedPackQueryReqData redPackQueryReqData){
        RedPackQueryResult result = new RedPackQueryResult();
        String resString = redPackageQueryService.request(redPackQueryReqData);
        RedPackQueryResData resData = (RedPackQueryResData) Util.getObjectFromXML(resString,RedPackQueryResData.class);
        if(resData==null){
            result.setStatus(ResultStatus.UNKNOW);
            result.setMsg("系统未知错误");
        }else{
            if(resData.isSuccess()){
                result.setStatus(ResultStatus.SUCCESS);
                result.setMsg("查询成功");
            }else{
                result.setStatus(ResultStatus.FAIL);
                result.setMsg(resData.getErrMsg());
            }
        }
        result.setResData(resData);
        return result;

    }
}
