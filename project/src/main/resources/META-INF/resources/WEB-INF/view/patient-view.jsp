<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Cradle</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <script src="../../js/app.js"></script>
</head>

<div>
      <title>Patients</title>
</div>

<body>
    <h1>List of Patients</h1>
    <p id="list-of-patients"></p>
    <script>
        var txt = '{"patients":[' +
            '{"firstName":"John","lastName":"Doe" },' +
            '{"firstName":"Paul","lastName":"Smith" },' +
            '{"firstName":"Peter","lastName":"Jones" }]}';
        patientsObjects = JSON.parse(txt);

        var patientsList = [];
        for (var i = 0; i < patientsObjects.patients.length; i++)
        {
            patientsList[i] =
                patientsObjects.patients[i].firstName + " " + patientsObjects.patients[i].lastName;
        }
        document.getElementById("list-of-patients").innerHTML = patientsList.join('<br>');
    </script>
</body>

</html>