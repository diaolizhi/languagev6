
package com.hzxy.admin.web.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //默认拦截所有
        registry.addInterceptor(new SessionInterceptor()).addPathPatterns("/**")
                //排除不拦截的页面
                .excludePathPatterns("/user/login","/static/**","/user/forget","/user/reset");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/static/upload/**").addResourceLocations("file:E:/javaPro/project/maven/language2/admin/src/main/resources/static/upload/");

    }

}

