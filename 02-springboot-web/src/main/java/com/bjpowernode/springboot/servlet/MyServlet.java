package com.bjpowernode.springboot.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//value和urlPatterns均可映射url
@WebServlet(value = {"/servlet/myServlet","/servlet/myServlet2"})
public class MyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");
        response.getWriter().print("Hello,this is myservlet....fds肥嘟嘟放松放松");
        response.getWriter().flush();
        response.getWriter().close();
    }
}
