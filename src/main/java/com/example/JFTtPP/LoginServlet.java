package com.example.JFTtPP;

import com.myJDBC.DAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Login", value = "/Login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("login");
        String pass = request.getParameter("pass");
        if(DAO.userExist(name,pass)){
            request.getSession().setAttribute("authority",DAO.getAuthority(name,pass));
            getServletContext().getRequestDispatcher("/menu.jsp").forward(request,response);
        }

    }
}
