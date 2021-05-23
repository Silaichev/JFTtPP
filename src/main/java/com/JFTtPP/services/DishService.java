package com.JFTtPP.services;

import com.JFTtPP.models.Menu;
import com.JFTtPP.myJDBC.DishDAO;
import com.JFTtPP.myJDBC.DishDAO;

public class DishService {
    public static void addDish(String name, DishDAO.Category category, int price){
        DishDAO.addDish(name,category,price);
    }
    public static void updateDishById(int id, String newName, DishDAO.Category category, int price) {
        DishDAO.updateDishById(id,newName,category,price);
    }
    public static void updateDishByName(String oldName, String newName, DishDAO.Category category, int price) {
        DishDAO.updateDishByName(oldName,newName,category,price);
    }
    public static void deleteDishById(int id) {
        DishDAO.deleteDishById(id);
    }
    public static void deleteDishByName(String name) {
        DishDAO.deleteDishByName(name);
    }
    public static Menu getMenu(){
        return  DishDAO.getMenu();
    }
}
