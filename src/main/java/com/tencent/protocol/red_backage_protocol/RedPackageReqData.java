package com.tencent.protocol.red_backage_protocol;

import com.tencent.protocol.BaseReqData;

import java.util.UUID;

/**
 * Created by WANGHJ on 2018-11-08.
 */
public class RedPackageReqData extends BaseReqData {

    private String nonce_str;

    private String mch_billno;

    private String wxappid;

    private String sub_mch_id;

    private String msgappid;

    private String send_name;

    private String re_openid;

    private String total_amount;

    private String total_num="1";

    private String wishing="大吉大利,今晚吃鸡";

    private String client_ip="127.0.0.1";

    private String act_name;

    private String remark;

    private String scene_id="PRODUCT_5";

    public String getScene_id() {
        return scene_id;
    }

    public void setScene_id(String scene_id) {
        this.scene_id = scene_id;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getMch_billno() {
        return mch_billno;
    }

    public void setMch_billno(String mch_billno) {
        this.mch_billno = mch_billno;
        this.nonce_str = mch_billno;
    }

    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
    }

    public String getMsgappid() {
        return msgappid;
    }

    public void setMsgappid(String msgappid) {
        this.msgappid = msgappid;
    }

    public String getWxappid() {
        return wxappid;
    }

    public void setWxappid(String wxappid) {
        this.wxappid = wxappid;
    }

    public String getSend_name() {
        return send_name;
    }

    public void setSend_name(String send_name) {
        this.send_name = send_name;
    }

    public String getRe_openid() {
        return re_openid;
    }

    public void setRe_openid(String re_openid) {
        this.re_openid = re_openid;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }

    public String getTotal_num() {
        return total_num;
    }

    public void setTotal_num(String total_num) {
        this.total_num = total_num;
    }

    public String getWishing() {
        return wishing;
    }

    public void setWishing(String wishing) {
        this.wishing = wishing;
    }

    public String getClient_ip() {
        return client_ip;
    }

    public void setClient_ip(String client_ip) {
        this.client_ip = client_ip;
    }

    public String getAct_name() {
        return act_name;
    }

    public void setAct_name(String act_name) {
        this.act_name = act_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean verify() {
        return false;
    }
}
