<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register Page</title>
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
        .register-container {
            width: 100%;
            max-width: 400px;
            padding: 20px;
            background-color: rgba(255, 255, 255, 0.9); /* Make background slightly transparent */
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .register-container h1 {
            margin-bottom: 20px;    
            text-align: center;
            font-size: 24px;
        }
        .register-container .form-group span {
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
        <li class="breadcrumb-item active">Register</li>
    </ol>
</div>
<div class="container">
    <div class="register-container">
        <h1>Register</h1>
        <div class="form-group" style="color: green;">
            <%
                String registerSuccess = (String) request.getAttribute("REGISTER_SUCCESS");
                if (registerSuccess != null) {
                    out.print(registerSuccess);
                }
            %>
        </div>
        <form action="registerController" method="POST">
            <div class="form-group">
                <input type="text" name="userId" class="form-control" placeholder="User ID" required>
            </div>
            <div class="form-group">
                <input type="text" name="fullname" class="form-control" placeholder="Full Name" required>
            </div>
            <div class="form-group">
                <input type="text" name="address" class="form-control" placeholder="Address" required>
            </div>
            <div class="form-group">
                <input type="text" name="email" class="form-control" placeholder="Email" required>
            </div>
            <div class="form-group">
                <input type="password" name="pass" class="form-control" placeholder="Password" required>
            </div>
            <div class="form-group">
                <input type="password" name="confirm_pass" class="form-control" placeholder="Confirm Password" required>
            </div>
            <div class="form-group">
                <button type="submit" name="action" value="Register" class="btn btn-primary btn-block">Register</button>
            </div>
        </form>
        <div class="form-group text-center">
            <span>Already have an account?</span>
            <a href="login.jsp">
                <button type="button" class="btn btn-link">Login</button>
            </a>
        </div>
    </div>
</div>
</body>
</html>
