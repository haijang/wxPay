package com.tencent.service;

import com.tencent.exception.WXPayException;
import com.tencent.protocol.getsignkey_protocol.GetsignKeyReqData;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

/**
 * Created by WANGHJ on 2017-03-21.
 */
public class GetsignKeyService extends BaseService {

    public GetsignKeyService(String api) {
        super(api);
    }

    public GetsignKeyService(String api,IServiceRequest serviceRequest) {
        super(api,serviceRequest);
    }

    /**
     * 请求沙箱密钥服务
     * @param getsignKeyReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的XML数据
     * @throws Exception
     */
    public String request(GetsignKeyReqData getsignKeyReqData){

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(getsignKeyReqData);

        return responseString;
    }
}
