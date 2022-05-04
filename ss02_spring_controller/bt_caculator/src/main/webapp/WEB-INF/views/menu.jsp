<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/4/2022
  Time: 2:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
    <style>
        div {
          padding-left: 300px;
        }
    </style>
</head>
<body>
<div>
    <form action="/calculator", method="get">
        <h2>Calculator</h2>
        <input type="number" name="number1"><p>     </p>
        <input type="number" name="number2"><br><br>
        <input type="submit" name="calculator" value="Addition">
        <input type="submit" name="calculator" value="Subtraction">
        <input type="submit" name="calculator" value="Multiplication">
        <input type="submit" name="calculator" value="Division">
    </form>
</div>
<div>
    ${show}
    ${result}
</div>
</body>
</html>
