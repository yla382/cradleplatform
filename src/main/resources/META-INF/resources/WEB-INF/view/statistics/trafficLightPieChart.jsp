<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.mercury.TeamMercuryCradlePlatform.model.Reading" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Comparator" %>
<%@ page import="com.mercury.TeamMercuryCradlePlatform.model.ReadingAnalysis" %>


<!DOCTYPE html>
<html lang="en">



<%
    List<Integer> data = (List<Integer>) request.getAttribute("data");
%>

<head>
    <meta charset="utf-8">
    <title>Patient Statistics</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>


<body>

<%@ include file="../navbar.jspf" %>

<div class="container">
    <canvas id="myChart"></canvas>
</div>

</body>

<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>


<script>

    new Chart(document.getElementById("myChart"),
        {
            "type":"doughnut",
            "data":
                {
                    "labels":["Red","Yellow", "Green"],
                    "datasets":[{
                        "label":"Status lights",
                        "data":
                        [
                            "<c:out value='<%=data.get(0)%>'/>",
                            "<c:out value='<%=data.get(1)%>'/>",
                            "<c:out value='<%=data.get(2)%>'/>"
                        ],
                        "backgroundColor":
                            [
                                "rgb(255, 99, 132)",
                                "rgb(255, 255, 0)",
                                "rgb(124, 252, 0)"
                        ]}]
                }}
    );


</script>


</html>
