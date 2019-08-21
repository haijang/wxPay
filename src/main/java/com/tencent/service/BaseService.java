package com.tencent.service;

import com.tencent.common.Configure;
import com.tencent.common.HttpsRequest;
import com.tencent.protocol.BaseReqData;
import com.tencent.protocol.BaseResData;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.Map;

/**
 * User: rizenguo
 * Date: 2014/12/10
 * Time: 15:44
 * 服务的基类
 */
public class BaseService{

    //API的地址
    private String apiURL;

    //发请求的HTTPS请求器
    private IServiceRequest serviceRequest;

    public BaseService(String api){
        if(!Configure.ISDEBUG){
            apiURL =Configure.BASE_PATH+ api;
        }else{
            apiURL =Configure.BASE_PATH+Configure.DEBUG_PATH+ api;
        }
    }

    public BaseService(String api,IServiceRequest serviceRequest){
        this(api);
        this.serviceRequest = serviceRequest;
    }

    protected String sendPost(BaseReqData xmlObj){
        return serviceRequest.sendPost(apiURL,xmlObj);
    }
    protected String sendPost(BaseReqData xmlObj,boolean checkSign){
        return serviceRequest.sendPost(apiURL,xmlObj,checkSign);
    }


    protected String sendPostWithoutCheckSign(BaseReqData xmlObj){
        return serviceRequest.sendPostWithoutCheckSign(apiURL,xmlObj);
    }

    /**
     * 供商户想自定义自己的HTTP请求器用
     * @param request 实现了IserviceRequest接口的HttpsRequest
     */
    public void setServiceRequest(IServiceRequest request){
        serviceRequest = request;
    }

    public String sign(Map<String,String> map){
       return  serviceRequest.sign(map);
    }

    public boolean checkSign(String content){
        return serviceRequest.checkSign(content);
    }
}
