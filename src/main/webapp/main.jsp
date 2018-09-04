<%--
  Created by IntelliJ IDEA.
  User: 陈磊
  Date: 2018/8/27 0027
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form method="post" id="pageForm" action="main.do">
    <table border="1px solid black">
        <thead><h2>热点事件排行榜</h2></thead>
        关键词:<input type="text" name="keyword" value="${keyword}"/>
        <input type="submit" value="查询"/>
        <tr>
            <td>关键词</td>
            <td>搜索指数</td>
            <td>创建时间</td>
        </tr>
        <c:forEach items="${list}" var="list" varStatus="status">
            <tr>
                <td><a href="search.do?id=${list.id}">${list.keyword}</a></td>
                <td>${list.searchsum}</td>
                <%--<td><fmt:formatDate value='${list.createdate}' type='time' pattern='yyyy-MM-dd'/></td>--%>
            </tr>
        </c:forEach>
    </table>
    <div>
        <input type="hidden" name="currPage" value="${pageNo}"/>
        <input type="hidden" name="pageTotal" value="${pageTotal}">
        <a href="javascript:void(0);" onclick="first(1)">首页</a>
        <a href="javascript:void(0);" onclick="pre(${pageNo})">上一页</a>
        <a href="javascript:void(0);" onclick="next(${pageNo})">下一页</a>
        <a href="javascript:void(0);" onclick="last(${pageTotal})">末页</a>
        共${countTotal}条记录,第${pageNo}页/共${pageTotal}页
    </div>
</form>
</body>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
    function first(num) {
        $("[name=currPage]").val(num);
        $("#pageForm").submit();
    }
    function pre(num) {
        if(num<=1){
            alert("当前已是首页!")
        }else{
            num--;
            $("[name=currPage]").val(num);
            $("#pageForm").submit();
        }
    }
    function next(num) {
        var pageTotal=$("[name=pageTotal]").val();
        if(num>=pageTotal){
            alert("当前已是末页!");
        }else{
            num++;
            $("[name=currPage]").val(num);
            $("#pageForm").submit();
        }
    }
    function last(num) {
        $("[name=currPage]").val(num);
        $("#pageForm").submit();
    }
</script>
</html>
