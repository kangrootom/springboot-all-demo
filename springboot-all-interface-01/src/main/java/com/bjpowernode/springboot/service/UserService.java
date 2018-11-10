package com.bjpowernode.springboot.service;

import com.bjpowernode.springboot.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    /**
     * 分页的查询
     *
     * @param paramMap
     * @return
     */
    public List<User> getUserByPage(Map<String, Object> paramMap);

    /**
     * 分页的总数
     *
     * @return
     */
    public int getUserByTotal();


    int add(User user);

    int update(User user);

    int delete(Integer id);

    User getUserById(Integer id);
}
