<%@ page import="com.auto.time.Model.Model" %>
<%@ page import="com.auto.time.Model.Variant" %>
<%@ page import="com.auto.time.dao.VariantDao" %>
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
<%@include file="/WEB-INF/Header.jsp" %>
<% request.getSession(true);
    long modelId = Long.valueOf(request.getParameter("model_id"));
    String modelName=request.getParameter("model_name");
%>
<div class="brandlistspaces">
    <%
        VariantDao vdi = WebApplicationContextUtils.getWebApplicationContext(application).getBean(VariantDao.class);

        List<Variant> variantList;

        Model model = new Model();

        model.setId(modelId);

        if (model.getId() != 0) {%>

    <h1 style="color:#5C97BF;">${param.model_name}</h1> <%if (BooleanUtils.isTrue((Boolean) session.getAttribute("Login"))) {%>
    <form method="get" action="/admin/DeleteModel">
        <input type="submit" class="deletebutton" value="- Delete model ${param.model_name}"
               onclick="return confirm('Are you really want to delete model ${param.model_name} and all information which connected with it?!')"/>
    </form>
    <%}%>

            <%variantList = vdi.getVariantsByModelId(model);

        } else {%>
    <h1 style="color:#5C97BF;">All variants</h1>
    <%
            variantList = vdi.getAllVariants();
        }

        for (Variant v : variantList) {
            if (model.getId() != 0) {%>
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
    <%
        if (BooleanUtils.isTrue((Boolean) session.getAttribute("Login")) && Integer.valueOf(request.getParameter("brand_id")) != 0 && Integer.valueOf(request.getParameter("model_id")) != 0) {
            session.setAttribute("model_id",modelId);
            session.setAttribute("model_name", modelName);%>
    <p class="whitespace">
    <form method="get" action="/admin/AddVariant"><input type="submit" class="addbutton" value="+ Add new variant"/></form></p>
    <%

        }
    %>
</div>


</body>
</html>
