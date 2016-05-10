<%@ page import="org.apache.commons.lang.BooleanUtils" %><%--
  Created by IntelliJ IDEA.
  User: Romachka
  Date: 21.04.16
  Time: 23:28
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

<%
    request.getSession(true);
        if (BooleanUtils.isTrue((Boolean) session.getAttribute("Login"))) {
%>

<form action="/AddModel" method="post">
    <div class="login">

        <div>
            <input class="logininput" hidden="true" type="text" name="brand_id" value="<%=session.getAttribute("brand_id")%>"/>
        </div>

        <div>
            <input class="logininput" type="text" name="model_name" placeholder="Name of model"/>
        </div>
        <div>
            <p><input class="loginbutton" type="submit" value="Add" onclick="location.href='/Brands.jsp';"></p>
        </div>
    </div>
</form>

<%

    }
%>
</body>
</html>
