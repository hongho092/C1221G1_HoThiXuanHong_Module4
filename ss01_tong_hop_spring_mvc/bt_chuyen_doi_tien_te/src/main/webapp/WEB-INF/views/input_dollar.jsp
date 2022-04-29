<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/29/2022
  Time: 1:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change Money</title>
</head>
<body>
<form action="/change" method="post">
    <p>Input Dolla</p>
    <input type="number" name="dollar" placeholder="${dollar}">
    <input type="submit" value="Change">
</form>
<p>${vnd} vnd</p>
</body>
</html>
