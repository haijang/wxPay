package com.tencent.protocol.getsignkey_protocol;

import com.tencent.common.Signature;
import com.tencent.protocol.BaseReqData;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WANGHJ on 2017-03-21.
 */
public class GetsignKeyReqData extends BaseReqData {

    private String mch_id;

    private String nonce_str;

    private String sign;

    public GetsignKeyReqData(String mchId, String nonceStr) {
        this.mch_id = mchId;
        this.nonce_str = nonceStr;
        sign = Signature.getSign(toMap());
    }

    public Map<String,Object> toMap(){
        Map<String,Object> map = new HashMap<String, Object>();
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            Object obj;
            try {
                obj = field.get(this);
                if(obj!=null){
                    map.put(field.getName(), obj);
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

    public boolean verify() {
        return true;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
