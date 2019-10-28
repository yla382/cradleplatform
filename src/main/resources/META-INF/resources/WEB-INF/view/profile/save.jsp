<%@ page import="com.mercury.TeamMercuryCradlePlatform.model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">

<%
    User postUser = (User)request.getAttribute("postUser");
%>

<head>
    <meta charset="utf-8">
    <title>Users</title>

    <link rel="stylesheet" type="text/css" href="/css/main.css" />
    <link rel='stylesheet' href="/css/bootstrap.min.css"/>
    <link rel='stylesheet' href="/css/edit-users.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>

<div class="main-container">
    <!--NAVBAR-->
    <div class="navbar-container">
        <div class="navbar-title">
            Cradle.
        </div>

        <ul>
            <li class="navbar-list"><a class="nav-link" href="/admin/index"><span class="glyphicon glyphicon-signal nav-link-icon"></span>Dashboard</a></li>
            <li class="navbar-list"><a class="nav-link" href="/admin/users"><span class="glyphicon glyphicon-search nav-link-icon"></span>View Users</a></li>
            <li class="navbar-list">
                <a class="nav-link" href="/admin/registration"><span class="glyphicon glyphicon-user nav-link-icon"></span>Register Users</a>
            </li>
        </ul>

        <ul>
            <li class="navbar-list"><a class="nav-link" href="/patient/patientlist"><span class="glyphicon glyphicon-user nav-link-icon"></span>Patients</a></li>
            <li class="navbar-list"><a class="nav-link" href="/reading/create"><span class="glyphicon glyphicon-file nav-link-icon"></span>Readings</a></li>
            <li class="navbar-list"><a class="nav-link" href="/admin/education"><span class="glyphicon glyphicon-folder-open nav-link-icon"></span>Education</a></li>
            <%if (request.getRemoteUser()!= null) {%>
            <li class="navbar-list">
                <a
                        class="nav-link"
                        href="/profile/${pageContext.request.userPrincipal.name}"
                ><span class="glyphicon glyphicon-cog nav-link-icon"></span>Profile</a
                >
            </li>
            <%} %>
            <li class="navbar-list"><a class="nav-link" href="/logout">< Sign Out ></a></li>
        </ul>
    </div> <!--END of NAVBAR-->

    <div class="content-container">
        <div class="content-header">
            User Information Edit Saved
        </div>

        <div class="save-users-container">
            <div class="form-group row">
                <div class="col-md-6">
                    Saved
                </div>
            </div>

        </div>

    </div>
</div>



<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


</body>
</html>