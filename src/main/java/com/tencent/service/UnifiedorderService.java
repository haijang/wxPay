package com.tencent.service;

import com.tencent.common.Configure;
import com.tencent.protocol.unifiedorder_protocol.UnifiedorderReqData;

/**
 * Created by WANGHJ on 2017-04-23.
 */
public class UnifiedorderService extends BaseService {


    public UnifiedorderService() {
        super(Configure.UNIFIED_ORDER_API);
    }

    public UnifiedorderService(IServiceRequest serviceRequest) {
        super(Configure.UNIFIED_ORDER_API,serviceRequest);
    }

    public String request(UnifiedorderReqData unifiedorderReqData){
        String responseString = sendPost(unifiedorderReqData);

        return responseString;
    }

}
