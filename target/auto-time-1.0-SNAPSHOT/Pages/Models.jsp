<%--
  Created by IntelliJ IDEA.
  User: Romachka
  Date: 13.04.16
  Time: 12:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.auto.time.Model.Brand" %>
<%@ page import="com.auto.time.Model.Model" %>
<%@ page import="com.auto.time.dao.impl.BrandDaoImpl" %>
<%@ page import="com.auto.time.dao.impl.ModelDaoImpl" %>
<%@ page import="org.apache.commons.lang.BooleanUtils" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Title</title>
    <style>
        <%@include file='/css/main.css' %>
    </style>

</head>
<body>
<%@include file="/WEB-INF/Header.jsp" %>
<% request.getSession(true);
    long brandId = Long.valueOf(request.getParameter("brand_id"));%>

<div class="brandlistspaces">

    <%
        ModelDaoImpl mdi = WebApplicationContextUtils.getWebApplicationContext(application).getBean(ModelDaoImpl.class);
        List<Model> modelList;
        Brand brand = new Brand();
        brand.setId(brandId);
        if (brand.getId() != 0) {%>
    <h1 style="color:#5C97BF;">${param.brand_name}</h1>

    <%if (BooleanUtils.isTrue((Boolean) session.getAttribute("Login"))) {%>
    <form method="get" action="/admin/DeleteBrand">
        <input type="submit" class="deletebutton" value="- Delete brand ${param.brand_name}"
               onclick="return confirm('Are you really want to delete brand ${param.brand_name} and all information which connected with it?!')"/>
    </form>
    <%}%>
    <% modelList = mdi.getModelsByBrandId(brand);
    } else {%>
    <h1 style="color:#5C97BF;">All models</h1>
    <% modelList = mdi.getAllModels();
    }

        for (Model m : modelList) {
            if (brand.getId() != 0) {%>
    <p class="whitespace"><a
            href="Variants.jsp?brand_id=${param.brand_id}&brand_name=${param.brand_name}&model_id=<%=m.getId()%>&model_name=<%=m.getModelName()%>"
            class="brandtitle"><%=m.getModelName()%>
    </a></p>
    <%} else {%>
    <p class="whitespace"><a
            href="Variants.jsp?brand_id=${param.brand_id}&model_id=<%=m.getId()%>&model_name=<%=m.getModelName()%>"
            class="brandtitle"><%=m.getModelName()%>
    </a></p>
    <%
            }
        }
    %>
    <%
        if (BooleanUtils.isTrue((Boolean) session.getAttribute("Login")) && Integer.valueOf(request.getParameter("brand_id")) != 0) {
            session.setAttribute("brand_id", brandId);

            session.setAttribute("brand_name", request.getParameter("brand_name"));
    %>
    <p class="whitespace">
    <form method="get" action="/admin/AddModel"><input type="submit" class="addbutton" value="+ Add new model"/></form>
    </p>
    <%--<p class="whitespace"><a href="../WEB-INF/AddModel.jsp?brand_id=${param.brand_id}&brand_name=${param.brand_name}" class="brandtitle">+ Add new model</a></p>--%>
    <%

        }
    %>
</div>
</body>
</html>
