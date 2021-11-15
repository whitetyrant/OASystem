<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword"
          content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>DASHGUM - Bootstrap Admin Template</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet"/>

    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">

</head>

<body>


<div id="login-page">
    <div class="container">

        <!-- 请求方式为post    enctype="multipart/form-data"-->
        <form method="post" action="/oa/UpdateAnnouncement">
            <!-- 设置请求方式为method     类型 enctype="multipart/form-data"  -->
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" id="button_close" class="close" data-dismiss="modal"
                                aria-hidden="true">&times;
                        </button>
                        <h4 class="modal-title">修改公告信息</h4>
                    </div>
                    <div class="modal-body">
                        <p>标题：</p>
                        <input type="text" name="title" placeholder="请输入标题" value="${announcement.title}"
                               autocomplete="off" class="form-control placeholder-no-fix">

                    </div>
                    <div class="modal-body">
                        <p>正文：</p>
                        <textarea type="text" name="content"
                                  autocomplete="off" class="form-control placeholder-no-fix">${announcement.content}</textarea>
                        <input name="uid" value="${NowUser.id}" type="hidden"/>
                        <input name="aid" value="${announcement.id}" type="hidden"/>
                    </div>
                    <div class="modal-footer">
                        <button data-dismiss="modal" class="btn btn-default"
                                type="button">Cancel
                        </button>
                        <button class="btn btn-theme" type="submit">Submit</button>
                    </div>
                </div>
            </div>
        </form>

    </div>
</div>

<!-- js placed at the end of the document so the pages load faster -->
<script src="assets/js/jquery.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<!--BACKSTRETCH-->
<!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
<script type="text/javascript"
        src="assets/js/jquery.backstretch.min.js"></script>
<script>
    $.backstretch("assets/img/login-bg.jpg", {
        speed: 500
    });
    $('#button_close').click(function () {
        history.go(-1);
    });
</script>


</body>
</html>


