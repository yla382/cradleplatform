<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Cradle Admin</title>
    <!-- Native scripts -->
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/welcome.css">
    <link rel="stylesheet" type="text/css" href="/css/navfunc.css">

    <!-- Imported scripts -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>

<body>

<%@ include file="../navbar_admin.jspf" %>

<br>
<br>
<br>
<br>
<br>

<div class="container">
    <div class="card-deck">

    <a href="${pageContext.request.contextPath}/patients/index" class="custom-card">
      <div class="card bg-light">
      <img class="card-img-top" src="../images/patient.jpg" width="196" height="131" alt="Card patient">
        <div class="card-body text-center">
          <p class="card-text">PATIENTS</p>
          <a href="${pageContext.request.contextPath}/patients/index" class="stretched-link"></a>
        </div>
      </div>

      <a href="${pageContext.request.contextPath}/vht/report" class="custom-card">
      <div class="card bg-warning text-white">
      <img class="card-img-top" src="../images/report.jpg" width="196" height="131" alt="Card report">
        <div class="card-body text-center">
          <p class="card-text">MONTHLY REPORTS</p>
          <a href="${pageContext.request.contextPath}/vht/report" class="stretched-link"></a>
        </div>
      </div>

      <a href="${pageContext.request.contextPath}/vht/allocation" class="custom-card">
      <div class="card bg-warning text-white">
      <img class="card-img-top" src="../images/migration.jpg" width="196" height="131" alt="Card migration">
        <div class="card-body text-center">
          <p class="card-text">ALLOCATE PATIENTS</p>
          <a href="${pageContext.request.contextPath}/vht/allocation" class="stretched-link"></a>
        </div>
      </div>

      <a href="${pageContext.request.contextPath}/admin/registration" class="custom-card">
      <div class="card bg-info text-white">
      <img class="card-img-top" src="../images/add_user.png" width="196" height="131" alt="Card user">
        <div class="card-body text-center">
          <p class="card-text">ADD USER</p>
          <a href="${pageContext.request.contextPath}/admin/registration" class="stretched-link"></a>
        </div>
      </div>

      <a href="${pageContext.request.contextPath}/" class="custom-card">
      <div class="card bg-info text-white">
      <img class="card-img-top" src="../images/roles.png" width="196" height="131" alt="Card role" >
       <div class="card-body text-center">
         <p class="card-text">ASSIGN ROLES</p>
         <a href="${pageContext.request.contextPath}/" class="stretched-link"></a>
        </div>
      </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>