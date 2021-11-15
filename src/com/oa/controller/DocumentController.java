package com.oa.controller;


import com.oa.bean.Document;
import com.oa.bean.Document;
import com.oa.bean.PageInfo;
import com.oa.dao.DocumentDao;
import com.oa.dao.DocumentDao;
import com.oa.service.DocumentService;
import com.oa.service.impl.DocumentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@WebServlet(urlPatterns = {"/insertDocument", "/deleteDocument", "/downloadDocument", "/queryDocument"})
@MultipartConfig
public class DocumentController extends HttpServlet {

    //获取业务层接口的对象
    DocumentService DocumentService = new DocumentServiceImpl();

    //doGet方法是用于接收get请求的
    @Override   //          request  请求对象           response  响应对象
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//请求对象设置编码
        //获取请求uri
        String uri = request.getRequestURI();
        if (uri.contains("insertDocument")) {
            insertDocument(request, response);    //上传文件请求处理方法
        } else if (uri.contains("queryDocument")) {
            queryDocument(request, response);    //查询请求处理方法
        } else if (uri.contains("deleteDocument")) {
            deleteDocument(request, response);    //删除请求处理方法
        } else if (uri.contains("downloadDocument")) {
            downloadDocument(request, response);    //下载文件请求处理方法
        }
    }

    //下载文件请求处理方法
    protected void downloadDocument(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1、设置请求的字符集编码为UTF-8
        // 2、获取需要下载的文件名，通过request的getParameter方法来进行获取
        String fileName = request.getParameter("fileName");
        // 3、构建文件路径
        String path = "C:\\Users\\www10\\Desktop\\OA存放文件";
        // 4、创建文件对象
        File downloadFile = new File(path + File.separator + fileName);
        // 5、进行下载操作
        // --1、设置以流的形式打开文件
        response.setContentType("application/octet-stream");
        // --2、获取文件的长度
        Long length = downloadFile.length();
        //把文件长度设置到响应对象中
        response.setContentLength(length.intValue());
        // --3、使用UTF-8对文件名进行编码，并设置文件描述信息   decode
        fileName = URLEncoder.encode(downloadFile.getName(), "UTF-8");
        //将信息添加到响应头中
        response.addHeader("Content-Disposition", "attachment; filename=" + fileName);
        // 6、定义文件输入流以及输出流
        ServletOutputStream servletOutputStream = response.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(downloadFile);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        // 7、刷新流操作，将流进行关闭，通过流操作将文件写出到页面
        int len = 0;
        byte[] buff = new byte[1024];
        while ((len = bufferedInputStream.read(buff)) != -1) {//读取--读取到缓冲字节数组中
            //写出
            servletOutputStream.write(buff, 0, len);
            //刷新流
            servletOutputStream.flush();
        }

    }

    //删除文件请求处理方法
    protected void deleteDocument(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、从请求对象中获取请求参数 通过getParameter方法根据key来获取value
        String filename = request.getParameter("filename");
        String str_aid = request.getParameter("id");
        int id = Integer.parseInt(str_aid);//转换为int类型
        //2、调用业务层方法实现功能
        boolean isok = DocumentService.deleteDocument(id, filename);
        //3、作出响应--跳转页面
        if (isok) {//成功则跳转到首页
            request.getRequestDispatcher("queryDocument").forward(request, response);
        } else {//失败跳转回到登录页面
            request.setAttribute("message", "删除文件失败，请重新操作");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    //查询请求处理方法
    protected void queryDocument(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取跳转页面
        String pn = request.getParameter("pn");
        int pageNo = 1;
        if (pn != null) {
            pageNo = Integer.parseInt(pn);
        }
        //获取查询的name数据search
        String search = request.getParameter("search") == null ? "" : request.getParameter("search");
        //创建分页的对象
        PageInfo page = new PageInfo(pageNo, DocumentDao.queryDocumentCount(search));
        //1、调用业务层方法查询数据
        List<Document> DocumentList = DocumentService.queryDocument(page, search);
        //2、保存数据到属性作用域中
        request.setAttribute("DocumentList", DocumentList);
        request.setAttribute("pageInfo", page);
        request.setAttribute("Documentname", search);
        //3、跳转到DocumentIndex.jsp页面进行数据显示
        request.getRequestDispatcher("DocumentIndex.jsp").forward(request, response);
    }

    //公告发布请求处理方法
    protected void insertDocument(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1、从请求对象中获取请求参数 通过getParameter方法根据key来获取value
        String remark = request.getParameter("remark");//没有获取到该数据则为null
        String uploader = request.getParameter("uploader");
        //创建Document对象将数据进行封装
        Document document = new Document();
        document.setRemark(remark);
        document.setUploaduser(uploader);
        //获取文件区域的对象数据
        Part filepart = request.getPart("filepart");
        //2、调用业务层方法实现功能
        System.out.println("现在在controller");
        boolean isok = DocumentService.insertDocument(document, filepart);
        //3、作出响应--跳转页面
        if (isok) {//成功则跳转到首页
            request.getRequestDispatcher("queryDocument").forward(request, response);
        } else {//失败跳转回到错误页面
            request.setAttribute("message", "上传文件失败，请重新操作");
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    //doPost方法是用于接收Post请求的
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用了上面的doGet，目的是方便操作【不管是get、post都可以在doGet中编写处理代码】
        doGet(request, response);
    }
}
