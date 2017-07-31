package com.mysoft;
import java.io.IOException;


@javax.servlet.annotation.WebServlet(name = "AuthServlet", urlPatterns = "/auth")
public class AuthServlet extends javax.servlet.http.HttpServlet {


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        if (login.equals("admin") && password.equals("1234")) {
            response.sendRedirect("/events?authorization=admin");
        } else if (login.equals("user") && password.equals("1234")){
            response.sendRedirect("/events?authorization=user");
        } else {
            response.getWriter().print("Ошибка авторизации");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}

