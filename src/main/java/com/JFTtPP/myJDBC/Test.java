package com.JFTtPP.myJDBC;

import com.JFTtPP.services.OrderService;

import java.sql.*;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        /*Connection con = Pool.getConnection();
        PreparedStatement pst = con
                .prepareStatement("SELECT * FROM users WHERE name='SMV' AND pass='q2w1e4r33' ");

        ResultSet rSet = pst.executeQuery();
        System.out.println(rSet.next());
        System.out.println(DAO.getAuthority("Alina","asdf"));*/
        /*        DAO.addDish("Soop", DAO.Category.starters,35);

         */
        System.out.println(OrderService.getOrdersWithoutDone().size());
    }
}
