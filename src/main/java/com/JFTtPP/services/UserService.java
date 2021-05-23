package com.JFTtPP.services;

import com.JFTtPP.myJDBC.UserDAO;

public class UserService {
    public static void addUser(String name, String pass) {
        UserDAO.addUser(name, pass);
    }
    public static boolean userExist(String name,String pass){
        return UserDAO.userExist(name, pass);
    }
    public static String getAuthority(String name, String pass){
        return UserDAO.getAuthority(name, pass);
    }
    public static int getIdByName(String name){
        return UserDAO.getIdByName(name);
    }
}
