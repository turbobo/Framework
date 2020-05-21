package com.wonders.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*@Api：修饰整个类，描述Controller的作用
@ApiOperation：描述一个类的一个方法，或者说一个接口
@ApiParam：单个参数描述
@ApiModel：用对象来接收参数
@ApiProperty：用对象接收参数时，描述对象的一个字段
@ApiResponse：HTTP响应其中1个描述
@ApiResponses：HTTP响应整体描述
@ApiIgnore：使用该注解忽略这个API
@ApiError ：发生错误返回的信息
@ApiImplicitParam：描述一个请求参数，可以配置参数的中文含义，还可以给参数设置默认值
@ApiImplicitParams：描述由多个 @ApiImplicitParam 注解的参数组成的请求参数列表*/

@Configuration
@EnableSwagger2 //开启Swagger2
public class SwaggerConfig {

    //配置Swagger需要的Docket实例，可以配置多个实例，每个实例都是一个分组
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("A分组")
                .apiInfo(apiInfo())
                //是否启动swagger2，默认是true，线上环境建议关闭
                .enable(true)
                .select()
                // RequestHandlerSelectors 配置要扫描接口的方式
                //      basePackage() 指定要扫描的包
                //      any() 扫描全部
                //      none() 不扫描
                .apis(RequestHandlerSelectors.basePackage("com.wonders.base.example.controller"))
                // Path 过滤路径
                //      ant() 指定路径
                //      any() 过滤所有
                //      none() 不过滤
                //      regex() 正则匹配过滤路径
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        //配置swagger信息
        return new ApiInfoBuilder()
                .title("标题： swagger-api文档")
                .description("描述： swagger接入教程")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket docket1(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("B分组");
    }
    @Bean
    public Docket docket2(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("C分组");
    }
    @Bean
    public Docket docket3(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("D分组");
    }
}
