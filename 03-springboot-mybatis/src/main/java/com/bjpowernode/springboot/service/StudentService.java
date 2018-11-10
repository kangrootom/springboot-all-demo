package com.bjpowernode.springboot.service;

import com.bjpowernode.springboot.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    int updateByPrimaryKey();
}
