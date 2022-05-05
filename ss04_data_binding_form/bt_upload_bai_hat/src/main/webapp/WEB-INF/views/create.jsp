<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/5/2022
  Time: 2:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="text-align: center">
<form:form action="save" method="post" modelAttribute="song">
    Name: <form:input path="name" type="text"/><br><br>
    Singer: <form:input path="singer" type="text"/><br><br>
    Kind of music: <form:select path="kindOfMusic" items="${kom}"/><br><br>
    Path: <form:input path="path"/><br><br>
    <input type="submit" value="create">
</form:form>
</body>
</html>
