<%@ page import="org.apache.commons.lang.BooleanUtils" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %><%--
  Created by IntelliJ IDEA.
  User: Romachka
  Date: 22.04.16
  Time: 00:53
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

<sec:authorize access="hasRole('USER')">
<form action="/admin/AddVariant" method="post">
    <div class="login">

        <div>
            <input class="logininput" type="text" name="variantName" placeholder="Name of variant"/>
        </div>

        <div>
            <input class="logininput" type="text" name="engine" placeholder="Engine"/>
        </div>

         <div>
             <input class="logininput" type="text" name="expertRating" placeholder="Expert rating"/>
        </div>

        <div>
            <input class="logininput" type="text" name="fuelEconomy" placeholder="Fuel economy"/>
        </div>


        <div>
            <input class="logininput" type="text" name="horsePower" placeholder="Horse power"/>
        </div>

        <div>
            <input class="logininput" type="text" name="driveTrain" placeholder="Drive train"/>
        </div>

        <div>
            <input class="logininput" type="text" name="fuelType" placeholder="Fuel type"/>
        </div>

        <div>
            <p><input class="loginbutton" type="submit" value="Add" onclick="location.href='/Brands.jsp';"></p>
        </div>
    </div>
</form>
</sec:authorize>
</body>
</html>
