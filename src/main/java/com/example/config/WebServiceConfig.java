package com.example.config;

import java.io.InputStream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;

@Configuration
@EnableWs
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition() {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("HelloSoapServicePort");
        wsdl11Definition.setLocationUri("/HelloSoapService");
        wsdl11Definition.setTargetNamespace("http://example.com/HelloSoapService");
        wsdl11Definition.setSchema(HelloServiceSchema());
        return wsdl11Definition;
    }

    @Bean
    public SimpleXsdSchema HelloServiceSchema() {
        return new SimpleXsdSchema();
    }

    private InputStream getResource(String name) {
        return getClass().getResourceAsStream(name);
    }
}
