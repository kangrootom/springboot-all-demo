package com.bjpowernode.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JSPController {
    @GetMapping("/boot/index")
    public String getJsp(Model model){
        model.addAttribute("msg","添加jsp功能成功");
        return "index";
    }
}
