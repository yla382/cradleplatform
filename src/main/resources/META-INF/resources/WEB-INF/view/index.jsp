<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Cradle</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/welcome.css">
    <script src="/js/app.js"></script>
</head>

<body>
    <!--NAVBAR-->
    <div class="navbar-container">
        <div class="navbar-title">
            cradle
        </div>
        <ul class="navbar">
            <li class="nav-item">
                <a class="nav-link" href="/">HOME </a> </li>
            <li class="nav-item">
                <a class="nav-link" href=#>PAGE </a> </li>
            <li class="nav-item">
                <a class="nav-link" href="/admin/index">ADMIN </a> </li>
            <li class="nav-item">
                <a class="nav-link" href="#">ABOUT US</a>
            </li>
        </ul>
    </div>
    <!--END of NAVBAR-->


    <div class="container">
        <div id="welcome-view">
            <div id="welcome-background" class="fade"></div>
            <div class="welcome-container">
                <!--HERO-->
                <div class="welcome-hero-container">
                    <div id="welcome-hero" class="fade">
                        <div class="welcome-title">
                            <h1>Cradle.</h1>
                        </div>

                        <div id="welcome-title-desc" class="fade horizontal-translate">
                            Welcome to Mercury's Group Project!
                        </div>

                        <button class="welcome-title-btn" type="button" onclick="window.location.href='/login'">Sign in</button>
                        <button class="welcome-title-btn" type="button">Register</button>

                        <i class="welcome-arrow-d"></i>
                    </div>
                </div>
                <!--END of HERO-->

                <!--DETAILS-->
                <div class="welcome-content">
                    <div id="welcome-details">
                        <div id="welcome-details-info" class="fade vertical-translate">
                            Our goal is blah blah Lorem ipsum dolor sit
                            amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut
                            labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
                            exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.
                            Duis aute irure dolor in reprehenderit in voluptate velit esse
                        </div>

                        <div id="welcome-details-about" class="fade vertical-translate">
                            <div class="welcome-details-about-header">
                                ABOUT US
                            </div>
                            <div>
                                Made by blah blah sed do eiusmod tempor incididunt ut nim ad minim
                                veniam, quis nostrud
                            </div>
                        </div>

                        <div id="welcome-details-start" class="fade">
                            GET STARTED
                        </div>
                    </div>
                </div>
                <!--END of DETAILS-->

                <!--FOOTER-->
                <div class="welcome-footer">
                    cradle
                    <br />
                    <span class="welcome-copyright">&#9400; 2019 Copyright</span>
                </div>
                <!--END of FOOTER-->
            </div>
        </div>
    </div>
</body>

</html>