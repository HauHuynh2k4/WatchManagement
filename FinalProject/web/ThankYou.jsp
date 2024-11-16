<%-- 
    Document   : ThankYou
    Created on : Jun 21, 2024, 6:44:58 PM
    Author     : ADMIN
--%>

<%-- 
    Document   : ThankYou
    Created on : Jun 21, 2024, 6:44:58 PM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thank You for Your Purchase!</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                background-color: #f4f4f4;
            }
            .container {
                max-width: 600px;
                margin: 50px auto;
                padding: 20px;
                background-color: rgba(81, 77, 76,0.7);
                border-radius: 5px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                text-align: center;
            }
            h1 {
                color: gold;
            }
            p {
                font-size: 18px;
                color: white;
            }
            .btn {
                display: inline-block;
                margin: 20px 10px;
                padding: 15px 25px;
                font-size: 16px;
                color: white;
                background-color: rgb(192, 175, 159);
                border: none;
                border-radius: 5px;
                text-decoration: none;
                cursor: pointer;
            }
            .btn:hover {
                background-color: rgb(192, 175, 159);
            }
            .navbar2 {
                display: flex;
                justify-content: center;
                align-items: center;
                background: rgb(95, 95, 99);
                height: 3em;
                margin-bottom: 20px;
            }
            nav a {
                margin: 0 15px;
                text-decoration: none;
                color: white;
            }
            .video-background {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                z-index: -1;
                overflow: hidden;
            }

            .video-background video {
                min-width: 100%;
                min-height: 100%;
                width: auto;
                height: auto;
                position: absolute;
                top: 50%;
                left: 50%;
                transform: translate(-50%, -50%);
            }
            .container a{
                color: white;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <nav class="navbar2">
            <a href="Home.jsp">Home</a>
            <a href="getAllWatchController">Shop</a>
            <a href="about.jsp">About</a>
            <a href="Account.jsp">Account</a>
        </nav>
        <div class="video-background">
            <video autoplay loop muted>
                <source type="video/mp4" src="img/PATEK PHILIPPE 2023 NEW MODELS_1080p.mp4">
            </video>
        </div>
        <div class="container">
            <h1>Thank You for Your Purchase!</h1>
            <p>We appreciate your business and hope you enjoy your new items. Your order has been successfully processed.</p>
            <a href="Home.jsp" class="btn">Continue Shopping</a>
            <a href="Account.jsp" class="btn">View Your Account</a>
        </div>
    </body>
</html>
