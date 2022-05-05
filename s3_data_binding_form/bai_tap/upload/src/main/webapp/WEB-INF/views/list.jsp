<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 05/05/2022
  Time: 2:18 CH
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>List Bài Hát </h1>

<a href="/upload"> Thêm mới bài hát </a>
<table border="1px">
    <tr>
        <th>Tên bài hát</th>
        <th> Ca sĩ</th>
        <th> Thể loại</th>
        <th> Link</th>
    </tr>

        <c:forEach var="item" items="${list}">
    <tr>
            <th> ${item.nameBaiHat}</th>
            <th> ${item.nameNgheSi}</th>
            <th> ${item.theLoai}</th>
            <th> ${item.duongDan}</th>
    </tr>
        </c:forEach>

</table>
</body>
</html>
