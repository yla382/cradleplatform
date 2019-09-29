<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Patient Migration</title>
    <!-- Native scripts -->
    <link rel="stylesheet" type="text/css" href="/css/vht.css">
    <link rel="stylesheet" type="text/css" href="/css/navfunc.css">
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link rel="stylesheet" type="text/css" href="/css/welcome.css">


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


<form>
  <div class="head-style">
    <h1 > Allocate patients from</h1>
  </div>

  <br>
  <div style="text-align:center;">
    <div class="btn-group">
      <button id="firstAVHT" class="btn btn-primary dropdown-toggle btn-select" data-toggle="dropdown" href="#">Select the First VHT <span class="caret"></span></button>
      <ul class="dropdown-menu">
        <li><a class="dropdown-item" href="#">I</a></li>
        <li><a class="dropdown-item" href="#"> II</a></li>
        <li><a class="dropdown-item" href="#"> III</a></li>
      </ul>
    </div>

    <div class="divider"> &nbsp; &nbsp; TO </div>

    <div class="btn-group">
      <button id="secondAVHT" class="btn btn-primary dropdown-toggle btn-select2" data-toggle="dropdown" href="#">Select the Second VHT <span class="caret"></span></button>
      <ul class="dropdown-menu">
        <li><a class="dropdown-item" href="#"> IV</a></li>
      </ul>
    </div>


  <br>
  <br>
  <br>
 <div style="text-align:center;">

           <button id="mig_confirm" type="button" class="btn btn-success btn-lg" onclick="confirmAllocation()">
                  CONFIRM
           </button>

</div>
  </div>
</form>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>

<script src="/js/allocation.js"></script>

</html>