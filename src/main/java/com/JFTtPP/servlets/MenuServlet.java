package com.JFTtPP.servlets;

import com.JFTtPP.models.Menu;
import com.JFTtPP.models.Visitor;
import com.JFTtPP.myJDBC.OrderDAO;
import com.JFTtPP.myJDBC.MenuOrdersDAO;
import com.JFTtPP.myJDBC.OrderDAO;
import com.JFTtPP.security.SecurityUtils;
import com.JFTtPP.services.MenuOrdersService;
import com.JFTtPP.services.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Menu", value = "/Menu")
public class MenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SecurityUtils.checkVisitor(request, response);
        getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] dishes = request.getParameterValues("dishes");
        String address = request.getParameter("address");
        String name = ((Visitor)request.getSession().getAttribute("visitor")).getName();
        Menu menu = (Menu) request.getSession().getAttribute("menu");
        int sum = 0;

        OrderDAO.addOrderWithoutSum(OrderDAO.State.fresh,address,name);

        for (String str : dishes) {
            MenuOrdersService.addMenuOrders(menu.getDishByName(str).getId(),
                              MenuOrdersService.getIdMenuOrdersByName(name),
                              Integer.valueOf(request.getParameter(str)));
            sum += menu.getDishByName(str).getPrice() * Integer.parseInt(request.getParameter(str));
        }
        OrderService.setSumByName(name,sum);
        getServletContext().getRequestDispatcher("/preparing.jsp").forward(request, response);
    }
}
