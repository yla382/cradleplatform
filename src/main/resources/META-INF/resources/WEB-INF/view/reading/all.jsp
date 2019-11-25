<%@ page import="java.util.List" %>
<%@ page import="com.mercury.TeamMercuryCradlePlatform.model.Reading" %>
<%@ page import="com.mercury.TeamMercuryCradlePlatform.model.ReadingAnalysis" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Patients</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css" />
    <link rel="stylesheet" type="text/css" href="/css/patient.css" />
    <link rel="stylesheet" type="text/css" href="/css/dashboard.css" />
    <link rel='stylesheet' href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<script>
    function deleteRow(patientId) {
        var isConfirmed = confirm("Are you sure you want to delete " + patientId + "?");
        return isConfirmed;
    }
</script>
<%
    List<Reading> readingList = (List<Reading>) request.getAttribute("readingList");
    int i = 0;
%>
<body>

<div class="main-container">
    <%@ include file="../navbar/navbar.jspf" %>

    <div class="content-container">
        <div class="content-header">
            Readings
        </div>
        <div class="content-body">
            <div class="table-container">
                <table id="readingsTable" class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">Age</th>
                        <th scope="col">Status</th>
                        <th scope="col">Time Taken</th>
                        <th scope="col"></th>
                        <th scope="col"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="<%=readingList%>" var = "reading">
                        <tr data-toggle="collapse" data-target=".<%=i%>" onclick="changeIcon(<%=i%>)">
                            <td>${reading.firstName} ${reading.lastName}</td>
                            <td>${reading.ageYears}</td>
                            <td>
                                <img src="/images/${ReadingAnalysis.analyze(reading).trafficLightImg}.png" alt="Traffic Light">
                                <c:if test="${not empty ReadingAnalysis.analyze(reading).arrowDirection}">
                                    <img src="/images/${ReadingAnalysis.analyze(reading).arrowDirection}.png" alt="Arrow Direction">
                                </c:if>
                            </td>
                            <td>${reading.timeYYYYMMDD}</td>
                            <td></td>
                            <td>
                                    <span id ="glyphicon-<%=i%>" class="glyphicon glyphicon-plus"></span>
                            </td>

                        </tr>
                        <tr>
                            <td colspan="6" class="hiddenRow" style="width: 100%">
                                <div class="collapse <%=i++%>">
                                    <div class="content-body" style="padding: 0;">
                                        <div class="edit-patient-container" style="width: auto; margin: auto" >
                                            <h2> ${reading.firstName} ${reading.lastName}, ${reading.ageYears}y @${reading.gestationWeekDaysString}</h2>
                                            <p> ${reading.symptomsString}</p>
                                            <h2> ${reading.timeTakenAmPm}: ${ReadingAnalysis.analyze(reading).analysisText}</h2>
                                            <div class="container">
                                                <div class="row">
                                                    <div class="col">
                                                        <p> ${reading.bpSystolic}/${reading.bpDiastolic}</p>
                                                        <p> HR: ${reading.heartRateBPM}</p>
                                                    </div>
                                                    <div class="col">
                                                        <div class="row">
                                                            <div class="col-sm">
                                                                <img src="/images/${ReadingAnalysis.analyze(reading).trafficLightImg}.png" alt="${ReadingAnalysis.analyze(reading).trafficLightImg}">
                                                                <c:if test="${not empty ReadingAnalysis.analyze(reading).arrowDirection}">
                                                                    <img src="/images/${ReadingAnalysis.analyze(reading).arrowDirection}.png" alt="Arrow Direction">
                                                                </c:if>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <h2> Advice</h2>
                                            <p> ${ReadingAnalysis.analyze(reading).briefText}</p>
                                            <div class="container mt-4">
                                                <div class="row">
                                                    <div class="col">
                                                        <form action="${pageContext.request.contextPath}/reading/edit/${reading.readingId}" method="get">
                                                            <button type="submit" class="btn-generic">Edit</button>
                                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                                        </form>
                                                    </div>
                                                    <div class="col">
                                                        <form action="${pageContext.request.contextPath}/statistics/blood-pressure-graph/${reading.patientId}" method="get">
                                                            <button type="submit" class="btn-generic">Statistics</button>
                                                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

</body>
<script>


    $('.collapse').each(function(){
        if ($(this).hasClass('in')) {
            $(this).collapse('toggle');
        }
    });

    function changeIcon(i) {

        const spans = document.getElementById('glyphicon-' + i);

        if(spans.classList.contains("glyphicon-plus")){
            spans.className = "glyphicon glyphicon-minus";
        }
        else{
            spans.className = "glyphicon glyphicon-plus";
        }

    }


</script>

</html>
