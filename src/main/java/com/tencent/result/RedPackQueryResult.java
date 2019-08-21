package com.tencent.result;

import com.tencent.protocol.red_backage_protocol.RedPackQueryResData;

/**
 * Created by WANGHJ on 2019-03-12.
 */
public class RedPackQueryResult extends Result {

    private RedPackQueryResData resData;

    public RedPackQueryResData getResData() {
        return resData;
    }

    public void setResData(RedPackQueryResData resData) {
        this.resData = resData;
    }

    public boolean isSuccess() {
        if (ResultStatus.SUCCESS.equals(status)){
            return true;
        }
        return false;
    }
}
