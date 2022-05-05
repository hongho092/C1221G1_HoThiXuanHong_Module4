<%@taglib prefix="h" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choose Menu</title>
    <style>
        div {
            padding-top: 50px;
            padding-left: 300px;
        }
    </style>
</head>
<body>
<div>
    <h2>Settings</h2>
    <form:form modelAttribute="setting" action="save" method="post">
        Languages: <form:select path="language" items="${languages}"/><br><br>
        Page Size: show <form:select path="pageSize" items="${pageSizes}"/> emails per page<br><br>
        Spams filter: <form:checkbox path="spamsFilter"/> Enable spams filter<br><br>
        Signature: <form:textarea path="signature"/><br><br>
        <input type="submit" value="save">
    </form:form>
</div>
<div>
<%--    <h4>${mess}</h4>--%>
<%--    <h:forEach var="con" items="${con}">--%>
<%--        ${con}<br>--%>
<%--    </h:forEach>--%>
</div>
</body>
</html>
