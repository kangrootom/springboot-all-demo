package com.bjpowernode.springboot.controller;

import com.bjpowernode.springboot.entity.BOOK_STATUS;
import com.bjpowernode.springboot.entity.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedList;
import java.util.List;

@Controller
public class ThymeLeafController {
    @RequestMapping("/boot/index")
    public String index (Model model) {
        model.addAttribute("msg", "恭喜，Spring boot集成 Thymeleaf成功！");
        //return 中就是你页面的名字（不带.html后缀）
        return "index";
    }
    @RequestMapping("/boot/books")
    public String books (Model model) {
        List<Book> books = new LinkedList<>();
        Book book1 = new Book(1,"水浒传",30d);
        book1.setStatus(BOOK_STATUS.SOLD);
        Book book2 = new Book(1,"红楼梦",50d);
        book2.setStatus(BOOK_STATUS.SOLD);
        Book book3 = new Book(1,"金瓶梅",20d);
        book3.setStatus(BOOK_STATUS.UNSOLD);
        books.add(book1);
        books.add(book2);
        books.add(book3);

        model.addAttribute("books", books);
        //return 中就是你页面的名字（不带.html后缀）
        return "book";
    }
}
