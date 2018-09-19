package com.arif.soap;

import javax.xml.ws.Endpoint;

public class MyPublisher {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:9090/ws/hello", new HelloWorldImpl());
    }
}
