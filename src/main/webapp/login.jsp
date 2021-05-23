<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <title>Register</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="res/css/main.css">
</head>
<body>
<% String error = (String) request.getSession().getAttribute("loginError");

    request.setAttribute("error", error);
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

            </ul>
        </div>
    </nav>
</header>
<section>
    <form class="whiteBack" action="Login" method="POST">
        <div class="form-group">
            <label >Login</label>
            <input name="login" type="text" class="form-control"  placeholder="Enter login">
            <small class="form-text text-muted">We'll never share your login with anyone else.</small>
        </div>
        <div class="form-group">
            <label>Password</label>
            <input name="pass" type="password" class="form-control" placeholder="Password">
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-success">Submit</button>
        </div>
    </form>
    <c:if test="${error!=null}">
    <p>${error}</p>
</c:if>
</section>


  <%--  <form action="Login" method="POST">
        Login:<input name="login"/>
        Password:<input name="pass">
        <button class="btn btn-success" type="submit" >Submit</button>

    </form>--%>





</body>
</html>
