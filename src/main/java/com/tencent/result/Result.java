package com.tencent.result;

/**
 * Created by WANGHJ on 2017-03-24.
 */
public abstract class Result {

    protected ResultStatus status;

    protected String msg;

    protected String errorCode;

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public ResultStatus getStatus() {
        return status;
    }

    public void setStatus(ResultStatus status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 是否成功
     * @return
     */
    public  boolean isSuccess(){
        if(ResultStatus.SUCCESS.equals(status)){
            return true;
        }
        return false;
    };

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Result{");
        sb.append("status=").append(status);
        sb.append(", msg='").append(msg).append('\'');
        sb.append(", errorCode='").append(errorCode).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
