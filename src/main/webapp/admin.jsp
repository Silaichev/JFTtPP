<%@ page import="com.JFTtPP.models.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="com.JFTtPP.myJDBC.OrderDAO" %>
<%@ page import="com.JFTtPP.services.OrderService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin`s work</title>
    <title>Register</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="res/css/main.css">
</head>
<body>
<header>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Restaurant</a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="Menu"><span class=""></span> Menu</a></li>
                <li><a href="NewDish"><span class=""></span> New Dish</a></li>
                <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span>Logout</a></li>
            </ul>
        </div>
    </nav>
</header>
<% List<Order> orders = new LinkedList<Order>();
    orders = OrderService.getOrdersWithoutDone();
    request.setAttribute("orders", orders);

    List<OrderDAO.State> enumList = new LinkedList<>();
    enumList = OrderService.getStates();

    request.setAttribute("states", enumList);
%>
<section>
    <table class="table" style="background-color: rgba(255,255,255,0.75);">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">address</th>
            <th scope="col">State</th>
            <th scope="col">new State</th>
            <th scope="col">Change</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="order" items="${orders}">
            <tr>
                <form method="post" action="Admin">
                    <td>${order.name}</td>
                    <td>${order.state}</td>
                    <td>
                        <input type="hidden" name="orderId" value="${order.id}" />
                        <select name="selectedState">
                            <c:forEach var="status" items="${states}">
                                <option name="newStatus" value="${status}">${status.name()}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>${order.sum}</td>
                    <td><input type="submit"></td>
                </form>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</section>





</body>
</html>
