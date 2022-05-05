<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 05/05/2022
  Time: 5:19 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/">Create Khai báo </a>
<table border="1px">
    <tr>
        <th>Tên</th>
        <th>Ngày Sinh</th>
        <th>Giới tính</th>
        <th>Quốc tịch</th>
        <th>Số căn cước</th>
        <th>Phương tiện </th>
        <th>Số Hiệu xe</th>
        <th>Số ghế</th>
        <th>Ngày khởi hành</th>
        <th>Ngày đến</th>
        <th>Nơi đã đến </th>
    </tr>

    <c:forEach var="list" items="${list}">
<tr>
        <th>${list.ten}</th>
        <th>${list.ngaySinh}</th>
        <th>${list.gioiTinh}</th>
        <th>${list.quocTich}</th>
        <th>${list.cmnd}</th>
        <th>${list.phuongTien}</th>
        <th>${list.soHieu}</th>
        <th>${list.soGhe}</th>
        <th>${list.ngayDi}</th>
        <th>${list.ngayDen}</th>
        <th>${list.noiDiQua}</th>
</tr>
    </c:forEach>


</table>
</body>
</html>
