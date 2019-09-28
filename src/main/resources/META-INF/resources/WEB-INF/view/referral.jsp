<body>

<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<div class="container w-100" style="padding: 10px">
    <form action="${pageContext.request.contextPath}/submitReading" method="post">
        <div class="form-group">
            <div class="row">
                <div class="col">
                    <label for="formdate">Date:</label>
                    <input required type="date" class="form-control" id="formdate" name="formdate">
                </div>
                <div class="col">
                    <label for="facility">Facility Referred To:</label>
                    <input required type="text" class="form-control" id="facility" name="facility">
                </div>
                <div class="col">
                    <label for="name">Name:</label>
                    <input required type="text" class="form-control" id="name" name="name">
                </div>
                <div class="col">
                    <label for="age">Age:</label>
                    <input required type="number" min="0" class="form-control" id="age" name="age">
                </div>
                <div class="col">
                    <label for="name">Sex:</label>
                    <form action="" method="post" id="sex">
                        <input type="radio" name="sex_choice" value="male" />Male
                        <input type="radio" name="sex_choice" value="female" />Female
                    </form>
                </div>
                <div class="col">
                    <label for="zone">Zone:</label>
                    <input required type="text" class="form-control" id="zone" name="name">
                </div>
                <div class="col">
                    <label for="blockno">Block Number:</label>
                    <input required type="number" min="0" class="form-control" id="blockno" name="blockno">
                </div>
                <div class="col">
                    <label for="tankno">Tank Number:</label>
                    <input required type="number" min="0" class="form-control" id="tankno" name="tankno">
                </div>
                <div class="col">
                    <label for="village">Village:</label>
                    <input required type="text" class="form-control" id="village" name="village">
                </div>
                <div class="col">
                    <label for="householdno">Household Number:</label>
                    <input required type="number" min="0" class="form-control" id="householdno" name="householdno">
                </div>
                <div class="col">
                    <label for="vhtname">VHT Name:</label>
                    <input required type="text" class="form-control" id="vhtname" name="vhtname">
                </div>
            </div>
            <p1>
                Reasons for patient referral:
            </p1>
            <div class="form-group">
                <select multiple class="form-control" id="symptomsSelector" name="symptoms">
                    <option value="Headache">Headache</option>
                    <option value="Blurred vision">Blurred vision</option>
                    <option value="Abdominal pain">Abdominal pain</option>
                    <option value="Bleeding">Bleeding</option>
                    <option value="Feverish">Feverish</option>
                    <option value="Unwell">Unwell</option>
                </select><br>
                <label for="form_other">Other:</label>
                <input required type="text" class="form-control" id="form_other" name="form_other">
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Submit" id="submitButton">
    </form>

    <%--Detects when user comes back to this page--%>
    <label for="backButtonState"></label>
    <input id="backButtonState" type="text" value="0" style="display:none;" />

</div>
</body>
