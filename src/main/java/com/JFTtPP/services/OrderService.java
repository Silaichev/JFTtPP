package com.JFTtPP.services;

import com.JFTtPP.models.Order;
import com.JFTtPP.myJDBC.OrderDAO;
import com.JFTtPP.myJDBC.OrderDAO;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class OrderService {

    public static void setStateById(int id, String newState){
        OrderDAO.setStateById(id,newState);
    }
    public static List<OrderDAO.State> getStates(){
        List<OrderDAO.State> enumList =
                new ArrayList<OrderDAO.State>(EnumSet.allOf(OrderDAO.State.class));
        return enumList;
    }

    public static void addOrder(OrderDAO.State state, String address, String name, int sum) {
        OrderDAO.addOrder(state, address, name, sum);
    }
    public static void addOrderWithoutSum(OrderDAO.State state, String address, String name) {
        OrderDAO.addOrderWithoutSum(state, address, name);
    }
    public static void setSumByName(String name, int sum){
        OrderDAO.setSumByName(name, sum);
    }
    public static void setStateByName(String name, OrderDAO.State oldState, OrderDAO.State newState){
        OrderDAO.setStateByName(name, oldState, newState);
    }
    public static List<Order> getOrders(){
        return OrderDAO.getOrders();
    }
}
