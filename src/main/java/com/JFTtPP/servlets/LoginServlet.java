package com.JFTtPP.servlets;

import com.JFTtPP.models.Visitor;
import com.JFTtPP.myJDBC.DishDAO;
import com.JFTtPP.myJDBC.UserDAO;
import com.JFTtPP.services.DishService;
import com.JFTtPP.services.UserService;

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
        if(UserService.userExist(name,pass)){

            request.getSession().setAttribute("visitor",new Visitor(UserService.getIdByName(name),name));
            request.getSession().setAttribute("authority",UserService.getAuthority(name,pass));
            System.out.println(UserService.getAuthority(name,pass) );
            if(UserService.getAuthority(name,pass).equals("visitor")){
                request.getSession().setAttribute("menu", DishService.getMenu());
                getServletContext().getRequestDispatcher("/menu.jsp").forward(request,response);
            }else{
                getServletContext().getRequestDispatcher("/admin.jsp").forward(request,response);
            }

        }else{

        }

    }
}
