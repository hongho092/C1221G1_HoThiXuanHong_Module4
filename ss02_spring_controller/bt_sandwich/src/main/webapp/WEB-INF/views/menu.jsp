<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/4/2022
  Time: 1:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="h" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choose Menu</title>
    <style>
        div {
            padding-left: 300px;
        }
    </style>
</head>
<body>
<div>
    <form action="/save" method="post">
        <h2>Sandwich Condiments:</h2>
        <label><input name="condiment" value="Lettuce" type="checkbox"/>Lettuce</label> <br/>
        <label><input name="condiment" value="Tomato" type="checkbox"/>Tomato</label> <br/>
        <label><input name="condiment" value="Mustard" type="checkbox"/>Mustard</label> <br/>
        <label><input name="condiment" value="Sprouts" type="checkbox"/>Sprouts</label> <br/>
        <lable><input type="submit" value="Confirm"></lable>
    </form>
</div>
<div>
    <h4>${mess}</h4>
    <h:forEach var="con" items="${con}">
        ${con}<br>
    </h:forEach>
</div>
</body>
</html>
