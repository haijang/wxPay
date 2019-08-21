package com.tencent.service;

import com.tencent.common.Configure;
import com.tencent.protocol.red_backage_protocol.RedPackQueryReqData;

/**
 * Created by WANGHJ on 2019-03-11.
 */
public class RedPackageQueryService extends BaseService {
    public RedPackageQueryService(String api) {
        super(api);
    }

    public RedPackageQueryService(IServiceRequest serviceRequest) {
        super(Configure.QUERY_RED_PACKAGE, serviceRequest);
    }

    public String request(RedPackQueryReqData redPackageReqData){

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(redPackageReqData,false);
        return responseString;
    }
}
