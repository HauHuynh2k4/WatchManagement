<%@page import="sample.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Watch</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/Home.css">
        <style>
            body {
                background-color: #f8f9fa; /* Màu nền cũ */
            }
            .container {
                padding: 40px;
                background-color: #fff;
                border-radius: 10px;
                box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            }
            .form-section input[type="text"],
            .form-section input[type="number"],
            .form-section input[type="file"],
            .form-section textarea,
            .form-section select {
                width: 100%;
                padding: 10px;
                margin: 10px 0;
                box-sizing: border-box;
                border: 1px solid #ced4da;
                border-radius: 4px;
                background-color: #fdfdfd;
            }
            .form-section button {
                display: block;
                width: 100%;
                padding: 15px;
                background-color: #4a00e0;
                color: white;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                margin-top: 10px;
                transition: background-color 0.3s ease;
            }
            .form-section button:hover {
                background-color: #3a00b0;
            }
            label {
                font-weight: bold;
                color: #333;
            }
            .header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 10px 20px;
                background-color: rgb(51, 51, 51);
                color: white;
            }
            .header img {
                width: 3em;
                margin-right: 10px;
            }
            .header .store-name {
                font-size: 1.5em;
                font-weight: bold;
            }
            .header .icons a {
                color: white;
                margin-left: 10px;
            }
            .navbar {
                display: flex;
                justify-content: center;
                background-color: rgb(95, 95, 99);
                padding: 10px 0;
            }
            .navbar a {
                color: white;
                padding: 10px 20px;
                text-decoration: none;
                transition: background-color 0.3s ease;
            }
            .navbar a:hover {
                background-color: #575757;
            }
            .alert {
                margin-top: 20px;
            }
        </style>
    </head>
    <body>
        <%
            UserDTO user = (UserDTO) session.getAttribute("LOGIN_USER");
            if (user == null || !"AD".equals(user.getRole())) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
        <div class="header">
            <div class="store-name">
                <img src="img/Remove-bg.ai_1718442518067.png">
                Hậu Watch
            </div>
            <div class="icons">
                <%
                    if (session.getAttribute("LOGIN_USER") != null) {
                %>
                <a href="logoutController" class="btn">Log Out</a>
                <%
                } else {
                %>
                <a href="login.jsp" class="btn">Log In</a>
                <%
                    }
                %>
                <a href="Account.jsp"><img src="img/user.png" alt="User"></a>
            </div>
        </div>
        <div class="navbar">
            <a href="admin.jsp">Home</a>
            <a href="InsertWatch.jsp">Add new Watch</a>
            <a href="getAllWatchController">Manage Watch</a>
            <a href="getAllUserController">Manage User</a>
            <a href="getAllInvoicesController">Manage Invoice</a>
            <a href="Account.jsp">Account</a>
        </div>

        <div class="container">
            <% if (request.getAttribute("SUCCESS") != null) {%>
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <%= request.getAttribute("SUCCESS")%>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <% } %>

            <% if (request.getAttribute("ERROR") != null) {%>
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <%= request.getAttribute("ERROR")%>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <% }%>

            <form action="MainController" method="post">
                <div class="row">
                    <div class="col-md-6 form-section">
                        <h2 style="color: #4a00e0">Create Watch</h2>
                        <label for="watchId">ID</label>
                        <input type="text" id="watchId" name="watchId" required>

                        <label for="name">Name</label>
                        <input type="text" id="name" name="name" required>

                        <label for="brand">Brand</label>
                        <input type="text" id="brand" name="brand" required>

                        <label for="description">Description</label>
                        <textarea id="description" name="description" rows="4"></textarea>

                        <label for="type">Type</label>
                        <select id="type" name="type">
                            <option value="Male">Male</option>
                            <option value="Female">Female</option>
                            <option value="Both">Unisex</option>
                        </select>

                        <label style="margin-top: 10px" for="price">Price</label>
                        <input style="margin-top: 10px" type="number" id="price" name="price" required>
                    </div>
                    <div class="col-md-6 form-section">
                        <br><br>
                        <label for="quantity">Quantity</label>
                        <input type="number" id="quantity" name="quantity" required>

                        <label for="sale">Sale</label>
                        <select id="sale" name="sale">
                            <option value="false">Sale</option>
                            <option value="true">Not Sale</option>
                        </select>

                        <label for="discount">Discount</label>
                        <input type="number" id="discount" name="discount">

                        <label for="image">Image</label>
                        <input type="file" id="image" name="image" required>
                        <button type="submit" name="action" value="Insert">Create</button>
                    </div>
                </div>
            </form>
        </div>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
