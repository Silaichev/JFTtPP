package com.JFTtPP.security;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecurityUtils {
        public static void checkVisitor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            if(request.getSession().getAttribute("authority")==null){
                request.getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
            }
        }
    public static void checkAdmin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!request.getSession().getAttribute("authority").equals("admin")){
            request.getServletContext().getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
}
