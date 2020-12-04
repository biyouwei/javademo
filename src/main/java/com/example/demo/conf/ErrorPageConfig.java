package com.example.demo.conf;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;


@Configuration
public class ErrorPageConfig implements ErrorPageRegistrar{

        @Override
        public void registerErrorPages(ErrorPageRegistry registry) {
            ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/404.html");
            ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/404.html");
            ErrorPage error403Page = new ErrorPage(HttpStatus.FORBIDDEN, "/404.html");
            registry.addErrorPages(error500Page);
            registry.addErrorPages(error403Page);
            registry.addErrorPages(error404Page);
        }

}
