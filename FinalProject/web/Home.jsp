<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hậu Watch</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/Home.css">
        <script>
        function submitBrand(brand) {
            document.getElementById('brand').value = brand;
            document.getElementById('brandForm').submit();
        }
    </script>
    </head>
    <body>
        <div class="header">
            <div class="search-bar">
                <form action="MainController" method="GET">
                    <input type="text" placeholder="Search Watch" name="IdOrName">
                    <input type="hidden" name="action" value="Search">
                </form>
            </div>
            <div class="store-name">
                <img src="img/Remove-bg.ai_1718442518067.png" style="width: 3em">
                Hậu Watch
            </div>
            <div class="icons">
                <%
                    if (session.getAttribute("LOGIN_USER") != null) {
                %>
                <a href="logoutController" class="btn ">Log Out</a>
                <%
                } else {
                %>
                <a href="login.jsp" class="btn">Log In</a>
                <%
                    }
                %>
                <a href="Account.jsp"> <img src="img/user.png" alt="User"></a>
                <a href="MainController?action=View Cart"><img src="img/cart.png" alt="View Cart"> </a>
            </div>
        </div>
        <div class="navbar">
            <a href="Home.jsp">Home</a>
            <div class="dropdown d-inline">
                <a class="dropdown-toggle" data-toggle="dropdown">Shop</a>
                <div class="dropdown-menu">
                <form id="brandForm" action="MainController" method="POST">
                    <input type="hidden" name="action" value="Find">
                    <input type="hidden" name="Brand" id="brand" value="">
                </form>
                <div class="dropdown-item" onclick="submitBrand('Casio')">Casio</div>
                <div class="dropdown-item" onclick="submitBrand('Rolex')">Rolex</div>
                <div class="dropdown-item" onclick="submitBrand('Cartier')">Cartier</div>
                <div class="dropdown-item" onclick="submitBrand('Hublot')">Hublot</div>
                <div class="dropdown-item" onclick="submitBrand('Richard Mille')">Richard Mille</div>
                <div class="dropdown-item" onclick="submitBrand('Patek Philippe')">Patek Philippe</div>
            </div>
            </div>
            <a href="Account.jsp">Account</a>
        </div>
        <div class="video-background">
            <video autoplay loop muted>
                <source type="video/mp4" src="img/PATEK PHILIPPE 2023 NEW MODELS_1080p.mp4">
            </video>
        </div>
        <div class="main-content">
            <div class="text-content">
                <div>
                    <img src="img/model2.jpg" alt="Model">
                </div>
                <div>
                    <h1 style="color: yellow">Finding Your Perfect Watch</h1>
                    <p style="color: white">Welcome to Hậu Watch! We believe that the right pair of watches can not only improve your vision but also express your unique personality and style. Whether you are looking for a professional look for the office, a funky pair for the weekends, or a sturdy set for outdoor activities, we have got you covered.</p>
                    <a href="getAllWatchController">Shop Now</a>
                </div>
                <div>
                    <img src="img/model.jpg" alt="Model">
                </div>
            </div>
        </div>
        <footer class="footer">
            <div class="container">
                <p>Contact us:</p>
                <p>Email: hauwatch@gmail.com</p>
                <p>Phone: +84 123 456 789</p>
                <p>Address: FPT university, Ho Chi Minh, Viet Nam</p>
            </div>
        </footer>

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.2/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
