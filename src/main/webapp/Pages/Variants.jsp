<%@ page import="com.auto.time.Model.Variant" %>
<%@ page import="com.auto.time.dao.impl.VariantDaoImpl" %>
<%@ page import="org.apache.commons.lang.BooleanUtils" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Romachka
  Date: 22.04.16
  Time: 00:10
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
<% request.getSession(true);
    long modelId = Long.valueOf(request.getParameter("model_id"));%>


<div class="brandlistspaces">

    <%
        VariantDaoImpl vdi = WebApplicationContextUtils.getWebApplicationContext(application).getBean(VariantDaoImpl.class);
        List<Variant> variantList;

        if (modelId != 0) {
            variantList = vdi.getVariantsByModelId(modelId);
        } else {
            variantList = vdi.getAllVariants();
        }

        for (Variant v : variantList) {
            if (modelId != 0) {%>
    <p class="whitespace"><a
            href="Variant.jsp?model_id=${param.model_id}&model_name=${param.model_name}&variant_id=<%=v.getId()%>&variant_name=<%=v.getVariantName()%>"
            class="brandtitle"><%=v.getVariantName()%>
    </a></p>
    <%} else {%>
    <p class="whitespace"><a href="Variant.jsp?variant_id=<%=v.getId()%>&variant_name=<%=v.getVariantName()%>"
                             class="brandtitle"><%=v.getVariantName()%>
    </a></p>
    <%
            }
        }
    %>
    <% if (session.isNew()) {
        session.setAttribute("Login", false);
    } else {
        if (BooleanUtils.isTrue((Boolean) session.getAttribute("Login")) && Integer.valueOf(request.getParameter("brand_id")) != 0 && Integer.valueOf(request.getParameter("model_id")) != 0) {%>
    <p class="whitespace"><a href="../WEB-INF/AddVariant.jsp?brand_id=${param.brand_id}&brand_name=${param.brand_name}&model_id=${param.model_id}&model_name=${param.model_name}"
                             class="brandtitle">+ Add new variant</a></p>
    <%
            }
        }
    %>
</div>


</body>
</html>
