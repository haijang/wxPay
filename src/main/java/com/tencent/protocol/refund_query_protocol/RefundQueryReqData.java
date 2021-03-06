package com.tencent.protocol.refund_query_protocol;

import com.tencent.common.RandomStringGenerator;
import com.tencent.protocol.BaseReqData;

/**
 * User: rizenguo
 * Date: 2014/10/25
 * Time: 16:35
 */
public class RefundQueryReqData extends BaseReqData{
    //每个字段具体的意思请查看API文档
    private String device_info = "";
    private String nonce_str = "";
    private String transaction_id = "";
    private String out_trade_no = "";
    private String out_refund_no="";
    private String refund_id="";
    /**
     * 请求退款查询服务
     * @param transactionID 是微信系统为每一笔支付交易分配的订单号，通过这个订单号可以标识这笔交易，它由支付订单API支付成功时返回的数据里面获取到。建议优先使用
     * @param outTradeNo 商户系统内部的订单号,transaction_id 、out_trade_no 二选一，如果同时存在优先级：transaction_id>out_trade_no
     * @param deviceInfo 微信支付分配的终端设备号，与下单一致
     * @param outRefundNo 商户系统内部的退款单号，商户系统内部唯一，同一退款单号多次请求只退一笔
     * @param refundID 来自退款API的成功返回，微信退款单号refund_id、out_refund_no、out_trade_no 、transaction_id 四个参数必填一个，如果同事存在优先级为：refund_id>out_refund_no>transaction_id>out_trade_no
     */

    public RefundQueryReqData(String transactionID,String outTradeNo,String deviceInfo,String outRefundNo,String refundID){



        //transaction_id是微信系统为每一笔支付交易分配的订单号，通过这个订单号可以标识这笔交易，它由支付订单API支付成功时返回的数据里面获取到。
        setTransaction_id(transactionID);

        //商户系统自己生成的唯一的订单号
        setOut_trade_no(outTradeNo);

        //微信支付分配的终端设备号，与下单一致
        setDevice_info(deviceInfo);

        setOut_refund_no(outRefundNo);

        //商户系统自己管理的退款号，商户自身必须保证这个号在系统内唯一
        setRefund_id(refundID);

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

    public String getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(String transaction_id) {
        this.transaction_id = transaction_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getOut_refund_no() {
        return out_refund_no;
    }

    public void setOut_refund_no(String out_refund_no) {
        this.out_refund_no = out_refund_no;
    }

    public String getRefund_id() {
        return refund_id;
    }

    public void setRefund_id(String refund_id) {
        this.refund_id = refund_id;
    }

    public boolean verify() {
        return true;
    }
}
