package com.oa.service.impl;

import com.oa.bean.Announcement;
import com.oa.bean.PageInfo;
import com.oa.dao.AnnouncementDao;
import com.oa.service.AnnouncementService;

import javax.servlet.http.Part;
import java.util.List;

public class AnnouncementServiceImpl implements AnnouncementService {

    //获取dao的对象
    AnnouncementDao announcementDao = new AnnouncementDao();

    @Override
    public boolean insertAnnouncement(Announcement announcement) {
        return announcementDao.insertAnnouncement(announcement);
    }

    @Override
    public boolean deleteAnnouncement(int id) {
        return announcementDao.deleteAnnouncement(id);
    }

    @Override
    public boolean updateAnnouncement(Announcement announcement) {
        return announcementDao.updateAnnouncement(announcement);
    }

    @Override
    public List<Announcement> queryAnnouncement(PageInfo page, String search) {
        return announcementDao.queryAnnouncement(page, search);
    }

    @Override
    public Announcement queryAnnouncementById(int announcementid) {
        return announcementDao.queryAnnouncementById(announcementid);
    }
}
