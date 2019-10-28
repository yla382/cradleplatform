<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.mercury.TeamMercuryCradlePlatform.model.Reading" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.stream.Collectors" %>
<%@ page import="java.util.Collections" %>
<%@ page import="java.util.Comparator" %>


<!DOCTYPE html>
<html lang="en">



<%
    List<Reading> readingList = (List<Reading>) request.getAttribute("readingList");
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


    function getData(type) {

        var data = [];

        <% for (int i=0; i<readingList.size(); i++) { %>

        if(type === 0 ){
            data[<%= i %>] = "<%= readingList.get(i).getTimeYYYYMMDD()%>";
        }
        else if(type === 1){
            data[<%= i %>] = "<%= readingList.get(i).getBpSystolic()%>";
        }
        else if(type === 2){
            data[<%= i %>] = "<%= readingList.get(i).getBpDiastolic()%>";
        }
        else {
            data[<%= i %>] = "<%= readingList.get(i).getHeartRateBPM()%>";
        }

        <% } %>

        return data;
    }

    var canvas = document.getElementById('myChart');
    var chart = new Chart(canvas,
        {
            "type":"line",
            "data":
                {
                    "labels": getData(0),
                    "datasets": [
                        {
                            "label":"Systolic",
                            "data": getData(1),
                            "fill":false,
                            "backgroundColor": "rgb(0, 0, 255)",
                            "borderColor" : "rgb(0, 0, 255)"
                        },
                        {
                            "label":"Diastolic",
                            "data": getData(2),
                            "fill":false,
                            "backgroundColor": "rgb(255, 129, 0)",
                            "borderColor" : "rgb(255, 129, 0)"
                        },
                        {
                            "label":"Heart Rate",
                            "data": getData(3),
                            "fill":false,
                            "backgroundColor": "rgb(142, 56, 140)",
                            "borderColor" : "rgb(142, 56, 140)"
                        }
                    ]},
            "options":
                {
                    "scales":
                        {
                            "xAxes": [{
                                scaleLabel: {
                                    display: true,
                                    labelString: 'Time Reading Taken'
                                },
                            }],

                            "yAxes": [{
                                "ticks":{
                                    "beginAtZero":true
                                }
                            }]
                        }
                }
        });



</script>


</html>
