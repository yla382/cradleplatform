<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


    <body>
        <div class="container w-100">

            <h2> ${personalInfo}</h2>
            <p> ${patientId}</p>
            <p> ${symptoms}</p>
            <h2> ${timeTaken}: ${analysis}</h2>
            <p> ${bp}</p>
            <p> ${hr}</p>

            <img src="../resources/drawable/${trafficLight}.png" alt="Traffic light image">
            <c:if test="${!arrowDirection.equals(null)}">
                <img src="../resources/drawable/${arrowDirection}.png" alt="Arrow direction image">
            </c:if>


            <h2> Advice</h2>
            <p> ${briefText}</p>

            <div class="custom-control custom-switch">
                <input checked type="checkbox" class="custom-control-input" id="recheckVitalsNow">
                <label class="custom-control-label" for="recheckVitalsNow">Recheck vitals now(after save)</label>
            </div>

            <div class="custom-control custom-switch">
                <input type="checkbox" class="custom-control-input" id="recheckVitals15">
                <label class="custom-control-label" for="recheckVitals15"> Recheck vitals in 15 minutes (after save)</label>
            </div>


            <h2> Not referred</h2>
            <p> ${referralRecommended == "true"? "Referral recommened" : "Referral not recommended"} <button type="button">Send referral</button> </p>

            <div class="custom-control custom-switch">
                <input checked type="checkbox" class="custom-control-input" id="followUp">
                <label class="custom-control-label" for="followUp"> Follow-up needed (another day)</label>
            </div>
            <p> Follow-up ${isFollowUp == "true"? "recommended" : "not recommended"}</p>

            <button type="button" onclick="editButton()"> Edit </button>
            <button type="button" onclick="saveButton()"> Save </button>

        </div>
    </body>


    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

    <script>

        function editButton() {
            window.history.back();
        }

        // TODO: implement save when database is done
        function saveButton() {

        }

    </script>

</html>