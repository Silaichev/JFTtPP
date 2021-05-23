package com.JFTtPP.servlets;

import com.JFTtPP.security.SecurityUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Admin", value = "/Admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SecurityUtils.checkAdmin(request, response);

        getServletConfig().getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String o = request.getParameter("button");
        System.out.println(request.getParameterNames());
        System.out.println(o);


    }
}
