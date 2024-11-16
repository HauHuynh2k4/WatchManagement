<%-- 
    Document   : header
    Created on : Jun 18, 2024, 11:34:46 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/Header.css">  
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="header">
            <div class="search-bar">
                <form action="MainController" method="GET">
                    <input type="text" placeholder="Search Watch" name="IdOrName1">
                    <input type="hidden" name="action" value="Search">
                </form>
            </div>
            <div class="store-name">
                <img src="img/Remove-bg.ai_1718442518067.png" style="width: 3em">
                Hậu Watch
            </div>
            <div class="icons">
                <%
                    if (session.getAttribute("LOGIN_USER") != null) {
                %>
                <a href="logoutController" class="btn ">Log Out</a>
                <%
                } else {
                %>
                <a href="login.jsp" class="btn">Log In</a>
                <%
                    }
                %>
                <a href="Account.jsp"> <img src="img/user.png" alt="User"></a>
                <a href="viewCart.jsp"><img src="img/cart.png" alt="View Cart"> </a>
            </div>
        </div>
    </body>
</html>
