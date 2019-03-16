package Servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import classes.post;
import data.postStuff;

@WebServlet(name = "Post")
public class Post extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        post Post =new post();
        postStuff postAdder = new postStuff();
        Post.setTitle(request.getParameter("PostTItle"));
        Post.setBody(request.getParameter("TextBody"));
        Post.setSetting(request.getParameter("Setting"));
        Post.setDate(request.getParameter("DateSet"));
        String message =  postAdder.addAPost(Post);
        request.setAttribute("isITGood?",message);
        request.getRequestDispatcher("/Wall.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
