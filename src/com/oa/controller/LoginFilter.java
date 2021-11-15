package com.oa.controller;

import com.oa.bean.Employee;
import com.oa.bean.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//过滤器--进行登录的过滤拦截
@WebFilter(urlPatterns = {"/*"})
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoginFilter--初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //强制类型转换为HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //获取请求uri
        String uri = request.getRequestURI();
        //登录拦截
        //--1获取session中的NowUser
        Object NowUser = request.getSession().getAttribute("NowUser");
        Object NowEmployee = request.getSession().getAttribute("NowEmployee");
        //--判断
        if (NowUser != null || NowEmployee != null) {//用户已经登录
            //请求允许通过
            System.out.println(uri + "允许通过");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        //允许一些固定的请求访问
        if (uri.equals("/oa/")
                ||uri.equals("/oa/loginUser")
                || uri.equals("/oa/loginEmployee")
                || uri.equals("/oa/toObjecIndex")
                || uri.equals("/oa/insertUser")
                || uri.contains("assets")
                || uri.contains(".jsp")) {//用户已经登录--样式允许访问
            //请求允许通过
            System.out.println(uri + "允许通过");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        System.out.println(uri + "被拦截");
        request.getRequestDispatcher("login_Emp.jsp").forward(request, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("LoginFilter--销毁");
    }
}
