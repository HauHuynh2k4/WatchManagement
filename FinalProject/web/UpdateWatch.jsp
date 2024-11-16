<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="sample.product.WatchDTO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Watch</title>
        <link rel="stylesheet" href="css/UpdateWatch.css">
    </head>
    <body>
        <jsp:include page="header.jsp" />
        <nav class="navbar2">
            <a href="admin.jsp">Home</a>
            <a href="InsertWatch.jsp">Add new Watch</a>
            <a href="getAllWatchController">Manage Watch</a>
            <a href="getAllUserController">Manage User</a>
            <a href="getAllInvoicesController">Manage Invoice</a>
            <a href="Account.jsp">Account</a>
        </nav>
        <div class="video-background">
            <video autoplay loop muted>
                <source src="img/Rolex Explorer.mp4" type="video/mp4">
            </video>
        </div>
        <div class="form-container">
            <h1>Update Watch</h1>
            <%
                String errorMessage = (String) request.getAttribute("ERROR_MESSAGE");
                WatchDTO watch = (WatchDTO) request.getAttribute("WatchInfo");
                if (errorMessage != null) {
            %>
            <div class="error"><%= errorMessage%></div>
            <%
                }
                if (watch != null) {
            %>

            <div class="form-content">
                <div class="image-section">
                    <img src="<%= watch.getImage()%>" alt="Current Image">
                </div>
                <div class="info-section">
                    <form action="MainController" method="post" >
                        <label for="id">ID</label>
                        <input type="text" id="id" name="watchId" value="<%= watch.getWatchId()%>" required>

                        <label for="name">Name</label>
                        <input type="text" id="name" name="name" value="<%= watch.getName()%>" required>

                        <label for="brand">Brand</label>
                        <input type="text" id="brand" name="brand" value="<%= watch.getBrand()%>" required>

                        <label for="description">Description</label>
                        <textarea id="description" name="description" required><%= watch.getDescription()%></textarea>

                        <label for="type">Type</label>
                        <select id="type" name="type">
                            <option value="Male" <%= "Male".equals(watch.getType()) ? "selected" : ""%>>Male</option>
                            <option value="Female" <%= "Female".equals(watch.getType()) ? "selected" : ""%>>Female</option>
                            <option value="Both" <%= "Both".equals(watch.getType()) ? "selected" : ""%>>Unisex</option>
                        </select>
                </div>
                <div class="form-section">
                    <label for="quantity">Quantity</label>
                    <input type="number" id="quantity" name="quantity" value="<%= watch.getQuantity()%>" required>

                    <label for="price">Price</label>
                    <input type="number" step="0.01" id="price" name="price" value="<%= watch.getPrice()%>" required>

                    <label for="sale">Sale</label>
                    <select id="sale" name="sale">
                        <option value="No" <%= "No".equals(watch.isNotSale()) ? "selected" : ""%>>Sale</option>
                        <option value="Yes" <%= "Yes".equals(watch.isNotSale()) ? "selected" : ""%>>Not Sale</option>
                    </select>

                    <label for="discount">Discount</label>
                    <input type="number" step="0.01" id="discount" name="discount" value="<%= watch.getDiscount()%>" required>

                    <label for="image">New Image</label>
                    <input type="file" id="image" name="image">
                    <input type="hidden" name="imageCurrent" value="<%= watch.getImage()%>">
                    <button type="submit" name="action" value="Update Info">Update </button>
                    </form>
                </div>
            </div>
        <%
            }
        %>

    </div>
</body>
</html>
