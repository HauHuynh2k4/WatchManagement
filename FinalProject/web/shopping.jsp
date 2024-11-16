<%@page import="sample.wishlist.WishListDAO"%>
<%@page import="sample.user.UserDTO"%>
<%@page import="sample.user.UserDao"%>
<%@page import="sample.product.WatchDAO"%>
<%@page import="java.math.RoundingMode"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="sample.product.WatchDTO"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Watch Store</title>
        <link rel="stylesheet" href="css/Shopping.css">
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <nav class="navbar2">
            <a href="Home.jsp">Home</a>
            <a href="getAllWatchController">Shop</a>
            <a href="about.jsp">About</a>
            <a href="Account.jsp">Account</a>
            <a href="ViewWishListController">View WishList</a>
        </nav>
        <div class="productMenu">
            <div class="sidebar">
                <div class="category">
                    <h3>Type</h3>
                    <p><a href="MainController?action=FIND&Type=Male">Men</a></p>
                    <p><a href="MainController?action=FIND&Type=Female">Women</a></p>
                    <p><a href="MainController?action=FIND&Type=Both">UniSex</a></p>
                </div>
                <div class="category">
                    <h3>Brand</h3>
                    <p><a href="MainController?action=Find&Brand=Casio">Casio</a></p>
                    <p><a href="MainController?action=Find&Brand=Rolex">Rolex</a></p>
                    <p><a href="MainController?action=Find&Brand=Hublot">Hublot</a></p>
                    <p><a href="MainController?action=Find&Brand=Patek%20Philippe">Patek Philippe</a></p>
                    <p><a href="MainController?action=Find&Brand=Richard%20Mille">Richard Mille</a></p>
                </div>
                <div class="category">
                    <h3>Filter by Name or Id</h3>
                    <form action="MainController" method="GET">
                        <label for="min-price">Name or Id:</label>
                        <input type="text" id="min-price" value="<%= request.getParameter("IdOrName") != null ? request.getParameter("IdOrName") : ""%>" name="IdOrName"><br><br>
                        <button type="submit" name="action" value="Search">Filter</button>
                    </form>
                </div>
                <div class="category">
                    <h3>Filter by Price</h3>
                    <form action="MainController" method="GET">
                        <label for="min-price">Min Price:</label>
                        <input type="text" id="min-price" value="<%= request.getParameter("minPrice") != null ? request.getParameter("minPrice") : ""%>" name="minPrice"><br><br>
                        <label for="max-price">Max Price:</label>
                        <input type="text" id="max-price" value="<%= request.getParameter("maxPrice") != null ? request.getParameter("maxPrice") : ""%>" name="maxPrice"><br><br>
                        <button type="submit" name="action" value="SEARCH">Filter</button>
                    </form>
                </div>

            </div>
            <div class="main-content">
                <%
                    List<WatchDTO> listWatch = (List<WatchDTO>) request.getAttribute("LIST_WATCH");
                    if (listWatch != null && !listWatch.isEmpty()) {
                %>
                <div class="products">
                    <%
                        for (WatchDTO watch : listWatch) {
                            if (watch.getQuantity() > 1 && !watch.isNotSale()) {
                                BigDecimal originalPrice = watch.getPrice();
                                BigDecimal discount = watch.getDiscount();

                                // Tính toán giá sau khi giảm giá
                                BigDecimal discountAmount = originalPrice.multiply(discount).divide(new BigDecimal(100));
                                BigDecimal discountedPrice = originalPrice.subtract(discountAmount);
                                String originalPriceStr = String.format("%.2f", originalPrice);
                                String discountedPriceStr = String.format("%.2f", discountedPrice);
                                String discountPercentStr = String.format("%.0f", discount);

                                // Display the product with discounted information
%>
                    <div class="product">
                        <a href="MainController?action=GetInfo&watchId=<%= watch.getWatchId()%>">
                            <img src="<%= watch.getImage()%>" alt="<%= watch.getName()%>">
                        </a>

                        <h3><%= watch.getName()%></h3>
                        <p class="price">
                            $ <del><%= originalPriceStr%></del> 
                            <br>
                            <span style="color: red;">$ <%= discountedPriceStr%> 
                                <span style="font-size: smaller;">(<%= discountPercentStr%>% off)</span> 
                            </span>
                        </p>
                        <div class="product-buttons">
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
                    <%
                            }
                        }
                    %>
                </div>
                <%
                } else {
                %>
                <p>No watches found.</p>
                <%
                    }
                    String error = (String) request.getAttribute("ERROR");
                    if (error != null) {
                %>
                <p style="color: red;"><%= error%></p>
                <%
                    }
                %>
            </div>
        </div>
    </body>
</html>
