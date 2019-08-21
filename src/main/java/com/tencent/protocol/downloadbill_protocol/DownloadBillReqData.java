package com.tencent.protocol.downloadbill_protocol;

import com.tencent.common.RandomStringGenerator;
import com.tencent.protocol.BaseReqData;

/**
 * User: rizenguo
 * Date: 2014/10/25
 * Time: 16:48
 */
public class DownloadBillReqData extends BaseReqData{
    //每个字段具体的意思请查看API文档
    private String device_info = "";
    private String nonce_str = "";
    private String bill_date = "";
    private String bill_type = "";

    /**
     * 请求对账单下载服务
     * @param deviceInfo 商户自己定义的扫码支付终端设备号，方便追溯这笔交易发生在哪台终端设备上
     * @param billDate 下载对账单的日期，格式：yyyyMMdd 例如：20140603
     * @param billType 账单类型
     *                 ALL，返回当日所有订单信息，默认值
    SUCCESS，返回当日成功支付的订单
    REFUND，返回当日退款订单
    REVOKED，已撤销的订单
     */
    public DownloadBillReqData(String deviceInfo,String billDate,String billType){

        //商户自己定义的扫码支付终端设备号，方便追溯这笔交易发生在哪台终端设备上
        setDevice_info(deviceInfo);

        setBill_date(billDate);

        setBill_type(billType);


        //随机字符串，不长于32 位
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));

    }

    public String getDevice_info() {
        return device_info;
    }

    public void setDevice_info(String device_info) {
        this.device_info = device_info;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getBill_date() {
        return bill_date;
    }

    public void setBill_date(String bill_date) {
        this.bill_date = bill_date;
    }

    public String getBill_type() {
        return bill_type;
    }

    public void setBill_type(String bill_type) {
        this.bill_type = bill_type;
    }

    public boolean verify() {
        return true;
    }
}
