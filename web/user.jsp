<%-- 
    Document   : user
    Created on : May 24, 2024, 1:13:24 PM
    Author     : DELL'
--%>

<%@page import="user_watch.watchDTO"%>
<%@page import="user_watch.DAO"%>
<%@page import="wishlist.WishList"%>
<%@page import="product.CartDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        <link rel="icon" type="image/x-icon" href="images/logo.png">
        <script src="https://kit.fontawesome.com/853d2cd4f0.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
        <style>
            body{
                font-family: serif;
            }
            .animated-gradient-text {
                margin-top: 350px;
                margin-bottom: -300px;
                font-size: 30px;
                font-weight: 900;
                background: linear-gradient(270deg, #ff6ec4, #7873f5, #7bdff2, #f7f881);
                background-size: 800% 800%;
                -webkit-background-clip: text;
                -webkit-text-fill-color: transparent;
                animation: gradientAnimation 8s ease infinite;
                text-transform: capitalize;        
            }

            @keyframes gradientAnimation {
                0% {
                    background-position: 0% 50%;
                }
                50% {
                    background-position: 100% 50%;
                }
                100% {
                    background-position: 0% 50%;
                }
            }
            .navbar{
                background-color: blueviolet;
                width: 100%;
                background-color: #660066;
            }
            a{
                text-decoration: none;
                color: black;
                font-weight: 100;
            }
            a:hover {
                text-decoration: none;
                color: #dc3545;
            }
            ul{
                list-style: none;
            }
            ul.product{
                text-align: center;
                display: flex;
                flex-wrap: wrap;
                justify-content: space-between;
            }
            header{
                background-color: #660066;;

            }
            .search-bar{
                text-align: center;
            }
            .search-bar {
                margin-top: 30px;
                padding: 15px;
            }

            .search-bar h3 {
                margin-bottom: 10px;
            }

            .search-bar input[type="number"] {
                width: 230px;
            }

            .search-bar input[type="submit"] {
                margin-top: 10px;
                padding: 5px 10px;
                background-color: #28a745;
                color: white;
                border: none;
                cursor: pointer;
            }

            .search-bar input[type="submit"]:hover {
                background-color: #218838;
            }
            .logo{
                width: 70px;
                height: 40px;
            }
            .banner{
                margin-top: 10px;
                width: 1200px;
                height: 40px;
                background-color: black;
            }
            .img-banner{
                width: 1518px;
                height: 350px;
            }
            img.watchimg {
                width: 300px;
                height: 300px;
            }
            .span{
                margin-left: 100px;
            }
            img{
                width: 230px;
                height: 230px;
            }
            .shop{
                margin-top: 330px;
            }
            .cart-icon{
                display: flex;
                justify-content: center;
                align-content: center;
                font-size: 40px;
                color: #333;
                margin-top: 50px;
            }
            .your-cart{
                font-family: serif;
                font-size: 28px;
                color: #333;
                font-weight: bold;
            }
            .your-wishlist{
                font-family: serif;
                font-size: 28px;
                color: #333;
                font-weight: bold;
            }

            .section{
                border: 1px solid #ccc;
                background-color: #cccccc;
                max-width: 1200px;
                margin: auto;
                padding: 20px;
                margin-bottom: 20px;
                opacity: 0.9;
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);

            }
            #quantity{
                display: inline;
                width: 25px;
                height: 30px;
                font-size: 16px;
                background-color: red;
                opacity: 0.9;
                border-radius: 15px;
                color: white;
            }
            .product {
                list-style: none;
                padding: 0;
            }

            .product li {
                display: inline-block;
                width: 23%;
                margin: 1%;
                border: 1px solid #ccc;
                padding: 10px;
                box-sizing: border-box;
            }

            .product-item {
                text-align: center;
            }

            .product-img img {
                width: 230px;
                height: 230px;
            }

            .product-name {
                font-size: 16px;
                margin: 10px 0;
            }

            .product-price {
                color: #28a745;
                font-size: 14px;
                margin-bottom: 10px;
            }
            .addcart a {
                text-decoration: none;
                color: white;
                background-color: #007bff;
                padding: 5px 10px;
                display: inline-block;
                margin-top: 10px;
            }

            .addcart a:hover {
                background-color: #0056b3;
            }
            .addtowishlist a {
                text-decoration: none;
                color: white;
                background-color: red;
                padding: 5px 10px;
                display: inline-block;
                margin-top: 10px;
            }

            .addtowishlist a:hover {
                background-color: #0056b3;
            }
            footer {
                background-color: #f1f1f1;
                padding: 10px 0;
                text-align: center;
            }
            .form-container {
                text-align: center;
                margin-top: 20px;
            }

            .form-container input[type="submit"] {
                padding: 5px 10px;
                background-color: #dc3545;
                color: white;
                border: none;
                cursor: pointer;
            }
            .social ul{
                margin-top: 20px;
                display: flex; 
                justify-content: space-around;
            }
            .col-md-6{
                border-bottom: 1px solid #ff9a9e;

            }
            .sold-out{
                color: red;
                text-decoration: line-through;
            }
        </style>
    </head>
    <body>
        <%
            String user = (String) session.getAttribute("user");
            DAO dao = new DAO();
            CartDTO cart = (CartDTO) session.getAttribute("CART");
            List<WishList> wishlist = dao.showWishList(user);
            String min = "0";
            String max = "0";
            if (session.getAttribute("min") != null) {
                min = (String) session.getAttribute("min");
            }
            if (session.getAttribute("max") != null) {
                max = (String) session.getAttribute("max");
            }
        %>
        <jsp:include page="headershop.jsp"/>
        <div class="banner">
            <img class="img-banner"  src="images/Logo-The-Gioi-Dong-Ho-Dep-Desktop.jpg">
        </div>
        <div class="container"> 
            <div class="col-12">
                <h4 class="animated-gradient-text"> <p> Welcome <%= user%> <i class="fa-regular fa-user"></i> </p></h4> 
            </div>
        </div>

        <div class="shop">
<!--        <h1 style="color: green"> Welcome user <%= user%> </h1> <br>-->
            <div class="container">
                <div class="section">
                    <div class="row">
                        <div class="search-bar col-md-6">
                            <h3> Search Price <i class="fa-solid fa-hand-holding-dollar"></i> </h3>
                            <form action="MainController" method="post">
                                From <input type="number" name="min" value="<%= min%>"> <br>
                                To &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="number" name="max" value="<%= max%>"> <br>
                                <input type="submit" name="action" value="Search price"> &nbsp; <i class="fa-solid fa-magnifying-glass"></i> <br> <br><br>
                            </form>
                        </div>

                        <div class="col-md-6">
                            <div class="cart-icon" >
                                <a class="your-cart" href="viewcart.jsp"> Your cart </a> &nbsp; <i class="fa-solid fa-cart-shopping"></i>
                                <%
                                    if (cart != null) {
                                %>
                                <span id="quantity"> &nbsp; <%= cart.getCart().size()%> &nbsp; </span>
                                <%
                                    }
                                %>
                            </div>
                            <div class="cart-icon">
                                <a class="your-wishlist" href="WistListController?uId=<%=user%>"> Your wishlist </a> &nbsp; <i class="fa-brands fa-gratipay"></i>
                                <%
                                    if (wishlist!=null && wishlist.size()!=0) {
                                %>
                                <span id="quantity"> &nbsp; <%= wishlist.size()%> &nbsp; </span>
                                <%
                                    }
                                %>
                            </div>

                        </div>
                    </div>
                </div>
                <br>
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h3 style="color: green"> ${done} </h3>
                            <h3 style="color: red"> ${fail} </h3>
                        </div>
                    </div>
                </div>
                <br>
                <div class="col-md-12">
                    <ul class="product">
                        <%
                            List<watchDTO> list2 = null;
                            if (request.getAttribute("data") != null) {
                                list2 = (List<watchDTO>) request.getAttribute("data");
                                for (watchDTO i : list2) {
                        %>
                        <li>
                            <div class="product-item">
                                <div class="product-img">
                                    <img class="product-img-src" src="images/<%=i.getImg()%>">
                                </div>
                                <div class="product-name">
                                    <%=i.getWatchName()%> 
                                </div>
                                <div class="product-price">
                                    <%=i.getPrice()%>$
                                </div>
                                <div class="product-name">
                                   Stock: <%=i.getQuantity()%>
                                </div>
                                    <%
                                        if(i.getQuantity()>0 && i.isNotSale()){
                                    %>
                                <div class="addcart">
                                    <a href="AddToCartController?watchId=<%=i.getWatchId()%>" > Add to cart </a>
                                </div>
                                <div class="addtowishlist">
                                    <a href="AddToWishlistController?watchId=<%=i.getWatchId()%>&userId=<%=user%>" > Add to wishlist </a>
                                </div>
                                <% 
                                    }else{
                                %>
                                <h4 class="sold-out"> Sold Out !! </h4>
                                <% 
                                    }
                                %>
                            </div>        
                            <form>
                        </li>
                        <%
                                }
                            }
                        %>
                    </ul>
                </div>

            </div>
        </div>
        <div class="form-container">
            <form action="LoginController" method="get">
                <input type="submit" value="Loggout" > &nbsp; <i class="fa-solid fa-right-from-bracket"></i>
            </form>
        </div>
        <br>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div  class="social">
                        <ul>
                            <li> <a href="#"><i class="fa-brands fa-facebook"></i> &nbsp; Facebook </a> </li>
                            <li> <a href="#"><i class="fa-brands fa-square-instagram"></i> &nbsp; Instagram </a> </li>
                            <li> <a href="#"><i class="fa-brands fa-square-x-twitter"></i> &nbsp; X(Twitter) </a> </li>
                            <li> <a href="#"><i class="fa-brands fa-square-threads"></i> &nbsp; Thread </a> </li>
                            <li> <a href="#"><i class="fa-brands fa-tiktok"></i> &nbsp; Tiktok </a> </li>
                            <li> <a href="#"><i class="fa-brands fa-square-threads"></i> &nbsp; Thread </a> </li>
                        </ul> 
                    </div>   
                </div>
            </div>
        </div>
        <div class="footer"> 
            <jsp:include page="footer.html"/> 
        </div>
    </body>
</html>
