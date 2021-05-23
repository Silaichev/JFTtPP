package com.JFTtPP.services;

import com.JFTtPP.models.Dish;
import com.JFTtPP.models.Menu;
import com.JFTtPP.myJDBC.DishDAO;
import com.JFTtPP.myJDBC.DishDAO;
import com.JFTtPP.myJDBC.OrderDAO;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

public class DishService {
    public static void addDish(String name, DishDAO.Category category, int price) {
        DishDAO.addDish(name, category, price);
    }

    public static void updateDishById(int id, String newName, DishDAO.Category category, int price) {
        DishDAO.updateDishById(id, newName, category, price);
    }

    public static void updateDishByName(String oldName, String newName, DishDAO.Category category, int price) {
        DishDAO.updateDishByName(oldName, newName, category, price);
    }

    public static void deleteDishById(int id) {
        DishDAO.deleteDishById(id);
    }

    public static void deleteDishByName(String name) {
        DishDAO.deleteDishByName(name);
    }

    public static Menu getMenu() {
        return DishDAO.getMenu();
    }

    public static List<DishDAO.Category> getCategories() {
        List<DishDAO.Category> enumList =
                new ArrayList<DishDAO.Category>(EnumSet.allOf(DishDAO.Category.class));
        return enumList;
    }

}
