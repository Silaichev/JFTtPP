package com.example.JFTtPP;

import com.models.Visitor;
import com.myJDBC.DAO;
import com.myJDBC.DishDAO;
import com.myJDBC.UserDAO;

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
        if(UserDAO.userExist(name,pass)){

            request.getSession().setAttribute("visitor",new Visitor(UserDAO.getIdByName(name),name));
            request.getSession().setAttribute("authority",UserDAO.getAuthority(name,pass));
            request.getSession().setAttribute("menu", DishDAO.getMenu());
            getServletContext().getRequestDispatcher("/menu.jsp").forward(request,response);
        }else{

        }

    }
}
