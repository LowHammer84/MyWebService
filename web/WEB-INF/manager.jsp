<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: Stanislav
  Date: 05.07.2017
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8"%>
<jsp:useBean id="date" class="java.util.Date"/>
<html>
<head>
    <title>Оркестр полиции</title>
    <link rel="icon" href="../Music-Treble-Clef-icon.png" type="image/x-icon">
    <link rel="stylesheet" type="text/css" href="../schedule.css">
</head>
<body>
<div id="allContent">
    <h1>Расписание выступлений оркестра</h1>
    <h3>Сегодня <fmt:formatDate value="${date}" pattern="dd MMMM yyyy,  HH:mm"/></h3>
<table border="2">
        <tr>
            <th>№</th>
            <th>Дата</th>
            <th>Названиe</th>
            <th>Выезд</th>
            <th>Информация</th>
            <th>Удалить</th>
        </tr>
    <c:forEach items="${requestScope.eventsList}" var="event" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${event.date}</td>
            <td>${event.title}</td>
            <td>${event.depart_time}</td>
            <td>${event.information}</td>
            <td><a href="${pageContext.request.contextPath}/delete?id=${event.id}" ><img src="../delete-icon.png" alt="удалить"></a></td>
        </tr>
    </c:forEach>

    <form action="/add" method="post" accept-charset="UTF-8">
    <tr>
        <td></td>
        <%
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            out.println("<td><input type=\"date\" name=\"date\" value=\"" + ft.format(dNow) + "\"></td>");
        %>
        <td><input type="text" name="title" value="Мероприятие"></td>
        <td><input type="time" name="dep_time" value="10:00"></td>
        <td><input type="text" name="information" value="Обычное мероприятие"></td>
        <td><input type="image" src="../add-icon.png" name="добавить"></td>
    </tr>
    </form>
</table>
    <p><a href="../">Выход</a></p>
</div>
</body>
</html>
