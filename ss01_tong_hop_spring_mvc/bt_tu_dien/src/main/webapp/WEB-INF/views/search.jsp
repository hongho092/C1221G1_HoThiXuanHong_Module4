<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/29/2022
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>辞書</title>
</head>
<body>
<form action="/search" method="post">
  <p>言葉</p>
  <input type="text" name="word">
  <input type="submit" value="探す">
</form>
<p>この言葉は　${newWord}</p>
</body>
</html>
