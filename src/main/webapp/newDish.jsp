<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.List" %>
<%@ page import="com.JFTtPP.services.DishService" %>
<%@ page import="com.JFTtPP.myJDBC.DishDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>New Dish</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="res/css/main.css">
</head>
<body>
<fmt:setBundle basename="header"/>
<header>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#"><fmt:message key="logo"/></a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="Menu"><span class=""></span><fmt:message key="menu"/></a></li>

                <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span><fmt:message key="logout"/></a></li>
            </ul>
        </div>
    </nav>
</header>
<% List<DishDAO.Category> categoryList = DishService.getCategories();
    request.setAttribute("categoryList",categoryList);%>

<fmt:setBundle basename="category" var="cat"/>
<fmt:setBundle basename="newDish" var="newDish"/>
<section>
    <form class="whiteBack" action="NewDish" method="POST">
        <div class="form-group">
            <label ><fmt:message key="name" bundle="${newDish}"/> </label>
            <input name="name" type="text" class="form-control" >
        </div>
        <div class="form-group">
            <select class="form-control"  name="selectedCategory">
                <c:forEach var="category" items="${categoryList}">
                    <option name="newStatus" value="${category}">
                            <fmt:message key="${category.name()}" bundle="${cat}"/></option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label ><fmt:message key="price" bundle="${newDish}"/> </label>
            <input name="price" type="text" class="form-control" >
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success"><fmt:message key="submit" bundle="${newDish}"/> </button>
        </div>
    </form>

</section>
</body>
</html>
