<%--
  Created by IntelliJ IDEA.
  User: Romachka
  Date: 20.04.16
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        <%@include file='/css/main.css' %>
    </style>
    <title>AutoTime</title>
</head>
<body>
<%@include file="/Pages/Header.jsp" %>


<div class="login">
    <form action="/admin" method="post">
        <div>
            <input class="logininput" type="text" name="login" placeholder="Login"/>
        </div>
        <div>
            <input  class="logininput" type="password" name="password" placeholder="Password"/>
        </div>
        <div>
            <p><input  class="loginbutton" type="submit" value="Log In" onclick="location.href='/Brands.jsp';"></p>
        </div>
    </form>
</div>
</body>
</html>