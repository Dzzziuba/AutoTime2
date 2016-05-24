<%--
  Created by IntelliJ IDEA.
  User: Romachka
  Date: 13.04.16
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
<%@include file="/WEB-INF/Header.jsp" %>
<div class="brandlistspaces">

    <h1 style="color:#5C97BF;">All brands</h1>
    <%
        request.getSession(true);
        BrandDao bdi = WebApplicationContextUtils.getWebApplicationContext(application).getBean(BrandDao.class);


        List<Brand> brandList = bdi.getAllBrands();
        for (Brand b : brandList) {%>

    <p class="whitespace"><a href="Models.jsp?brand_id=<%=b.getId()%>&brand_name=<%=b.getBrandName()%>"
                             class="brandtitle"><%=b.getBrandName()%>
    </a></p>

    <%}%>
    <%--<%if(BooleanUtils.isTrue((Boolean) session.getAttribute("Login"))){%>--%>
    <sec:authorize access="hasRole('USER')">
    <p class="whitespace">
        <form method="get" action="/admin/AddBrand"><input type="submit" class="addbutton" value="+ Add new brand"/></form></p>
    </sec:authorize>
        <%--<%}%>--%>
</div>

</body>
</html>
