<%-- 
    Document   : WatchInfo
    Created on : Jun 21, 2024, 10:08:42 AM
    Author     : ADMIN
--%>

<%@page import="sample.user.UserDTO"%>
<%@page import="sample.wishlist.WishListDAO"%>
<%@page import="java.math.BigDecimal"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sample.product.WatchDTO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Watch Information</title>
        <link rel="stylesheet" href="css/WatchInfo.css">
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
                <source src="img/Rolex Explorer.mp4" type="video/mp4">
            </video>
        </div>
        <div class="watch-details">
            <%
                WatchDTO watch = (WatchDTO) request.getAttribute("WatchInfo");
                if (watch != null) {
                    if (watch.getQuantity() > 1 && !watch.isNotSale()) {
                        BigDecimal originalPrice = watch.getPrice();
                        BigDecimal discount = watch.getDiscount();

                        BigDecimal discountAmount = originalPrice.multiply(discount).divide(new BigDecimal(100));
                        BigDecimal discountedPrice = originalPrice.subtract(discountAmount);
                        String originalPriceStr = String.format("%.2f", originalPrice);
                        String discountedPriceStr = String.format("%.2f", discountedPrice);
                        String discountPercentStr = String.format("%.0f", discount);


            %>
            <div class="watch-info-container">
                <div class="watch-image">
                    <img src="<%= watch.getImage()%>" alt="<%= watch.getName()%>">
                </div>
                <div class="watch-info">
                    <h2><%= watch.getName()%></h2>
                    <p><strong>Brand:</strong> <%= watch.getBrand()%></p>
                    <p><strong>ID:</strong> <%= watch.getWatchId()%></p>
                    <p><strong>Description:</strong> <%= watch.getDescription()%></p>
                    <p class="price">
                        <strong>Brand: </strong><span style="color: red;">$ <%= discountedPriceStr%></span>
                        <del style="font-size:smaller; color: gold">$ <%= originalPriceStr%></del> 
                        <span style="font-size: smaller;color: gold">(<%= discountPercentStr%>% off)</span>
                    </p>
                    <div class="actions">
                        <form action="MainController" method="post" class="add-to-cart-form">
                                <input type="hidden" name="watchId" value="<%= watch.getWatchId()%>">
                                <%
                                    UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
                                    if (user != null) {
                                %>
                                <button type="submit" name="action" value="Add" class="add-to-cart-button">Add to cart</button>
                                <%
                                    } else {
                                %>
                                <button type="button" class="add-to-cart-button" disabled>Add to cart</button>
                                <%
                                    }
                                %>
                            </form>
                            <form action="MainController" method="post" class="wishlist-form">
                                <%
                                    WishListDAO dao = new WishListDAO();
                                    boolean check = (user != null) && dao.isWishlistItemExists(user.getUserID(), watch.getWatchId());
                                    if (check) {
                                %>
                                <button type="submit" name="action" value="DeleteWishList" class="wishlist-button2">
                                    <input type="hidden" name="watchId" value="<%=watch.getWatchId() %>">
                                    <span class="heart">&#9829;</span>
                                </button>
                                <%
                                } else {
                                %>
                                <button type="submit" name="action" value="InsertWishList" class="wishlist-button">
                                    <input type="hidden" name="watchId" value="<%=watch.getWatchId() %>">
                                    <span class="heart">&#9829;</span>
                                </button>
                                <%
                                    }
                                %>
                            </form>
                    </div>
                </div>
            </div>
            <%
                }
            } else {
            %>
            <p>No watch information available.</p>
            <%
                }
            %>
        </div>

    </body>
</html>
