package com.myJDBC;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.models.Dish;
import com.models.Menu;
import com.sun.deploy.panel.ITreeNode;

import java.sql.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class DAO {

    public enum Category {
        starters, salads,
        main_dishes, meat, fish_and_seafoods,
        side_dishes, sauces, desserts,
        beverages
    }

    public enum State {
        fresh, preparing, delivering, done
    }
    //Work with users
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

    //Work with dishes
    public static void addDish(String name, Category category, int price) {
        try {
            Connection con = Pool.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO menu VALUE (default,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, category.name());
            ps.setInt(3, price);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void updateDishById(int id, String newName, Category category, int price) {
        try {
            Connection con = Pool.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE menu SET name=?,category=?,price=? WHERE idM=?");
            ps.setString(1, newName);
            ps.setString(2, category.name());
            ps.setInt(3, price);
            ps.setInt(4, id);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void updateDishByName(String oldName, String newName, Category category, int price) {
        try {
            Connection con = Pool.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE menu SET name=?,category=?,price=? WHERE name=?");
            ps.setString(1, newName);
            ps.setString(2, category.name());
            ps.setInt(3, price);
            ps.setString(4, oldName);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteDishById(int id) {
        try {
            Connection con = Pool.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM menu WHERE idM = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void deleteDishByName(String name) {
        try {
            Connection con = Pool.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM menu WHERE name = ?");
            ps.setString(1, name);
            ps.executeUpdate();
            ps.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public static Menu getMenu(){
        Connection con = null;
        PreparedStatement s = null;
        Menu menu = new Menu();
        try {
            con = Pool.getConnection();
            s = con.prepareStatement("SELECT * FROM menu");
            Dish temp ;
            ResultSet rs = s.executeQuery();
            while (rs.next()){
                temp = new Dish(rs.getInt("idM"),
                                rs.getString("name"),
                                rs.getString("category"),
                                rs.getInt("price"));
                menu.addDish(temp);
            }

            s.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return menu;
    }

    //Work with orders
    public static void addOrder(State state,String address,String name,int sum) {
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

    public static void addOrderWithoutSum(State state,String address,String name) {
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
    public static void setStateByName(String name,State oldState, State newState){
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
