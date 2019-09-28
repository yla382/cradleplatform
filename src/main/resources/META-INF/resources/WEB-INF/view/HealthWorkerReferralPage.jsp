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
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <ol type="1">
                    <li>
                        <input class="form-control" type="text">
                    </li>
                    <li>
                        <input class="form-control" type="text">
                    </li>
                </ol>
            </div>
        </div>

        <!-- Diagnosis -->
        <div class="form-group">
            <label for="exampleFormControlTextarea1">Diagnosis</label>
            <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
        </div>

        <!-- Blood Pressure -->

        <!-- Heart Rate -->
        <!-- Date when the patient should return -->
        <!-- Name of Health Worker -->
        <div class="form-group row">
            <div class="col-sm-2">Checkbox</div>
            <div class="col-sm-10">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="gridCheck1">
                    <label class="form-check-label" for="gridCheck1">
                        Example checkbox
                    </label>
                </div>
            </div>
        </div>



        <button type="button" onclick="saveButton()"> Save </button>

    </form>
</body>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<script>


    // TODO: implement save when database is done
    function saveButton() {

    }

</script>

</html>