package com.oa.service;

import com.oa.bean.Job;
import com.oa.bean.PageInfo;

import javax.servlet.http.Part;
import java.util.List;

//部门模块的业务层接口--定义规范方法（抽象方法）
public interface JobService {
    //定义添加操作[入参一个Job对象][文件上传]
    public boolean insertJob(Job Job);
    //
    public boolean deleteJob(int id);
    //
    public boolean updateJob(Job Job);
    //
    public List<Job> queryJob();
    //
    public Job queryJobById(int Jobid);

    List<Job> queryJob(PageInfo page, String search);
}
