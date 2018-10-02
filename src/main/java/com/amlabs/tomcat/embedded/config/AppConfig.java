package com.amlabs.tomcat.embedded.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.amlabs.tomcat.embedded")
@EnableWebMvc
@ImportResource("classpath:applicationContext.xml")
public class AppConfig {

}
