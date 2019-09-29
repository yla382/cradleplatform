<%@ page import="com.mercury.TeamMercuryCradlePlatform.Model.Patient" %>
<!DOCTYPE html>
<html>
    <%
        Patient patient = (Patient)request.getAttribute("patient");
    %>

<head>
    <meta charset="utf-8">
    <title>AddPatient</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script>
        function createPatient() {
            document.getElementById("status").innerHTML = "Patient Created";
            document.getElementById("patientInfo").innerHTML = document.getElementById("firstName").value + "<br>" +
                                                               document.getElementById("lastName").value;
        }
    </script>
</head>

<body>
    <%@ include file="../navbar.jspf" %>
</body>

<body>

    <form action="${pageContext.request.contextPath}/patient/confirmPatient" method="post">
        <div class="container w-100" style="padding: 10px">
            <div class="form-group">
                <label for="firstName">First name: </label>
                <input type="text" class="form-control" id="firstName" name="firstName"><br>
            </div>
            <div class="form-group">
                <label for="lastName">Last name: </label>
                <input type="text" class="form-control" id="lastName" name="lastName"><br>
            </div>
            <div class="form-group">
                <label for="country">Country: </label>
                <input type="text" class="form-control" id="country" name="country"><br>
            </div>
            <div class="form-group">
                <label for="location">Location: </label>
                <input type="text" class="form-control" id="location" name="location"><br>
            </div>
            <button type="submit" value="Submit"> Create </button>
            <p id="status"></p>
            <p id="patientInfo"></p>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</body>


</html>