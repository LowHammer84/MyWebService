package com.mysoft;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "ShowEvents", urlPatterns = "/events")
public class ShowEvents extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String authorization = request.getParameter("authorization");
        if (authorization.equals("admin")) {
            request.setAttribute("eventsList", DAO.getEventsList());
            request.getRequestDispatcher("WEB-INF/manager.jsp").forward(request,response);
        } else if (authorization.equals("user")){
            request.setAttribute("eventsList", DAO.getEventsList());
            request.getRequestDispatcher("WEB-INF/user.jsp").forward(request,response);
        }

    }
}