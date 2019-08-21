package com.tencent.test;

import com.tencent.WXPay;
import com.tencent.common.Configure;
import com.tencent.common.RandomStringGenerator;
import com.tencent.protocol.getsignkey_protocol.GetsignKeyReqData;
import com.tencent.protocol.pay_protocol.ScanPayReqData;
import com.tencent.protocol.red_backage_protocol.RedPackQueryReqData;
import com.tencent.protocol.red_backage_protocol.RedPackageReqData;
import com.tencent.protocol.refund_protocol.RefundReqData;
import com.tencent.protocol.reverse_protocol.ReverseReqData;
import com.tencent.protocol.unifiedorder_protocol.UnifiedorderReqData;
import com.tencent.result.RedPackQueryResult;
import com.tencent.result.RedPackageResult;
import com.tencent.result.RefundResult;
import com.tencent.result.ReverseResult;
import com.tencent.result.ScanPayResult;
import com.tencent.result.UnifiedorderResult;
import com.tencent.service.GetsignKeyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

public class Main {

    public static final Logger logger = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args){
        WXPay wxPay = new WXPay();
        wxPay.init(Configure.getKey(),Configure.getAppid(),Configure.getMchid(),Configure.getCertLocalPath(),Configure.getCertPassword(),false);
        queryRedPackage(wxPay);
    }

    public static void queryRedPackage(WXPay wxPay){
        RedPackQueryReqData reqData = new RedPackQueryReqData();
        reqData.setMch_billno("1104748063425802240");
        reqData.setNonce_str(UUID.randomUUID().toString().replaceAll("-",""));
        RedPackQueryResult result = wxPay.queryRedPakcageStatus(reqData);
        System.out.println(result);
    }


    public static void sendRedPack(WXPay wxPay){
        RedPackageReqData reqdata = new RedPackageReqData();
        String billNo = UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(5);
        reqdata.setMch_billno(billNo);
        reqdata.setAct_name("测试场景");
        reqdata.setSend_name("测试商户");
        reqdata.setRemark("客户未领退回重新发");
        reqdata.setWxappid(Configure.getAppid());
        reqdata.setTotal_amount("100");
        reqdata.setRe_openid("ofSi5sxUWX9uhNT9egfPQuuE29Zo");
        RedPackageResult result =  wxPay.sendRedPackage(reqdata);
        System.out.println(result.getStatus().toString());
        System.out.println(result.getMsg());
    }

    public static void reverse(WXPay wxPay){
        String outTradeNo = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        ReverseReqData reverseReqData = new ReverseReqData("","10D3BA58BE7A463F941BE95FC98FFDF8","1453237502");
        ReverseResult  result =  wxPay.reverse(reverseReqData);
        System.out.println(result.getStatus().toString());
        System.out.println(result.getMsg());
    }


    /**
     * 申请退款
     */
    public static void refun(WXPay wxPay){
        String outRefundNo = UUID.randomUUID().toString().replace("-", "").toUpperCase();
        String outTradeNo="10D3BA58BE7A463F941BE95FC98FFDF8";
        int totleFee = 1;
        int refundFee =1;
        String subMchId="1453237502";
        RefundReqData refundReqData = new RefundReqData("",outTradeNo,outRefundNo,totleFee,refundFee,subMchId,"");
        RefundResult result =  wxPay.refund(refundReqData);
        System.out.println(result.getStatus().toString());
        System.out.println(result.getMsg());
    }

    /**
     * 付款
     */
    public static void testPay(WXPay wxPay) {
        try {
            //必填 这个是扫码终端设备从用户手机上扫取到的支付授权号，这个号是跟用户用来支付的银行卡绑定的，有效期是1分钟
            String authCode = "130125797297325235";

            //必填 要支付的商品的描述信息，用户会在支付成功页面里看到这个信息
            String body = "刷卡支付测试";

            //支付订单里面可以填的附加数据，API会将提交的这个附加数据原样返回
            String attach = "";

            //必填 商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
            String outTradeNo = UUID.randomUUID().toString().replace("-", "").toUpperCase();

            //必填 订单总金额，单位为“分”，只能整数
            int totalFee = 32;

            //商户自己定义的扫码支付终端设备号，方便追溯这笔交易发生在哪台终端设备上
            String deviceInfo = "";

            //必填 订单生成的机器IP
            String spBillCreateIP = "192.168.1.150";

            //商品标记，微信平台配置的商品标记，用于优惠券或者满减使用
            String goodsTag = "";

            ScanPayReqData data = new ScanPayReqData(authCode, body, attach, outTradeNo, totalFee, deviceInfo, spBillCreateIP, "", "", goodsTag,"1453237502");
            ScanPayResult result =  wxPay.scanPay(data);
            System.out.println(result.getStatus().toString());
            System.out.println(result.getMsg());
        } catch (Exception e) {
            logger.error("",e);
        }
    }

    public static void unorder(WXPay wxPay){
        try {

            //必填 要支付的商品的描述信息，用户会在支付成功页面里看到这个信息
            String body = "刷卡支付测试";

            //支付订单里面可以填的附加数据，API会将提交的这个附加数据原样返回
            String attach = "";

            //必填 商户系统内部的订单号,32个字符内可包含字母, 确保在商户系统唯一
            String outTradeNo = UUID.randomUUID().toString().replace("-", "").toUpperCase();

            //必填 订单总金额，单位为“分”，只能整数
            int totalFee = 1;

            //商户自己定义的扫码支付终端设备号，方便追溯这笔交易发生在哪台终端设备上
            String deviceInfo = "";

            //必填 订单生成的机器IP
            String spBillCreateIP = "192.168.1.150";

            //商品标记，微信平台配置的商品标记，用于优惠券或者满减使用
            String goodsTag = "";

            String nofiyUrl="http://saas.ishanshan.com/paygateway-test/payGateway/wxcallback";

            UnifiedorderReqData data = new UnifiedorderReqData(nofiyUrl,body, attach, outTradeNo, totalFee, deviceInfo, spBillCreateIP, "", "", goodsTag,null,"oBikyv6jD7wkrkkYgXCAh7NMo9QM");
            UnifiedorderResult result =  wxPay.unifiedorder(data);
            System.out.println(result.getStatus().toString());
            System.out.println(result.getMsg());
            System.out.println(result.toString());
        } catch (Exception e) {
            logger.error("",e);
        }
    }

    public static void getTestKey() {
        try {

            GetsignKeyService service = new GetsignKeyService("/pay/getsignkey");
            GetsignKeyReqData data = new GetsignKeyReqData("1325285601", RandomStringGenerator.getRandomStringByLength(32));
            String rep = service.request(data);
            System.out.println(rep);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
