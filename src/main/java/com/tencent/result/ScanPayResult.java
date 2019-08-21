package com.tencent.result;

import com.tencent.protocol.pay_protocol.ScanPayResData;

/**
 * Created by WANGHJ on 2017-03-24.
 */
public class ScanPayResult extends Result {


    private ScanPayResData scanPayResData;


    public ScanPayResData getScanPayResData() {
        return scanPayResData;
    }

    public void setScanPayResData(ScanPayResData scanPayResData) {
        this.scanPayResData = scanPayResData;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("ScanPayResult{");
        sb.append("scanPayResData=").append(scanPayResData);
        sb.append('}');
        return sb.toString();
    }
}
