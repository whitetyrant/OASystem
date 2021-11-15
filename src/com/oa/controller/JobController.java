package com.oa.controller;


import com.oa.bean.*;
import com.oa.dao.JobDao;
import com.oa.service.JobService;
import com.oa.service.JobService;
import com.oa.service.JobService;
import com.oa.service.impl.JobServiceImpl;
import com.oa.service.impl.JobServiceImpl;
import com.oa.service.impl.JobServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/queryJob", "/deleteJob", "/UpdateJob", "/insertJob", "/toUpdateJob"})
public class JobController extends HttpServlet {

    //获取业务层接口的对象
    JobService JobService = new JobServiceImpl();

    //doGet方法是用于接收get请求的
    @Override   //          request  请求对象           response  响应对象
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//请求对象设置编码
        //获取请求uri
        String uri = request.getRequestURI();
        if (uri.contains("queryJob")) {
            queryJob(request, response);    //登录请求处理方法
        } else if (uri.contains("insertJob")) {
            insertJob(request, response);    //公告发布请求处理方法
        } else if (uri.contains("toUpdateJob")) {
            toUpdateJob(request, response);    //修改页面跳转请求处理方法
        } else if (uri.contains("UpdateJob")) {
            UpdateJob(request, response);    //修改请求处理方法
        } else if (uri.contains("deleteJob")) {
            deleteJob(request, response);    //删除请求处理方法
        }
    }

    //公告删除请求处理方法
    protected void deleteJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、从请求对象中获取请求参数 通过getParameter方法根据key来获取value
        String str_aid = request.getParameter("id");
        int aid = Integer.parseInt(str_aid);//转换为int类型
        //2、调用业务层方法实现功能
        boolean isok = JobService.deleteJob(aid);
        //3、作出响应--跳转页面
        if (isok) {//成功则跳转到首页
            request.getRequestDispatcher("queryJob").forward(request, response);
        } else {//失败跳转回到登录页面
            request.setAttribute("message", "删除公告失败，请重新操作");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    //公告修改请求处理方法
    protected void UpdateJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、从请求对象中获取请求参数 通过getParameter方法根据key来获取value
        String str_id = request.getParameter("id");//没有获取到该数据则为null
        int id = Integer.parseInt(str_id);
        String name = request.getParameter("name");
        String remark = request.getParameter("remark");
        //创建Job对象将数据进行封装
        Job job = new Job();
        job.setId(id);
        job.setName(name);
        job.setRemark(remark);
        //2、调用业务层方法实现功能
        boolean isok = JobService.updateJob(job);
        //3、作出响应--跳转页面
        if (isok) {//成功则查询
            request.getRequestDispatcher("queryJob").forward(request, response);
        } else {//失败跳转回到修改页面
            request.getRequestDispatcher("toUpdateJob?id=" + id).forward(request, response);
        }
    }

    //跳转页面发布请求处理方法
    protected void toUpdateJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、从请求对象中获取请求参数 通过getParameter方法根据key来获取value
        String str_id = request.getParameter("id");
        int id = Integer.parseInt(str_id);//转换为int类型
        //2、调用业务层方法实现功能
        Job job = JobService.queryJobById(id);
        //3、作出响应--跳转页面
        request.setAttribute("Job", job);
        request.getRequestDispatcher("JobUpdate.jsp").forward(request, response);
    }

    //公告发布请求处理方法
    protected void insertJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、从请求对象中获取请求参数 通过getParameter方法根据key来获取value
        String name = request.getParameter("name");
        String remark = request.getParameter("remark");
        //创建Job对象将数据进行封装
        Job job = new Job();
        job.setName(name);
        job.setRemark(remark);
        //2、调用业务层方法实现功能
        boolean isok = JobService.insertJob(job);
        //3、作出响应--跳转页面
        if (isok) {//成功则跳转到首页
            request.getRequestDispatcher("queryJob").forward(request, response);
        } else {//失败跳转回到登录页面
            request.setAttribute("message", "发布公告失败，请重新操作");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    //查询请求处理方法
    protected void queryJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取跳转页面
        String pn = request.getParameter("pn");
        int pageNo = 1;
        if (pn != null) {
            pageNo = Integer.parseInt(pn);
        }
        //获取查询的name数据search
        String search = request.getParameter("search") == null ? "" : request.getParameter("search");
        //创建分页的对象
        PageInfo page = new PageInfo(pageNo, JobDao.queryJobCount(search));
        //1、调用业务层方法查询数据
        List<Job> JobList = JobService.queryJob(page, search);
        //2、保存数据到属性作用域中
        request.setAttribute("jobList", JobList);
        request.setAttribute("pageInfo", page);
        request.setAttribute("jobname", search);
        //3、跳转到JobIndex.jsp页面进行数据显示
        request.getRequestDispatcher("JobIndex.jsp").forward(request, response);
    }

    //doPost方法是用于接收Post请求的
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用了上面的doGet，目的是方便操作【不管是get、post都可以在doGet中编写处理代码】
        doGet(request, response);
    }
}

