<%--
  Created by IntelliJ IDEA.
  User: 陈磊
  Date: 2018/8/28 0028
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h3>${hotEvents.keyword}</h3>
<div>创建于:<fmt:formatDate value='${hotEvents.createdate}' type='time' pattern='yyyy-MM-dd'/></div>
<p>${hotEvents.hotcontent}</p>
<div>
    <p><h4>评论</h4></p>
    <form>
        <table>
            <c:forEach items="${comments}" var="comments">
                <tr>
                    <td>
                        <div>评论时间:<fmt:formatDate value='${comments.commentdate}' type='time' pattern='yyyy-MM-dd hh:mm:ss'/></div>
                        <div>${comments.content}</div>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <textarea id="content"></textarea>
        <span id="show" style="color: red"></span>
        <div>
            <input type="button" value="提交" id="confimBtn"/>
            <a href="main.do">返回首页</a>
        </div>
        <input type="hidden" id="hotEventsId" value="${hotEvents.id}"/>
    </form>
</div>
</body>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript"><!--
$("#confimBtn").click(function () {
    var content=$("#content").val();
    var hotEventsId=$("#hotEventsId").val();
    if(content==""){
        $("#show").text("请填写评论内容");
        return false;
    }
    $.ajax({
        url:"confirm.do",
        type:"post",
        data:{"content":content,"id":hotEventsId},
        dataType:"text",
        success:function (data) {
            if(data=="fail"){
                alert("添加失败!");
            }else{
                alert("添加成功!");
                location.reload();//刷新
            }
        },
        error:function () {
            alert("error")
            location.reload();
        },
    })
})
--></script>
</html>