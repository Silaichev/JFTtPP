package com.JFTtPP.servlets;

import com.JFTtPP.security.SecurityUtils;
import com.JFTtPP.services.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Admin", value = "/Admin")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SecurityUtils.checkVisitor(request, response);
        SecurityUtils.checkAdmin(request, response);
        getServletConfig().getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            System.out.println(request.getParameter("orderId"));
            OrderService.setStateById(Integer.valueOf(request.getParameter("orderId")),request.getParameter("selectedState"));
            getServletConfig().getServletContext().getRequestDispatcher("/resend.jsp").forward(request, response);
    }
}
