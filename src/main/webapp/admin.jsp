<%@ page import="com.JFTtPP.models.Order" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="com.JFTtPP.myJDBC.OrderDAO" %>
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


%>

<%--<form action="Admin" method="POST">
    <% for(int i=0;i<10;i++){
        out.print("<input type=\"submit\" name=\"button\" value=\""+i+"\"/>");
    }  %>
</form>--%>


<c:forEach var="order" items="${orders}">

    <p>${order.name}</p>

</c:forEach>


</body>
</html>
