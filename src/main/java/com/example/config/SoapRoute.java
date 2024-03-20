package com.example.config;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SoapRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("spring-ws:rootqname:{http://example.com/HelloSoapService}HelloRequest?endpointMapping=#endpointMapping")
        .log("Received SOAP request: ${body}")
        .setBody(constant("<HelloResponse xmlns='http://example.com/HelloSoapService'><Message>Hello from SOAP service</Message></HelloResponse>"));

		
	}

}
