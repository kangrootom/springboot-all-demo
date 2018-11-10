package com.bjpowernode.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * SpringBoot2.0项目无法在Tomcat7.0下运行，在stackoverflow上面查到有人这样说：
 * Spring Boot 2.0 (and Spring Framework 5 upon which it builds) requires
 * a Servlet 3.1 compatible container. Tomcat 7 only implements Servlet 3.0
 * so it cannot be used with Spring Boot 2.0.
 *
 * ---------------------
 */
@SpringBootApplication
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
