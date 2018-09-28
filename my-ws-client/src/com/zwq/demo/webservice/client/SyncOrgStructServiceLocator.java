/**
 * SyncOrgStructServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.zwq.demo.webservice.client;

public class SyncOrgStructServiceLocator extends org.apache.axis.client.Service implements com.zwq.demo.webservice.client.SyncOrgStructService {

    public SyncOrgStructServiceLocator() {
    }


    public SyncOrgStructServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SyncOrgStructServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SyncOrgStructServiceHttpPort
    private java.lang.String SyncOrgStructServiceHttpPort_address = "http://www.test108.thinkmail.com/webadmin/webservice/SyncOrgStructService";

    public java.lang.String getSyncOrgStructServiceHttpPortAddress() {
        return SyncOrgStructServiceHttpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SyncOrgStructServiceHttpPortWSDDServiceName = "SyncOrgStructServiceHttpPort";

    public java.lang.String getSyncOrgStructServiceHttpPortWSDDServiceName() {
        return SyncOrgStructServiceHttpPortWSDDServiceName;
    }

    public void setSyncOrgStructServiceHttpPortWSDDServiceName(java.lang.String name) {
        SyncOrgStructServiceHttpPortWSDDServiceName = name;
    }

    public com.zwq.demo.webservice.client.SyncOrgStructServicePortType getSyncOrgStructServiceHttpPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SyncOrgStructServiceHttpPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSyncOrgStructServiceHttpPort(endpoint);
    }

    public com.zwq.demo.webservice.client.SyncOrgStructServicePortType getSyncOrgStructServiceHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.zwq.demo.webservice.client.SyncOrgStructServiceHttpBindingStub _stub = new com.zwq.demo.webservice.client.SyncOrgStructServiceHttpBindingStub(portAddress, this);
            _stub.setPortName(getSyncOrgStructServiceHttpPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSyncOrgStructServiceHttpPortEndpointAddress(java.lang.String address) {
        SyncOrgStructServiceHttpPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.zwq.demo.webservice.client.SyncOrgStructServicePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.zwq.demo.webservice.client.SyncOrgStructServiceHttpBindingStub _stub = new com.zwq.demo.webservice.client.SyncOrgStructServiceHttpBindingStub(new java.net.URL(SyncOrgStructServiceHttpPort_address), this);
                _stub.setPortName(getSyncOrgStructServiceHttpPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SyncOrgStructServiceHttpPort".equals(inputPortName)) {
            return getSyncOrgStructServiceHttpPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://service.midsync.sync.plugs.cmail.richinfo.cn", "SyncOrgStructService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://service.midsync.sync.plugs.cmail.richinfo.cn", "SyncOrgStructServiceHttpPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SyncOrgStructServiceHttpPort".equals(portName)) {
            setSyncOrgStructServiceHttpPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
