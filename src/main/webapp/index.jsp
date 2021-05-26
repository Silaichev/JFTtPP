<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Intro</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="res/css/main.css">
</head>
<body>
<fmt:setLocale value="en_US" scope="session"/>
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
                <li><a href="Login"><span class="glyphicon glyphicon-log-in"></span> <fmt:message key="login" bundle="${head}"/></a></li>
            </ul>
        </div>
    </nav>
</header>
<section>
    <a type="button" class="btn btn-success btn-lg btn-block" href="Menu"><fmt:message key="menu" bundle="${head}"/></a>
</section>
<footer>
</footer>


</body>
</html>