package com.wonders.base.example.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/*
* 添加一些控制器，跳过一些404，页面正常登录
* */
@RestController
public class UserController {

    @RequestMapping("/api/currentUser")
//    @RequestMapping("/currentUser")
    public String queryCurrent() {
        return "queryCurrent";
    }

    @RequestMapping("/api/login/account")
//    @RequestMapping("/login/account")
    public String fakeAccountLogin() {
        return "fakeAccountLogin";
    }

    @RequestMapping("/api/fake_chart_data")
//    @RequestMapping("/fake_chart_data")
    public String fakeChartData() {
        return "fakeChartData";
    }
}