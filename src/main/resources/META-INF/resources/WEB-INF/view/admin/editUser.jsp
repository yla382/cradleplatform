<%@ page import="com.example.TeamMercuryCradlePlatform.Model.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">

<%
    User user = (User)request.getAttribute("user");
%>

<head>
    <meta charset="utf-8">
    <title>Users</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>

<%@ include file="../navbar.jspf" %>

<div class="container">
    <br>
    <div class="row justify-content-center">
        <div class="col-md-8">
            <div class="card">
                <div class="card-header">Edit User</div>
                <div class="card-body">
                    <form action="${pageContext.request.contextPath}/admin/users/" method = "post">
                        <div class="form-group row">
                            <label for="firstName" class="col-md-4 col-form-label text-md-right">First Name</label>
                            <div class="col-md-6">
                                <input required type="text" id="firstName" class="form-control" name="firstName" value="<%=user.getFirstName()%>">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="lastName" class="col-md-4 col-form-label text-md-right">Last Name</label>
                            <div class="col-md-6">
                                <input required type="text" id="lastName" class="form-control" name="lastName" value="<%=user.getLastName()%>">
                            </div>
                        </div>

                        <div hidden class="form-group row">
                            <label for="password" class="col-md-4 col-form-label text-md-right">Password</label>
                            <div class="col-md-6">
                                <input required type="password" id="password" class="form-control" name="password" value="<%=user.getPassword()%>">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label for="email" class="col-md-4 col-form-label text-md-right">email</label>
                            <div class="col-md-6">
                                <input required type="email" id="email" class="form-control" name="email" value="<%=user.getEmail()%>">
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-md-4 col-form-label text-md-right">User Roles</label>
                            <div class="col-md-6 col-form-label">
                                <div class="form-check form-check-inline">
                                    <c:if test="<%= user.isVHT() %>">
                                        <input checked class="form-check-input" type="checkbox" name="roles" id="inlineCheck1" value="VTH">
                                    </c:if>
                                    <c:if test="<%= !user.isVHT() %>">
                                        <input class="form-check-input" type="checkbox" name="roles" id="inlineCheck1" value="VTH">
                                    </c:if>
                                    <label class="form-check-label" for="inlineCheck1">VHT</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <c:if test="<%= user.isHealthWorker() %>">
                                        <input checked class="form-check-input" type="checkbox" name="roles" id="inlineCheck2" value="HEALTHWORKER">
                                    </c:if>
                                    <c:if test="<%= !user.isHealthWorker() %>">
                                        <input class="form-check-input" type="checkbox" name="roles" id="inlineCheck2" value="HEALTHWORKER">
                                    </c:if>
                                    <label class="form-check-label" for="inlineCheck2">Health Worker</label>
                                </div>
                                <div class="form-check form-check-inline">
                                    <c:if test="<%= user.isAdmin() %>">
                                        <input checked class="form-check-input" type="checkbox" name="roles" id="inlineCheck3" value="ADMIN">
                                    </c:if>
                                    <c:if test="<%= !user.isAdmin() %>">
                                        <input class="form-check-input" type="checkbox" name="roles" id="inlineCheck3" value="ADMIN">
                                    </c:if>
                                    <label class="form-check-label" for="inlineCheck3">Admin</label>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 offset-md-4">
                            <button type="submit" class="btn btn-primary">
                                Save
                            </button>
                        </div>
                        <input type = "hidden" name = "${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </div>
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