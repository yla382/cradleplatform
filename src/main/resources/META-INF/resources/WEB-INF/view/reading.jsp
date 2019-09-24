<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Cradle</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
    <body>
    <div class="container w-100">

        <form action="${pageContext.request.contextPath}/submitReading" method="post">
            <div class="form-group">
                <label for="patientId">ID number</label>
                <input required type="text" class="form-control" id="patientId" name="patientId">
            </div>
            <div class="form-group">
                <label for="patientName">Initials</label>
                <input required type="text" class="form-control" id="patientName" name="patientName">
            </div>
            <div class="form-group">
                <label for="ageYears">Age</label>
                <input required type="number" min="0" class="form-control" id="ageYears" name="ageYears">
            </div>
            <div class="form-group">
                <label for="gestationalAgeValue">Gestational Age</label>
                <input required type="number" min="0" class="form-control" id="gestationalAgeValue" name="gestationalAgeValue">
            </div>
            <div class="form-group">
                <label for="gestationalAgeUnit"></label>
                <select class="form-control" id="gestationalAgeUnit" name="gestationalAgeUnit" onchange="gestationalAgeUnitChange()">
                    <option value="Weeks">Weeks</option>
                    <option value="Months">Months</option>
                    <option value="Not Pregnant">Not Pregnant</option>
                </select>
            </div>
            <div class="form-group">
                <label for="symptomsSelector">Symptoms</label>
                <select required multiple class="form-control" id="symptomsSelector" name="symptoms" onchange="symptomSelectionChange()">
                    <option value="No Symptoms (patient healthy)">No Symptoms (patient healthy)</option>
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
                <textarea class="form-control" id="otherSymptoms" name="otherSymptoms" rows="1"></textarea>
            </div>
            <div class="form-group">
                <label for="bpSystolic">Systolic</label>
                <input required type="number" min="10" max="300" class="form-control" id="bpSystolic" name="bpSystolic">
            </div>
            <div class="form-group">
                <label for="bpDiastolic">Diastolic</label>
                <input required type="number" min="10" max="300" class="form-control" id="bpDiastolic" name="bpDiastolic">
            </div>
            <div class="form-group">
                <label for="heartRateBPM">Heart rate</label>
                <input required type="number" min="40" max="200" class="form-control" id="heartRateBPM" name="heartRateBPM">
            </div>
            <input type="submit" value="Submit" id="submitButton">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

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
            }
        }, false);

        function gestationalAgeUnitChange() {
            var e = document.getElementById("gestationalAgeUnit");
            var strUser = e.options[e.selectedIndex].value;
            document.getElementById("gestationalAgeValue").disabled = strUser === "Not Pregnant";
        }


        <%--function sendData(){--%>

        <%--    var patientId = $("#patientId").val();--%>
        <%--    var patientName = $("#patientName").val();--%>
        <%--    var ageYears = $("#ageYears").val();--%>
        <%--    var symptoms = $("#symptomsSelector").val() + $("#otherSymptoms").val();--%>
        <%--    var gestationalAgeUnit = $("#gestationalAgeUnit").val();--%>
        <%--    var gestationalAgeValue = $("#gestationalAgeValue").val();--%>
        <%--    var bpSystolic = $("#bpSystolic").val();--%>
        <%--    var bpDiastolic = $("#bpDiastolic").val();--%>
        <%--    var heartRateBPM = $("#heartRateBPM").val();--%>

        <%--    var patientInfo = {--%>
        <%--        patientId : patientId,--%>
        <%--        patientName : patientName,--%>
        <%--        ageYears : ageYears,--%>
        <%--        symptoms : symptoms,--%>
        <%--        gestationalAgeUnit : gestationalAgeUnit,--%>
        <%--        gestationalAgeValue : gestationalAgeValue,--%>
        <%--        bpSystolic : bpSystolic,--%>
        <%--        bpDiastolic : bpDiastolic,--%>
        <%--        heartRateBPM : heartRateBPM--%>
        <%--    };--%>

        <%--    $.ajax({--%>
        <%--        url : '${pageContext.request.contextPath}/ajax/submitReading',--%>
        <%--        type : 'POST',--%>
        <%--        data : JSON.stringify(patientInfo),--%>
        <%--        dataType : 'json',--%>
        <%--        success: function(){--%>
        <%--            alert("ajax")--%>
        <%--        }--%>
        <%--    });--%>
        <%--}--%>

    </script>

</html>