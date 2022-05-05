
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h2> Setting</h2>
<form:form action="" modelAttribute="mail" method="post">

    <div>
        <span>Languages</span>
        <form:select path="languages" >
            <form:option value="english">English</form:option>
            <form:option value="vietnamese">Vietnamese</form:option>
            <form:option value="japanese">Japanese</form:option>
            <form:option value="chinese">Chinese</form:option>
        </form:select>
    </div>

    <div>
        <span> Page Size:</span>
        <span> Show <form:input type="number" min="5" max="100" placeholder="25" path="show"/> email per page </span>
    </div>

    <div>
        <span>Spams fittelr</span>
        <form:checkbox  path="spams" value="spams"/> <span>enable spams fitter</span>
    </div>


    <div>
        <span>Signature</span>
        <form:textarea rows="9" cols="70" path="signature"/>

    </div>
    <div><input type="submit" value="update"></div>


</form:form>

</body>
</html>
