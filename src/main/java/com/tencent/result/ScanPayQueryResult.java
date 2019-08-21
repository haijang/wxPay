package com.tencent.result;

import com.tencent.protocol.pay_query_protocol.ScanPayQueryResData;

/**
 * Created by WANGHJ on 2017-03-28.
 */
public class ScanPayQueryResult extends Result {

    /**
     * 查询的响应数据
     */
    private ScanPayQueryResData scanPayQueryResData;

    public ScanPayQueryResData getScanPayQueryResData() {
        return scanPayQueryResData;
    }

    public void setScanPayQueryResData(ScanPayQueryResData scanPayQueryResData) {
        this.scanPayQueryResData = scanPayQueryResData;
    }
}
