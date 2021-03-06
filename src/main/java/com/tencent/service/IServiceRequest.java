package com.tencent.service;

import com.tencent.protocol.BaseReqData;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.util.Map;

/**
 * User: rizenguo
 * Date: 2014/12/10
 * Time: 15:16
 * 这里定义服务层需要请求器标准接口
 */
public interface IServiceRequest {

    //Service依赖的底层https请求器必须实现这么一个接口
    public String sendPost(String api_url, BaseReqData xmlObj);

    public String sendPost(String url, BaseReqData xmlObj,Boolean checkSign);

    public String sendPostWithoutCheckSign(String apiUrl,BaseReqData xmlObj);

    //签名
    public String sign(Map<String,String> map);

    //验证签名
    public Boolean checkSign(String content);

}
