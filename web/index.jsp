<%--
  Created by IntelliJ IDEA.
  User: Stanislav
  Date: 05.07.2017
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="utf-8"%>
<html>
  <head>
      <link rel="icon" href="Music-Treble-Clef-icon.png" type="image/x-icon">
      <title>Расписание игр оркестра - авторизация</title>
  </head>
  <body>
     <form action="auth" method="post" accept-charset="UTF-8">
         <p>
             <h1>Введите логин и пароль <br></h1>
             <table>
             <tr> <td>Логин:</td> <td><input type="text" name="login" value="" placeholder="user"/></td></tr>
             <tr><td>Пароль:</td><td><input type="password" name="password" value="" placeholder="1234"/></td></tr>
             </table>
             <input type="submit"/>
         </p>
     </form>
  </body>
</html>
