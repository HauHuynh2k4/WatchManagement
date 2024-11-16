<%@page import="java.math.BigDecimal"%>
<%@page import="java.util.HashMap"%>
<%@page import="sample.product.WatchDTO"%>
<%@page import="sample.cart.CatDAO"%>
<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your Cart</title>
        <style>
            body {
                font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                background-color: #f5f5f5;
                color: #333;
            }
            .cart-container {
                width: 80%;
                margin: 50px auto;
                padding: 20px;
                background-color: #fff;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                border-radius: 8px;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 20px;
            }
            table th, table td {
                padding: 15px;
                text-align: left;
                border-bottom: 1px solid #ddd;
            }
            table th {
                background-color: #f8f8f8;
                font-weight: 600;
            }
            table td img {
                width: 80px;
                height: auto;
                display: block;
                margin: 0 auto;
            }
            .cart-totals {
                text-align: right;
                margin-top: 20px;
            }
            .cart-totals h3 {
                font-size: 24px;
                margin-right: 5%;
                color: #333;
            }
            .actions button, .actions a {
                display: inline-block;
                background-color: #007bff;
                color: white;
                border: none;
                padding: 10px 20px;
                text-align: center;
                text-decoration: none;
                font-size: 16px;
                margin: 5px;
                border-radius: 5px;
                transition: background-color 0.3s;
            }
            .actions a {
                background-color: #dc3545;
            }
            .actions button:hover {
                background-color: #0056b3;
            }
            .actions a:hover {
                background-color: #c82333;
            }
            nav {
                padding-top: 10px;
                padding-bottom: 10px;
                text-align: center;
                background-color: rgb(95, 95, 99);
            }
            nav a {
                margin: 0 15px;
                text-decoration: none;
                color: white;
                font-weight: 500;
                transition: color 0.3s;
            }
            nav a:hover {
                color: #0056b3;
            }
            .error-message {
                color: #721c24;
                padding: 10px;
                margin-bottom: 20px;
                border-radius: 5px;
            }
            .error-message p{
                background-color: #f8d7da;
                border: 1px solid #f5c6cb;
                width: 16em;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <nav>
            <a href="Home.jsp">Home</a>
            <a href="getAllWatchController">Shop</a>
            <a href="about.jsp">About</a>
            <a href="Account.jsp">Account</a>
        </nav>
        <div class="cart-container">
            <h1>Your selected products</h1>
            <div class="error-message">
                <%
                    String errorMessage = (String) request.getAttribute("ERROR_MESSAGE");
                    if (errorMessage != null && !errorMessage.isEmpty()) {
                        out.println("<p>" + errorMessage + "</p>");
                    }
                %>
            </div>
            <%
                UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
                if (user == null) {
                    response.sendRedirect("login.jsp");
                    return;
                }

                CatDAO cartDao = new CatDAO();
                HashMap<String, WatchDTO> cart = cartDao.getListCart(user.getUserID());

                if (cart != null && !cart.isEmpty()) {
                    BigDecimal finalTotal = BigDecimal.ZERO;
            %>       
            <table>
                <thead>
                    <tr>
                        <th>Image</th>
                        <th>Product</th>
                        <th>Price</th>
                        <th>Discount</th>
                        <th>Quantity</th>
                        <th>Total</th>
                        <th>Remove</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (WatchDTO watch : cart.values()) {
                            BigDecimal discountedPrice = watch.getPrice().multiply(BigDecimal.ONE.subtract(watch.getDiscount().divide(new BigDecimal(100))));
                            BigDecimal itemTotal = discountedPrice.multiply(new BigDecimal(watch.getQuantity()));
                            finalTotal = finalTotal.add(itemTotal);
                    %>
                    <tr>
                        <td><img src="<%= watch.getImage()%>" alt="<%= watch.getName()%>"></td>
                        <td><%= watch.getName()%></td>
                        <td>$ <%= watch.getPrice()%></td>
                        <td><%= watch.getDiscount()%>%</td>
                        <td>
                            <form action="UpdateCartController" method="post" class="actions">
                                <input type="number" min="1" name="quantity" value="<%= watch.getQuantity()%>" required>
                                <input type="hidden" name="watchId" value="<%= watch.getWatchId()%>">
                                <button type="submit" name="action" value="Update cart">Update</button>
                            </form>
                        </td>
                        <td>$ <%= itemTotal.setScale(2, BigDecimal.ROUND_HALF_UP)%></td>
                        <td>
                            <a href="RemoveCartController?userID=<%= user.getUserID()%>&watchID=<%= watch.getWatchId()%>">Remove</a>
                        </td>
                    </tr>
                    <% }%>
                </tbody>
            </table>
            <div class="cart-totals">
                <h3>Total Amount: $ <%= finalTotal.setScale(2, BigDecimal.ROUND_HALF_UP)%></h3>
                <a class="actions checkout-btn" href="CheckOut.jsp">GO TO CHECKOUT</a>
            </div>
            <%
            } else {
            %>
            <h3>Your cart is empty.</h3>
            <% }%>
        </div>
    </body>
</html>
