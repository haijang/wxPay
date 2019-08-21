package com.tencent.protocol.red_backage_protocol;

import com.tencent.protocol.BaseResData;

/**
 * Created by WANGHJ on 2019-03-11.
 */
public class RedPackQueryResData extends BaseResData {

    /**
     * 红包单号
     */
    private String mch_billno;

    /**
     * 商户号
     */
    private String mch_id;

    /**
     * SENDING:发放中
     * SENT:已发放待领取
     * FAILED：发放失败
     * RECEIVED:已领取
     * RFUND_ING:退款中
     * REFUND:已退款
     */
    private String status;

    /**
     * 红包金额
     */
    private String total_amount;

    public String getMch_billno() {
        return mch_billno;
    }

    public void setMch_billno(String mch_billno) {
        this.mch_billno = mch_billno;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(String total_amount) {
        this.total_amount = total_amount;
    }
}
