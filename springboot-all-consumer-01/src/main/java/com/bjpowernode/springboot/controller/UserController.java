package com.bjpowernode.springboot.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bjpowernode.springboot.constants.Constants;
import com.bjpowernode.springboot.model.User;
import com.bjpowernode.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 714班
 */
@Controller
public class UserController {

    /**引用远程dubbo服务*/
    @Reference
    private UserService userService;

    /**
     * 首页列表
     *
     * @param model
     * @param curPage
     * @return
     */
    @RequestMapping("/index")
    public String index (Model model,
                         @RequestParam(value="curPage", required=false) Integer curPage) {

        if (null == curPage) {
            curPage = 1;
        }

        //查总数
        int totalRows = userService.getUserByTotal();

        int totalPages = totalRows / Constants.DEFAULT_PAGESIEZE;
        int left = totalRows % Constants.DEFAULT_PAGESIEZE;
        if (left > 0) {
            totalPages = totalPages + 1;
        }

        //每次查询的起始行
        int startRow = (curPage - 1) * Constants.DEFAULT_PAGESIEZE;
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("startRow", startRow);
        paramMap.put("pageSize", Constants.DEFAULT_PAGESIEZE);
        //分页查询当前页数据
        List<User> userList = userService.getUserByPage(paramMap);

        model.addAttribute("userList", userList);

        model.addAttribute("totalPages", totalPages);
        model.addAttribute("curPage", curPage);

        return "index";
    }

    @RequestMapping("/user/toAddUser")
    public String toAddUser(){

        return "user";
    }

    @RequestMapping("/user/addUser")
    public String addUser(User user){
        if(user.getId()==null){
            userService.add(user);
        }else{
            userService.update(user);
        }
        return "redirect:/index";
    }


    @RequestMapping("/user/toUpdate")
    public String toUpdate(@RequestParam(value = "id",required = true) Integer id,Model model){
        User user = userService.getUserById(id);
        model.addAttribute(user);
        return "user";
    }

    @RequestMapping("/user/delete")
    public String delete(@RequestParam(value = "id",required = true) Integer id){
        userService.delete(id);
        return "redirect:/index";
    }
}