package com.tencent.protocol.red_backage_protocol;

import com.tencent.protocol.BaseReqData;

/**
 * Created by WANGHJ on 2019-03-11.
 */
public class RedPackQueryReqData extends BaseReqData {

    private String nonce_str;

    private String mch_billno;

    private String bill_type="MCHT";

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
    }

    public String getBill_type() {
        return bill_type;
    }

    public void setBill_type(String bill_type) {
        this.bill_type = bill_type;
    }

    public boolean verify() {
        return false;
    }
}
