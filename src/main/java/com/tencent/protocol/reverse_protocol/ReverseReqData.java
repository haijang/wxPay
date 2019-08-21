package com.tencent.protocol.reverse_protocol;

import com.tencent.common.RandomStringGenerator;
import com.tencent.protocol.BaseReqData;

/**
 * User: rizenguo
 * Date: 2014/10/25
 * Time: 16:42
 */
public class ReverseReqData extends BaseReqData{
    //每个字段具体的意思请查看API文档
    private String transaction_id = "";
    private String out_trade_no = "";
    private String nonce_str = "";
    private String sub_mch_id;

    /**
     * 请求撤销服务
     * @param transactionID 是微信系统为每一笔支付交易分配的订单号，通过这个订单号可以标识这笔交易，它由支付订单API支付成功时返回的数据里面获取到。建议优先使用
     * @param outTradeNo 商户系统内部的订单号,transaction_id 、out_trade_no 二选一，如果同时存在优先级：transaction_id>out_trade_no
     * @return API返回的XML数据
     * @throws Exception
     */

    public ReverseReqData(String transactionID,String outTradeNo){

        //--------------------------------------------------------------------
        //以下是测试数据，请商户按照自己的实际情况填写具体的值进去
        //--------------------------------------------------------------------

        //transaction_id是微信系统为每一笔支付交易分配的订单号，通过这个订单号可以标识这笔交易，它由支付订单API支付成功时返回的数据里面获取到。
        setTransaction_id(transactionID);

        //商户系统自己生成的唯一的订单号
        setOut_trade_no(outTradeNo);

        //随机字符串，不长于32 位
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));

    }

    public ReverseReqData(String transactionID,String outTradeNo,String sub_mch_id){

        //--------------------------------------------------------------------
        //以下是测试数据，请商户按照自己的实际情况填写具体的值进去
        //--------------------------------------------------------------------

        //transaction_id是微信系统为每一笔支付交易分配的订单号，通过这个订单号可以标识这笔交易，它由支付订单API支付成功时返回的数据里面获取到。
        setTransaction_id(transactionID);

        //商户系统自己生成的唯一的订单号
        setOut_trade_no(outTradeNo);

        setSub_mch_id(sub_mch_id);

        //随机字符串，不长于32 位
        setNonce_str(RandomStringGenerator.getRandomStringByLength(32));

    }


    public String getSub_mch_id() {
        return sub_mch_id;
    }

    public void setSub_mch_id(String sub_mch_id) {
        this.sub_mch_id = sub_mch_id;
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

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public boolean verify() {
        return true;
    }
}
