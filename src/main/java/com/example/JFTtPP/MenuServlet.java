package com.example.JFTtPP;

import com.security.SecurityUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "MenuS", value = "/Menu")
public class MenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SecurityUtils.checkVisitor(request, response);
        getServletContext().getRequestDispatcher("/menu.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] dishes = request.getParameterValues("dishes");
        String num = request.getParameter(dishes[0]);
        for(String str : dishes){
            System.out.println(str+" - "+request.getParameter(str));
        }


    }
}
