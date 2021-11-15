package com.oa.service.impl;

import com.oa.bean.Dept;
import com.oa.bean.Job;
import com.oa.bean.PageInfo;
import com.oa.dao.DeptDao;
import com.oa.dao.JobDao;
import com.oa.service.JobService;

import javax.servlet.http.Part;
import java.util.List;

public class JobServiceImpl implements JobService {

    //获取dao
    JobDao jobDao = new JobDao();

    @Override
    public boolean insertJob(Job Job) {
        return jobDao.insertJob(Job);
    }

    @Override
    public boolean deleteJob(int id) {
        return jobDao.deleteJob(id);
    }

    @Override
    public boolean updateJob(Job Job) {
        return jobDao.updateJob(Job);
    }

    @Override
    public List<Job> queryJob() {
        return jobDao.queryJob();
    }

    @Override
    public List<Job> queryJob(PageInfo page, String search) {
        return jobDao.queryJob(page,search);
    }


    @Override
    public Job queryJobById(int Jobid) {
        return jobDao.queryJobById(Jobid);
    }
}
