package com.bjpowernode.springboot.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

public class BootFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("您已进入bootfilter过滤器，您的请求正常，请继续遵规则...");
        chain.doFilter(request, response);
    }
    @Override
    public void destroy() {
    }
}