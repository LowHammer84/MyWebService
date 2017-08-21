<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Stas
  Date: 30.07.2017
  Time: 13:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="date" class="java.util.Date"/>
<html>
<head>
    <title>User</title>
    <link rel="icon" href="../Music-Treble-Clef-icon.png" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="../schedule.css">
</head>
<body>
<div id="allContent">
    <h1>Расписание выступлений оркестра</h1>
    <h2><c:out value="${date}"></c:out></h2>
<table border="2">
    <tr>
        <th>№</th>
        <th>Дата</th>
        <th>Названиe</th>
        <th>Выезд</th>
        <th>Информация</th>
    </tr>
    <c:forEach items="${requestScope.eventsList}" var="event" varStatus="status">
        <tr>
            <td>${status.index}</td>
            <td>${event.date}</td>
            <td>${event.title}</td>
            <td>${event.depart_time}</td>
            <td>${event.information}</td>
        </tr>
    </c:forEach>
</table>
<p><a href="../">Выход</a></p>
</div>
</body>
</html>
