package com.tencent.business;

import com.tencent.common.RandomStringGenerator;
import com.tencent.common.Util;
import com.tencent.protocol.unifiedorder_protocol.JSReqData;
import com.tencent.protocol.unifiedorder_protocol.UnifiedorderReqData;
import com.tencent.protocol.unifiedorder_protocol.UnifiedorderResData;
import com.tencent.result.ResultStatus;
import com.tencent.result.UnifiedorderResult;
import com.tencent.service.IServiceRequest;
import com.tencent.service.UnifiedorderService;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by WANGHJ on 2017-04-23.
 */
public class UnifiedorderBusiness {

    private UnifiedorderService unifiedorderService;

    public UnifiedorderBusiness(IServiceRequest iServiceRequest) {
        this.unifiedorderService = new UnifiedorderService(iServiceRequest);
    }

    public UnifiedorderResult run(UnifiedorderReqData unifiedorderReqData){
        UnifiedorderResult result = new UnifiedorderResult();
        String resString =  this.unifiedorderService.request(unifiedorderReqData);
        UnifiedorderResData resData = (UnifiedorderResData) Util.getObjectFromXML(resString,UnifiedorderResData.class);
        if(resData == null){
            result.setStatus(ResultStatus.UNKNOW);
            result.setMsg("请求失败,请过5秒后再发起请求");
        }else{
            if(resData.isSuccess()){
                result.setStatus(ResultStatus.SUCCESS);
                result.setMsg("查询成功");
                result.setUnifiedorderResData(resData);
                JSReqData jsReqData = this.getJSReqData(unifiedorderReqData,resData);
                result.setJsReqData(jsReqData);
            }else{
                result.setStatus(ResultStatus.FAIL);
                result.setMsg(resData.getErrMsg());
            }
        }
        return result;
    }

    private JSReqData getJSReqData(UnifiedorderReqData unifiedorderReqData, UnifiedorderResData resData) {
        JSReqData jsReqData = new JSReqData();
        Map<String,String> map = new HashMap();
        map.put("appId",unifiedorderReqData.getSub_appid()==null?unifiedorderReqData.getAppid():unifiedorderReqData.getSub_appid());
        map.put("timeStamp", new Date().getTime()/1000+"");
        map.put("nonceStr", RandomStringGenerator.getRandomStringByLength(32));
        map.put("signType","MD5");
        map.put("package","prepay_id="+resData.getPrepay_id());
        map.put("paySign",unifiedorderService.sign(map));
        try {
            BeanUtils.copyProperties(jsReqData,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        jsReqData.setPackages(map.get("package"));
        return jsReqData;
    }
}
