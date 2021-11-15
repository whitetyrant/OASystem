<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword"
          content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>人事管理系统首页</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css"
          href="assets/css/zabuto_calendar.css">
    <link rel="stylesheet" type="text/css"
          href="assets/js/gritter/css/jquery.gritter.css"/>
    <link rel="stylesheet" type="text/css" href="assets/lineicons/style.css">

    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

    <script src="assets/js/chart-master/Chart.js"></script>

</head>

<body>

<section id="container"> <!-- **********************************************************************************************************************************************************
      TOP BAR CONTENT & NOTIFICATIONS
      *********************************************************************************************************************************************************** -->
    <!--header start-->
    <header class="header black-bg">
        <div class="sidebar-toggle-box">
            <div class="fa fa-bars tooltips" data-placement="right"
                 data-original-title="Toggle Navigation"></div>
        </div>
        <!--logo start--> <a href="index.html" class="logo"><b>DASHGUM
        FREE</b></a> <!--logo end-->
        <div class="nav notify-row" id="top_menu">
            <!--  notification start -->
            <ul class="nav top-menu">
                <!-- settings start -->
                <li class="dropdown"><a data-toggle="dropdown"
                                        class="dropdown-toggle" href="index.html#"> <i
                        class="fa fa-tasks"></i> <span class="badge bg-theme">4</span>
                </a>
                    <ul class="dropdown-menu extended tasks-bar">
                        <div class="notify-arrow notify-arrow-green"></div>
                        <li>
                            <p class="green">You have 4 pending tasks</p>
                        </li>
                        <li><a href="index.html#">
                            <div class="task-info">
                                <div class="desc">DashGum Admin Panel</div>
                                <div class="percent">40%</div>
                            </div>
                            <div class="progress progress-striped">
                                <div class="progress-bar progress-bar-success"
                                     role="progressbar" aria-valuenow="40" aria-valuemin="0"
                                     aria-valuemax="100" style="width: 40%">
                                    <span class="sr-only">40% Complete (success)</span>
                                </div>
                            </div>
                        </a></li>
                        <li><a href="index.html#">
                            <div class="task-info">
                                <div class="desc">Database Update</div>
                                <div class="percent">60%</div>
                            </div>
                            <div class="progress progress-striped">
                                <div class="progress-bar progress-bar-warning"
                                     role="progressbar" aria-valuenow="60" aria-valuemin="0"
                                     aria-valuemax="100" style="width: 60%">
                                    <span class="sr-only">60% Complete (warning)</span>
                                </div>
                            </div>
                        </a></li>
                        <li><a href="index.html#">
                            <div class="task-info">
                                <div class="desc">Product Development</div>
                                <div class="percent">80%</div>
                            </div>
                            <div class="progress progress-striped">
                                <div class="progress-bar progress-bar-info" role="progressbar"
                                     aria-valuenow="80" aria-valuemin="0" aria-valuemax="100"
                                     style="width: 80%">
                                    <span class="sr-only">80% Complete</span>
                                </div>
                            </div>
                        </a></li>
                        <li><a href="index.html#">
                            <div class="task-info">
                                <div class="desc">Payments Sent</div>
                                <div class="percent">70%</div>
                            </div>
                            <div class="progress progress-striped">
                                <div class="progress-bar progress-bar-danger" role="progressbar"
                                     aria-valuenow="70" aria-valuemin="0" aria-valuemax="100"
                                     style="width: 70%">
                                    <span class="sr-only">70% Complete (Important)</span>
                                </div>
                            </div>
                        </a></li>
                        <li class="external"><a href="#">See All Tasks</a></li>
                    </ul>
                </li>
                <!-- settings end -->
                <!-- inbox dropdown start-->
                <li id="header_inbox_bar" class="dropdown"><a
                        data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                    <i class="fa fa-envelope-o"></i> <span class="badge bg-theme">5</span>
                </a>
                    <ul class="dropdown-menu extended inbox">
                        <div class="notify-arrow notify-arrow-green"></div>
                        <li>
                            <p class="green">You have 5 new messages</p>
                        </li>
                        <li><a href="index.html#"> <span class="photo"><img
                                alt="avatar"
                                <c:if test="${nowUser!=null}">src="/photo/${nowUser.imgname}"</c:if>></span>
                            <span class="subject"> <span class="from"> <c:if
                                    test="${nowUser!=null}">src="/photo/${nowUser.username}"</c:if>
							</span> <span class="time">Just now</span>
						</span> <span class="message"> Hi mate, how is everything? </span>
                        </a></li>
                        <li><a href="index.html#"> <span class="photo"><img
                                alt="avatar" src="assets/img/ui-divya.jpg"></span> <span
                                class="subject"> <span class="from">Divya Manian</span> <span
                                class="time">40 mins.</span>
						</span> <span class="message"> Hi, I need your help with this. </span>
                        </a></li>
                        <li><a href="index.html#"> <span class="photo"><img
                                alt="avatar" src="assets/img/ui-danro.jpg"></span> <span
                                class="subject"> <span class="from">Dan Rogers</span> <span
                                class="time">2 hrs.</span>
						</span> <span class="message"> Love your new Dashboard. </span>
                        </a></li>
                        <li><a href="index.html#"> <span class="photo"><img
                                alt="avatar" src="assets/img/ui-sherman.jpg"></span> <span
                                class="subject"> <span class="from">Dj Sherman</span> <span
                                class="time">4 hrs.</span>
						</span> <span class="message"> Please, answer asap. </span>
                        </a></li>
                        <li><a href="index.html#">See all messages</a></li>
                    </ul>
                </li>
                <!-- inbox dropdown end -->
            </ul>
            <!--  notification end -->
        </div>
        <div class="top-menu">
            <ul class="nav pull-right top-menu">
                <li><a class="logout" href="logout">Logout</a></li>
            </ul>
        </div>
    </header>

    <!--sidebar start-->
    <jsp:include page="menu.jsp"></jsp:include>
    <!--sidebar end-->

    <div class="copyrights">Collect from MJR</div>

    <!-- **********************************************************************************************************************************************************
      MAIN CONTENT
      *********************************************************************************************************************************************************** -->
    <!--main content start-->
    <section id="main-content">
        <section
                class="wrapper">

            <div class="row">
                <div class="col-lg-9 main-chart">
                    <!-- input -->
                    <div style="margin-top: 45px;">
                        <h4 class="mb">
                            <i class="fa fa-angle-right"></i> Inline Form
                        </h4>
                        <form id="form_query" class="form-inline" role="form"
                              action="${pageContext.servletContext.contextPath}/queryEmployee">
                            <input id="page" name="pn" type="hidden" value="1"/>
                            <div class="form-group">
                                <label class="sr-only" for="exampleInputEmail2">Email
                                    address</label> <input type="text" class="form-control"
                                                           id="exampleInputEmail2" placeholder="Employee Name"
                                                           name="search"
                                                           value="${Employeename}">
                            </div>
                            <select name="dId" class="form-control">
                                <option value="0">部门</option>
                                <c:forEach items="${deptList}" var="deptSelectItem">
                                    <option value="${deptSelectItem.id}"
                                            <c:if test="${deptSelectItem.id==selectedDid}">
                                                selected
                                            </c:if>
                                    >${deptSelectItem.name}</option>
                                </c:forEach>
                            </select>
                            <button type="submit" class="btn btn-theme">Submit</button>
                        </form>
                    </div>
                    <br>
                    <!-- input -->
                    <div class="content-panel">
                        <table class="table table-striped table-advance table-hover">
                            <h4>
                                <i class="fa fa-angle-right"></i> Advanced Table
                            </h4>
                            <hr>
                            <thead>
                            <tr>
                                <th><i class="fa fa-bullhorn"></i>员工ID</th>
                                <th><i class="fa fa-bullhorn"></i>员工名</th>
                                <th><i class="fa fa-bullhorn"></i>性别</th>
                                <th class="hidden-phone"><i class="fa fa-question-circle"></i>
                                    手机号码
                                </th>
                                <th><i class="fa fa-bookmark"></i>部门</th>
                                <th><i class="fa fa-bookmark"></i>岗位</th>
                                <th><i class="fa fa-bookmark"></i>邮箱</th>
                                <th><i class=" fa fa-edit"></i>学历</th>
                                <th><i class=" fa fa-edit"></i>入职时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <!-- 遍历用户 -->
                            <c:forEach items="${employeeList}" var="employeeItem">
                                <tr>
                                    <td>${employeeItem.id}</td>
                                    <td>${employeeItem.username}</td>
                                    <td>${employeeItem.sex}</td>
                                    <td class="hidden-phone">${employeeItem.phone}</td>
                                    <td>${employeeItem.deptName}</td>
                                    <td>${employeeItem.jobName}</td>
<%--
                                    <td>${employeeItem.dept_id}</td>
                                    <td>${employeeItem.job_id}</td>
--%>
                                    <td>${employeeItem.email}</td>
                                    <td>${employeeItem.education}</td>
                                    <td><span class="label label-info label-mini">${employeeItem.createDate}
                                    </span></td>
                                    <c:if test="${NowUser!=null&&NowUser.status==1}">
                                        <td >
                                            <button class="btn btn-primary btn-xs">
                                                <a class="fa fa-pencil" style="color: white;"
                                                   href="${pageContext.servletContext.contextPath}/toUpdateEmp?Update_Empid=${employeeItem.id}">Update</a>
                                            </button>
                                            <button class="btn btn-danger btn-xs" onclick="">
                                                <a class="fa fa-trash-o" style="color: white;"
                                                   href="${pageContext.servletContext.contextPath}/DeleteEmp?Delete_Empid=${employeeItem.id}">Delete</a>
                                            </button>
                                        </td>
                                    </c:if>
                                    <c:if test="${NowUser==null||NowUser.status!=1}">
                                        <td style="padding-left: 50px">
                                        </td>
                                    </c:if>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                    <!-- 分页html标签 -->
                    <div class="card-body">
                        <nav aria-label="Page navigation example"
                             style="margin-left: 330px;">
                            <ul class="pagination">
                                <li class="page-item"><a class="page-link"
                                                         href="#">【${pageInfo.pageIndex}/${pageInfo.pages}，共${pageInfo.total}条记录】
                                </a></li>
                                <li class="page-item"><a class="page-link"
                                                         href="javascript:jumpPage(1)">首页</a></li>
                                <c:if test="${pageInfo.prePage!=0}">
                                    <li class="page-item"><a class="page-link"
                                                             href="javascript:jumpPage(${pageInfo.prePage})">上一页</a>
                                    </li>
                                </c:if>
                                <li class="page-item"><a class="page-link"
                                                         href="javascript:jumpPage(${pageInfo.pageIndex})">${pageInfo.pageIndex}</a>
                                </li>
                                <c:if test="${pageInfo.nextPage!=0}">
                                    <li class="page-item"><a class="page-link"
                                                             href="javascript:jumpPage(${pageInfo.nextPage})">下一页</a>
                                    </li>
                                </c:if>
                                <li class="page-item"><a class="page-link"
                                                         href="javascript:jumpPage(${pageInfo.pages})">尾页</a></li>
                            </ul>
                        </nav>
                    </div>
                    <!-- 分页html标签 -->
                </div>
                <!-- /col-lg-9 END SECTION MIDDLE -->
                <!-- **********************************************************************************************************************************************************
              RIGHT SIDEBAR CONTENT
              *********************************************************************************************************************************************************** -->

                <!-- /col-lg-3 -->
                <jsp:include page="col_lg_3.jsp"></jsp:include>
                <!-- /col-lg-3 -->
            </div>
            <! --/row -->
        </section>
    </section> <!--main content end--> <!--footer start-->
    <footer
            class="site-footer">
        <div class="text-center">2018 - Alvarez.is - Person System -
            Collect from MJR
        </div>
    </footer> <!--footer end--> </section>

<!-- js placed at the end of the document so the pages load faster -->
<script src="assets/js/jquery.js"></script>
<script src="assets/js/jquery-1.8.3.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>
<script class="include" type="text/javascript"
        src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
<script src="assets/js/jquery.scrollTo.min.js"></script>
<script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
<script src="assets/js/jquery.sparkline.js"></script>


<!--common script for all pages-->
<script src="assets/js/common-scripts.js"></script>

<script type="text/javascript"
        src="assets/js/gritter/js/jquery.gritter.js"></script>
<script type="text/javascript" src="assets/js/gritter-conf.js"></script>

<!--script for this page-->
<script src="assets/js/sparkline-chart.js"></script>
<script src="assets/js/zabuto_calendar.js"></script>


<script type="application/javascript">


    $(document).ready(function () {
        $("#date-popover").popover({html: true, trigger: "manual"});
        $("#date-popover").hide();
        $("#date-popover").click(function (e) {
            $(this).hide();
        });

        $("#my-calendar").zabuto_calendar({
            action: function () {
                return myDateFunction(this.id, false);
            },
            action_nav: function () {
                return myNavFunction(this.id);
            },
            today:true,
            ajax: {
                url: "show_data.php?action=1",
                modal: true
            },
            legend: [
                {type: "text", label: "Special event", badge: "00"},
                {type: "block", label: "Regular event",}
            ]
        });
    });

    function myNavFunction(id) {
        $("#date-popover").hide();
        var nav = $("#" + id).data("navigation");
        var to = $("#" + id).data("to");
        console.log('nav ' + nav + ' to: ' + to.month + '/' + to.year);
    }


    function jumpPage(page) {
        //要修改访问的页码
        document.getElementById("page").value = page;
        document.getElementById("form_query").submit();
    }


</script>


</body>
</html>