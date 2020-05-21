package com.wonders.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

/**
 * 1.引入Maven依赖
 * 2.创建Swagger的配置文件，具体请看com.wonders.base.config.SwaggerConfig中的SwaggerConfig.java
 * 3.对controller包中的类和方法做注释，具体请看com.wonders.base.example.controller.ExampleController.java
 * 4.对实体类及属性做注释，具体请看com.wonders.base.example.entity.ExampleEntity.java
 * 5.设置prevent.isRefererCheck=false，为true时无法访问swagger-ui.html
 * 6.地址栏输入http://localhost:端口号/swagger-ui.html即可查看API文档
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@ComponentScan(basePackages = {"com.*", "gov.*"})
public class BaseApplication {
    public static void main(String[] args) {
        SpringApplication.run(BaseApplication.class, args);
    }
    @Bean
  //  @LoadBalanced 负载功能
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
