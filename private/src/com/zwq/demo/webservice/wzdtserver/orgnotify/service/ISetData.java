package com.zwq.demo.webservice.wzdtserver.orgnotify.service;


import com.zwq.demo.webservice.wzdtserver.orgnotify.vo.RequestMessage;
import com.zwq.demo.webservice.wzdtserver.orgnotify.vo.ResponseMessage;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface ISetData {
	@WebMethod
	public ResponseMessage setData(RequestMessage requestMessage);
}
