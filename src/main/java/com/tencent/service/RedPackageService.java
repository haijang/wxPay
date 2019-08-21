package com.tencent.service;

import com.tencent.common.Configure;
import com.tencent.protocol.getsignkey_protocol.GetsignKeyReqData;
import com.tencent.protocol.red_backage_protocol.RedPackageReqData;

/**
 * Created by WANGHJ on 2018-11-08.
 */
public class RedPackageService extends BaseService {
    public RedPackageService(String api) {
        super(api);
    }

    public RedPackageService(IServiceRequest serviceRequest) {
        super(Configure.SEND_RED_PACKAGE, serviceRequest);
    }

    public String request(RedPackageReqData redPackageReqData){

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPostWithoutCheckSign(redPackageReqData);
        return responseString;
    }


}
