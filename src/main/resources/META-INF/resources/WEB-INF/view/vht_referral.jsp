<head>
        <meta charset="utf-8">
        <title>VHT Referral Page</title>
        <h2>VHT Referral Page</h2>
        <link rel="stylesheet" type="text/css" href="/css/vht_referral.css">
        <!-- link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous" -->
        <style></style>
</head>
<body>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="referral_form" style="padding: 10px">
                <form action="${pageContext.request.contextPath}/submitReading" method="post">
                        <table>
                                <tr>
                                        <td align="right"><label for="formdate">Date:</label></td>
                                        <td align="left"><input required type="date" class="form-control" id="formdate" name="formdate"></td>
                                </tr>
                                <tr>
                                        <td align="right"><label for="facility">Facility Referred To:</label></td>
                                        <td align="left"><input required type="text" class="form-control" id="facility" name="facility"></td>
                                </tr>
                                <tr>
                                        <td align="right"><label for="name">Name:</label></td>
                                        <td align="left"><input required type="text" class="form-control" id="name" name="name"></td>
                                </tr>
                                <tr>
                                        <td align="right"><label for="age">Age:</label></td>
                                        <td align="left"><input required type="number" min="0" class="form-control" id="age" name="age"></td>
                                </tr>
                                <tr>
                                        <td align="right"><label for="name">Sex:</label></td>
                                        <td align="left">
                                                <form action="" method="post" id="sex">
                                                        <input type="radio" name="sex_choice" value="male" />Male
                                                        <input type="radio" name="sex_choice" value="female" />Female
                                                </form>
                                        </td>
                                </tr>
                                <tr>
                                        <td align="right"><label for="zone">Zone:</label></td>
                                        <td align="left"><input required type="text" class="form-control" id="zone" name="name"></td>
                                </tr>
                                <tr>
                                        <td align="right"><label for="blockno">Block Number:</label></td>
                                        <td align="left"><input required type="number" min="0" class="form-control" id="blockno" name="blockno"></td>
                                </tr>
                                <tr>
                                        <td align="right"><label for="tankno">Tank Number:</label></td>
                                        <td align="left"><input required type="number" min="0" class="form-control" id="tankno" name="tankno"></td>
                                </tr>
                                <tr>
                                        <td align="right"><label for="village">Village:</label></td>
                                        <td align="left"><input required type="text" class="form-control" id="village" name="village"></td>
                                </tr>
                                <tr>
                                        <td align="right"><label for="householdno">Household Number:</label></td>
                                        <td align="left"><input required type="number" min="0" class="form-control" id="householdno" name="householdno"></td>
                                </tr>
                                <tr>
                                        <td align="right"><label for="vhtname">VHT Name:</label></td>
                                        <td align="left"><input required type="text" class="form-control" id="vhtname" name="vhtname"></td>
                                </tr>
                                <tr>
                                        <td align="right">Reasons for patient referral:</td>
                                        <td align="left" class="form-group">
                                                <select multiple class="form-control" id="symptoms" name="symptoms">
                                                        <option value="Headache">Headache</option>
                                                        <option value="Blurred vision">Blurred vision</option>
                                                        <option value="Abdominal pain">Abdominal pain</option>
                                                        <option value="Bleeding">Bleeding</option>
                                                        <option value="Feverish">Feverish</option>
                                                        <option value="Unwell">Unwell</option>
                                                </select><br>
                                        </td>
                                </tr>
                                <tr>
                                        <td align="right">Blood Pressure (BP):</td>
                                        <td align="left">
                                                <input required type="number" min="0" class="form-control" id="dia" name="diastolic">
                                                <p1>/</p1>
                                                <input required type="number" min="0" class="form-control" id="sys" name="systolic">
                                        </td>
                                </tr>
                                <tr>
                                        <td align="right"><label for="pulse">Pulse:</label></td>
                                        <td align="left"><input required type="number" class="form-control" id="pulse" name="pulse"></td>
                                </tr>
                                <tr>
                                        <td align="right">Patient light reading:</td>
                                        <td align="left" class="form-group">
                                                <select class="form-control" id="statuslight" name="light">
                                                        <option value="green">Green</option>
                                                        <option value="yellow_up">Yellow ↑</option>
                                                        <option value="yellow_dn">Yellow ↓</option>
                                                        <option value="red_up">Red ↑</option>
                                                        <option value="red_dn">Red ↓</option>
                                                </select><br>
                                        </td>
                                </tr>
                                <tr>
                                        <td align="right"><label for="actions_taken">Actions already taken:</label></td>
                                        <td align="left"><input required type="text" class="form-control" id="actions_taken" name="actions_taken"></td>
                                </tr>
                        </table>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <input type="submit" value="Submit" id="submitButton">
                </form>

                <!--Detects when user comes back to this page-->
                <label for="backButtonState"></label>
                <input id="backButtonState" type="text" value="0" style="display:none;" />
        </div>
        <script>
                // TODO: Connect form submission to database
        </script>
</body>
