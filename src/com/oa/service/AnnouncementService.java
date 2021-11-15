package com.oa.service;

import com.oa.bean.Announcement;
import com.oa.bean.PageInfo;

import javax.servlet.http.Part;
import java.util.List;

//管理员模块的业务层接口--定义规范方法（抽象方法）
public interface AnnouncementService {
    //定义添加操作[入参一个Announcement对象][文件上传]
    public boolean insertAnnouncement(Announcement announcement);

    //
    public boolean deleteAnnouncement(int id);

    //
    public boolean updateAnnouncement(Announcement announcement);

    //
    public List<Announcement> queryAnnouncement(PageInfo page, String search);

    //
    public Announcement queryAnnouncementById(int announcementid);
}
