package com.bjpowernode.springboot.config;

import com.bjpowernode.springboot.filter.BootFilter;
import com.bjpowernode.springboot.servlet.BootServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class ServletConfig {
    @Bean
    public ServletRegistrationBean bootServletRegistrationBean(){
        ServletRegistrationBean registration = new ServletRegistrationBean(new BootServlet(), "/servlet/bootServlet");
        return registration;
    }

    @Bean
    public FilterRegistrationBean bootFilterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean(new BootFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

    /*
    注意：只有当spring.http.encoding.enabled=false配置成false后，过滤器才会起作用；
     */
    /*@Bean
    public FilterRegistrationBean characterEncodingFilterRegistrationBean(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setForceEncoding(true);
        characterEncodingFilter.setEncoding("UTF-8");
        registration.setFilter(characterEncodingFilter);
        registration.addUrlPatterns("/*");
        return registration;
    }*/
}
