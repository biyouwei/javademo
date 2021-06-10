package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class IndexController {


    AtomicInteger aa = new AtomicInteger();
    HashMap hashMap=new HashMap();
    @RequestMapping(value = "/index")
    public String index(Model model, HttpServletRequest request){
        String nn ="";
        //throw new NullPointerException("wfsd");
        return "index";
    }





}
