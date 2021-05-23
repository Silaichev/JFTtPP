package com.JFTtPP.services;

import com.JFTtPP.myJDBC.MenuOrdersDAO;

public class MenuOrdersService {
    public static void addMenuOrders(int idM, int idO, int quantity) {
        MenuOrdersDAO.addMenuOrders(idM, idO, quantity);
    }

    public static int getIdMenuOrdersByName(String name) {
        return MenuOrdersDAO.getIdMenuOrdersByName(name);
    }

}
