<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 03/05/2022
  Time: 10:00 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gia vị</title>
</head>
<body>
<h2> Gia vị </h2>
<form method="post" action="save">
    <span>Lettuce</span>
    <input type="checkbox" name="condiment" value="lettuce">
    <span>Tomato</span>
    <input type="checkbox" name="condiment" value="tomato">
    <span>Mustard</span>
    <input type="checkbox" name="condiment" value="mustard">
    <span>Sprouts</span>
    <input type="checkbox" name="condiment" value="sprouts">
    <hr>


    <input type="submit" value="save">
</form>
</body>
</html>
