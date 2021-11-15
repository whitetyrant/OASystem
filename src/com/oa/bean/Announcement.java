package com.oa.bean;

import java.util.Date;

//公告Java实体类      公告只能管理员添加
public class Announcement {
    //私有化属性
    private int id;
    private String title;
    private String content;
    private String createtime;
    private int uid;
    //一对一的上传者关联
    private String uploader;

    //提供get、set方法
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUploader() {
        return uploader;
    }

    public void setUploader(String uploader) {
        this.uploader = uploader;
    }

    public Announcement() {
        super();
    }

    public Announcement(int id, String title, String content, String createtime, int uid, String uploader) {
        super();
        this.id = id;
        this.title = title;
        this.content = content;
        this.createtime = createtime;
        this.uid = uid;
        this.uploader = uploader;
    }

    @Override
    public String toString() {
        return "Announcement [id=" + id + ", title=" + title + ", content=" + content + ", createtime=" + createtime
                + ", uid=" + uid + ", uploader=" + uploader + "]";
    }

}

