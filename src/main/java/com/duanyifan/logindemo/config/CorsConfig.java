package com.duanyifan.logindemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域配置
 * 允许前端页面从不同端口/域名访问后端接口
 */
@Configuration // 标记为配置类
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 所有接口都允许跨域
                .allowedOriginPatterns("*") // 允许所有来源
                .allowedMethods("GET", "POST", "PUT", "DELETE") // 允许的请求方式
                .allowCredentials(true) // 允许携带cookie
                .maxAge(3600); // 预检请求有效期1小时
    }
}
