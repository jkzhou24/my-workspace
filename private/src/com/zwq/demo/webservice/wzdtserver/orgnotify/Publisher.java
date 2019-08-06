package com.zwq.demo.webservice.wzdtserver.orgnotify;

import com.zwq.demo.webservice.wzdtserver.orgnotify.service.impl.SetData;

import javax.xml.ws.Endpoint;

/*
 * @description:
 * @author: zwq
 * @date: 2018/9/29 23:40
 */
public class Publisher {
    public static void main(String[] args) {
        String address = "http://localhost:8082/webservice/OrgNotifyReceiver";
        Endpoint.publish(address, new SetData());
        System.out.println("发布成功");
    }
}
