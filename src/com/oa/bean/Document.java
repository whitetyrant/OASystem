package com.oa.bean;

import java.util.Date;

//文件实体类
public class Document {

    private int id;
    private String filename;
    private String remark;
    private String createdate;
    private String uploaduser;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getUploaduser() {
        return uploaduser;
    }

    public void setUploaduser(String uploaduser) {
        this.uploaduser = uploaduser;
    }

    public Document(int id, String filename, String remark, String createdate, String uploaduser) {
        super();
        this.id = id;
        this.filename = filename;
        this.remark = remark;
        this.createdate = createdate;
        this.uploaduser = uploaduser;
    }

    public Document() {
        super();
    }

    @Override
    public String toString() {
        return "Document [id=" + id + ", filename=" + filename + ", remark=" + remark + ", createdate=" + createdate
                + ", uploaduser=" + uploaduser + "]";
    }

}
