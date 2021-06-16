package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class GlobalError11Controller implements ErrorController {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalError11Controller.class);

    private final static String ERROR_PATH = "/error";




    /*@RequestMapping(path  = ERROR_PATH )
    public String error(HttpServletRequest request, HttpServletResponse response){
        LOGGER.info("访问/error" + "  错误代码："  + response.getStatus());
        //BaseResult result = new WebResult(WebResult.RESULT_FAIL,"HttpErrorController error:"+response.getStatus());
        return "404.html";
    }*/

    @RequestMapping(value=ERROR_PATH,produces="text/html")
    public String handleError(HttpServletRequest request, HttpServletResponse response){

        LOGGER.info("访问/error" + "  错误代码："  + response.getStatus());
        return "404.html";
    }

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }
}
