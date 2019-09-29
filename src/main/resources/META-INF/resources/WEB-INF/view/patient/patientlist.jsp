<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.mercury.TeamMercuryCradlePlatform.Model.Patient" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Patients</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    </head>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <%
        List<Patient> patientList = (List<Patient>)request.getAttribute("patientList");
    %>

    <body>
    <%@ include file="../navbar.jspf" %>

    </body>


    <main role="main" class="container">
        <div>
            <br>
            <h1>List of Patients</h1>
            <p><a href="${pageContext.request.contextPath}/patient/addPatient"><button>Create a new Patient</button></a></p>
            <table id="patients" class="table table-striped">
                <thead>
                    <tr>
                        <th scope="col">Patient ID</th>
                        <th scope="col">First Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Country</th>
                        <th scope="col">Location</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="<%=patientList%>" var = "patient">
                    <tr>
                        <th>${patient.patientId}</th>
                        <th>${patient.firstName}</th>
                        <th>${patient.lastName}</th>
                        <th>${patient.country}</th>
                        <th>${patient.location}</th>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </main>

</html>