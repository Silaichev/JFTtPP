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
<%@ page import="com.JFTtPP.models.Menu" %>
<%@ page import="com.JFTtPP.models.Dish" %>
<%@ page import="com.JFTtPP.myJDBC.DishDAO" %>

<% Menu menu = DishDAO.getMenu();  %>
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
                    <td> <% for(Dish d : menu.getByCategory(DishDAO.Category.starters)){
                        out.print("<input type=\"checkbox\" name=\"dishes\" value=\""+d.getName()+"\" />"+d.getName()+
                                "<input type=\"number\" name=\""+d.getName()+"\"/>"+"<br>");
                    } %>
                    </td>
                    <td> <% for(Dish d : menu.getByCategory(DishDAO.Category.meat)){
                        out.print("<input type=\"checkbox\" name=\"dishes\" value=\""+d.getName()+"\" />"+d.getName()+
                                "<input type=\"number\" name=\""+d.getName()+"\"/>"+"<br>");
                    } %>
                    </td>


                    <td> <% for(Dish d : menu.getByCategory(DishDAO.Category.salads)){
                        out.print("<input type=\"checkbox\" name=\"dishes\" value=\""+d.getName()+"\" />"+d.getName()+
                                "<input type=\"number\" name=\""+d.getName()+"\"/>"+"<br>");
                    } %>
                    </td>
                    <td> <% for(Dish d : menu.getByCategory(DishDAO.Category.main_dishes)){
                        out.print("<input type=\"checkbox\" name=\"dishes\" value=\""+d.getName()+"\" />"+d.getName()+
                                "<input type=\"number\" name=\""+d.getName()+"\"/>"+"<br>");
                    } %>
                    </td>
                    <td> <% for(Dish d : menu.getByCategory(DishDAO.Category.fish_and_seafoods)){
                        out.print("<input type=\"checkbox\" name=\"dishes\" value=\""+d.getName()+"\" />"+d.getName()+
                                "<input type=\"number\" name=\""+d.getName()+"\"/>"+"<br>");
                    } %>
                    </td>
                    <td> <% for(Dish d : menu.getByCategory(DishDAO.Category.side_dishes)){
                        out.print("<input type=\"checkbox\" name=\"dishes\" value=\""+d.getName()+"\" />"+d.getName()+
                                "<input type=\"number\" name=\""+d.getName()+"\"/>"+"<br>");
                    } %>
                    </td>
                    <td> <% for(Dish d : menu.getByCategory(DishDAO.Category.sauces)){
                        out.print("<input type=\"checkbox\" name=\"dishes\" value=\""+d.getName()+"\" />"+d.getName()+
                                "<input type=\"number\" name=\""+d.getName()+"\"/>"+"<br>");
                    } %>
                    </td>
                    <td> <% for(Dish d : menu.getByCategory(DishDAO.Category.desserts)){
                        out.print("<input type=\"checkbox\" name=\"dishes\" value=\""+d.getName()+"\" />"+d.getName()+
                                "<input type=\"number\" name=\""+d.getName()+"\"/>"+"<br>");
                    } %>
                    </td>
                    <td> <% for(Dish d : menu.getByCategory(DishDAO.Category.beverages)){
                        out.print("<input type=\"checkbox\" name=\"dishes\" value=\""+d.getName()+"\" />"+d.getName()+
                                "<input type=\"number\" name=\""+d.getName()+"\"/>"+"<br>");
                    } %>
                    </td>
                </tr>
            </tbody>
        </table>
        <input type="text" name="address"/>
        <input type="submit" value="Submit" />
</form>
</body>
</html>
