package com.mysoft;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@javax.servlet.annotation.WebServlet(name = "AuthServlet", urlPatterns = "/index.jsp")
public class AuthServlet extends javax.servlet.http.HttpServlet {


    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        if (login.equals("admin") && password.equals("1234")) {
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(300);
            session.setAttribute("logged-in", "admin");
            System.out.println(session);
            request.setAttribute("eventsList", DAO.getEventsList());
            request.getRequestDispatcher("WEB-INF/manager.jsp").forward(request,response);
        } else if (login.equals("user") && password.equals("1234")){
            HttpSession session = request.getSession();
            session.setAttribute("logged-in", "user");
            System.out.println(session);
            request.setAttribute("eventsList", DAO.getEventsList());
            request.getRequestDispatcher("WEB-INF/user.jsp").forward(request,response);
        } else {
            response.getWriter().print("Ошибка авторизации");
        }
    }
    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null) {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Login</title>");
        out.println("<link rel=\"icon\" href=\"../Music-Treble-Clef-icon.png\" type=\"image/x-icon\">");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"../login.css\">");
        out.println("</head>");
        out.println("<body>");
        out.println("<div id=allContent>");
        out.println("<form action=\"/index.jsp\" method=\"post\" accept-charset=\"UTF-8\"><p>");
        out.println("<h1>Введите логин и пароль</h1><br>");
        out.println("<table>");
        out.println("<tr> <td>Логин:</td><td><input type=\"text\" name=\"login\" value=\"\" placeholder=\"user\"/></td></tr>");
        out.println("<tr><td>Пароль:</td><td><input type=\"password\" name=\"password\" value=\"\" placeholder=\"1234\"/></td></tr>");
        out.println("<tr><td><input type=\"submit\"/></td><td></td></tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
        } else {
            String logged = (String) session.getAttribute("logged-in");
            System.out.println(logged);
            if (logged.equals("admin")) {
                request.setAttribute("eventsList", DAO.getEventsList());
                request.getRequestDispatcher("WEB-INF/manager.jsp").forward(request,response);
            } else if (logged.equals("user")) {
                request.setAttribute("eventsList", DAO.getEventsList());
                request.getRequestDispatcher("WEB-INF/user.jsp").forward(request,response);
            }
        }
    }
}

