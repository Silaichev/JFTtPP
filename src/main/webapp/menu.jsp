<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="com.JFTtPP.models.Menu" %>
<%@ page import="com.JFTtPP.myJDBC.DishDAO" %>
<%@ page import="com.JFTtPP.services.DishService" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Menu</title>
    <style>
        /*td {
            vertical-align: top; !* Выравнивание по верхнему краю ячеек *!
        }*/
    </style>
    <title>Register</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="res/css/main.css">
</head>
<body>


<% Menu menu = DishDAO.getMenu();

    request.setAttribute("menu",menu);

    List<DishDAO.Category> listCategories = new LinkedList<DishDAO.Category>();
    listCategories = DishService.getCategories();
    request.setAttribute("categories",listCategories);
%>

<fmt:setBundle basename="header"  var="head"/>
<header>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#"><fmt:message key="logo" bundle="${head}"/></a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="Menu"><span class=""></span> <fmt:message key="menu" bundle="${head}"/></a></li>
                <li><a href="Register"><span class="glyphicon glyphicon-user"></span> <fmt:message key="signUp" bundle="${head}"/></a></li>
                <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span> <fmt:message key="logout" bundle="${head}"/></a></li>
            </ul>
        </div>
    </nav>
</header>

<fmt:setBundle basename="category" var="categoryBandle"/>
<section class="menu">
    <form class="" action="Menu" method="POST">

        <table class="table table-menu">
            <thead>
            <tr class="tr tr-menu">
                <c:forEach var="category" items="${categories}">
                    <th class="th th-menu" scope="col">
                        <fmt:message key="${category.name()}" bundle="${categoryBandle}"/>
                    </th>
                </c:forEach>

            </tr>
            </thead>
            <tbody>
            <tr class="tr tr-menu">
                <c:forEach var="category" items="${categories}">
                    <td class="td td-menu">
                        <c:forEach var="dish" items="${menu.getByCategory(category)}">
                            <input type="checkbox" name="dishes" value="${dish.getName()}" class="col-2 col-form-label"/>
                            <span>${dish.getName()}</span> <span>$${dish.getPrice()}</span><br>
                            <input type="number" size="7" name="${dish.getName()}" class=" col-form-label"/><br>
                        </c:forEach>
                    </td>
                </c:forEach>

            </tr>
            </tbody>
        </table>
        <fmt:setBundle basename="menu" var="menu"/>
        <label><fmt:message key="address" bundle="${menu}"/></label>
        <input type="text" required name="address" class="col-2 col-form-label"/>
        <input type="submit" value="Submit" />
    </form>
</section>



</body>
</html>
