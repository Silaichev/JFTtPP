<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Preparing</title>

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
                <li><a href="Register"><span class="glyphicon glyphicon-user"></span><fmt:message key="signUp"/></a></li>
                <li><a href="Logout"><span class="glyphicon glyphicon-log-in"></span><fmt:message key="logout"/></a></li>
            </ul>
        </div>
    </nav>
</header>
<fmt:setBundle basename="preparing" var="pre"/>
<section>
    <div class="whiteBack">
        <h3><fmt:message bundle="${pre}" key="process"/> </h3>

        <a type="button" class="btn btn-success" href="Menu"><fmt:message key="menu" bundle="${pre}"/></a>
    </div>
</section>



</body>
</html>
