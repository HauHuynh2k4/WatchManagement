<%@ page import="sample.invoice.InvoiceDTO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Manage Invoices</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/Home.css">
        <style>
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
            .header .icons {
                display: flex;
                align-items: center;
            }
            .header .icons a {
                color: white;
                margin-left: 10px;
                text-decoration: none;
            }
            .header .icons a:hover {
                text-decoration: underline;
            }
            .navbar {
                display: flex;
                justify-content: center;
                background-color: rgb(95, 95, 99);
                padding: 10px 0;
                margin-bottom: 20px;
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
            .search-bar {
                margin-bottom: 20px;
                display: flex;
                justify-content: center;
            }
            .search-bar input[type="text"] {
                padding: 10px;
                width: 300px;
                border: 1px solid #ccc;
                border-radius: 5px;
                margin-right: 10px;
            }
            .search-bar button {
                padding: 10px 20px;
                border: none;
                border-radius: 5px;
                background-color: #4d79ff;
                color: white;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }
            .search-bar button:hover {
                background-color: #3d5fdb;
            }
            table {
                width: 100%;
                border-collapse: collapse;
                margin-bottom: 20px;
            }
            th, td {
                padding: 10px;
                border: 1px solid #ddd;
                text-align: left;
            }
            th {
                background-color: #333;
                color: white;
            }
            td input[type="text"] {
                width: 100%;
                padding: 5px;
                border: 1px solid #ddd;
                border-radius: 5px;
            }
            .actions button {
                padding: 8px 16px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                font-size: 14px;
            }
            .actions .delete {
                background-color: #ff4d4d;
                color: white;
            }
            .actions .update {
                background-color: #4d79ff;
                color: white;
            }
        </style>
    </head>
    <body>
        <%-- Check if user is logged in and has admin role --%>
        <%
            sample.user.UserDTO user1 = (sample.user.UserDTO) session.getAttribute("LOGIN_USER");
            if (user1 == null || !"AD".equals(user1.getRole())) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>
        <div class="header">
            <div class="store-name">
                <img src="img/Remove-bg.ai_1718442518067.png" alt="Hậu Watch Logo">
                Hậu Watch
            </div>
            <div class="icons">
                <% if (user1 != null) { %>
                <a href="logoutController" class="btn">Log Out</a>
                <% } else { %>
                <a href="login.jsp" class="btn">Log In</a>
                <% } %>
                <a href="Account.jsp"><img src="img/user.png" alt="User Icon"></a>
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
            <h1>Manage Invoices</h1>
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

            <div class="search-bar">
                <form action="MainController" method="GET">
                    <input type="text" name="search" placeholder="Search by UserID">
                    <button type="submit" name="action" value="Search Invoice">Search</button>
                </form>
            </div>

            <table>
                <thead>
                    <tr>
                        <th>Invoice ID</th>
                        <th>User ID</th>
                        <th>Email</th>
                        <th>Address</th>
                        <th>Purchase Date</th>
                        <th>Total Price</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<InvoiceDTO> invoiceList = (List<InvoiceDTO>) request.getAttribute("LIST_INVOICE");
                        if (invoiceList != null) {
                            for (InvoiceDTO invoice : invoiceList) {
                    %>
                    <tr>
                            <td><%= invoice.getInvId()%></td>
                            <td><%= invoice.getUserId()%></td>
                            <td><%= invoice.getGmail()%></td>
                            <td><%= invoice.getAddress()%></td>
                            <td><%= invoice.getPurchaseDate()%></td>
                            <td><%= invoice.getTotalPrice()%></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
