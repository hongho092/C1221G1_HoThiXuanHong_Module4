<%@taglib prefix="h" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        div {
            padding-left: 500px;
        }
    </style>
</head>
<body style="text-align: center">
    <button><a href="/create">create song</a></button>
    <p>${mess}</p>
    <div style="text-align: center">
        <table border="1">
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Singer</th>
                <th>Kind Of Music</th>
                <th>Path</th>
            </tr>
            <h:forEach items="${song}" var="song" varStatus="hong">
                <tr>
                    <td>${hong.count}</td>
                    <td>${song.name}</td>
                    <td>${song.singer}</td>
                    <td>${song.kindOfMusic}</td>
                    <td><a href="${song.path}">click</a></td>
                </tr>
            </h:forEach>
        </table>
    </div>
</body>
</html>
