package com.arif.soap;

import javax.jws.WebService;

@WebService(endpointInterface = "com.arif.soap.HelloWorld")
public class HelloWorldImpl implements HelloWorld{

    @Override
    public String getHelloWorldString(String name) {
        return "Hello SOAP : " + name;
    }

    @Override
    public String getMyName(String name) {
        return "Hello SOAP myName : " + name;
    }

}
