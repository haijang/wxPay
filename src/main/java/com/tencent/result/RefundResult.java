package com.tencent.result;

import com.tencent.protocol.refund_protocol.RefundResData;

/**
 * Created by WANGHJ on 2017-03-24.
 */
public class RefundResult extends Result{

    /**
     * 响应数据
     */
    private RefundResData resData;

    public RefundResData getResData() {
        return resData;
    }

    public void setResData(RefundResData resData) {
        this.resData = resData;
    }

    public boolean isSuccess() {
        if (resData !=  null && ResultStatus.SUCCESS.equals(status)){
            return true;
        }
        return false;
    }



}
