<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 05/05/2022
  Time: 1:48 CH
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1> Ứng dụng nghe nhạc tùm lum tà la</h1>

<form:form method="post" modelAttribute="upload" action="/result">
    <div>
        <p>Tên bài hát</p>
        <form:input type="text" path="nameBaiHat"/>
    </div>
    <div>
        <p>Nghệ sĩ thể hiện</p>
        <form:input type="text" path="nameNgheSi"/>
    </div>
    <div>
        <p>Thể loại nhạc</p>
        <form:select path="theLoai">
            <form:option value="pop">Pop</form:option>
            <form:option value="rock">Rock</form:option>
            <form:option value="jazz">Jazz</form:option>
            <form:option value="blues">Blues</form:option>
            <form:option value="hiphop">Hip Hop</form:option>
        </form:select>
    </div>
    <div>
        <p>Tên Đường Dẫn </p>
        <form:input type="text" path="duongDan" value=".mp3"/>
    </div>

    <button type="submit" value="sub"> sub</button>

</form:form>

</body>
</html>
