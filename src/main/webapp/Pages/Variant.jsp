<%@ page import="com.auto.time.dao.VariantDao" %>
<%@ page import="org.apache.commons.lang.BooleanUtils" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="java.util.Map" %>
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
<h1>${param.variant_name}</h1>


<%if (BooleanUtils.isTrue((Boolean) session.getAttribute("Login"))) {%>
<form method="get" action="/admin/EditVariant">
    <input type="submit" class="deletebutton" value="- Edit variant ${param.variant_name}"
           onclick="return confirm('Are you really want to edit variant ${param.variant_name} and all information which connected with it?!')"/>
</form>
<%}%>


<%
    long variantId = Long.valueOf(request.getParameter("variant_id"));
    session.setAttribute("variant_id", variantId);%>
<div style="width: 30%">
    <%VariantDao vdi = WebApplicationContextUtils.getWebApplicationContext(application).getBean(VariantDao.class);%>
    <%
        Map<String, String> map = vdi.getVariantInfo(variantId);
        for (Map.Entry entry : map.entrySet()) {
    %>

    <p><span class="infolabel"><%=entry.getKey()%></span><span class="infovalue"><%=entry.getValue()%></span></p>
    <%}%>
</div>

</body>
</html>
