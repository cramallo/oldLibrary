package com.library.oldlibrary.configuration;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet (ApplicationContext context){
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(messageDispatcherServlet,"/oldLibrary/*");
    }

    @Bean XsdSchema orderSchema(){
        return new SimpleXsdSchema(new ClassPathResource("orderdetail.xsd"));
    }

    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema orderSchema){
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(orderSchema);
        definition.setLocationUri("/oldLibrary");
        definition.setPortTypeName("OrderServicePort");
        definition.setTargetNamespace("http://oldLibrary.com/books");
        return definition;
    }
}
