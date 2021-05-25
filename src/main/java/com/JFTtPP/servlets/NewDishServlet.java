package com.JFTtPP.servlets;

import com.JFTtPP.security.SecurityUtils;
import com.JFTtPP.services.DishService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "NewDish", value = "/NewDish")
public class NewDishServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SecurityUtils.checkVisitor(request, response);
        SecurityUtils.checkAdmin(request, response);
        getServletConfig().getServletContext().getRequestDispatcher("/newDish.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String category = request.getParameter("selectedCategory");
        int price = Integer.valueOf(request.getParameter("price"));
        DishService.addDish(name,category,price);
        getServletConfig().getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);

    }
}
