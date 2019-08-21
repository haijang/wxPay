package com.tencent.protocol.unifiedorder_protocol;

import com.google.gson.annotations.SerializedName;
import com.tencent.common.RandomStringGenerator;
import com.tencent.protocol.BaseReqData;

import java.util.Date;

/**
 * Created by WANGHJ on 2017-05-16.
 * 微信JS发起的支付的请求封装类
 */
public class JSReqData {

    private String appId;

    private String timeStamp;

    private String nonceStr;

    private String signType="MD5";

    @SerializedName("package")
    private String packages;

    private String paySign;


    public boolean verify() {
        return true;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getNonceStr() {
        return nonceStr;
    }

    public void setNonceStr(String nonceStr) {
        this.nonceStr = nonceStr;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getPackages() {
        return packages;
    }

    public void setPackages(String packages) {
        this.packages = packages;
    }

    public String getPaySign() {
        return paySign;
    }

    public void setPaySign(String paySign) {
        this.paySign = paySign;
    }
}
