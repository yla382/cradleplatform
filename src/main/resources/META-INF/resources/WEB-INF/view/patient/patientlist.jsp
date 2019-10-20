<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.mercury.TeamMercuryCradlePlatform.model.Patient" %>
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

    <script>
        function deleteRow(patientId) {
            var isConfirmed = confirm("Are you sure you want to delete " + patientId + "?");
            if (isConfirmed) {
                return true;
            } else {
                return false;
            }
        }
    </script>

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
                        <th></th>
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
                        <th>
                            <div class="btn-group" role="group" aria-label="Button group">
<%--                                <button type="button" class="btn btn-secondary" href="${pageContext.request.contextPath}/patient/addPatient">Edit</button>--%>
<%--                                <button type="button" class="btn btn-secondary" onclick="deleteRow(${patient.patientId})">Delete</button>--%>
<%--                                <a href="${pageContext.request.contextPath}/patient/addPatient"--%>
<%--                                   onclick="return confirm('Are you sure you want to edit ' + ${patient.patientId}--%>
<%--                                           + '?')"--%>
<%--                                   class="button">--%>
<%--                                    <button>--%>
<%--                                        Edit--%>
<%--                                    </button>--%>
<%--                                </a>--%>
                                <form action="${pageContext.request.contextPath}/patient/editPatient" method="post">
                                    <input type="hidden" id="firstName" name="firstName" value=${patient.getFirstName()}>
                                    <input type="hidden" id="lastName" name="lastName" value=${patient.getLastName()}>
                                    <input type="hidden" id="country" name="country" value=${patient.getCountry()}>
                                    <input type="hidden" id="location" name="location" value=${patient.getLocation()}>
                                    <button type="submit" onclick="return true" class="btn btn-primary">
                                        Edit
                                    </button>

                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                </form>
                                <a href="${pageContext.request.contextPath}/patient/addPatient"
                                   onclick="return confirm('Are you sure you want to delete ' + ${patient.patientId}
                                           + '?') "
                                   class="button">
                                    <button>
                                        Delete
                                    </button>
                                </a>

                            </div>
                        </th>
<%--                        <th><input type='button' class="EditRow" value="Edit"></th>--%>
<%--                        <th><input type='button' class="RemoveRow" value="Delete"></th>--%>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </main>


</html>