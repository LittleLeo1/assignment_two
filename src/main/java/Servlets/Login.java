package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import data.LoginDatabase;

@WebServlet(name = "Login")
public class Login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username= request.getParameter("username");
        String pword = request.getParameter("inputPassword");

        LoginDatabase LogIn = new LoginDatabase();

        if (LogIn.validUserLogin(username,pword))
        {
            response.sendRedirect("/Wall.jsp");
        }
        else {
             response.sendRedirect("Loing.html");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
