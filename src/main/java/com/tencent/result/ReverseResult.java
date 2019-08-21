package com.tencent.result;

import com.tencent.protocol.reverse_protocol.ReverseResData;

/**
 * Created by WANGHJ on 2017-03-27.
 * 撤销业务的结果
 */
public class ReverseResult extends Result{

    /**
     * 撤销接口的响应数据
     */
    private ReverseResData reverseResData;

    public ReverseResData getReverseResData() {
        return reverseResData;
    }

    public void setReverseResData(ReverseResData reverseResData) {
        this.reverseResData = reverseResData;
    }
}
