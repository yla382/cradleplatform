<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<%
String email = (String)request.getAttribute("email");
String phoneNumber = (String)request.getAttribute("phoneNumber");
%>

<head>
    <meta charset="utf-8">
    <title>
        contact
    </title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <form action="${pageContext.request.contextPath}/admin/submitMessage" method = "POST">
            <input id="email" name="email" type="hidden" value="<%=email%>">
            <input id="phoneNumber" name="phoneNumber" type="hidden" value="<%=phoneNumber%>">
            <label for="contactMethod">Contact Method</label>
            <select class="form-control" id="contactMethod" name="contactMethod">
                <option value="email">Email</option>
                <option value="phone_number">Phone Number</option>
            </select>
            <label for="subject">Subject</label>
            <input type="text" name="subject" id="subject">
            <br>
            <label for="message">Message</label>
            <input type="text" name="message" id="message">
            <br>
            <button type="submit" value="Submit" class="btn btn-secondary">Send</button>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>