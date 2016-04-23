<html>
<head>
    <style>
        <%@include file='css/main.css' %>
    </style>
    <title>AutoTime</title>
</head>
<body>
<div>
    <form action="/admin" method="get">
        <input class="smallloginbutton" type="submit" value="Login">
    </form>
</div>
<h1 class="Title">Auto time!</h1>

<% session.setAttribute("Login", false);%>

<div class="divspace">
    <p class="whitespace"><a href="Pages/Brands.jsp" class="menu">Brands</a></p>
    <p class="whitespace"><a href="Pages/Models.jsp?brand_id=0" class="menu">Models</a></p>
    <p class="whitespace"><a href="Pages/Variants.jsp?brand_id=0&model_id=0" class="menu">Variants</a></p>
    <p class="whitespace"><a href="#" class="menu">About</a></p>
    <p class="whitespace"><a href="#" class="menu">Contact</a></p>
</div>

</body>
</html>
