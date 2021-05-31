package com.manage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置
 * @author 吴政杰
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    /**
     *    是否开启swagger，正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
     */


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("Main")
                .apiInfo(apiInfo())
                // 是否开启
                .enable(true).select()
                // 扫描的路径包
                .apis(RequestHandlerSelectors.basePackage("com.manage"))
                // 指定路径处理PathSelectors.any()代表所有的路径
                .paths(PathSelectors.any()).build().pathMapping("/");
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("个人健康平台项目")
                .description("Jonyon的API文档")
                // 作者信息
                .contact(new Contact("吴政杰", "https://www.jonyonwzj.top", "wzj994857864@gmail.com"))
                .version("1.0.0")
                .build();
    }
}
