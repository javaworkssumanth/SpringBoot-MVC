package com.sumanth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import groovy.servlet.TemplateServlet;
@Configuration
@SpringBootApplication
public class Application implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new MetaDataResolver());
    }

    @Bean
    public ServletRegistrationBean<TemplateServlet> exampleServletBean() {
        ServletRegistrationBean<TemplateServlet> bean = new ServletRegistrationBean<TemplateServlet>(
          new TemplateServlet(), "/jsp/*");
        Map<String, String> params = new HashMap<>();
        params.put("template.engine", "groovy.text.GStringTemplateEngine");
        bean.setInitParameters(params);
        bean.setLoadOnStartup(1);
        return bean;
    }
}
