package com.oa.service.impl;

import com.oa.bean.Dept;
import com.oa.bean.PageInfo;
import com.oa.dao.DeptDao;
import com.oa.service.DeptService;

import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

public class DeptServiceImpl implements DeptService {

    //获取dao
    DeptDao deptDao = new DeptDao();

    @Override
    public boolean insertDept(Dept Dept) {
        return deptDao.insertDept(Dept);
    }

    @Override
    public boolean deleteDept(int id) {
        return deptDao.deleteDept(id);
    }

    @Override
    public boolean updateDept(Dept Dept) {
        //3、实现数据修改的操作
        return deptDao.updateDept(Dept);
    }

    @Override
    public List<Dept> queryDept() {
        return deptDao.queryDept();
    }

    @Override
    public List<Dept> queryDept(PageInfo page, String search) {
        return deptDao.queryDept(page,search);
    }

    @Override
    public Dept queryDeptById(int Deptid) {
        return deptDao.queryDeptById(Deptid);
    }
}
