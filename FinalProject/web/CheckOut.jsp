<%@page import="sample.cart.CatDAO"%>
<%@page import="sample.user.UserDTO"%>
<%@page import="sample.product.WatchDTO"%>
<%@page import="java.util.Map, java.util.HashMap, java.math.BigDecimal"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Checkout Page</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
            }
            .container2 {
                display: flex;
                justify-content: space-around;
                padding: 20px;
                width: 100%;
            }
            .billing-details {
                border: 1px solid #ccc;
                padding: 20px;
                border-radius: 5px;
                flex: 1;
                margin-right: 2em;
                height: 45em;
            }
            .order-summary {
                border: 1px solid #ccc;
                padding: 20px;
                border-radius: 5px;
                flex: 2;
                height: 45em;
                display: flex;
                flex-direction: column;
            }
            h2 {
                margin-top: 0;
            }
            input[type="text"], input[type="email"], input[type="date"] {
                width: 100%;
                padding: 10px;
                margin: 10px 0;
                box-sizing: border-box;
            }
            .place-order-btn {
                margin-top: 3em;
                display: block;
                width: 100%;
                padding: 15px;
                background-color: #8A2BE2;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }
            .place-order-btn:hover {
                background-color: #5A189A;
            }
            table {
                width: 100%;
                border-collapse: collapse;
            }
            table, th, td {
                border: 1px solid #ddd;
                padding: 8px;
            }
            th {
                background-color: #f2f2f2;
            }
            .order-total {
                font-weight: bold;
                background-color: #8A2BE2;
                color: white;
                padding: 10px;
                border-radius: 5px;
                text-align: center;
            }
            .navbar2 {
                display: flex;
                justify-content: center;
                align-items: center;
                background: rgb(95, 95, 99);
                height: 3em;
            }
            nav a {
                margin: 0 15px;
                text-decoration: none;
                color: white;
            }
            img {
                width: 80px;
                height: auto;
                display: block;
                margin: 0 auto;
            }
            .order-total-wrapper {
                margin-top: 10px;
                text-align: left;
                flex-shrink: 0;
            }
            .order-total-wrapper h2 {
                margin: 0;
            }
            .order-table-wrapper {
                overflow-y: auto;
                flex-grow: 1;
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
        <div class="container2">
            <div class="billing-details">
                <%
                    UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
                    if (user == null) {
                        response.sendRedirect("login.jsp");
                        return;
                    }

                    CatDAO cartDao = new CatDAO();
                    HashMap<String, WatchDTO> cart = cartDao.getListCart(user.getUserID());

                    BigDecimal finalTotal = BigDecimal.ZERO;
                    if (cart != null && !cart.isEmpty()) {
                        for (WatchDTO watch : cart.values()) {
                            BigDecimal discountedPrice = watch.getPrice().multiply(BigDecimal.ONE.subtract(watch.getDiscount().divide(new BigDecimal(100))));
                            BigDecimal itemTotal = discountedPrice.multiply(new BigDecimal(watch.getQuantity()));
                            finalTotal = finalTotal.add(itemTotal);
                        }
                    }
                %>
                <h2>Billing Details</h2>
                <form action="MainController" method="post">
                    <label for="userId">User ID</label>
                    <input type="text" id="userId" name="userId" value="<%= user.getUserID()%>" readonly>

                    <label for="dateOfPurchase">Date of Purchase</label>
                    <input type="date" id="dateOfPurchase" name="dateOfPurchase" required>

                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" value="<%= user.getGmail()%>" required>

                    <label for="address">Address</label>
                    <input type="text" id="address" name="address" value="" placeholder="Your Address" required>

                    <input type="hidden" id="finalTotal" name="finalTotal" value="<%= finalTotal.setScale(2, BigDecimal.ROUND_HALF_UP)%>">

                    <button type="submit" name="action" value="Check out" class="place-order-btn">Place Order</button>
                </form>
            </div>
            <div class="order-summary">
                <h2>Your Order</h2>
                <div class="order-table-wrapper">
                    <table>
                        <thead>
                            <tr>
                                <th>Image</th>
                                <th>Product</th>
                                <th>Quantity</th>
                                <th>Total</th>
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                if (cart != null && !cart.isEmpty()) {
                                    for (WatchDTO watch : cart.values()) {
                                        BigDecimal discountedPrice = watch.getPrice().multiply(BigDecimal.ONE.subtract(watch.getDiscount().divide(new BigDecimal(100))));
                                        BigDecimal itemTotal = discountedPrice.multiply(new BigDecimal(watch.getQuantity()));
                            %>
                            <tr>
                                <td><img src="<%= watch.getImage()%>" alt="<%= watch.getName()%>"></td>
                                <td><%= watch.getName()%></td>
                                <td><%= watch.getQuantity()%></td>
                                <td>$ <%= itemTotal.setScale(2, BigDecimal.ROUND_HALF_UP)%></td>
                            </tr>
                            <%
                                    }
                            %>
                        </tbody>
                    </table>
                </div>
                <div class="order-total-wrapper">
                    <h2 style="display: inline">Order Total: <h5 style="display: inline;color: red">$ <%= finalTotal.setScale(2, BigDecimal.ROUND_HALF_UP)%></h5></h2>
                </div>
                <%
                } else {
                %>
                <h2>Your cart is empty.</h2>
                <%
                    }
                %>
            </div>
        </div>
    </body>
</html>
