package com.example.storagemanager.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
//开启swagger 2
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(true)
                .select()
//                RequestHandlerSelector配置要扫描接口的方式
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
//                .apis(RequestHandlerSelectors.basePackage("com.guo.service..controller"))
                //过滤指定的路径
//                .paths(PathSelectors.ant("/**"))
                .build();
    }

    //配置swagger信息=apiInfo
    private ApiInfo apiInfo(){
        Contact contact = new Contact("guopei","-","xxx.com");

        return  new ApiInfo("swagger文档",
                "111",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
