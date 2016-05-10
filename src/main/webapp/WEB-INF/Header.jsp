<%--
  Created by IntelliJ IDEA.
  User: Romachka
  Date: 13.04.16
  Time: 11:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%request.getSession(false);%>
<%if(session.getAttribute("UserName")!=null){%>
<p class="welcome">Hello, <%=session.getAttribute("UserName")+"!"%>
<a class="exitlink" href="/index.jsp">Exit</a>
<%}%></p>

<h1 class="Title">Auto time!</h1>


    <div class="divspace">
        <p class="whitespace"><a href="/Pages/Brands.jsp" class="menu">Brands</a></p>
        <p class="whitespace"><a href="/Pages/Models.jsp?brand_id=0" class="menu">Models</a></p>
        <p class="whitespace"><a href="/Pages/Variants.jsp?brand_id=0&model_id=0" class="menu">Variants</a></p>
        <p class="whitespace"><a href="#" class="menu">About</a></p>
        <p class="whitespace"><a href="#" class="menu">Contact</a></p>
    </div>
