package com.bjpowernode.springboot.controller;


import com.bjpowernode.springboot.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class MVCRestController {

    @RequestMapping("/boot/getUser")
    public User getUser(){
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-",""));
        user.setName("范德萨");
        return user;
    }

    /**
     * 使用@PostMapping,Get请求不了type=Method Not Allowed, status=405
     * @return
     */
    @PostMapping("/boot/getUser2")
    public User getUser2(){
        User user = new User();
        user.setId(UUID.randomUUID().toString().replace("-",""));
        user.setName("范德萨2");
        return user;
    }
}
