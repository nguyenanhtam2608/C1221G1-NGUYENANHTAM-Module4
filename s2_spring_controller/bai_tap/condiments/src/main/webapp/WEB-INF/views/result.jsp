<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 03/05/2022
  Time: 10:12 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2> Gia vị đã chọn</h2>


<c:forEach var="kq" items="${result}">
    ${kq}
</c:forEach>


</body>
</html>
