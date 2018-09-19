package com.arif.soap;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class MyClient {


    public void helloWorldClient() throws MalformedURLException {
        URL url = new URL("http://localhost:9090/ws/hello?wsdl");

        QName qName = new QName("http://soap.arif.com/", "HelloWorldImplService");
        Service service = Service.create(url, qName);

        HelloWorld hello = service.getPort(HelloWorld.class);
        System.out.println(hello.getHelloWorldString("Arif"));
    }

    public static void main(String[] args) throws Exception{
        MyClient client = new MyClient();
        client.helloWorldClient();
    }
}
