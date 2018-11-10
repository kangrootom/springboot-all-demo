package com.bjpowernode.springboot.controller;

import com.bjpowernode.springboot.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;
    @RequestMapping("/boot/getStudents")
    public Object getStudents(){
        ExecutorService executorService = Executors.newFixedThreadPool(24);
        for(int i=0;i<10000;i++){
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    studentService.findAll();
                }
            });
        }

        return  studentService.findAll();
    }
    @RequestMapping("/boot/updateStudent")
    public int updateStudent(){
        return studentService.updateByPrimaryKey();
    }
}
