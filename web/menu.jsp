<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--sidebar start-->
<aside>
    <div id="sidebar" class="nav-collapse ">
        <!-- sidebar menu start-->
        <%--<ul class="sidebar-menu" id="nav-accordion">--%>
        <%--管理员的菜单显示--%>
        <c:if test="${NowUser!=null}">
            <ul class="sidebar-menu" id="nav-accordion">

                <p class="centered"><a href="profile.html"><img src="assets/img/ui-sam.jpg" class="img-circle"
                                                                width="60"></a></p>
                <h5 class="centered">${NowUser.username}</h5>

                <li class="sub-menu"><a href="javascript:;"> <i
                        class="fa fa-desktop"></i> <span>管理员模块</span>
                </a>
                    <ul class="sub">
                        <li><a href="queryUser">管理员信息</a></li>
                        <li><a data-toggle="modal" href="#insertUserModal">添加管理员</a></li>
                    </ul>
                </li>

            <li class="sub-menu"><a href="javascript:;"> <i
                    class="fa fa-cogs"></i> <span>员工模块</span>
            </a>
                <ul class="sub">
                    <li><a href="queryEmployee">员工信息</a></li>
                    <li><a data-toggle="modal" href="#insertEmployeeModal">添加员工</a></li>
                </ul>
            </li>
            <li class="sub-menu"><a href="javascript:;"> <i
                    class="fa fa-book"></i> <span>部门模块</span>
            </a>
                <ul class="sub">
                    <li><a href="queryDept">部门信息</a></li>
                    <li><a data-toggle="modal" href="#insertDeptModal">添加部门</a></li>
                </ul>
            </li>
            <li class="sub-menu"><a href="javascript:;"> <i
                    class="fa fa-tasks"></i> <span>岗位模块</span>
            </a>
                <ul class="sub">
                    <li><a href="queryJob">岗位信息</a></li>
                    <li><a data-toggle="modal" href="#insertJobModal">添加岗位</a></li>
                </ul>
            </li>
            <li class="sub-menu"><a href="javascript:;"> <i
                    class="fa fa-th"></i> <span>公告管理</span>
            </a>
                <ul class="sub">
                    <li><a href="queryAnnouncement">公告展示</a></li>
                    <c:if test="${NowUser!=null&&NowUser.status==1}">
                        <li><a data-toggle="modal" href="#insertAnnouncementModal">添加公告</a></li>
                    </c:if>
                </ul>
            </li>
            <li class="sub-menu"><a href="javascript:;"> <i
                    class=" fa fa-bar-chart-o"></i> <span>文件管理</span>
            </a>
                <ul class="sub">
                    <li><a href="queryDocument">文件显示及下载</a></li>
                    <li><a data-toggle="modal" href="#insertDocumentModal">上传文件</a></li>
                </ul>
            </li>
        </ul>
        </c:if>
        <!-- sidebar menu end-->
        <%--员工的菜单显示--%>
        <c:if test="${NowEmployee!=null}">
            <ul class="sidebar-menu" id="nav-accordion">

                <p class="centered"><a href="profile.html"><img src="assets/img/ui-sam.jpg" class="img-circle"
                                                                width="60"></a></p>
                <h5 class="centered">${NowEmployee.username}</h5>

                <li class="sub-menu"><a href="javascript:;"> <i
                        class="fa fa-cogs"></i> <span>员工模块</span>
                </a>
                    <ul class="sub">
                        <li><a href="queryEmployee">员工信息</a></li>
                    </ul>
                </li>
                <li class="sub-menu"><a href="javascript:;"> <i
                        class="fa fa-book"></i> <span>部门模块</span>
                </a>
                    <ul class="sub">
                        <li><a href="queryDept">部门信息</a></li>
                    </ul>
                </li>
                <li class="sub-menu"><a href="javascript:;"> <i
                        class="fa fa-tasks"></i> <span>岗位模块</span>
                </a>
                    <ul class="sub">
                        <li><a href="queryJob">岗位信息</a></li>
                    </ul>
                </li>
                <li class="sub-menu"><a href="javascript:;"> <i
                        class="fa fa-th"></i> <span>公告管理</span>
                </a>
                    <ul class="sub">
                        <li><a href="queryAnnouncement">公告展示</a></li>
                    </ul>
                </li>
                <li class="sub-menu"><a href="javascript:;"> <i
                        class=" fa fa-bar-chart-o"></i> <span>文件管理</span>
                </a>
                    <ul class="sub">
                        <li><a href="queryDocument">文件显示及下载</a></li>
                        <li><a data-toggle="modal" href="#insertDocumentModal">上传文件</a></li>
                    </ul>
                </li>
            </ul>
        </c:if>
    </div>
</aside>
<!--sidebar end-->

<!-- 文件Modal enctype="multipart/form-data"-->
<form method="post" action="/oa/insertDocument" enctype="multipart/form-data">
    <!-- 模态框Modal -->
    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
         tabindex="-1" id="insertDocumentModal" class="modal fade">
        <!-- 设置请求方式为method     类型 enctype="multipart/form-data"  -->
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">&times;
                    </button>
                    <h4 class="modal-title">添加文件</h4>
                </div>
                <div class="modal-body">
                    <p>文件：</p>
                    <input type="file" name="filepart"
                           autocomplete="off" class="form-control placeholder-no-fix">
                </div>
                <div class="modal-body">
                    <p>描述：</p>
                    <textarea type="text" name="remark"
                              autocomplete="off" class="form-control placeholder-no-fix"></textarea>
                    <input name="uploader" value="${NowUser.username}" type="hidden"/>
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                    <button class="btn btn-theme" type="submit">Submit</button>
                </div>
            </div>
        </div>
    </div>
</form>
<!-- 文件Modal enctype="multipart/form-data"-->

<!-- 公告Modal enctype="multipart/form-data"-->
<form method="post" action="/oa/insertAnnouncement">
    <!-- 模态框Modal -->
    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
         tabindex="-1" id="insertAnnouncementModal" class="modal fade">
        <!-- 设置请求方式为method     类型 enctype="multipart/form-data"  -->
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">&times;
                    </button>
                    <h4 class="modal-title">添加公告</h4>
                </div>
                <div class="modal-body">
                    <p>标题：</p>
                    <input type="text" name="title" placeholder="请输入标题"
                           autocomplete="off" class="form-control placeholder-no-fix">

                </div>
                <div class="modal-body">
                    <p>正文：</p>
                    <textarea type="text" name="content"
                              autocomplete="off" class="form-control placeholder-no-fix"></textarea>
                    <input name="uid" value="${NowUser.id}" type="hidden"/>
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                    <button class="btn btn-theme" type="submit">Submit</button>
                </div>
            </div>
        </div>
    </div>
</form>
<!-- 公告Modal enctype="multipart/form-data"-->

<!-- 管理员Modal enctype="multipart/form-data"-->
<form method="post" action="/oa/insertUser" enctype="multipart/form-data">
    <!-- 模态框Modal -->
    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
         tabindex="-1" id="insertUserModal" class="modal fade">
        <!-- 设置请求方式为method     类型 enctype="multipart/form-data"  -->
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">&times;
                    </button>
                    <h4 class="modal-title">添加管理员</h4>
                </div>
                <div class="modal-body">
                    <p>登录名：</p>
                    <input type="text" name="loginname" placeholder="请输入登录名"
                           autocomplete="off" class="form-control placeholder-no-fix">

                </div>
                <div class="modal-body">
                    <p>用户名：</p>
                    <input type="text" name="username" placeholder="请输入用户名"
                           autocomplete="off" class="form-control placeholder-no-fix">

                </div>
                <div class="modal-body">
                    <p>密码：</p>
                    <input type="text" name="password" placeholder="请输入密码"
                           autocomplete="off" class="form-control placeholder-no-fix">

                </div>
                <div class="modal-body">
                    <p>状态：</p>
                    <select name="status" class="form-control placeholder-no-fix">
                        <option value="1">超级管理员</option>
                        <option value="0">普通管理员</option>
                    </select>
                </div>
                <div class="modal-body">
                    <p>头像：</p>
                    <input type="file" name="filepart" autocomplete="off"
                           class="form-control placeholder-no-fix">
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                    <button class="btn btn-theme" type="submit">Submit</button>
                </div>
            </div>
        </div>
    </div>
</form>
<!-- 管理员Modal enctype="multipart/form-data"-->

<!-- 添加员工的请求方式为post    enctype="multipart/form-data"-->
<form method="post" id="insertEmployee" action="/oa/insertEmployee"
      enctype="multipart/form-data">
    <!-- 模态框Modal -->
    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
         tabindex="-1" id="insertEmployeeModal" class="modal fade">
        <!-- 设置请求方式为method     类型 enctype="multipart/form-data"  -->
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">&times;
                    </button>
                    <h4 class="modal-title">添加员工</h4>
                </div>

                <div class="row">
                    <div class="col-md-1"></div>
                    <div class="modal-body col-md-5">
                        <p>员工名：</p>
                        <input type="text" name="name" placeholder="请输入员工名"
                               autocomplete="off" class="form-control placeholder-no-fix">
                    </div>
                    <div class="modal-body  col-md-5">
                        <p>密码：</p>
                        <input type="text" name="password" placeholder="请输入密码"
                               autocomplete="off" class="form-control placeholder-no-fix">
                    </div>
                    <div class="col-md-1"></div>
                </div>
                <div class="row">
                    <div class="col-md-1"></div>
                    <div class="modal-body col-md-5">
                        <p>身份证：</p>
                        <input type="text" name="cardId" placeholder="请输入身份证"
                               autocomplete="off" class="form-control placeholder-no-fix">
                    </div>
                    <div class="modal-body col-md-5">
                        <p>手机号码：</p>
                        <input type="text" name="phone" placeholder="请输入手机号码"
                               autocomplete="off" class="form-control placeholder-no-fix">
                    </div>
                    <div class="col-md-1"></div>
                </div>

                <div class="row">
                    <div class="col-md-1"></div>
                    <div class="modal-body col-md-5">
                        <p>邮箱：</p>
                        <input type="text" name="email" placeholder="请输入邮箱"
                               autocomplete="off" class="form-control placeholder-no-fix">
                    </div>
                    <div class="modal-body col-md-5">
                        <p>性别：</p>
                        <select name="sex" class="form-control placeholder-no-fix">
                            <option value="男">男</option>
                            <option value="女">女</option>
                        </select>
                    </div>
                    <div class="col-md-1"></div>
                </div>

                <div class="row">
                    <div class="col-md-1"></div>
                    <div class="modal-body col-md-5">
                        <p>部门：</p>
                        <select name="deptId" class="form-control placeholder-no-fix">
                            <c:forEach items="${deptList}" var="deptItem">
                                <option value="${deptItem.id}">${deptItem.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="modal-body col-md-5">
                        <p>岗位：</p>
                        <select name="jobId" class="form-control placeholder-no-fix">
                            <c:forEach items="${jobList}" var="jobItem">
                                <option value="${jobItem.id}">${jobItem.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="col-md-1"></div>
                </div>
                <div class="row">
                    <div class="col-md-1"></div>
                    <div class="modal-body col-md-10">
                        <p>头像：</p>
                        <input type="file" name="filepart" autocomplete="off"
                               class="form-control placeholder-no-fix">
                    </div>
                    <div class="col-md-1"></div>
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                    <button class="btn btn-theme" type="submit">Submit</button>
                </div>
            </div>
        </div>
    </div>
</form>
<!-- 添加员工的请求方式为post    enctype="multipart/form-data"-->

<!-- 部门Modal enctype="multipart/form-data"-->
<form method="post" action="/oa/insertDept">
    <!-- 模态框Modal -->
    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
         tabindex="-1" id="insertDeptModal" class="modal fade">
        <!-- 设置请求方式为method     类型 enctype="multipart/form-data"  -->
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">&times;
                    </button>
                    <h4 class="modal-title">添加部门</h4>
                </div>
                <div class="modal-body">
                    <p>部门名：</p>
                    <input type="text" name="name" placeholder="请输入部门"
                           autocomplete="off" class="form-control placeholder-no-fix">

                </div>
                <div class="modal-body">
                    <p>别名：</p>
                    <textarea type="text" name="remark"
                              autocomplete="off" class="form-control placeholder-no-fix"></textarea>
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                    <button class="btn btn-theme" type="submit">Submit</button>
                </div>
            </div>
        </div>
    </div>
</form>
<!-- 部门Modal enctype="multipart/form-data"-->

<!-- 职员Modal enctype="multipart/form-data"-->
<form method="post" action="/oa/insertJob">
    <!-- 模态框Modal -->
    <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog"
         tabindex="-1" id="insertJobModal" class="modal fade">
        <!-- 设置请求方式为method     类型 enctype="multipart/form-data"  -->
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"
                            aria-hidden="true">&times;
                    </button>
                    <h4 class="modal-title">添加职员</h4>
                </div>
                <div class="modal-body">
                    <p>职员名：</p>
                    <input type="text" name="name" placeholder="请输入职员"
                           autocomplete="off" class="form-control placeholder-no-fix">

                </div>
                <div class="modal-body">
                    <p>别名：</p>
                    <textarea type="text" name="remark"
                              autocomplete="off" class="form-control placeholder-no-fix"></textarea>
                </div>
                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
                    <button class="btn btn-theme" type="submit">Submit</button>
                </div>
            </div>
        </div>
    </div>
</form>
<!-- 职员Modal enctype="multipart/form-data"-->

</body>
</html>
