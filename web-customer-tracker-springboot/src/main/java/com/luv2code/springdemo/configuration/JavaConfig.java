package com.luv2code.springdemo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource(locations = {"/config/spring-mvc-crud-demo-servlet.xml"})
public class JavaConfig {

}
