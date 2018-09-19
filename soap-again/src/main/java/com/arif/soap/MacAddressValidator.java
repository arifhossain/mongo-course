package com.arif.soap;

import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Iterator;
import java.util.Set;

public class MacAddressValidator implements SOAPHandler<SOAPMessageContext> {

    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        System.out.println("Server: handleMessage()...");

        Boolean isRequest = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if(!isRequest) {
            try{
                SOAPMessage soapMessage = context.getMessage();
                SOAPEnvelope envelope = soapMessage.getSOAPPart().getEnvelope();

                SOAPHeader header = envelope.getHeader();
                Iterator iter = header.extractHeaderElements(SOAPConstants.URI_SOAP_ACTOR_NEXT);

                if(!iter.hasNext()) {
                    throw new SOAPException("NO HEADERS!!!");
                }

                Node macnode = (Node) iter.next();
                String macValue = macnode.getValue();

                System.out.println("MAC value: " + macValue + " : " + macnode.getNodeName());

            } catch (SOAPException se) {
                System.err.print(se);
            }
        }

        return true;

    }

    @Override
    public boolean handleFault(SOAPMessageContext context) {

        System.out.println("Server : handleFault()......");

        return true;
    }

    @Override
    public void close(MessageContext context) {
        System.out.println("Server : close()......");
    }

    @Override
    public Set<QName> getHeaders() {
        System.out.println("Server : getHeaders()......");
        return null;
    }

}
