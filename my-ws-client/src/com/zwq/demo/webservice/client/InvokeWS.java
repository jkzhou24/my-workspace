package com.zwq.demo.webservice.client;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

/*
 * @description:
 * @author zwq:
 * @date: 2018/9/1 22:16
 */
public class InvokeWS {

    public static void main(String[] args) throws ServiceException, RemoteException {

        SyncOrgStructServiceLocator locator = new SyncOrgStructServiceLocator();
        SyncOrgStructServicePortType service = locator.getSyncOrgStructServiceHttpPort();
        String result = service.syncOrgStruct("123");
        System.out.println(result);
    }
}
