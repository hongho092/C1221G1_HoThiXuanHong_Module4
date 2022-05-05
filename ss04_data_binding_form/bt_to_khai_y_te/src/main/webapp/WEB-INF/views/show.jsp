<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="text-center">
    <h2>TỜ KHAI Y TẾ</h2>
    <h7>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỀ PHÒNG CHỐNG DỊCH BỆNH</h7>
    <p class="text-danger">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</p>
    <br>
    <p class="text-warning fw-bold">${mess}</p>
</div>
<br>
<div class="px-5">
    <form:form action="/save" method="post" modelAttribute="form">
        <div class="col-12">
            <label for="1" class="form-label fw-bold">Họ tên (ghi chữ IN HOA)</label>
            <form:input type="text" class="form-control" id="1" path="name" value="${formEdit.name}"/>
        </div>
        <br>
        <div class="row">
            <div class="col-4">
                <label for="2" class="form-label fw-bold">Ngày sinh</label>
                <form:input type="date" class="form-control" id="2" path="dateOfBirth" value="${formEdit.dateOfBirth}"/>
            </div>
            <div class="col-4">
                <label for="3" class="form-label fw-bold">Giới tính</label>
                <form:select class="form-control" id="3" path="gender" items="${gender}" value="${formEdit.gender}"/>
            </div>
            <div class="col-4">
                <label for="4" class="form-label fw-bold">Quốc tịch</label>
                <form:input type="text" class="form-control" id="4" path="country" value="${formEdit.country}"/>
            </div>
        </div>
        <br>
        <div class="col-12">
            <label for="5" class="form-label fw-bold">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác</label>
            <form:input type="text" class="form-control" id="5" path="passportNumber" value="${formEdit.passportNumber}"/>
        </div>
        <br>
        <div class="col-12">
            <label for="6" class="form-label fw-bold">Thông tin đi lại</label><br>
            <form:radiobuttons id="6" path="vehicle" items="${vehicle}" value="${formEdit.vehicle}" select="${formEdit.vehicle}"/>
        </div>
        <br>
        <div class="col-12">
            <label for="7" class="form-label fw-bold">Số hiệu phương tiện</label>
            <form:input type="text" class="form-control" id="7" path="vehicleCode" value="${formEdit.vehicleCode}"/>
        </div>
        <br>
        <div class="row">
            <div class="col-6">
                <label for="8" class="form-label fw-bold">Ngày khởi hành</label>
                <form:input type="date" class="form-control" id="8" path="dayStart" value="${formEdit.dayStart}"/>
            </div>
            <div class="col-6">
                <label for="9" class="form-label fw-bold">Ngày kết thúc</label>
                <form:input type="date" class="form-control" id="9" path="dayEnd" value="${formEdit.dayEnd}"/>
            </div>
        </div>
        <br>
        <div class="col-12">
            <label for="10" class="form-label fw-bold">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?</label>
            <form:input type="text" class="form-control" id="10" path="note" value="${formEdit.note}"/>
        </div>
        <br>
        <div class="text-center">
            <button type="submit" class="btn btn-primary">GỬI TỜ KHAI</button>
        </div>
    </form:form>
</div>




<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
