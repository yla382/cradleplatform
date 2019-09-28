<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>PatientList</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script ></script>
    <style>
        h1 {color: blue;}
        .center {
            text-align: center;
        }

        #patients td, #patients tr {
            border: 1px solid #ddd;
            padding: 8px;
        }

        #patients td:hover {
            background-color: #ddd;
        }

        #patients th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #1b56cc;
            color: white;
        }

    </style>
</head>
<body>
<%@ include file="../navbar.jspf" %>

</body>

<body>
    <div class="center">
        <h1>List of Patients</h1>
        <table id="patients">
            <tr>
                <td> Name </td>
                <td> Diastolic </td>
                <td> Need Followup </td>
            </tr>
        </table>
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
            const attributeRowOffset = 1;
            for (var i = 0; i < patientsObjects.patients.length; i++)
            {
                var row = table.insertRow(i + attributeRowOffset);
                var nameCell = row.insertCell(0);
                var bpDiastolicCell = row.insertCell(1);
                var isFlaggedForFollowupCell = row.insertCell(2);

                nameCell.innerHTML = patientsObjects.patients[i].patientName;
                bpDiastolicCell.innerHTML = patientsObjects.patients[i].bpDiastolic;
                isFlaggedForFollowupCell.innerHTML = patientsObjects.patients[i].isFlaggedForFollowup;
            }
        </script>
    </div>
</body>

<body>
    <form action="/patient/addPatient">
        <input type="submit" value="Create New Patient">
    </form>
</body>
</html>