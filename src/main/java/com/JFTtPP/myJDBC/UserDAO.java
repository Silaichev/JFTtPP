package com.JFTtPP.myJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public static void addUser(String name, String pass) {
        try {
            Connection con = Pool.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO users VALUE (default,?,?,2)");
            ps.setString(1, name);
            ps.setString(2, pass);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static boolean userExist(String name,String pass){
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = Pool.getConnection();
            ps = con.prepareStatement("SELECT * FROM users WHERE name=? AND pass=?");
            ps.setString(1, name);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally{
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return false;
    }

    public static String getAuthority(String name, String pass){
        Connection con=null;
        PreparedStatement ps = null;
        try {
            con = Pool.getConnection();
            ps = con.prepareStatement("SELECT authority FROM users JOIN authority a on a.idA = users.authority_id WHERE name=? AND pass=? ");
            ps.setString(1, name);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            rs.next();
            return rs.getString("authority");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return "";
    }
    public static int getIdByName(String name){

        try {
            Connection con = Pool.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT idU FROM users  WHERE name=? ");
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            rs.next();
            return Integer.parseInt(rs.getString("idU"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }
}
