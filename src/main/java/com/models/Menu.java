package com.models;

import com.myJDBC.DAO;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Menu {
    private List<Dish> list = new LinkedList<Dish>();

    public Menu() {

    }

    public void addDish(Dish dish){
        list.add(dish);
    }

    public List<Dish> getByCategory(DAO.Category category){
        List<Dish> temp = list.stream().filter(d->d.getCategory().equals(category.name())).collect(Collectors.toList());
        return temp;
    }
    public List<Dish> getAll(){
        return list;
    }

}
