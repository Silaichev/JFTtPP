<%--
  Created by IntelliJ IDEA.
  User: silai
  Date: 20.05.2021
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
    <style>
        td {
            vertical-align: top; /* Выравнивание по верхнему краю ячеек */
        }
    </style>
</head>
<body>
<%@ page import="com.myJDBC.DAO" %>
<%@ page import="com.models.Menu" %>
<%@ page import="com.models.Dish" %>
<% Menu menu = DAO.getMenu();  %>
    <form action="Menu" method="POST">

        Menu<br>

        <table>
            <thead>
                <tr>
                    <th>Starters</th>
                    <th>Meat</th>
                    <th>Salads</th>
                    <th>Main Dishes</th>
                    <th>Fish and seafood</th>
                    <th>Side Dishes</th>
                    <th>Sauces</th>
                    <th>Desserts</th>
                    <th>Beverages</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td> <% for(Dish d : menu.getByCategory(DAO.Category.starters)){
                        out.print("<input type=\"checkbox\" name=\"dishes\" value=\""+d.getName()+"\" />"+d.getName()+
                                "<input type=\"number\" name=\""+d.getName()+"\"/>"+"<br>");
                    } %>
                    </td>
                    <td> <% for(Dish d : menu.getByCategory(DAO.Category.meat)){
                        out.print("<input type=\"checkbox\" name=\"dishes\" value=\""+d.getName()+"\" />"+d.getName()+
                                "<input type=\"number\" name=\""+d.getName()+"\"/>"+"<br>");
                    } %>
                    </td>


                    <td> <% for(Dish d : menu.getByCategory(DAO.Category.salads)){
                        out.print("<input type=\"checkbox\" name=\"dishes\" value=\""+d.getName()+"\" />"+d.getName()+
                                "<input type=\"number\" name=\""+d.getName()+"\"/>"+"<br>");
                    } %>
                    </td>
                    <td> <% for(Dish d : menu.getByCategory(DAO.Category.main_dishes)){
                        out.print("<input type=\"checkbox\" name=\"dishes\" value=\""+d.getName()+"\" />"+d.getName()+
                                "<input type=\"number\" name=\""+d.getName()+"\"/>"+"<br>");
                    } %>
                    </td>
                    <td> <% for(Dish d : menu.getByCategory(DAO.Category.fish_and_seafoods)){
                        out.print("<input type=\"checkbox\" name=\"dishes\" value=\""+d.getName()+"\" />"+d.getName()+
                                "<input type=\"number\" name=\""+d.getName()+"\"/>"+"<br>");
                    } %>
                    </td>
                    <td> <% for(Dish d : menu.getByCategory(DAO.Category.side_dishes)){
                        out.print("<input type=\"checkbox\" name=\"dishes\" value=\""+d.getName()+"\" />"+d.getName()+
                                "<input type=\"number\" name=\""+d.getName()+"\"/>"+"<br>");
                    } %>
                    </td>
                    <td> <% for(Dish d : menu.getByCategory(DAO.Category.sauces)){
                        out.print("<input type=\"checkbox\" name=\"dishes\" value=\""+d.getName()+"\" />"+d.getName()+
                                "<input type=\"number\" name=\""+d.getName()+"\"/>"+"<br>");
                    } %>
                    </td>
                    <td> <% for(Dish d : menu.getByCategory(DAO.Category.desserts)){
                        out.print("<input type=\"checkbox\" name=\"dishes\" value=\""+d.getName()+"\" />"+d.getName()+
                                "<input type=\"number\" name=\""+d.getName()+"\"/>"+"<br>");
                    } %>
                    </td>
                    <td> <% for(Dish d : menu.getByCategory(DAO.Category.beverages)){
                        out.print("<input type=\"checkbox\" name=\"dishes\" value=\""+d.getName()+"\" />"+d.getName()+
                                "<input type=\"number\" name=\""+d.getName()+"\"/>"+"<br>");
                    } %>
                    </td>
                </tr>
            </tbody>
        </table>
        <input type="submit" value="Submit" />
</form>
</body>
</html>
