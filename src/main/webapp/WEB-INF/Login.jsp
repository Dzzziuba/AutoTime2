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
<%@include file="/WEB-INF/Header.jsp" %>


<div class="login">
    <form action="/Login" method="post">
        <div>
            <input class="logininput" type="text" name="j_username" placeholder="Login"/>
        </div>
        <div>
            <input  class="logininput" type="password" name="j_password" placeholder="Password"/>
        </div>
        <div>
            <p><input  class="loginbutton" type="submit" value="Log In"></p>
        </div>
    </form>
</div>
</body>
</html>
