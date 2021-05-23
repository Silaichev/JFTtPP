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
        //Проверка есть ли вообще такой пользователь в БД
        if(UserService.userExist(name,pass)){
            request.getSession().setAttribute("visitor",new Visitor(UserService.getIdByName(name),name));
            request.getSession().setAttribute("authority",UserService.getAuthority(name,pass));
            System.out.println(UserService.getAuthority(name,pass) );
            //Если он гость(посетитель)
            if(UserService.getAuthority(name,pass).equals("visitor")){
                request.getSession().setAttribute("menu", DishService.getMenu());
                getServletContext().getRequestDispatcher("/menu.jsp").forward(request,response);
                //Если он админ(работник)
            }else{
                getServletContext().getRequestDispatcher("/admin.jsp").forward(request,response);
            }
            //Если такого пользователя нет в БД
        }else{
            request.getSession().setAttribute("loginError","Bad credentials");
            getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
