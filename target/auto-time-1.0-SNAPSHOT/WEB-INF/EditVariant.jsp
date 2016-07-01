<%@ page import="com.auto.time.Model.Variant" %>
<%@ page import="com.auto.time.dao.VariantDao" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%--
  Created by IntelliJ IDEA.
  User: Romachka
  Date: 22.04.16
  Time: 13:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        <%@include file='/css/main.css' %>
    </style>

</head>
<body>

<%@include file="/WEB-INF/Header.jsp" %>

    <%long variantId = Long.valueOf(request.getParameter("variant_id"));%>
<% VariantDao vdi = WebApplicationContextUtils.getWebApplicationContext(application).getBean(VariantDao.class);%>
    <%
        Variant var = vdi.getVariantById(variantId);
    %>
<h1 style="color:#5C97BF;">Edit <%=var.getVariantName()%> info of <%=var.getModel().getModelName()%>, <%=var.getBrand().getBrandName()%></h1>
<sec:authorize access="hasRole('USER')">
    <form method="get" action="/admin/DeleteVariant">
        <input type="submit" class="deletebutton" value="- Delete variant <%=var.getVariantName()%>"
               onclick="return confirm('Are you really want to delete variant <%=var.getVariantName()%> and all information which connected with it?!')"/>
    </form>
</sec:authorize>
<sec:authorize access="hasRole('USER')">
<form action="/admin/EditVariant" method="post">

    <div class="login">
        <div>
    <div>
        <input class="logininput" type="text" name="variantName" value="<%=var.getVariantName()%>"/>
    </div>

    <div>
        <input class="logininput" type="text" name="engine" value="<%=var.getEngine()%>"/>
    </div>

    <div>
        <input class="logininput" type="text" name="expertRating" value="<%=var.getExpertRating()%>"/>
    </div>

    <div>
        <input class="logininput" type="text" name="fuelEconomy" value="<%=var.getFuelEconomy()%>"/>
    </div>


    <div>
        <input class="logininput" type="text" name="horsePower" value="<%=var.getHorsePower()%>"/>
    </div>

    <div>
        <input class="logininput" type="text" name="driveTrain" value="<%=var.getDriveTrain()%>"/>
    </div>

    <div>
        <input class="logininput" type="text" name="fuelType" value="<%=var.getFuelType()%>"/>
    </div>

</div>

<div>
    <p><input class="loginbutton" type="submit" value="Change" onclick="location.href='/Variants.jsp';"></p>
</div>
        </div>
</form>
</sec:authorize>
</body>
</html>