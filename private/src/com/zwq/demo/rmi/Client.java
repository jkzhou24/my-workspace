package com.zwq.demo.rmi;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//RMI客户端  
public class Client {  

 public static void main(String[] args) {  
     // 注册管理器  
     Registry registry = null;  
     try {  
         // 获取服务注册管理器  
         registry = LocateRegistry.getRegistry("127.0.0.1",8088);  
         // 列出所有注册的服务  
         String[] list = registry.list();  
         for(String s : list){  
             System.out.println("service name : " + s);  
             try {  
                 // 根据命名获取服务  
                 IService server = (IService) registry.lookup(s);  
                 // 调用远程方法  
                 String result = server.queryName("zwq");  
                 // 输出调用结果  
                 System.out.println("result from remote : " + result);  
             } catch (AccessException e) {  
                   
             } catch (RemoteException e) {  
                   
             } catch (NotBoundException e) {  
                   
             }  
         }  
     } catch (RemoteException e) {  
           
     }  
    
 }  
}  
