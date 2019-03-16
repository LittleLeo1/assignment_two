package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import classes.user;
import data.addUser;

@WebServlet(name = "Register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        user User = new user();
        User.seteMail(request.getParameter("emailAddress"));
        User.setUsername(request.getParameter("username"));
        User.setPassword(request.getParameter("Password"));
        addUser user = new addUser();
        user.addAUser(User);
        response.sendRedirect("/Profile.html");






    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
