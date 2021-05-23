<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <title>Register</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="res/css/main.css">
</head>
<body>
<%@ page import="com.JFTtPP.models.Menu" %>
<%@ page import="com.JFTtPP.models.Dish" %>
<%@ page import="com.JFTtPP.myJDBC.DishDAO" %>
<%@ page import="com.JFTtPP.services.DishService" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.List" %>

<% Menu menu = DishDAO.getMenu();

    request.setAttribute("menu",menu);

    List<DishDAO.Category> listCategories = new LinkedList<DishDAO.Category>();
    listCategories = DishService.getCategories();
    request.setAttribute("categories",listCategories);
%>
<header>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Restaurant</a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="Menu"><span class=""></span> Menu</a></li>
                <li><a href="Register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
                <li><a href="Login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
                <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span>Logout</a></li>
            </ul>
        </div>
    </nav>
</header>
<section class="menu">
    <form class="" action="Menu" method="POST">

        Menu<br>

        <table class="table">
            <thead>
            <tr>
                <c:forEach var="category" items="${categories}">
                    <th scope="col">
                            ${category}
                    </th>
                </c:forEach>

            </tr>
            </thead>
            <tbody>
            <tr>
                <c:forEach var="category" items="${categories}">
                    <td>
                        <c:forEach var="dish" items="${menu.getByCategory(category)}">
                            <input type="checkbox" name="dishes" value="${dish.getName()}" class="col-2 col-form-label"/>
                            <span>${dish.getName()}</span>
                            <input type="number" name="${dish.getName()}" class=" minInput col-2 col-form-label"/><br>
                        </c:forEach>
                    </td>
                </c:forEach>

            </tr>
            </tbody>
        </table>
        <label>Enter your address</label>
        <input type="text" required name="address" class="col-2 col-form-label"/>
        <input type="submit" value="Submit" />
    </form>
</section>



</body>
</html>
