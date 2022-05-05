<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="text-center">
    <h2>TỜ KHAI Y TẾ</h2>
    <h7>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH/CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỀ PHÒNG CHỐNG
        DỊCH BỆNH
    </h7>
    <p class="text-danger">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</p>
</div>
<br>
<div class="px-5">
    <form:form action="/edit" method="post" modelAttribute="form">
        <div class="col-12">
            <label class="form-label fw-bold">Họ tên (ghi chữ IN HOA): </label>
            <form:hidden path="name" value="${form.name}"/>
                ${form.name}
        </div>
        <br>
        <div class="row">
            <div class="col-4">
                <label class="form-label fw-bold">Ngày sinh: </label>
                <form:hidden path="dateOfBirth" value="${form.dateOfBirth}"/>
                    ${form.dateOfBirth}
            </div>
            <div class="col-4">
                <label class="form-label fw-bold">Giới tính: </label>
                <form:hidden path="gender" items="${gender}" value="${form.gender}"/>
                    ${form.gender}
            </div>
            <div class="col-4">
                <label class="form-label fw-bold">Quốc tịch: </label>
                <form:hidden path="country" value="${form.country}"/>
                    ${form.country}
            </div>
        </div>
        <br>
        <div class="col-12">
            <label class="form-label fw-bold">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác: </label>
            <form:hidden path="passportNumber" value="${form.passportNumber}"/>
                ${form.passportNumber}
        </div>
        <br>
        <div class="col-12">
            <label class="form-label fw-bold">Thông tin đi lại: </label><br>
            <form:hidden path="vehicle" value="${form.vehicle}"/>
                ${form.vehicle}
        </div>
        <br>
        <div class="col-12">
            <label class="form-label fw-bold">Số hiệu phương tiện: </label>
            <form:hidden path="vehicleCode" value="${form.vehicleCode}"/>
                ${form.vehicleCode}
        </div>
        <br>
        <div class="row">
            <div class="col-6">
                <label class="form-label fw-bold">Ngày khởi hành: </label>
                <form:hidden path="dayStart" value="${form.dayStart}"/>
                    ${form.dayStart}
            </div>
            <div class="col-6">
                <label class="form-label fw-bold">Ngày kết thúc: </label>
                <form:hidden path="dayEnd" value="${form.dayEnd}"/>
                    ${form.dayEnd}
            </div>
        </div>
        <br>
        <div class="col-12">
            <label class="form-label fw-bold">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào? </label>
            <form:hidden path="note" value="${form.note}"/>
                ${form.note}
        </div>
        <br>
        <div class="text-center">
            <button type="submit" class="btn btn-danger">SỬA TỜ KHAI</button>
        </div>
    </form:form>
</div>


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
        integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
        integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
        crossorigin="anonymous"></script>
</body>
</html>
