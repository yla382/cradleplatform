<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>VHT Report</title>
    <!-- Native scripts -->
    <link rel="stylesheet" type="text/css" href="/css/navfunc.css">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/welcome.css">

    <style>
        .title-style{
                font-family: "Montserrat", "Helvetica", "Arial", sans-serif;
                text-align: center;
                color: white;
              }
    </style>


    <!-- Imported scripts -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>

<body>

<%@ include file="../navbar_admin.jspf" %>

<br>
<br>
<br>


<h2 class = "title-style">PLEASE CHOOSE WHAT REPORT YOU WOULD LIKE TO SEE:</h2>

<br>

<div class="container">
    <div class="card-deck">

    <a href="${pageContext.request.contextPath}/vht/genreport" class="custom-card">
      <div class="card bg-light">
      <img class="card-img-top" src="../images/month.jpg" width="530" height="350" alt="Card general">
        <div class="card-body text-center">
          <p class="card-text">GENERAL REPORT</p>
          <a href="${pageContext.request.contextPath}/vht/genreport" class="stretched-link"></a>
        </div>
      </div>

      <a href="${pageContext.request.contextPath}/vht/genreport" class="custom-card">
      <div class="card bg-warning text-white">
      <img class="card-img-top" src="../images/personal.jpg" width="530" height="350" alt="Card personal">
        <div class="card-body text-center">
          <p class="card-text">VHT PERSONAL REPORTS</p>
          <a href="${pageContext.request.contextPath}/vht/genreport" class="stretched-link"></a>
        </div>
      </div>


    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>