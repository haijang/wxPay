package com.tencent.protocol.reverse_protocol;

import com.tencent.protocol.BaseResData;

/**
 * User: rizenguo
 * Date: 2014/10/25
 * Time: 16:43
 */
public class ReverseResData extends BaseResData{



    //协议返回的具体数据（以下字段在return_code 为SUCCESS 的时候有返回）
    private String err_code = "";

    private String sign = "";
    private String appid = "";
    private String mch_id = "";
    private String nonce_str = "";

    private String recall = "";

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
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

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getRecall() {
        return recall;
    }

    public void setRecall(String recall) {
        this.recall = recall;
    }

    @Override
    public boolean isSuccess() {
        if("FAIL".equals(this.getReturn_code())){
            return false;
        }else{
            if("FAIL".equals(this.getResult_code())){
                return false;
            }else{
                return true;
            }
        }
    }
}
