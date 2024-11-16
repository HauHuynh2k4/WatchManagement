<%-- 
    Document   : Account
    Created on : Jun 18, 2024, 2:06:26 AM
    Author     : ADMIN
--%>

<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Page</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
        <style>
            h1, th, td, img {
    color: white;
}

.avatar-container {
    border: 1px solid #ccc;
    padding: 10px;
    width: 200px;
    height: 200px;
    display: flex;
    justify-content: center;
    align-items: center;
}

.avatar-image {
    max-width: 100%;
    max-height: 100%;
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

.container {
    background-color: rgba(255, 255, 255, 0.9);
    border-radius: 10px;
    padding: 30px;
    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    margin-top: 20px;
}

.table {
    background-color: transparent;
}

.table th, .table td {
    background-color: transparent;
    color: #333;
}

.table-striped tbody tr:nth-of-type(odd) {
    background-color: rgba(0, 0, 0, 0.05);
}

.btn-primary {
    background-color: #333;
    border: none;
}

.btn-primary:hover {
    background-color: #555;
}

.alert {
    border-radius: 5px;
    margin-top: 20px;
}

h1 {
    color: #333;
    font-weight: bold;
    margin-bottom: 20px;
}

        </style>
    </head>
    <body>
        <div class="video-background">
            <video autoplay loop muted>
                <source type="video/mp4" src="img/PATEK PHILIPPE 2023 NEW MODELS_1080p.mp4">
            </video>
        </div>
        <jsp:include page="header.jsp"/>
        <%
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user == null) {
                response.sendRedirect("login.jsp");
                return;
            }
            if(user.getRole().equals("US")){
        %>
        <nav class="navbar2">
            <a href="Home.jsp">Home</a>
            <a href="getAllWatchController">Shop</a>
            <a href="about.jsp">About</a>
            <a href="Account.jsp">Account</a>
        </nav>
        <% }else if(user.getRole().equals("AD")){
        %>
        <nav class="navbar2">
            <a href="admin.jsp">Home</a>
            <a href="InsertWatch.jsp">Add new Watch</a>
            <a href="getAllWatchController">Manage Watch</a>
            <a href="getAllUserController">Manage User</a>
            <a href="getAllInvoicesController">Manage Invoice</a>
            <a href="Account.jsp">Account</a>
        </nav>
        <% } %>
        <section class="py-3 py-md-5 py-xl-8">
            <div class="container">
                <div>
                    <h1 style="color: rgb(217, 183, 152)"><%=user.getFullName()%>'s Information</h1>
                </div>
                <div class="row">
                    <div class="col-8">
                        <table class="table table-striped mt-5">
                            <thead>
                                <tr>
                                    <th>User Info</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                            <form action="MainController" method="POST">
                                <tr>
                                    <td>User ID</td>
                                    <td><input type="text" name="userID" class="form-control" value="<%= user.getUserID()%>" readonly></td>
                                </tr>
                                <tr>
                                    <td>Password</td>
                                    <td><input type="text" name="Password" class="form-control" value="<%= user.getPassword()%>" required></td>
                                </tr>
                                <tr>
                                    <td>Confirm Password</td>
                                    <td><input type="password" name="confirmPassword" class="form-control" value="<%= user.getPassword()%>" required></td>
                                </tr>
                                <tr>
                                    <td>Full Name</td>
                                    <td><input type="text" name="fullName" class="form-control" value="<%= user.getFullName()%>" required></td>
                                </tr>
                                <tr>
                                    <td>Email</td>
                                    <td><input type="email" name="email" class="form-control" value="<%= user.getGmail()%>" required></td>
                                </tr>
                                <tr>
                                    <td>Address</td>
                                    <td><input type="text" name="address" class="form-control" value="<%= user.getAddress()%>" required></td>
                                </tr>
                                <tr>
                                    <td colspan="2" class="text-center">
                                        <button type="submit" name="action" value="UpdateUser" class="btn btn-primary">Update</button>
                                    </td>
                                </tr>
                            </form>

                            </tbody>
                        </table>
                        <%
                            String successMessage = (String) request.getAttribute("SUCCESS_MESS");
                            String errorMessage = (String) request.getAttribute("ERROR_MESS");
                            if (successMessage != null) {
                        %>
                        <div class="alert alert-success" role="alert">
                            <%= successMessage%>
                        </div>
                        <%
                            }
                            if (errorMessage != null) {
                        %>
                        <div class="alert alert-danger" role="alert">
                            <%= errorMessage%>
                        </div>
                        <%
                            }
                        %>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
