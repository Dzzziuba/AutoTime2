<%@ page import="com.auto.time.dao.impl.VariantDaoImpl" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="java.util.Map" %><%--
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
<%@include file="/Pages/Header.jsp" %>
    <% //request.getSession(true);
    long variantId = Long.valueOf(request.getParameter("variant_id"));%>
<div style="width: 30%">
<%VariantDaoImpl vdi = WebApplicationContextUtils.getWebApplicationContext(application).getBean(VariantDaoImpl.class);%>
<%Map<String, String> map=vdi.getVariantInfo(variantId);
for(Map.Entry entry: map.entrySet()){
%>

   <p><span class="infolabel"><%=entry.getKey()%></span><span class="infovalue"><%=entry.getValue()%></span></p>
<%}%>
</div>
</body>
</html>
