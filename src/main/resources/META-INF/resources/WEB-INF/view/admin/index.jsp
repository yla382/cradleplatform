<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.mercury.TeamMercuryCradlePlatform.model.Reading" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mercury.TeamMercuryCradlePlatform.model.Patient" %>
<%@ page import="java.lang.reflect.Array" %>
<%@ page import="com.mercury.TeamMercuryCradlePlatform.model.ReadingAnalysis" %>
<!DOCTYPE html>
<html>

<%
  List<Reading> readingList = (List<Reading>) request.getAttribute("readingList");
  List<Patient> patientList = (List<Patient>) request.getAttribute("patientList");
%>

  <head>
    <meta charset="ISO-8859-1" />
    <title>Cradle</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css" />
    <link rel="stylesheet" type="text/css" href="/css/dashboard.css" />
    <link rel='stylesheet' href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
    <script
      src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
      integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
      integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
      integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
      crossorigin="anonymous"
    ></script>
  </head>

  <body onload="populatePatientList()">
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
        <label for="selectNumber"> Select Patient</label>
        <select id="selectNumber" onchange="createGraphs()">
        </select>
        <div class="content-header">
          Dashboard
        </div>
        <div class="content-body">
          <div class="summary-container">
            <canvas id="bloodPressureChart"></canvas>
          </div>
          <div class="summary-container">
            <canvas id="statusChart"></canvas>
          </div>
        </div>
      </div>
    </div>
  </body>
</html>


<script>

  class Data {
    constructor(pId, pList, dates, systolic, diastolic, heartRate, numbGreen, numbYellow, numbRed) {
      this._pId = pId;
      this._pList = pList;
      this._dates = dates;
      this._systolic = systolic;
      this._diastolic = diastolic;
      this._heartRate = heartRate;
      this._numbGreen = numbGreen;
      this._numbYellow = numbYellow;
      this._numbRed = numbRed;
    }

    get pId() {
      return this._pId;
    }

    set pId(value) {
      this._pId = value;
    }

    get pList() {
      return this._pList;
    }

    set pList(value) {
      this._pList = value;
    }

    get dates() {
      return this._dates;
    }

    set dates(value) {
      this._dates = value;
    }

    get systolic() {
      return this._systolic;
    }

    set systolic(value) {
      this._systolic = value;
    }

    get diastolic() {
      return this._diastolic;
    }

    set diastolic(value) {
      this._diastolic = value;
    }

    get heartRate() {
      return this._heartRate;
    }

    set heartRate(value) {
      this._heartRate = value;
    }

    get numbGreen() {
      return this._numbGreen;
    }

    set numbGreen(value) {
      this._numbGreen = value;
    }

    get numbYellow() {
      return this._numbYellow;
    }

    set numbYellow(value) {
      this._numbYellow = value;
    }

    get numbRed() {
      return this._numbRed;
    }

    set numbRed(value) {
      this._numbRed = value;
    }
  }

  function generatePatientData() {

    var pId = [];
    var pList = [];
    var dates = [];
    var systolic = [];
    var diastolic = [];
    var heartRate = [];
    var numbGreen = 0;
    var numbYellow = 0;
    var numbRed = 0;

    <% for (Patient p : patientList) { %>

      pId.push("<%= p.getPatientId()%>");
      pList.push("<%= p.getFirstName() + " " + p.getLastName() + ", " + p.getAgeYears()%>");

    <% } %>

    var e = document.getElementById("selectNumber");
    <% for (Reading r : readingList) { %>

      if(pId[e.selectedIndex] === "<c:out value='<%=r.getPatient().getPatientId()%>'/>") {
        dates.push("<%= r.getTimeYYYYMMDD()%>");
        systolic.push("<%= r.getBpSystolic()%>");
        diastolic.push("<%= r.getBpDiastolic()%>");
        heartRate.push("<%= r.getHeartRateBPM()%>");

        <% ReadingAnalysis analysis = ReadingAnalysis.analyze(r);%>

        if("<c:out value='<%=analysis.isGreen()%>'/>"){
          numbGreen++;
        }
        else if("<c:out value='<%=analysis.isYellow()%>'/>"){
          numbYellow++;
        }
        else{
          numbRed++;
        }
      }
    <% } %>

    return new Data(pId, pList, dates, systolic, diastolic, heartRate, numbGreen, numbYellow, numbRed);

  }

  function populatePatientList() {

    generatePatientData();

    var select = document.getElementById("selectNumber");
    var options = listString;
    for(var i = 0; i < options.length; i++) {
      var opt = options[i];
      var el = document.createElement("option");
      el.textContent = opt;
      el.value = opt;
      select.appendChild(el);
    }

    Data d = new

    createGraphs();

  }

  function getBloodPressureData(type) {

    var data = [];
    var e = document.getElementById("selectNumber");


    <% for (int i=0; i<readingList.size(); i++) { %>

      if(patientId[e.selectedIndex] === "<c:out value='<%=readingList.get(i).getPatient().getPatientId()%>'/>") {

        // Get date
        if (type === 0) {
            data[<%= i %>] = "<%= readingList.get(i).getTimeYYYYMMDD()%>";
        }
        // Get systolic
        else if (type === 1) {
          data[<%= i %>] = "<%= readingList.get(i).getBpSystolic()%>";
        }

        // Get diastolic
        else if (type === 2) {
          data[<%= i %>] = "<%= readingList.get(i).getBpDiastolic()%>";
        }
        // Get heartRate
        else {
          data[<%= i %>] = "<%= readingList.get(i).getHeartRateBPM()%>";
        }
        }

    <% } %>

    return data;
  }

  function createGraphs() {
    createBloodPressureChart();
    createStatusChart();
  }


  function createBloodPressureChart() {
    new Chart(document.getElementById("bloodPressureChart"),
            {
              "type":"line",
              "data":
                      {
                        "labels": getBloodPressureData(0),
                        "datasets": [
                          {
                            "label":"Systolic",
                            "data": getBloodPressureData(1),
                            "fill":false,
                            "backgroundColor": "rgb(0, 0, 255)",
                            "borderColor" : "rgb(0, 0, 255)"
                          },
                          {
                            "label":"Diastolic",
                            "data": getBloodPressureData(2),
                            "fill":false,
                            "backgroundColor": "rgb(255, 129, 0)",
                            "borderColor" : "rgb(255, 129, 0)"
                          },
                          {
                            "label":"Heart Rate",
                            "data": getBloodPressureData(3),
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

  }

  var numbGreen, numbYellow, numbRed;
  function getBarChartData() {

    numbGreen = 0;
    numbYellow = 0;
    numbRed = 0;

    var e = document.getElementById("selectNumber");

    <% for (int i=0; i<readingList.size(); i++) { %>

    if(patientId[e.selectedIndex] === "<c:out value='<%=readingList.get(i).getPatient().getPatientId()%>'/>") {

      <% ReadingAnalysis analysis = ReadingAnalysis.analyze(readingList.get(i));%>

      if("<c:out value='<%=analysis.isGreen()%>'/>"){
        numbGreen++;
      }
      else if("<c:out value='<%=analysis.isYellow()%>'/>"){
        numbYellow++;
      }
      else{
        numbRed++;
      }
    }

    <% } %>

  }

  function createStatusChart() {

    new Chart(document.getElementById("statusChart"),
            {
              "type":"doughnut",
              "data":
                      {
                        "labels":["Red","Yellow", "Green"],
                        "datasets":[{
                          "label":"Status lights",
                          "data":
                                  [
                                    numbGreen,
                                    numbYellow,
                                    numbRed
                                  ],
                          "backgroundColor":
                                  [
                                    "rgb(255, 99, 132)",
                                    "rgb(255, 255, 0)",
                                    "rgb(124, 252, 0)"
                                  ]}]
                      }}
    );

  }


</script>


