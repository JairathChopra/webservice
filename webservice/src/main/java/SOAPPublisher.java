import eservice.EServiceImpl;

import javax.xml.ws.Endpoint;
import java.net.InetAddress;

public class SOAPPublisher {
    public static void main(String[] args) {
        try {
            String url = "http://"+ InetAddress.getLocalHost().getHostAddress()+":7777/ws/eservice";
            Endpoint.publish(url, new EServiceImpl());
            System.out.println("URL: "+url);
            System.out.println("WSDL: "+url+"?wsdl");
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
