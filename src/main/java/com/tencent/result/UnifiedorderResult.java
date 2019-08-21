package com.tencent.result;

import com.tencent.protocol.unifiedorder_protocol.JSReqData;
import com.tencent.protocol.unifiedorder_protocol.UnifiedorderResData;

/**
 * Created by WANGHJ on 2017-04-23.
 */
public class UnifiedorderResult extends Result {

    private UnifiedorderResData unifiedorderResData;

    /**
     * 当预下单中得trade_type为JSAPI时用jsReqData中得参数发起交易
     */
    private JSReqData jsReqData;

    public UnifiedorderResData getUnifiedorderResData() {
        return unifiedorderResData;
    }

    public void setUnifiedorderResData(UnifiedorderResData unifiedorderResData) {
        this.unifiedorderResData = unifiedorderResData;
    }

    public JSReqData getJsReqData() {
        return jsReqData;
    }

    public void setJsReqData(JSReqData jsReqData) {
        this.jsReqData = jsReqData;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UnifiedorderResult{");
        sb.append("unifiedorderResData=").append(unifiedorderResData);
        sb.append(", jsReqData=").append(jsReqData);
        sb.append('}');
        return sb.toString();
    }
}
