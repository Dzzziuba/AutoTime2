<%@ page import="com.auto.time.dao.impl.VariantDaoImpl" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.auto.time.Model.Variant" %><%--
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
<% VariantDaoImpl vdi = WebApplicationContextUtils.getWebApplicationContext(application).getBean(VariantDaoImpl.class);%>
    <%
        Variant var = vdi.getVariantById(variantId);
    %>
<h3> Edit <%=var.getVariantName()%> info of <%=var.getModel().getModelName()%>, <%=var.getBrand().getBrandName()%></h3>
<form action="/admin/EditVariant" method="post">
    <div class="login">
<div>


    <div>
        <input class="logininput" type="text" name="variant_name" value="<%=var.getVariantName()%>"/>
    </div>

    <div>
        <input class="logininput" type="text" name="engine" value="<%=var.getEngine()%>"/>
    </div>

    <div>
        <input class="logininput" type="text" name="expert_rating" value="<%=var.getExpertRating()%>"/>
    </div>

    <div>
        <input class="logininput" type="text" name="fuel_economy" value="<%=var.getFuelEconomy()%>"/>
    </div>


    <div>
        <input class="logininput" type="text" name="horse_power" value="<%=var.getHorsePower()%>"/>
    </div>

    <div>
        <input class="logininput" type="text" name="drive_train" value="<%=var.getDriveTrain()%>"/>
    </div>

    <div>
        <input class="logininput" type="text" name="fuel_type" value="<%=var.getFuelType()%>"/>
    </div>

</div>

<div>
    <p><input class="loginbutton" type="submit" value="Change" onclick="location.href='/Variants.jsp';"></p>
</div>
        </div>
</form>
</body>
</html>