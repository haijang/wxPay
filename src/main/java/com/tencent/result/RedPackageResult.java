package com.tencent.result;

import com.tencent.protocol.red_backage_protocol.RedPackageResData;

/**
 * Created by WANGHJ on 2018-11-08.
 */
public class RedPackageResult extends Result {

    /**
     * 响应数据
     */
    private RedPackageResData resData;

    public RedPackageResData getResData() {
        return resData;
    }

    public void setResData(RedPackageResData resData) {
        this.resData = resData;
    }

    public boolean isSuccess() {
        if (ResultStatus.SUCCESS.equals(status)){
            return true;
        }
        return false;
    }
}
