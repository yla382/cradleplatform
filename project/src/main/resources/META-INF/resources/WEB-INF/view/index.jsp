<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Cradle</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <script src="../../js/app.js"></script>


    <style>
        html {
            height: 100%;
            width: 100%;
            font-family: "Montserrat", "Helvetica", "Arial", sans-serif;
        }

        body {
            background-color: #232732;
            background-image: linear-gradient(45deg, #693f9c, #3b70cc, #4491d4);
            margin: 0;
        }

        /*############# MAIN ##############*/
        /*NAVBAR*/
        .navbar-container {
            height: 50px;
            width: 90%;
            margin-left: auto;
            margin-right: auto;
            border-bottom: 1px solid white;
            color: white;
            padding-top: 30px;
        }

        .navbar-title {
            width: 100px;
            float: left;
            margin-top: 10px;
            margin-left: 20px;
            font-size: 30px;
            font-weight: bold;
            color: white;
        }

        .navbar li {
            display: inline;
        }

        .navbar {
            padding: 0;
            float: right;
        }

        .nav-link {
            text-decoration: none;
            color: white;
            font-weight: lighter;
            font-size: 20px;
            padding-right: 20px;
        }

        .nav-link:hover {
            color: #94bdeb;
        }

        /*GENERAL*/
        .container {
            width: 100%;
        }

        /*############# WELCOME VIEW ##############*/
        #welcome-view {
            text-align: center;
            color: white;
            height: 100%;
            width: 100%;
        }

        #welcome-background {
            position: fixed;
            z-index: -1;
            height: 100vh;
            width: 100%;
            background: url("images/Network-PNG-Transparent.png") no-repeat 15% 30% fixed;
            background-size: 170vh;
            transition: 0.7s opacity;
        }

        .welcome-arrow-d {
            border: solid #73a2d8ad;
            border-width: 0 10px 10px 0;
            display: inline-block;
            padding: 10px;
            transform: rotate(45deg);
            position: absolute;
            bottom: 40px;
            left: 48%;
        }

        .welcome-container {
            width: 100%;
            padding-top: 200px;
            margin-bottom: -200px;
        }

        #welcome-hero {
            height: 100vh;
            margin-bottom: -345px;
            text-align: left;
            width: 500px;
            margin-left: 20%;
            transition: 1.4s opacity;
        }

        .welcome-hero-container {
            width: 100%;
        }

        .welcome-title {
            font-size: 48px;
        }

        #welcome-title-desc {
            margin-top: -30px;
            font-size: 28px;
            font-family: "Times New Roman", Times, serif !important;
            transition: 1.4s;
            height: 50px;
            width: 300px;
        }

        .welcome-title-btn {
            color: white;
            margin-top: 50px;
            margin-right: 10px;
            font-size: 20px;
            border-radius: 40px;
            padding: 15px 50px 15px 50px;
            background-color: #73a2d8;
            border-color: none;
            border-style: none;
        }

        .welcome-title-btn:hover {
            background-color: #94bdeb;
            cursor: pointer;
        }

        .welcome-content {
            background-color: white;
            color: #4e4e4e;
            min-height: 100vh;
            margin-bottom: -80px;
            width: 100%;
            text-align: left;
            font-weight: lighter;
        }

        #welcome-details {
            padding: 150px 100px 100px 100px;
        }

        #welcome-details a {
            text-decoration: none;
        }

        #welcome-details-info {
            text-align: center;
            padding-left: 10%;
            padding-right: 10%;
            font-size: 25px;
            transition: 1.4s;
        }

        #welcome-details-about {
            margin-top: 150px;
            text-align: center;
            padding-left: 30%;
            padding-right: 30%;
            font-size: 25px;
            transition: 1.4s;
        }

        .welcome-details-about-header {
            font-size: 45px;
            margin-bottom: 20px;
            color: black;
        }

        #welcome-details-start {
            margin-top: 150px;
            text-align: center;
            padding-left: 30%;
            padding-right: 30%;
            margin-bottom: 50px;
            transition: 1.4s;
            font-size: 45px;
            color: #51289e;
            text-decoration: none;
        }

        #welcome-details-start:hover {
            cursor: pointer;
        }

        .welcome-footer {
            font-size: 25px;
            height: 80px;
            padding-top: 40px;
            background-color: #f0f0f0;
            color: black;
        }

        .welcome-copyright {
            margin-top: 50px;
            font-size: 15px;
            color: #b6b6b6;
        }

        .fade {
            opacity: 0;
        }

        .horizontal-translate {
            margin-left: -50%;
        }

        .vertical-translate {
            margin-bottom: -50%;
        }
    </style>

    <script>
        window.onload = function () {
            var img = document.getElementById("welcome-background");
            var bodyHeight = window.pageYOffset;

            window.addEventListener("scroll", function () {
                var scroll = this.scrollY;
                img.style.transform = "rotate(" + scroll / 60 + "deg)";

                if (scroll >= window.innerHeight) {
                    setInterval(function () {
                        document.getElementById("welcome-details-info").classList.remove("vertical-translate");
                    }, 350);
                    setInterval(function () {
                        document.getElementById("welcome-details-info").classList.remove("fade");
                    }, 150);
                    setInterval(function () {
                        document.getElementById("welcome-details-about").classList.remove("vertical-translate");
                    }, 1350);
                    setInterval(function () {
                        document.getElementById("welcome-details-about").classList.remove("fade");
                    }, 1050);
                    setInterval(function () {
                        document.getElementById("welcome-details-start").classList.remove("fade");
                    }, 1950);
                }
            });

            document.getElementById("welcome-hero").classList.remove("fade");
            document.getElementById("welcome-background").classList.remove("fade");

            setInterval(function () {
                document
                    .getElementById("welcome-title-desc")
                    .classList.remove("horizontal-translate");
            }, 650);
            setInterval(function () {
                document.getElementById("welcome-title-desc").classList.remove("fade");
            }, 850);
        };
    </script>
</head>

<body>

    <div class="navbar-container">
        <div class="navbar-title">
            cradle
        </div>
        <ul class="navbar">
            <li class="nav-item">
                <a class="nav-link" href=#>HOME </a> </li>
            <li class="nav-item">
                <a class="nav-link" href=#>PAGE </a> </li>
            <li class="nav-item">
                <a class="nav-link" href="#">ABOUT US</a>
            </li>
        </ul>
    </div>


    <div class="container">

        <div id="welcome-view">
            <div id="welcome-background" class="fade"></div>
            <div class="welcome-container">
                <div class="welcome-hero-container">
                    <div id="welcome-hero" class="fade">
                        <div class="welcome-title">
                            <h1>Cradle.</h1>
                        </div>

                        <div id="welcome-title-desc" class="fade horizontal-translate">
                            This is our placeholder msg.
                        </div>

                        <button class="welcome-title-btn" type="button">Sign in</button>
                        <button class="welcome-title-btn" type="button">Register</button>

                        <i class="welcome-arrow-d"></i>
                    </div>
                </div>

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

                <div class="welcome-footer">
                    cradle
                    <br />
                    <span class="welcome-copyright">&#9400; 2019 Copyright</span>
                </div>
            </div>
        </div>
    </div>
</body>

</html>