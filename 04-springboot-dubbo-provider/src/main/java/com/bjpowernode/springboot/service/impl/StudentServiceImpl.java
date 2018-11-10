package com.bjpowernode.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bjpowernode.springboot.mapper.StudentMapper;
import com.bjpowernode.springboot.model.Student;
import com.bjpowernode.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(version = "1.0.0", timeout = 10000) //dubbo注解 <dubbo:springboot interface=... ref= version=>
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public String sayHi(String name) {
        return "Hi, SpringBoot : " + name;
    }

    @Override
    public Student getStudent(int id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
