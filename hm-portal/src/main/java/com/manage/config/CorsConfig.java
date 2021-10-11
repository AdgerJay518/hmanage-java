package com.manage.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *全局跨域相关配置
 * 1.匹配了所有的URL
 * 2.允许跨域请求包含任意的头信息
 * 3.设置允许的方法
 * 4.设置允许跨域请求的域名
 * 5.是否允许证书，默认false
 * @author 吴政杰
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowCredentials(true);
    }
}
