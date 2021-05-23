package com.JFTtPP.models;

import com.JFTtPP.myJDBC.DishDAO;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Menu {
    private List<Dish> list = new LinkedList<Dish>();

    public Menu() {

    }

    public void addDish(Dish dish) {
        list.add(dish);
    }

    public List<Dish> getByCategory(DishDAO.Category category) {
        List<Dish> temp = list.stream().filter(d -> d.getCategory().equals(category.name())).collect(Collectors.toList());
        return temp;
    }

    public List<Dish> getAll() {
        return list;
    }

    /*   public int getPriceByName(String dishName){

          List<Dish> result = list.stream().filter(d->d.getName().equals(dishName)).collect(Collectors.toList());
          if(result.size()>0){
              return result.get(0).getPrice();
          }
          return 0;
       }*/
    public Dish getDishByName(String dishName) {
        List<Dish> result = list.stream().filter(d -> d.getName().equals(dishName)).collect(Collectors.toList());
        return result.get(0);
    }

}
