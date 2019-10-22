<%@ page import="com.mercury.TeamMercuryCradlePlatform.model.Reading" %>
<%@ page import="java.util.List" %>


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


    function setUpData() {
        var labels = [];
        <% for (int i=0; i<readingList.size(); i++) { %>
        labels[<%= i+1 %>] = "<%= readingList.get(i).getTimeYYYYMMDD()%>";
        <% } %>
        return labels;
    }

    var ctx = document.getElementById('myChart').getContext('2d');
    var chart = new Chart(ctx, {
        // The type of chart we want to create
        type: 'line',


        // The data for our dataset
        data: {
            // times
            labels: setUpData(),

            //
            datasets: [{
                label: 'Blood pressure chart',
                backgroundColor: 'rgb(255, 99, 132)',
                borderColor: 'rgb(255, 99, 132)',
                data: [0, 10, 5, 2, 20, 30, 45]
            }]


        },

        // Configuration options go here
        options: {
            scales: {
                xAxes: [{
                    scaleLabel: {
                        display: true,
                        labelString: 'date reading taken'
                    }
                }],
                yAxes: [{
                    scaleLabel: {
                        display: true,
                        labelString: 'blood pressure'
                    }
                }]
            }
        }

    });

</script>


</html>
