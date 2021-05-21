<%--
  Created by IntelliJ IDEA.
  User: silai
  Date: 19.05.2021
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>First JSP</title>
</head>
<body>
    <h1>Testing JSP</h1>
    <%@ page import="java.util.Date" %>
    <p>
        <%
            java.util.Date date = new java.util.Date();
            String str = "Date now : "+date;
        %>
        <%= "Hello world "+str %>
    </p>
    <h1>
        <%
            for(int i=0;i<10;i++){
                out.println("Hi, its "+i+" iteration"+"</br>");
            }
        %>
    </h1>

    <form action="hello" method="POST">
        Name: <input name="username" />
        <br><br>
        Age: <input name="userage" />
        <br><br>
        Gender: <input type="radio" name="gender" value="female" checked />Female
        <input type="radio" name="gender" value="male" />Male
        <br><br>

        <br><br>
        Courses:
        <input type="checkbox" name="courses" value="JavaSE" checked />Java SE
        <input type="checkbox" name="courses" value="JavaFX" checked />Java FX
        <input type="checkbox" name="courses" value="JavaEE" checked />Java EE
        <br><br>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
