<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="ps.zaixian.ImageUtil"%>
<%@ page import="ps.zaixian.TestImageUtil"%>
<%@ page import="org.opencv.core.Mat" %>
<%@ page import="org.opencv.imgcodecs.Imgcodecs" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html lang="en">
<head>
    <script src="http://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <script type="text/javascript">
        function xiayizhang(){
            window.location.href="${pageContext.request.contextPath}/ps/index.do";
        }
    </script>
    <meta charset="UTF-8">
    <title>index</title>
    <!-- 引入样式 -->
    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/ps.css">
    <style>
        *margin{
            padding: 0;
            margin: 0;
        }
        .slider-box{  font-family:Microsoft Yahei; padding-bottom:10px}
        .slider-box .item{ padding:10px}
        .slider-box .item .tag, .slider-box .item .slider, .slider-box .item .val{ float:left; margin-right:10px}
        .slider-box .item .slider{ width:410px;
            height: 0px;}
        .slider-box .item .slider div{ background:#8FBF0B; border:none; height:0.5em; margin-top:0.5em}
        .slider-box .item .slider div .ui-slider-handle{ background:#F4F3F1; width:1em; height:1em; border-radius:1em}
        .slider-box .item .val input{ border:none; border-bottom:0px solid #ABADA8; background:none; padding:1.1em 1em; color:#E4531C; font-weight:bold; font-size:1em; width:2em; text-align:center}
        .clr{ clear:both}
        .slider-box{
            float: right;
        }
        body{
            text-align: center;
        }
        .vintage1{
            background: #EEE url(data:image/gif;base64,iVBORw0KGgoAAAANSUhEUgAAAAQAAAAECAIAAAAmkwkpAAAAHklEQVQImWNkYGBgYGD4//8/A5wF5SBYyAr+//8PAPOCFO0Q2zq7AAAAAElFTkSuQmCC) repeat;
            text-shadow: 5px -5px black, 4px -4px white;
            font-weight: bold;
            font-size: 70px;
            -webkit-text-fill-color: transparent;
            -webkit-background-clip: text }
        .mainContent .left{
            float: left;
            width:500px;
            margin-right:20px;
            padding-left:10px;
        }
        .mainContent .right{
            float:left;
            width:500px;
            margin-right: 10px;
            padding-right: 15px;

        }
        .mainContent #app{
            float:left;
            width:400px;

        }
        .mainContent .left #next .xiayizhang{
            float:left;
        }
        .mainContent .left #next .xiazai{
            float: right;
        }

        .mainContent .left #next .xiazai #xiazaiyanse{
           text-decoration: none;
            text-align: center;
            color: #000;
        }

        .mainContent .right .xiazai2 #xiazaiyanse2{
            text-decoration: none;
            text-align: center;
            color: #000;
        }
        .mainContent .right #xiazai2{
            float:right;
        }
    </style>
</head>
<body>
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/bootstrap.js">
<link rel="stylesheet" href="${pageContext.request.contextPath}/js/jquery-2.2.3.min.js">
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- import JavaScript -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
<h1 class="vintage1">用户数据收集系统</h1>
<script src="//unpkg.com/vue/dist/vue.js"></script>
<script src="//unpkg.com/element-ui@2.12.0/lib/index.js"></script>
<div class="mainContent ">
   <div class="left">

           <img src="${pageContext.request.contextPath}/images/${imageName}" alt="">
           <div id="next">
               <div class="xiayizhang"> <el-button type="primary" icon="el-icon-right" ><a href="${pageContext.request.contextPath}/ps/xiayizhang.do?bh=${bianhao}">下一张</a></el-button></div>
               <div class="xiazai"><el-button type="primary" icon="el-icon-bottom"><a id="xiazaiyanse" href="${pageContext.request.contextPath}/images/${imageName}" download="${imageName}">下载</a></el-button></div>
           </div>


   </div>
    <div class="right">

            <img src="${pageContext.request.contextPath}/images/${imageName}" alt="">
            <div  id="xiazai2">
                <div class="xiazai2"> <el-button type="primary" icon="el-icon-bottom"><a id="xiazaiyanse2" href="${pageContext.request.contextPath}/imagescopy/${imageName}" download="${imageName}">下载</a></el-button></div>
            </div>


    </div>


    <div class="slider-box">
        <div class="item">
            <div class="tag">亮度：</div>
            <div class="slider">
                <div id="budget"></div>
            </div>
            <div class="val"><input value="125" name="budget" /></div>

        </div>
        <div class="clr"></div>
        <div class="item">
            <div class="tag">对比度：</div>
            <div class="slider">
                <div id="days"></div>
            </div>
            <div class="val"><input value="125" name="days" /></div>
        </div>
        <div class="clr"></div>
    </div>

</div>
<script>
    $("#budget").slider({
        min: 0,
        max: 255,
        step: 1,
        value: $('input[name="budget"]').val(),
        slide: function( event, ui ) {
            $('input[name="budget"]').val(ui.value)
        }
    });
    $("#days").slider({
        min: 0,
        max: 255,
        step:1,
        value: $('input[name="days"]').val(),
        slide: function( event, ui ) {
            $('input[name="days"]').val(ui.value)

        }
    });




</script>

</body>
</html>