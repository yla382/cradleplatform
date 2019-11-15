
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.mercury.TeamMercuryCradlePlatform.model.Referral" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mercury.TeamMercuryCradlePlatform.model.Reading" %>
<%@ page import="com.mercury.TeamMercuryCradlePlatform.model.Patient" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ReferralInfo</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css" />
    <link rel="stylesheet" type="text/css" href="/css/dashboard.css" />
    <link rel='stylesheet' href="/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>

<%
    Referral referral = (Referral)request.getAttribute("referral");
    Reading reading = (Reading)request.getAttribute("reading");
    Patient patient = (Patient)request.getAttribute("patient");
%>

<body>
<%@ include file="../navbar/navbar.jspf" %>
<div class="container w-100 mt-4" >

    <h2>Patient ID</h2>
    <p><%=patient.getPatientId()%></p>

    <h2>Reading ID</h2>
    <p><%=reading.getReadingId()%></p>

    <h2>Personal Information</h2>
    <div class="container">
        <div class="row">
            <div class="col-sm">
                <p> <%= "Referral ID: " + referral.getReferralId()%></p>
                <p> <%= "Name: " + referral.getFirstName() + " " + referral.getLastName()%></p>
                <p> <%= "Age: " + referral.getAgeYears()%></p>
                <p> <%= "Sex: " + referral.getSex()%></p>
            </div>
        </div>
    </div>
    <h2>Referred Health Centre</h2>
    <div class="container">
        <div class="row">
            <div class="col-sm">
                <p> <%= "Date: " + referral.getDateTimeSent()%></p>
                <p> <%= "VHT Name: " + referral.getVhtName()%></p>
                <p> <%= "Referred Health Centre: " + referral.getReferredHealthCentre()%></p>
            </div>
        </div>
    </div>

    <h2>Address Information</h2>
    <div class="container">
        <div class="row">
            <div class="col-sm">
                <p> <%= "Zone Number: " + referral.getZoneNumber()%></p>
                <p> <%= "Block Number: " + referral.getBlockNumber()%></p>
                <p> <%= "Tank Number: " + referral.getTankNumber()%></p>
                <p> <%= "Village Number: " + referral.getVillageNumber()%></p>
                <p> <%= "Household Number: " + referral.getHouseholdNumber()%></p>
            </div>
        </div>
    </div>
    <h2>Blood Pressure and Heart Rate</h2>
    <div class="container">
        <div class="row">
            <div class="col-sm">
                <p> <%= "BP: " + referral.getBpSystolic() + "/" + referral.getBpDiastolic()%></p>
                <p> <%= "HR: " + referral.getHeartRateBPM() %></p>
            </div>
        </div>
    </div>

    <h2>Reason of Referral</h2>
    <p><%=referral.getReasonOfReferral()%></p>
    <h2>Action Already Taken</h2>
    <p> <%=referral.getActionAlreadyTaken()%></p>
    <h2>Other Messages</h2>
    <p> <%=referral.getOtherInformationMessage()%></p>

</div>
</body>
</html>
