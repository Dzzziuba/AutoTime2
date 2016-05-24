<%--
  Created by IntelliJ IDEA.
  User: Romachka
  Date: 17.04.16
  Time: 12:49
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

<%--<%--%>
    <%--request.getSession(true);--%>
    <%--if (session.isNew()) {--%>
        <%--session.setAttribute("Login", false);--%>
    <%--} else {--%>
        <%--if (Boolean.valueOf((boolean) session.getAttribute("Login"))) {--%>
<%--%>--%>
<sec:authorize access="hasRole('USER')">
        <form action="/admin/AddBrand" method="post">
            <div class="login">
        <div>

            <input class="logininput" type="text" name="brand" placeholder="Name of brand"/>
        </div>
        <div>
            <p><input class="loginbutton" type="submit" value="Add" onclick="location.href='/Brands.jsp';"></p>
        </div>
            </div>
    </form>
</sec:authorize>
<%--<%--%>
        <%--}--%>
    <%--}--%>
<%--%>--%>
</body>
</html>
