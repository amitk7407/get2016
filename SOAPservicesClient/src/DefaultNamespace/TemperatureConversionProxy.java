package DefaultNamespace;

public class TemperatureConversionProxy implements DefaultNamespace.TemperatureConversion {
  private String _endpoint = null;
  private DefaultNamespace.TemperatureConversion temperatureConversion = null;
  
  public TemperatureConversionProxy() {
    _initTemperatureConversionProxy();
  }
  
  public TemperatureConversionProxy(String endpoint) {
    _endpoint = endpoint;
    _initTemperatureConversionProxy();
  }
  
  private void _initTemperatureConversionProxy() {
    try {
      temperatureConversion = (new DefaultNamespace.TemperatureConversionServiceLocator()).getTemperatureConversion();
      if (temperatureConversion != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)temperatureConversion)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)temperatureConversion)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (temperatureConversion != null)
      ((javax.xml.rpc.Stub)temperatureConversion)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DefaultNamespace.TemperatureConversion getTemperatureConversion() {
    if (temperatureConversion == null)
      _initTemperatureConversionProxy();
    return temperatureConversion;
  }
  
  public float fahrenheitToCelcius(float fahrenheit) throws java.rmi.RemoteException{
    if (temperatureConversion == null)
      _initTemperatureConversionProxy();
    return temperatureConversion.fahrenheitToCelcius(fahrenheit);
  }
  
  
}