package com.JFTtPP.servlets;

import com.JFTtPP.myJDBC.UserDAO;
import com.JFTtPP.services.UserService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Register", value = "/Register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/register.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("username");
        String pass = request.getParameter("pass");
        UserService.addUser(name,pass);
        request.setAttribute("name",name);
        request.setAttribute("pass",pass);
        getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
    }
}
