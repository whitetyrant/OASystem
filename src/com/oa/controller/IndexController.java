package com.oa.controller;


import com.oa.bean.Dept;
import com.oa.bean.Job;
import com.oa.service.DeptService;
import com.oa.service.JobService;
import com.oa.service.impl.DeptServiceImpl;
import com.oa.service.impl.JobServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//实现登录页面跳转以及应用的数据查询【部门数据-岗位数据】
@WebServlet(urlPatterns = {"/toObjecIndex"})
public class IndexController extends HttpServlet {

    //获取业务层接口的对象
    DeptService deptService = new DeptServiceImpl();
    JobService jobService = new JobServiceImpl();

    //doGet方法是用于接收get请求的
    @Override   //          request  请求对象           response  响应对象
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //
        System.out.println("toObjecIndex---进行查询");
        //查询部门数据-岗位数据
        List<Dept> deptList = deptService.queryDept();
        List<Job> jobList = jobService.queryJob();
        //保存--应用作用域
        request.getServletContext().setAttribute("deptList",deptList);
        request.getServletContext().setAttribute("jobList",jobList);
        //跳转
        request.getRequestDispatcher("login_Emp.jsp").forward(request,response);
    }

    //doPost方法是用于接收Post请求的
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用了上面的doGet，目的是方便操作【不管是get、post都可以在doGet中编写处理代码】
        doGet(request, response);
    }
}
