package com.arif.soap;

import javax.jws.HandlerChain;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
@HandlerChain(file = "handler-chain.xml")
public interface HelloWorld {
    @WebMethod String getHelloWorldString(String name);
    @WebMethod String getMyName(String name);
}
