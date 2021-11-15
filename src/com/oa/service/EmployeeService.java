package com.oa.service;

import com.oa.bean.PageInfo;
import com.oa.bean.Employee;

import javax.servlet.http.Part;
import java.util.List;

//员工模块的业务层接口--定义规范方法（抽象方法）
public interface EmployeeService {
    //定义添加操作[入参一个Employee对象][文件上传]
    public boolean insertEmployee(Employee Employee, Part part);
    //
    public boolean deleteEmployee(int id);
    //
    public boolean updateEmployee(Employee Employee,Part part);
    //
    public List<Employee> queryEmployee(PageInfo page,String search,int deptId);
    //
    public Employee queryEmployeeById(int Employeeid);
    //
    public Employee queryEmployeeLogin(String name,String pass);
}
