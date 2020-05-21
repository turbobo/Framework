package com.wonders.base.config;

import gov.util.validate.filter.PreventHotlinkingFilter;
import gov.util.validate.filter.SessionValidationFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/*
 * @author ：swq
 * @date ：Created in 2020/3/2 10:40
 * @description：过滤器类  FilterConfig 接口则用于定义 FilterConfig 对象应该对外提供的方法，
 * @modified By：
 * @version: v1.0$
 * */
@Slf4j
@Configuration
@PropertySource(value = {"classpath:application-filter.properties"})
public class FilterConfig {

    public FilterRegistrationBean filterRegistration(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new SessionValidationFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("sessionNames", sessionNames);
        registrationBean.addInitParameter("include",include);
        registrationBean.addInitParameter("escape",escape);
        registrationBean.addInitParameter("errorPage",errorPage);
        registrationBean.setName("sessionValidationFilter");
        registrationBean.setOrder(2);
        return registrationBean;
    }
    @Bean
    public FilterRegistrationBean filterRegistrationPrevent(){
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new PreventHotlinkingFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("errorPage", preErrorPage);
        registrationBean.addInitParameter("allowLink",allowLink);
        registrationBean.addInitParameter("escape",preEscape);
        registrationBean.addInitParameter("isInjectProtect",isInjectProtect);
        registrationBean.addInitParameter("isRefererCheck",isRefererCheck);
        registrationBean.addInitParameter("regHtmlXss",regHtmlXss);
        registrationBean.addInitParameter("encode",encode);
        registrationBean.addInitParameter("regSql",regSql);
        registrationBean.addInitParameter("realPaths",realPaths);
        registrationBean.addInitParameter("escapeInjectUrls",escapeInjectUrls);
        registrationBean.addInitParameter("trustedSites",trustedSites);
        registrationBean.setName("PreventHotlinkingFilter");
        registrationBean.setOrder(1);
        return registrationBean;
    }

    @Value("${sessionFilter.escape:}")
    private String escape;

    @Value("${sessionFilter.include:}")
    private String include;

    @Value("${sessionFilter.sessionNames}")
    private String sessionNames;

    @Value("${sessionFilter.errorPage}")
    private String errorPage;

    @Value("${prevent.errorPage}")
    private String preErrorPage;
    @Value("${prevent.allowLink:}")
    private String allowLink;
    @Value("${prevent.escape:}")
    private String preEscape;
    @Value("${prevent.isInjectProtect}")
    private String isInjectProtect;
    @Value("${prevent.isRefererCheck}")
    private String isRefererCheck;
    @Value("${prevent.regHtmlXss}")
    private String regHtmlXss;
    @Value("${prevent.encode:utf-8}")
    private String encode;
    @Value("${prevent.regSql:}")
    private String regSql;
    @Value("${prevent.realPaths:}")
    private String realPaths;
    @Value("${prevent.escapeInjectUrls:}")
    private String escapeInjectUrls;
    @Value("${prevent.trustedSites:}")
    private String trustedSites;
}
