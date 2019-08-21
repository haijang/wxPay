package com.tencent.protocol;

import com.tencent.common.Signature;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WANGHJ on 2017-03-23.
 */
public abstract class BaseReqData {

    /**
     * 签名
     */
    protected  String sign="";
    protected String appid="";
    protected String mch_id = "";
    protected String wxappid;

    public String getWxappid() {
        return wxappid;
    }

    public void setWxappid(String wxappid) {
        this.wxappid = wxappid;
    }

    public void sign(String key){
        //根据API给的签名规则进行签名
        String sign = Signature.getSign(this,key);
        setSign(sign);//把签名数据设置到Sign这个属性中
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    /**
     * 参数验证接口,子类自己实现属性的校验
     * @return
     */
    public abstract boolean verify();
}
