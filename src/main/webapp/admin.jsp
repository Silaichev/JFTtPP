<%@ page import="com.JFTtPP.models.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="com.JFTtPP.myJDBC.OrderDAO" %>
<%@ page import="com.JFTtPP.services.OrderService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Admin`s work</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="res/css/main.css">
</head>
<body>
<fmt:setBundle basename="header" var="head"/>

<header>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#"><fmt:message key="menu" bundle="${head}"/></a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="Menu"><span class=""></span> <fmt:message key="menu" bundle="${head}"/></a></li>
                <li><a href="NewDish"><span class=""></span><fmt:message key="newDish" bundle="${head}"/></a></li>
                <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span><fmt:message key="logout" bundle="${head}"/></a></li>
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
<fmt:setBundle  basename="admin" var="admin"/>



<fmt:message key="change" var="change" bundle="${admin}"/>

<fmt:setBundle basename="states" var="statesBundle"/>
<section>
    <table class="table" style="background-color: rgba(255,255,255,0.75);">
        <thead>
        <tr>
            <th scope="col"><fmt:message key="name" bundle="${admin}"/></th>
            <th scope="col"><fmt:message key="address" bundle="${admin}"/></th>
            <th scope="col"><fmt:message key="state" bundle="${admin}"/></th>
            <th scope="col"><fmt:message key="new-state" bundle="${admin}"/></th>
            <th scope="col"><fmt:message key="sum" bundle="${admin}"/></th>
            <th scope="col">${change}</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="order" items="${orders}">
            <tr>
                <form method="post" action="Admin">
                    <td>${order.name}</td>
                    <td>${order.address}</td>
                    <td><fmt:message key="${order.state}" bundle="${statesBundle}"/></td>
                    <td>
                        <input type="hidden" name="orderId" value="${order.id}" />
                        <select class="form-control" name="selectedState">
                            <c:forEach var="status" items="${states}">
                                <option name="newStatus" value="${status}"><fmt:message key="${status.name()}" bundle="${statesBundle}"/></option>
                            </c:forEach>
                        </select>
                    </td>
                    <td>${order.sum}</td>
                    <td><input type="submit" value="${change}"></td>
                </form>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</section>





</body>
</html>
