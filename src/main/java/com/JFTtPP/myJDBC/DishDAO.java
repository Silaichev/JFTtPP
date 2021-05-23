package com.JFTtPP.myJDBC;

import com.JFTtPP.models.Dish;
import com.JFTtPP.models.Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DishDAO {
    public enum Category {
        starters, salads,
        main_dishes, meat, fish_and_seafoods,
        side_dishes, sauces, desserts,
        beverages
    }
    //Work with dishes
    public static void addDish(String name, DishDAO.Category category, int price) {
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

    public static void updateDishById(int id, String newName, DishDAO.Category category, int price) {
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

    public static void updateDishByName(String oldName, String newName, DishDAO.Category category, int price) {
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
}
