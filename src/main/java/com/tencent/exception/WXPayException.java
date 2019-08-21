package com.tencent.exception;

/**
 * Created by WANGHJ on 2017-03-23.
 * 微信支付异常
 */
public class WXPayException extends Exception {

    public WXPayException(String message) {
        super(message);
    }

    public WXPayException(String message, Throwable cause) {
        super(message, cause);
    }
}
