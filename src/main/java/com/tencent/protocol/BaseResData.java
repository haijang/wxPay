package com.tencent.protocol;

/**
 * Created by WANGHJ on 2017-03-25.
 */
public class BaseResData {

    //协议层
    protected String return_code = "";
    protected String return_msg = "";
    protected String result_code="";
    protected String err_code_des = "";
    /**
     * 通信和业务都成功
     * @return
     */
    public boolean isSuccess(){
        if("SUCCESS".equals(this.getReturn_code())&&"SUCCESS".equals(this.getResult_code())){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 通信成功
     * @return
     */
    public boolean isReturnSuccess(){
        if("SUCCESS".equals(this.getReturn_code())){
            return true;
        }
        return false;
    }


    /**
     * 获取失败的信息
     * @return
     */
    public String getErrMsg(){
        if(!isReturnSuccess()){//通信失败的话,返回通信失败的信息,否则返回业务失败的信息
            return this.getReturn_msg();
        }else{
            return this.getErr_code_des();
        }
    }

    public String getReturn_code() {
        return return_code;
    }

    public void setReturn_code(String return_code) {
        this.return_code = return_code;
    }

    public String getReturn_msg() {
        return return_msg;
    }

    public void setReturn_msg(String return_msg) {
        this.return_msg = return_msg;
    }

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getErr_code_des() {
        return err_code_des;
    }

    public void setErr_code_des(String err_code_des) {
        this.err_code_des = err_code_des;
    }
}
