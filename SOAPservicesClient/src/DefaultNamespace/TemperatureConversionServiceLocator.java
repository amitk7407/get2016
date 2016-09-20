/**
 * TemperatureConversionServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public class TemperatureConversionServiceLocator extends org.apache.axis.client.Service implements DefaultNamespace.TemperatureConversionService {

    public TemperatureConversionServiceLocator() {
    }


    public TemperatureConversionServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TemperatureConversionServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TemperatureConversion
    private java.lang.String TemperatureConversion_address = "http://localhost:8080/SOAPservices/services/TemperatureConversion";

    public java.lang.String getTemperatureConversionAddress() {
        return TemperatureConversion_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TemperatureConversionWSDDServiceName = "TemperatureConversion";

    public java.lang.String getTemperatureConversionWSDDServiceName() {
        return TemperatureConversionWSDDServiceName;
    }

    public void setTemperatureConversionWSDDServiceName(java.lang.String name) {
        TemperatureConversionWSDDServiceName = name;
    }

    public DefaultNamespace.TemperatureConversion getTemperatureConversion() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(TemperatureConversion_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTemperatureConversion(endpoint);
    }

    public DefaultNamespace.TemperatureConversion getTemperatureConversion(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            DefaultNamespace.TemperatureConversionSoapBindingStub _stub = new DefaultNamespace.TemperatureConversionSoapBindingStub(portAddress, this);
            _stub.setPortName(getTemperatureConversionWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTemperatureConversionEndpointAddress(java.lang.String address) {
        TemperatureConversion_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (DefaultNamespace.TemperatureConversion.class.isAssignableFrom(serviceEndpointInterface)) {
                DefaultNamespace.TemperatureConversionSoapBindingStub _stub = new DefaultNamespace.TemperatureConversionSoapBindingStub(new java.net.URL(TemperatureConversion_address), this);
                _stub.setPortName(getTemperatureConversionWSDDServiceName());
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
        if ("TemperatureConversion".equals(inputPortName)) {
            return getTemperatureConversion();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://DefaultNamespace", "TemperatureConversionService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://DefaultNamespace", "TemperatureConversion"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TemperatureConversion".equals(portName)) {
            setTemperatureConversionEndpointAddress(address);
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
