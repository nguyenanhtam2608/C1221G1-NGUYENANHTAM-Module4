<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 05/05/2022
  Time: 4:12 CH
  To change this template use File | Settings | File Templates.
--%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <style>
        h1 {
            text-align: center;
        }

        .thep {
            text-align: center;
            color: red;
        }
    </style>
</head>
<body>
<h1>Tờ khai y tế</h1>
<p class="thep">Đây là tài liệu quang trọng </p>

<form:form action="" modelAttribute="yTe" cssStyle="text-align: center" method="post">
    <div><p>Họ và tên (IN HOA) </p>
        <form:input path="ten"/>
    </div>

    <div><p>Ngày Sinh</p>
        <form:input type="date" path="ngaySinh"/>
    </div>
    <br>
    <div><span>Giới Tính</span>
        <form:select path="gioiTinh">
            <form:option value="Nam"/>
            <form:option value="Nữ"/>
        </form:select>
    </div>

    <div><p>Quốc tịch </p>
        <form:input path="quocTich"/>
    </div>

    <div><p>CMND </p>
        <form:input type="number" path="cmnd"/>
    </div>

    <div><p>Phương tiện di chuyển </p>
        <form:radiobutton path="phuongTien" value="maybay"/> <label>Máy Bay</label>
        <form:radiobutton path="phuongTien" value="tauthuyen"/><label>Tàu Thuyền </label>
        <form:radiobutton path="phuongTien" value="oto"/><label>Ô tô</label>
        <form:radiobutton path="phuongTien" value="khac"/><label>Khác</label>
    </div>

    <div><p>Số Hiệu Xe </p>
        <form:input type="number" path="soHieu"/>
    </div>

    <div><p>Số Ghế</p>
        <form:input type="number" path="soGhe"/>
    </div>

    <div><p>Ngày Khởi hành</p>
        <form:input type="date" path="ngayDi"/>
    </div>

    <div><p>Ngày kết thúc</p>
        <form:input type="date" path="ngayDen"/>
    </div>

    <div><p>nơi đi qua</p>
        <form:input path="noiDiQua"/>
    </div>
    <div>
        <input type="submit" value="Sub">
    </div>
</form:form>

</body>
</html>
