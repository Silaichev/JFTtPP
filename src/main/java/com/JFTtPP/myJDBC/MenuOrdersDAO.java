package com.JFTtPP.myJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuOrdersDAO {
    //Working with menu_orders
    public static void addMenuOrders(int idM, int idO, int quantity){
        try {
            Connection con = Pool.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO menu_orders VALUE (?,?,?)");
            ps.setInt(1,idO);
            ps.setInt(2,idM);
            ps.setInt(3,quantity);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static int getIdMenuOrdersByName(String name){
        try {
            Connection con = Pool.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT idO FROM orders  WHERE name=? ");
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            rs.next();
            return Integer.parseInt(rs.getString("idO"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
