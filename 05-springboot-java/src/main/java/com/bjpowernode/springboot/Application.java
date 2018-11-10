package com.bjpowernode.springboot;

import com.bjpowernode.springboot.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/*
在 Spring Boot 框架中，要创建一个非Web应用程序（纯Java程序）：
 */
@SpringBootApplication
public class Application /*implements CommandLineRunner */{
    //方式一直接在main方法中，根据SpringApplication.run()方法获取返回的Spring容器对象，
    // 再获取业务bean进行调用；
   /* public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        HiService hiService = (HiService) context.getBean("hiService");
        System.out.println(hiService.getClass().getName());
        String hi = hiService.sayHi("范德萨");
        System.out.println(hi);
    }*/

   //方式二
    //<!-- Springboot开发java项目的起步依赖 -->
   //<dependency>
   //    <groupId>org.springframework.boot</groupId>
   //    <artifactId>spring-boot-starter</artifactId>
   //</dependency>
   //1、Spring boot 的入口类实现CommandLineRunner接口；
   // 2、覆盖CommandLineRunner接口的run()方法，run方法中编写具体的处理逻辑即可；
  /* @Autowired
   private HiService hiService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }


    @Override
    public void run(String... args) throws Exception {
        String sayHi = hiService.sayHi("更好的冯绍峰的第三方的时代的发生");
        System.out.println(hiService.getClass().getSimpleName());
        System.out.println(sayHi);
    }*/
   //关闭spring logo图标 日志输出：
   public static void main(String[] args) {
       SpringApplication springApplication = new SpringApplication(Application.class);
       springApplication.setBannerMode(Banner.Mode.OFF);
       springApplication.run(args);
       System.out.println("Banner.Mode.OFF");
   }

}
