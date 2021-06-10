package com.example.demo;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ApplicationContext app =SpringApplication.run(DemoApplication.class, args);
        int beanDefinitionCount = app.getBeanDefinitionCount();
        String[] beanDefinitionNames = app.getBeanDefinitionNames();
        System.out.println("初始化bean个数："+beanDefinitionCount);
        for(String beanName:beanDefinitionNames){

            System.out.println(app.getBean(beanName));
        }

    }

        @Bean
        public ServletRegistrationBean servletRegistrationBean(DispatcherServlet dispatcherServlet) {
        ServletRegistrationBean<DispatcherServlet> servletServletRegistrationBean = new ServletRegistrationBean<>(dispatcherServlet);
        servletServletRegistrationBean.addUrlMappings("*.do");
        return servletServletRegistrationBean;
    }


    @Bean
    public InternalResourceViewResolver setupViewResolver(){
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        return resolver;

    }


}
