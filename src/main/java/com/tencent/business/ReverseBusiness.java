package com.tencent.business;

import com.tencent.common.Util;
import com.tencent.protocol.reverse_protocol.ReverseReqData;
import com.tencent.protocol.reverse_protocol.ReverseResData;
import com.tencent.result.ResultStatus;
import com.tencent.result.ReverseResult;
import com.tencent.service.IServiceRequest;
import com.tencent.service.ReverseService;

/**
 * Created by WANGHJ on 2017-03-27.
 * 撤销业务
 */
public class ReverseBusiness {

    private ReverseService reverseService;

    public ReverseBusiness(IServiceRequest serviceRequest){
        this.reverseService = new ReverseService(serviceRequest);
    }

    /**
     * 撤销
     * @param reverseReqData
     * @return
     */
    public ReverseResult reverse(ReverseReqData reverseReqData){
        ReverseResult result = new ReverseResult();
        String resString  = reverseService.request(reverseReqData);
        ReverseResData reverseResData = (ReverseResData) Util.getObjectFromXML(resString,ReverseResData.class);
        if(reverseResData == null){
            result.setStatus(ResultStatus.UNKNOW);
            result.setMsg("状态未知,请等待5秒后再发起撤销请求");
        }else{
            if(reverseResData.isSuccess()){
                result.setStatus(ResultStatus.SUCCESS);
                result.setMsg("撤销成功");
                result.setReverseResData(reverseResData);
            }else{
                result.setStatus(ResultStatus.FAIL);
                result.setMsg(reverseResData.getErrMsg());
                result.setReverseResData(reverseResData);
            }
        }
        return result;
    }



}
