package com.oa.service;

import com.oa.bean.PageInfo;
import com.oa.bean.Dept;

import javax.servlet.http.Part;
import java.util.List;

//部门模块的业务层接口--定义规范方法（抽象方法）
public interface DeptService {
    //定义添加操作[入参一个Dept对象][文件上传]
    public boolean insertDept(Dept Dept);
    //
    public boolean deleteDept(int id);
    //
    public boolean updateDept(Dept Dept);
    //
    public List<Dept> queryDept();
    //
    public List<Dept> queryDept(PageInfo page, String search);
    //
    public Dept queryDeptById(int Deptid);
}
