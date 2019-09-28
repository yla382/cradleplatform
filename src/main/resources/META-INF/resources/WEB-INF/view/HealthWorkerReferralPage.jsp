<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Referral Page (Health Worker)</title>
    <h2>Referral Page (Health Worker)</h2>
    <link rel="stylesheet" type="text/css" href="/css/referralPage.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

    <form>
        <!-- Name and Age -->
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputName3" class="col-sm-2 col-form-label">Name</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputName3" placeholder="Name">
                </div>
            </div>

            <div class="form-group col-md-4">
                <label for="inputAge3" class="col-sm-2 col-form-label">Age</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="inputAge3" placeholder="Age">
                </div>
            </div>
        </div>

        <!-- Sex checkbox -->
        <fieldset class="form-group">
            <div class="row">
                <legend class="col-form-label col-sm-2 pt-0">Sex</legend>
                <div class="col-sm-10">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gridSex" id="gridSex1" value="option1" checked>
                        <label class="form-check-label" for="gridSex1">
                            Female
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gridSex" id="gridSex2" value="option2">
                        <label class="form-check-label" for="gridSex2">
                            Male
                        </label>
                    </div>
                </div>
            </div>
        </fieldset>

        <!-- Address -->
        <div class="form-row">
            <div class="form-group col-md-2">
                <label for="inputZone">Zone</label>
                <input type="text" class="form-control" id="inputZone">
            </div>
            <div class="form-group col-md-2">
                <label for="inputBlockNumber">Block No</label>
                <input type="text" class="form-control" id="inputBlockNumber">
            </div>
            <div class="form-group col-md-2">
                <label for="inputTankNumber">Tank No</label>
                <input type="text" class="form-control" id="inputTankNumber">
            </div>
            <div class="form-group col-md-2">
                <label for="inputVillage">Village</label>
                <input type="text" class="form-control" id="inputVillage">
            </div>
        </div>

        <!-- Household Number and Name of VHT -->
        <div class="form-row">
            <div class="form-group col-md-2">
                <label for="inputHouseholdNumber">Household Number</label>
                <input type="text" class="form-control" id="inputHouseholdNumber">
            </div>
            <div class="form-group col-md-4">
                <label for="inputNameVHT">Name [VHT]</label>
                <input type="text" class="form-control" id="inputNameVHT">
            </div>
            <div class="form-group col-md-4">
                <label for="inputSignature">Signature</label>
                <input type="text" class="form-control" id="inputSignature">
            </div>
        </div>

        <!-- Description of followup care needed -->
        <div class="form-group">
            <div class="col-sm-4">Description of follow-up care needed</div>
            <ol type = "1">
                <li>
                    <input class="form-control" type="text">
                </li>
                <li>
                    <input class="form-control" type="text">
                </li>
            </ol>
        </div>


        <!-- Diagnosis -->
        <div class="form-group">
            <label for="exampleFormControlTextarea1">Diagnosis</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
        </div>

        <!-- Blood Pressure -->
        <div class="form-row">
            <div class="col-sm-2">Blood Pressure</div>
                <input type="number", name="systolicBloodPressure", min="1", max="300"> /
                <input type="number", name="diastolicBloodPressure", min="1", max="300">
        </div>

        <!-- Heart Rate -->
        <fieldset class="form-group">
            <div class="row">
                <div class="col-sm-2">Heart Rate</div>
                <div class="col-sm-10">
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gridHeartRate" id="gridHeartRate1" value="option1" checked>
                        <label class="form-check-label" for="gridHeartRate1">
                            <p class="text-success">Green</p>
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gridHeartRate" id="gridHeartRate2" value="option2">
                        <label class="form-check-label" for="gridHeartRate2">
                            <p class="text-warning">Yellow &#8593</p>
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gridHeartRate" id="gridHeartRate3" value="option3">
                        <label class="form-check-label" for="gridHeartRate3">
                            <p class="text-warning">Yellow &#8595</p>
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gridHeartRate" id="gridHeartRate4" value="option4">
                        <label class="form-check-label" for="gridHeartRate4">
                            <p class="text-danger">Red &#8593</p>
                        </label>
                    </div>
                    <div class="form-check">
                        <input class="form-check-input" type="radio" name="gridHeartRate" id="gridHeartRate5" value="option5">
                        <label class="form-check-label" for="gridHeartRate5">
                            <p class="text-danger">Red &#8595</p>
                        </label>
                    </div>
                </div>

            </div>
        </fieldset>

        <!-- Date when the patient should return -->
        <div class="form-group row">
            <label for="example-date-input" class="col-2 col-form-label">Date</label>
            <div class="col-10">
                <input class="form-control" type="date" id="example-date-input">
            </div>
        </div>

        <!-- Name of Health Worker -->
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="inputNameHealthWorker">Name of the health worker</label>
                <input type="text" class="form-control" id="inputNameHealthWorker">
            </div>
            <div class="form-group col-md-6">
                <label for="inputHealthWorkerSignature">Signature</label>
                <input type="text" class="form-control" id="inputHealthWorkerSignature">
            </div>
        </div>


    </form>
</body>

</html>