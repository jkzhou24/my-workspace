package com.zwq.demo.webservice.wzdtserver.orgnotify.service.impl;


import com.zwq.demo.webservice.wzdtserver.orgnotify.service.ISetData;
import com.zwq.demo.webservice.wzdtserver.orgnotify.vo.RequestMessage;
import com.zwq.demo.webservice.wzdtserver.orgnotify.vo.ResponseMessage;

import javax.jws.WebService;

/*
 * @description:
 * @author: zwq
 * @date: 2018/9/29 15:08
 */
@WebService
public class SetData implements ISetData {


    @Override
    public ResponseMessage setData(RequestMessage requestMessage) {
        String orgCode = requestMessage.getMessage().getOrgCode();

        ResponseMessage result = new ResponseMessage();

        return result;
    }
}
