package com.myJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderDAO {
    //Work with orders
    public static void addOrder(DAO.State state, String address, String name, int sum) {
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

    public static void addOrderWithoutSum(DAO.State state, String address, String name) {
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
    public static void setStateByName(String name, DAO.State oldState, DAO.State newState){
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

}
