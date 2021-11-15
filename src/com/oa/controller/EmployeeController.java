package com.oa.controller;


import com.oa.bean.PageInfo;
import com.oa.bean.Employee;
import com.oa.bean.Employee;
import com.oa.bean.Employee;
import com.oa.dao.EmployeeDao;
import com.oa.service.EmployeeService;
import com.oa.service.impl.EmployeeServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

//使用EmployeeController来接收和处理Employee模块的所有请求操作
//目的：一个请求处理类映射多个uri
@WebServlet(urlPatterns = {"/queryEmployee","/loginEmployee", "/DeleteEmp", "/insertEmployee", "/toUpdateEmp","/updateEmployee"})
@MultipartConfig //支持文件上传的注解
public class EmployeeController extends HttpServlet {

    //获取业务层接口的对象
    EmployeeService EmployeeService = new EmployeeServiceImpl();

    //doGet方法是用于接收get请求的
    @Override   //          request  请求对象           response  响应对象
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//请求对象设置编码
        //获取请求uri
        String uri = request.getRequestURI();
        // response.getWriter().append("EmployeeController--"+uri);
        if (uri.contains("queryEmployee")) {
            queryEmployee(request, response);     //查询请求处理方法
        } else if (uri.contains("insertEmployee")) {
            insertEmployee(request, response);     //查询请求处理方法
        } else if (uri.contains("toUpdateEmp")) {
            toUpdateEmp(request, response);     //查询请求处理方法
        } else if (uri.contains("updateEmployee")) {
            updateEmployee(request, response);     //查询请求处理方法
        } else if (uri.contains("DeleteEmp")) {
            DeleteEmp(request, response);     //查询请求处理方法
        } else if (uri.contains("loginEmployee")){
            loginEmployee(request, response);     //登录请求处理方法
        }
    }

    //登录请求处理方法
    protected void loginEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、从请求对象中获取请求参数【登录名、密码】 通过getParameter方法根据key来获取value
        String loginname = request.getParameter("loginname");//没有获取到该数据则为null
        String password = request.getParameter("password");
        //2、进行登录校验\做一个非空判断
        if (loginname == null || loginname.equals("")) {
            //在Servlet请求处理类中保存信息（key-value）到属性作用域(容器)【保存】 request作用域
            request.setAttribute("message", "登录名不能为空！");
            //3、进行响应--登录名或密码不能为空
            request.getRequestDispatcher("login_Emp.jsp").forward(request, response);
            //结束方法
            return;
        }
        if (password == null || password.equals("")) {
            //【保存】 request作用域
            request.setAttribute("message", "密码不能为空！");
            //3、进行响应--登录名或密码不能为空
            request.getRequestDispatcher("login_Emp.jsp").forward(request, response);
            //结束方法
            return;
        }
        //controller调用业务层的方法进行登录查询
        Employee loginEmployee = EmployeeService.queryEmployeeLogin(loginname, password);
        //校验
        if (loginEmployee != null) {//表示登录成功--有该用户数据
            //3、进行响应--成功--跳转到首页
            request.getSession().setAttribute("NowEmployee", loginEmployee);
            System.out.println("loginEmployee:"+loginEmployee);
            request.getRequestDispatcher("index.jsp").forward(request, response);//转发：无法访问外部程序
        } else {
            //3、进行响应--失败--跳转到登录页面
            //【保存】 request作用域
            request.setAttribute("message", "用户名或密码错误！");
            request.setAttribute("loginname", loginname);
            request.setAttribute("password", password);
            //转发是请求链没有断开的
            request.getRequestDispatcher("login_Emp.jsp").forward(request, response);
        }
    }


    //删除请求处理方法
    protected void DeleteEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、从请求对象中获取请求参数 通过getParameter方法根据key来获取value
        String str_id = request.getParameter("Delete_Empid");
        int id = Integer.parseInt(str_id);//转换为int类型
        //2、调用业务层方法实现功能
        boolean isok = EmployeeService.deleteEmployee(id);
        //3、作出响应--跳转页面
        if (isok) {//成功则重新查询数据
            request.getRequestDispatcher("queryEmployee").forward(request, response);
        } else {//失败跳转回到错误页面
            request.setAttribute("message","删除失败");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    //修改请求处理方法
    protected void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、从请求对象中获取请求参数 通过getParameter方法根据key来获取value
        String str_id = request.getParameter("id");
        int id = Integer.parseInt(str_id);//转换为int类型
        String name = request.getParameter("name");//没有获取到该数据则为null
        String password = request.getParameter("password");
        String cardId = request.getParameter("cardId");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        int deptId = Integer.parseInt(request.getParameter("deptId"));
        int jobId = Integer.parseInt(request.getParameter("jobId"));
        String party = request.getParameter("party");
        String race = request.getParameter("race");
        String education = request.getParameter("education");
        //创建Employee对象将数据进行封装
        Employee employee = new Employee(id, password, deptId, jobId, name, sex, email, education, phone, cardId, party, race, null, null, null, null);
        //获取文件区域的对象数据
        Part filepart = request.getPart("filepart");
        //2、调用业务层方法实现功能
        boolean isok = EmployeeService.updateEmployee(employee, filepart);
        //3、作出响应--跳转页面
        if (isok) {//成功则重新查询数据
            request.getRequestDispatcher("queryEmployee").forward(request, response);
        } else {//失败跳转回到修改页面
            request.getRequestDispatcher("toUpdateEmp?Update_Empid=" + id).forward(request, response);
        }
    }

    //添加跳转修改页面请求处理方法
    protected void toUpdateEmp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、从请求对象中获取请求参数 通过getParameter方法根据key来获取value
        String Update_Empid = request.getParameter("Update_Empid");//没有获取到该数据则为null
        int eId = Integer.parseInt(Update_Empid);//转换为int类型
        //2、查询数据
        Employee employee = EmployeeService.queryEmployeeById(eId);
        //3、保存数据到作用域中
        request.setAttribute("employee",employee);
        //3、作出响应--跳转页面
        request.getRequestDispatcher("EmployeeUpdate.jsp").forward(request, response);
    }

    //添加请求处理方法
    protected void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、从请求对象中获取请求参数 通过getParameter方法根据key来获取value
        String name = request.getParameter("name");//没有获取到该数据则为null
        String password = request.getParameter("password");
        String cardId = request.getParameter("cardId");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String sex = request.getParameter("sex");
        int deptId = Integer.parseInt(request.getParameter("deptId"));//转换为int类型
        int jobId = Integer.parseInt(request.getParameter("jobId"));//转换为int类型
        //创建Employee对象将数据进行封装
        Employee Employee = new Employee(password, deptId, jobId, name, sex, email, phone, cardId);
        //获取文件区域的对象数据
        Part filepart = request.getPart("filepart");
        //2、调用业务层方法实现功能
        boolean isok = EmployeeService.insertEmployee(Employee, filepart);
        //3、作出响应--跳转页面
        if (isok) {//成功则重新查询员工数据
            request.getRequestDispatcher("queryEmployee").forward(request, response);
        } else {//失败跳转回到错误页面页面
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    //查询请求处理方法
    protected void queryEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取跳转页面
        String dId = request.getParameter("dId");
        int deptId = 0;
        if (dId != null) {
            deptId = Integer.parseInt(dId);
        }
        String pn = request.getParameter("pn");
        int pageNo = 1;
        if (pn != null) {
            pageNo = Integer.parseInt(pn);
        }
        //获取查询的name数据search
        String search = request.getParameter("search") == null ? "" : request.getParameter("search");
        //创建分页的对象
        PageInfo page = new PageInfo(pageNo, EmployeeDao.queryEmployeeCount(search, deptId));
        //1、调用业务层方法查询数据
        List<Employee> EmployeeList = EmployeeService.queryEmployee(page, search, deptId);
        //2、保存数据到属性作用域中
        request.setAttribute("employeeList", EmployeeList);
        request.setAttribute("pageInfo", page);
        request.setAttribute("Employeename", search);
        request.setAttribute("selectedDid", deptId);
        //3、跳转到EmployeeIndex.jsp页面进行数据显示
        request.getRequestDispatcher("EmployeeIndex.jsp").forward(request, response);
    }


    //doPost方法是用于接收Post请求的
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用了上面的doGet，目的是方便操作【不管是get、post都可以在doGet中编写处理代码】
        doGet(request, response);
    }
}
