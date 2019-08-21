package com.tencent.exception;

/**
 * Created by WANGHJ on 2017-03-24.
 */
public class SignCheckException extends  RuntimeException {

    public SignCheckException() {
    }

    public SignCheckException(String message) {
        super(message);
    }

    public SignCheckException(String message, Throwable cause) {
        super(message, cause);
    }

    public SignCheckException(Throwable cause) {
        super(cause);
    }


}
