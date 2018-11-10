package com.bjpowernode.springboot.config;


import com.bjpowernode.springboot.intercepter.LoginIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        String[] addPathPatterns ={"/boot/**","/servlet/myServlet","/servlet/bootServlet"};
        String[] excludePathPatterns = {"/boot/hi","/boot/index"};
        registry.addInterceptor(new LoginIntercepter()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
        //注册权限拦截器
        //registry.addInterceptor(new AuthInterceptor()).addPathPatterns(addPathPatterns).excludePathPatterns(excludePathPatterns);
    }
}
