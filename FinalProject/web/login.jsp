<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <style>
            body {
                display: flex;
                flex-direction: column;
                height: 100vh;
                margin: 0;
                background-color: #f8f9fa;
                overflow: hidden;
            }
            .video-background {
                position: fixed;
                top: 0;
                left: 0;
                width: 100%;
                height: 100%;
                overflow: hidden;
                z-index: -1;
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
            .header {
                display: flex;
                justify-content: center;
                align-items: center;
                background-color: rgb(51, 51, 51);
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            .store-name {
                display: flex;
                align-items: center;
                font-size: 1.5em;
                color: white;
            }
            .store-name img {
                margin-right: 10px;
                width: 3em;
            }
            .taskbar {
                background-color: rgb(95, 95, 99);
                padding: 0.5em;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            .breadcrumb {
                background-color: transparent;
                padding: 0;
                margin: 0;
            }
            .breadcrumb-item a {
                color: black;
                text-decoration: none;
            }
            .breadcrumb-item.active {
                color: white;
            }
            .container {
                flex: 1;
                display: flex;
                justify-content: center;
                align-items: center;
                position: relative;
                z-index: 1;
            }
            .login-container {
                width: 100%;
                max-width: 400px;
                padding: 20px;
                background-color: rgba(255, 255, 255, 0.9); /* Make background slightly transparent */
                border-radius: 10px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            }
            .login-container h1 {
                margin-bottom: 20px;
                text-align: center;
                font-size: 24px;
            }
            .login-container .form-group span {
                display: block;
                text-align: center;
                margin-bottom: 10px;
            }
        </style>
    </head>
    <body>
        <div class="video-background">
            <video autoplay loop muted>
                <source src="img/PATEK PHILIPPE 2023 NEW MODELS_1080p.mp4" type="video/mp4">
            </video>
        </div>
        <div class="header">
            <div class="store-name">
                <img src="img/Remove-bg.ai_1718442518067.png" alt="Logo">
                Hậu Watch
            </div>
        </div>
        <div class="taskbar">
            <ol class="breadcrumb" aria-label="Main">
                <li class="breadcrumb-item"><a href="Home.jsp">Home</a></li>
                <li class="breadcrumb-item active">Login</li>
            </ol>
        </div>
        <div class="container">
            <div class="login-container">
                <h1>Login</h1>
                <div class="form-group" style="color: green;">
                    <%
                        String Register = (String) request.getAttribute("REGISTER_SUCCESS");
                        if (Register != null) {
                            out.print(Register);
                        }
                    %>
                </div>
                <form action="MainController" method="POST">
                    <div class="form-group">
                        <input type="text" name="userId" class="form-control" placeholder="UserID" required>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" placeholder="Password" required>
                    </div>
                    <div class="form-group" style="color: red;">
                        <%
                            String Error = (String) request.getAttribute("ERROR");
                            if (Error != null) {
                                out.print(Error);
                            }
                        %>
                    </div>
                    <div class="form-group">
                        <button type="submit" name="action" value="Login" class="btn btn-primary btn-block">Login</button>
                    </div>
                </form>
                <div class="form-group text-center">
                    <span>Don't have an account?</span>
                    <form action="Register.jsp" method="get" style="display:inline;">
                        <button type="submit" class="btn btn-link">Register</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
