<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.mercury.TeamMercuryCradlePlatform.model.Referral" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Referrals</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<%
    List<Referral> referralList = (List<Referral>)request.getAttribute("referralList");
%>
<body>
<%@ include file="../navbar.jspf" %>

<div>
    <h1>List of Referrals</h1>
    <table id="referral" class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Referral ID</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Age</th>
            <th scope="col">Zone Number</th>
            <th scope="col">Block Number</th>
            <th scope="col">Tank Number</th>
            <th scope="col">Village Number</th>
            <th scope="col">Household Number</th>
            <th scope="col">Referred Health Centre</th>
            <th scope="col">VHT Name</th>
            <th scope="col">Reading ID</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="<%=referralList%>" var = "referral">
            <tr>
                <th>${referral.referralId}</th>
                <th>${referral.firstName}</th>
                <th>${referral.lastName}</th>
                <th>${referral.ageYears}</th>
                <th>${referral.zoneNumber}</th>
                <th>${referral.blockNumber}</th>
                <th>${referral.tankNumber}</th>
                <th>${referral.villageNumber}</th>
                <th>${referral.householdNumber}</th>
                <th>${referral.referredHealthCentre}</th>
                <th>${referral.vhtName}</th>
                <th>${referral.readingId}</th>
                <th>
                    <form action="${pageContext.request.contextPath}/referral/close/${referral.referralId}" method="post">
                        <button type="submit" class="btn btn-secondary" name="delete" onclick="return confirm('Do you want to close this referral?');">Close</button>
                    </form>
                </th>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>

</html>