package com.wonders.base.example.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AntDesignController implements ErrorController {
//public class AntDesignController {
    /**
     * 配置url通配符，拦截多个地址
     * @return
     */
    @RequestMapping(value = {
            "/",
            "/user",
            "/user/**",
            "/console",
            "/console/**"
    })
    public String fowardIndex() {
//        return "http://localhost:8000/user/login";
        return "index";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}