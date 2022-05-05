
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show Setting</title>
    <style>
        div {
            padding-top: 50px;
            padding-left: 300px;
        }
    </style>
</head>
<body>
    Language: ${setting.language}
    Page size: ${setting.pageSize}
    Spams filter: ${setting.spamsFilter}
    Signature: ${setting.signature}
</body>
</html>
