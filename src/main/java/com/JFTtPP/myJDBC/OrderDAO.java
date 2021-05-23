package com.JFTtPP.myJDBC;

import com.JFTtPP.models.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class OrderDAO {
    public enum State {
        fresh, preparing, delivering, done
    }
    //Work with orders
    public static void addOrder(OrderDAO.State state, String address, String name, int sum) {
        try {
            Connection con = Pool.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO orders value (default,?,?,?,?)");
            ps.setString(1, state.name());
            ps.setString(2,address);
            ps.setString(3,name);
            ps.setInt(4,sum);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void addOrderWithoutSum(OrderDAO.State state, String address, String name) {
        try {
            Connection con = Pool.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO orders value (default,?,?,?,null)");
            ps.setString(1, state.name());
            ps.setString(2,address);
            ps.setString(3,name);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void setSumByName(String name, int sum){
        try {
            Connection con = Pool.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE orders SET sum=? WHERE name=? AND state='fresh'");
            ps.setInt(1,sum);
            ps.setString(2,name);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void setStateByName(String name, OrderDAO.State oldState, OrderDAO.State newState){
        try {
            Connection con = Pool.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE orders SET state=? WHERE name=? AND state=?");
            ps.setString(1,newState.name());
            ps.setString(2,name);
            ps.setString(3, oldState.name());
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static void setStateById(int id, String newState){
        try {
            Connection con = Pool.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE orders SET state=? WHERE idO=? ");
            ps.setString(1,newState);
            ps.setInt(2,id);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static List<Order> getOrders(){
        List<Order> list = new LinkedList<>();

        Connection con = null;
        PreparedStatement s = null;

        try {
            con = Pool.getConnection();
            s = con.prepareStatement("SELECT * FROM orders");
            Order temp;
            ResultSet rs = s.executeQuery();
            while (rs.next()){
                temp = new Order(rs.getInt("idO"),
                                 rs.getString("name"),
                                 rs.getString("address"),
                                 rs.getString("state"),
                                 rs.getInt("sum"));
                list.add(temp);
            }

            s.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

}
