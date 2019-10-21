<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.mercury.TeamMercuryCradlePlatform.model.Reading" %>
<%@ page import="com.mercury.TeamMercuryCradlePlatform.Strings" %>
<!DOCTYPE html>
<html>



<%
    Reading reading = (Reading)request.getAttribute("reading");
%>

<head>
    <meta charset="ISO-8859-1">
    <title>Edit Reading</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>

<%@ include file="../navbar.jspf" %>

    <div class="container w-100" style="padding: 10px">
        <form action="${pageContext.request.contextPath}/reading/update/<%=reading.readingId%>" method="post" id="form">
            <div class="form-group">
                <div class="row">
                    <input type="hidden" name="id" value="<%=reading.readingId%>"/>
                    <div class="col">
                        <label for="firstName">First Name</label>
                        <input required type="text" class="form-control" id="firstName" name="firstName" value="<%=reading.firstName%>">
                    </div>
                    <div class="col">
                        <label for="lastName">Last Name</label>
                        <input required type="text" class="form-control" id="lastName" name="lastName" value="<%=reading.lastName%>">
                    </div>
                    <div class="col">
                        <label for="ageYears">Age</label>
                        <input required type="number" min="0" class="form-control" id="ageYears" name="ageYears" value="<%=reading.ageYears%>">
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
            <div class="form-group" id="symptomsSelectorDiv">
                <ul class="list-unstyled">
                    <li>
                        <label>
                            <input type="checkbox" name="symptoms" value="<%=Strings.SYMPTOM_HEADACHE%>"> <%=Strings.SYMPTOM_HEADACHE%>
                        </label>
                    </li>
                    <li>
                        <label>
                            <input type="checkbox" name="symptoms" value="<%=Strings.SYMPTOM_BLURRED_VISION%>"> <%=Strings.SYMPTOM_BLURRED_VISION%>
                        </label>
                    </li>
                    <li>
                        <label>
                            <input type="checkbox" name="symptoms" value="<%=Strings.SYMPTOM_ABDOMINAL_PAIN%>"> <%=Strings.SYMPTOM_ABDOMINAL_PAIN%>

                        </label>
                    </li>
                    <li>
                        <label>
                            <input type="checkbox" name="symptoms" value=<%=Strings.SYMPTOM_BLEEDING%>> <%=Strings.SYMPTOM_BLEEDING%>
                        </label>
                    </li>
                    <li>
                        <label>
                            <input type="checkbox" name="symptoms" value="<%=Strings.SYMPTOM_FEVERISH%>"> <%=Strings.SYMPTOM_FEVERISH%>
                        </label>
                    </li>
                    <li><label>
                        <input type="checkbox" name="symptoms" value="<%=Strings.SYMPTOM_UNWELL%>"> <%=Strings.SYMPTOM_UNWELL%>
                    </label>
                    </li>
                </ul>
            </div>
            <div class="form-group">
                <label for="otherSymptoms">Other symptoms</label>
                <textarea class="form-control" id="otherSymptoms" name="otherSymptoms" rows="2" maxlength="200"></textarea>
            </div>
            <div class="form-group">
                <label for="bpSystolic">Systolic</label>
                <input required type="number" min="10" max="300" class="form-control" id="bpSystolic" name="bpSystolic" style="width: 25%" value="<%=reading.bpSystolic%>"/>
            </div>
            <div class="form-group">
                <label for="bpDiastolic">Diastolic</label>
                <input required type="number" min="10" max="300" class="form-control" id="bpDiastolic" name="bpDiastolic" style="width: 25%" value="<%=reading.bpDiastolic%>">
            </div>
            <div class="form-group">
                <label for="heartRateBPM">Heart rate</label>
                <input required type="number" min="40" max="200" class="form-control" id="heartRateBPM" name="heartRateBPM" style="width: 25%" value="<%=reading.heartRateBPM%>">
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input class="form-group" type="submit" value="Submit" id="submitButton">
        </form>
    </div>
</body>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<script type="text/javascript" src="validator.min.js"></script>


<script>

    window.onload = function () {
        selectGestationalUnit();
        selectSymptoms();
    };

    function selectGestationalUnit(){

        let selectedGestationUnit = $("#gestationalAgeUnit");
        let gestationalValue = $("#gestationalAgeValue");
        let val = "<c:out value='<%=reading.gestationalAgeUnit%>'/>"

        if(val ===  "<c:out value='<%=Reading.GestationalAgeUnit.GESTATIONAL_AGE_UNITS_WEEKS%>'/>"){
            selectedGestationUnit.prop('selectedIndex', 0);
        }
        else if(val ===  "<c:out value='<%=Reading.GestationalAgeUnit.GESTATIONAL_AGE_UNITS_MONTHS%>'/>"){
            selectedGestationUnit.prop('selectedIndex', 1);
        }
        else{
            gestationalValue.prop('disabled', true);
            selectedGestationUnit.prop('selectedIndex', 2);
        }
        gestationalValue.val(<%=reading.gestationalAgeValue%>);
    }

    function selectSymptoms(){

        let symptomsArr = "<c:out value='<%=reading.getSymptomsString()%>'/>".split(",");

        if(symptomsArr[0] === "<c:out value='<%=Strings.SYMPTOM_NO_SYMPTOMS%>'/>"){
            document.getElementById("health").selectedIndex = "1";
            healthChange();
        }
        else{
            let i = 0;
            $("#symptomsSelectorDiv input[type=checkbox]").each(function() {
                if (symptomsArr.indexOf($(this).val()) > -1) {
                    $(this).prop('checked', true);
                    i++;
                }
            });

            if(i < symptomsArr.length){
                const slicedArr = symptomsArr.slice(i, symptomsArr.length);
                for(i = 0; i < slicedArr.length; i++){
                    if(i > 0){
                        slicedArr[i] = " " + slicedArr[i];
                    }
                }

                $("#otherSymptoms").val(slicedArr);
            }
        }
    }

    function healthChange() {
        const e = document.getElementById("health");
        const strUser = e.options[e.selectedIndex].value;

        if(strUser === "2"){
            $("#symptomsSelectorDiv input").attr('disabled', true);
        }
        else {
            $("#symptomsSelectorDiv input").removeAttr('disabled');
        }

        document.getElementById("otherSymptoms").disabled = strUser === "2";
    }

    function gestationalAgeUnitChange() {
        const e = document.getElementById("gestationalAgeUnit");
        const strUser = e.options[e.selectedIndex].value;
        document.getElementById("gestationalAgeValue").disabled = strUser === "<c:out value='<%=Strings.GESTATION_UNIT_NOT_PREGNANT%>'/>";
    }

</script>


</html>