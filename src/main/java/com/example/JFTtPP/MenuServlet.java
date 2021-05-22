package com.example.JFTtPP;

import com.models.Menu;
import com.models.Visitor;
import com.myJDBC.DAO;
import com.myJDBC.MenuOrdersDAO;
import com.myJDBC.OrderDAO;
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
        getServletContext().getRequestDispatcher("/menu.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] dishes = request.getParameterValues("dishes");
        String address = request.getParameter("address");
        String name = ((Visitor)request.getSession().getAttribute("visitor")).getName();
        Menu menu = (Menu) request.getSession().getAttribute("menu");
        int sum = 0;

        OrderDAO.addOrderWithoutSum(DAO.State.fresh,address,name);

        for (String str : dishes) {
            MenuOrdersDAO.addMenuOrders(menu.getDishByName(str).getId(),
                              MenuOrdersDAO.getIdMenuOrdersByName(name),
                              Integer.parseInt(request.getParameter(str)));
            sum += menu.getDishByName(str).getPrice() * Integer.parseInt(request.getParameter(str));
        }

        OrderDAO.setSumByName(name,sum);
        for (String str : dishes) {
            System.out.println(str + " - " + request.getParameter(str));
        }

    }
}
