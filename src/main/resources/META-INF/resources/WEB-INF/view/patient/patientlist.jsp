<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Patients</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<%@ include file="../navbar.jspf" %>

</body>
    <main role="main" class="container">
        <div>
            <br>
            <h1>List of Patients</h1>
            <table id="patients" class="table table-striped">
                <thead>
                <tr>
                    <th scope="col">Patient ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Diastolic</th>
                    <th scope="col">Needs Followup</th>
                </tr>
                </thead>
            </table>
        </div>
    </main>
<body>

<script>
    var txt = '{"patients":[' +
        '{"ageYears":22,"appVersion":"15 = Beta 0.015","bpDiastolic":99,"bpSystolic":141,' +
        '"dateLastSaved":"2019-08-17T01:29:59.898-07:00[America/Vancouver]",' +
        '"dateRecheckVitalsNeeded":"2019-08-17T01:44:56.583-07:00[America/Vancouver]",' +
        '"dateTimeTaken":"2019-08-17T01:29:16.726-07:00[America/Vancouver]","deviceInfo":"Google, Pixel 3 XL",' +
        '"gestationalAgeUnit":"GESTATIONAL_AGE_UNITS_NONE","gestationalAgeValue":"N/A","heartRateBPM":77,' +
        '"isFlaggedForFollowup":false,"manuallyChangeOcrResults":4,' +
        '"pathToPhoto":"/storage/emulated/0/Pictures/CradleSupportApp/IMG_20190817_012949.jpg",' +
        '"patientId":"1234567890","patientName":"FirstN LastN","readingId":8,"symptoms":["Bleeding"],' +
        '"totalOcrSeconds":0.0,"vhtName":"Brian Fraser","region":"Testing again","ocrEnabled":true,' +
        '"uploadImages":true},' +
        '' +
        '{"ageYears":30,"appVersion":"15 = Beta 0.015","bpDiastolic":100,"bpSystolic":151,' +
        '"dateLastSaved":"2019-08-17T01:29:59.898-07:00[America/Vancouver]",' +
        '"dateRecheckVitalsNeeded":"2019-08-17T01:44:56.583-07:00[America/Vancouver]",' +
        '"dateTimeTaken":"2019-08-17T01:29:16.726-07:00[America/Vancouver]","deviceInfo":"Google, Pixel 3 XL",' +
        '"gestationalAgeUnit":"GESTATIONAL_AGE_UNITS_NONE","gestationalAgeValue":"N/A","heartRateBPM":77,' +
        '"isFlaggedForFollowup":false,"manuallyChangeOcrResults":4,' +
        '"pathToPhoto":"/storage/emulated/0/Pictures/CradleSupportApp/IMG_20190817_012949.jpg",' +
        '"patientId":"1234567877","patientName":"Bob By","readingId":8,"symptoms":["Bleeding"],' +
        '"totalOcrSeconds":0.0,"vhtName":"Brian Fraser","region":"Testing again","ocrEnabled":true,' +
        '"uploadImages":true}]' +
        '}';
    patientsObjects = JSON.parse(txt);

    var table = document.getElementById("patients");
    var attributeRowOffset = 1;
    for (var i = 0; i < patientsObjects.patients.length; i++)
    {
        var row = table.insertRow(i + attributeRowOffset);
        var ptid = row.insertCell(0);
        var nameCell = row.insertCell(1);
        var bpDiastolicCell = row.insertCell(2);
        var isFlaggedForFollowupCell = row.insertCell(3);

        ptid.innerHTML = patientsObjects.patients[i].patientId;
        nameCell.innerHTML = patientsObjects.patients[i].patientName;
        bpDiastolicCell.innerHTML = patientsObjects.patients[i].bpDiastolic;
        isFlaggedForFollowupCell.innerHTML = patientsObjects.patients[i].isFlaggedForFollowup;
    }
</script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>

</html>