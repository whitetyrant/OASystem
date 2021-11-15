package com.oa.service;

import com.oa.bean.Document;
import com.oa.bean.PageInfo;

import javax.servlet.http.Part;
import java.util.List;

//管理员模块的业务层接口--定义规范方法（抽象方法）
public interface DocumentService {
    //定义添加操作[入参一个Document对象][文件上传]
    public boolean insertDocument(Document Document, Part part);

    //
    public boolean deleteDocument(int id,String filename);

    //
    public List<Document> queryDocument(PageInfo page, String search);

}
