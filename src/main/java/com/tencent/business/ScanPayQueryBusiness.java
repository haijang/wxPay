package com.tencent.business;

import com.tencent.common.Util;
import com.tencent.protocol.pay_query_protocol.ScanPayQueryReqData;
import com.tencent.protocol.pay_query_protocol.ScanPayQueryResData;
import com.tencent.result.ResultStatus;
import com.tencent.result.ScanPayQueryResult;
import com.tencent.service.IServiceRequest;
import com.tencent.service.ScanPayQueryService;

/**
 * Created by WANGHJ on 2017-03-28.
 */
public class ScanPayQueryBusiness {


    private ScanPayQueryService scanPayQueryService;

    public ScanPayQueryBusiness(IServiceRequest serviceRequest) {
        this.scanPayQueryService = new ScanPayQueryService(serviceRequest);
    }

    public ScanPayQueryResult run(ScanPayQueryReqData scanPayQueryReqData){
        ScanPayQueryResult result = new ScanPayQueryResult();
        String resString =  this.scanPayQueryService.request(scanPayQueryReqData);
        ScanPayQueryResData resData = (ScanPayQueryResData) Util.getObjectFromXML(resString,ScanPayQueryResData.class);
        if(resData == null){
            result.setStatus(ResultStatus.UNKNOW);
            result.setMsg("请求失败,请过5秒后再发起请求");
        }else{
            if(resData.isSuccess()){
                result.setStatus(ResultStatus.SUCCESS);
                result.setMsg("查询成功");
                result.setScanPayQueryResData(resData);
            }else{
                result.setStatus(ResultStatus.FAIL);
                result.setMsg(resData.getErrMsg());
            }
        }
        return result;
    }

}
