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
</head>
<body>

<% List<Order> orders = new LinkedList<Order>();
    orders = OrderDAO.getOrders();
        request.setAttribute("orders", orders);

    List<OrderDAO.State> enumList = new LinkedList<>();
            enumList = OrderService.getStates();

    request.setAttribute("states", enumList);
%>


<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>address</th>
        <th>State</th>
        <th>new State</th>
        <th>Change</th>
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

</body>
</html>
