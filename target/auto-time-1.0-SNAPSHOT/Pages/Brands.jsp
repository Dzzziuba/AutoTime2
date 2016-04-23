<%--
  Created by IntelliJ IDEA.
  User: Romachka
  Date: 13.04.16
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.auto.time.Model.Brand" %>
<%@ page import="com.auto.time.dao.BrandDao" %>
<%@ page import="org.apache.commons.lang.BooleanUtils" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="java.util.List" %>


<html>
<head>
    <style>
        <%@include file='/css/main.css' %>
    </style>
    <title>AutoTime</title>
</head>
<body>
<%@include file="/Pages/Header.jsp" %>
<div class="brandlistspaces">

    <%
        request.getSession(true);
        BrandDao bdi = WebApplicationContextUtils.getWebApplicationContext(application).getBean(BrandDao.class);


        List<Brand> brandList = bdi.getAllBrands();
        for (Brand b : brandList) {%>

    <p class="whitespace"><a href="Models.jsp?brand_id=<%=b.getId()%>&brand_name=<%=b.getBrandName()%>"
                             class="brandtitle"><%=b.getBrandName()%>
    </a></p>

    <%}%>
    <%if(BooleanUtils.isTrue((Boolean) session.getAttribute("Login"))){%>
    <p class="whitespace"><a href="../WEB-INF/AddBrand.jsp" class="brandtitle">+ Add new brand</a></p>
    <%}%>
</div>

</body>
</html>
