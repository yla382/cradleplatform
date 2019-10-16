<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Cradle</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script type="text/javascript" src="validator.min.js"></script>
</head>
    <body>

        <%@ include file="../navbar.jspf" %>

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="container w-100" style="padding: 10px">
            <form action="${pageContext.request.contextPath}/reading/analysis" method="post" id="form">
                <div class="form-group">
                    <div class="row">
                        <div class="col">
                            <label for="patientId">ID number</label>
                            <input required type="text" class="form-control" id="patientId" name="patientId">
                        </div>
                        <div class="col">
                            <label for="firstName">First Name</label>
                            <input required type="text" class="form-control" id="firstName" name="firstName">
                        </div>
                        <div class="col">
                            <label for="lastName">Last Name</label>
                            <input required type="text" class="form-control" id="lastName" name="lastName">
                        </div>
                        <div class="col">
                            <label for="ageYears">Age</label>
                            <input required type="number" min="0" class="form-control" id="ageYears" name="ageYears">
                        </div>
                    </div>
                    <div class="row" style="width: 25%">
                        <div class="col">
                            <label for="gestationalAgeValue">Gestational Age</label>
                            <input required type="number" min="0" class="form-control" id="gestationalAgeValue" name="gestationalAgeValue">
                        </div>
                    </div>


                    <div class="form-group" style="width: 25%">
                        <label for="gestationalAgeUnit"></label>
                        <select class="form-control" id="gestationalAgeUnit" name="gestationalAgeUnit" onchange="gestationalAgeUnitChange()">
                            <option value="Weeks">Weeks</option>
                            <option value="Months">Months</option>
                            <option value="Not Pregnant">Not Pregnant</option>
                        </select>
                    </div>
                </div>
                <div class="form-group" style="width: 25%">
                    <label for="health"></label>
                    <select class="form-control" id="health" name="health" onchange="healthChange()">
                        <option value="1">Patient sick</option>
                        <option value="2">Patient healthy</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="symptomsSelector">Symptoms</label>
                    <select multiple class="form-control" id="symptomsSelector" name="symptoms">
                        <option value="Headache">Headache</option>
                        <option value="Blurred vision">Blurred vision</option>
                        <option value="Abdominal pain">Abdominal pain</option>
                        <option value="Bleeding">Bleeding</option>
                        <option value="Feverish">Feverish</option>
                        <option value="Unwell">Unwell</option>
                    </select>
                </div>
                <div class="form-group">
                    <label for="otherSymptoms">Other symptoms</label>
                    <textarea class="form-control" id="otherSymptoms" name="otherSymptoms" rows="2"></textarea>
                </div>
                <div class="form-group">
                    <label for="bpSystolic">Systolic</label>
                    <input required type="number" min="10" max="300" class="form-control" id="bpSystolic" name="bpSystolic" style="width: 25%"/>
                </div>
                <div class="form-group">
                    <label for="bpDiastolic">Diastolic</label>
                    <input required type="number" min="10" max="300" class="form-control" id="bpDiastolic" name="bpDiastolic" style="width: 25%">
                </div>
                <div class="form-group">
                    <label for="heartRateBPM">Heart rate</label>
                    <input required type="number" min="40" max="200" class="form-control" id="heartRateBPM" name="heartRateBPM" style="width: 25%">
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input class="form-group" type="submit" value="Submit" id="submitButton">
            </form>

            <%--Detects when user comes back to this page--%>
            <label for="backButtonState"></label>
            <input id="backButtonState" type="text" value="0" style="display:none;" />

        </div>
    </body>


<script>

        document.addEventListener('DOMContentLoaded', function () {
            var backButton = document.getElementById("backButtonState");
            if (backButton.value === "0") {
                backButton.value = "1";
            } else {
                // Back button pressed
                gestationalAgeUnitChange();
                healthChange();
            }
        }, false);

        function healthChange() {
            const e = document.getElementById("health");
            const strUser = e.options[e.selectedIndex].value;
            document.getElementById("symptomsSelector").disabled = strUser === "2";
            document.getElementById("otherSymptoms").disabled = strUser === "2";
        }

        function gestationalAgeUnitChange() {
            const e = document.getElementById("gestationalAgeUnit");
            const strUser = e.options[e.selectedIndex].value;
            document.getElementById("gestationalAgeValue").disabled = strUser === "Not Pregnant";
        }

        $('#form').validator().on('submit', function (e) {
            alert("stuff");
            if (e.isDefaultPrevented()) {
                // handle the invalid form...
                if($('#bpSystolic').val() <= $('#bpDiastolic').val){
                   alert("Systolic value must be greater than diastolic value");
                }
            } else {
                // everything looks good!
                alert("stuff");
            }
        })

    </script>

</html>