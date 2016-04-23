<%--
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
<%@include file="/Pages/Header.jsp" %>

<%
    request.getSession(true);
    if (session.isNew()) {
        session.setAttribute("Login", false);
    } else {
        if (Boolean.valueOf((boolean) session.getAttribute("Login"))) {
%>

<form action="/AddNewVariant" method="post">
    <div class="login">

        <div>
            <input class="logininput" hidden="true" type="text" name="brand_id" value="${param.brand_id}"/>
        </div>

        <div>
            <input class="logininput" hidden="true" type="text" name="model_id" value="${param.model_id}"/>
        </div>

        <div>
            <input class="logininput" type="text" name="variant_name" placeholder="Name of variant"/>
        </div>

        <div>
            <input class="logininput" type="text" name="engine" placeholder="Engine"/>
        </div>

         <div>
             <input class="logininput" type="text" name="expert_rating" placeholder="Expert rating"/>
        </div>

        <div>
            <input class="logininput" type="text" name="fuel_economy" placeholder="Fuel economy"/>
        </div>


        <div>
            <input class="logininput" type="text" name="horse_power" placeholder="Horse power"/>
        </div>

        <div>
            <input class="logininput" type="text" name="drive_train" placeholder="Drive train"/>
        </div>

        <div>
            <input class="logininput" type="text" name="fuel_type" placeholder="Fuel type"/>
        </div>

        <div>
            <p><input class="loginbutton" type="submit" value="Add" onclick="location.href='/Brands.jsp';"></p>
        </div>
    </div>
</form>

<%
        }
    }
%>
</body>
</html>
