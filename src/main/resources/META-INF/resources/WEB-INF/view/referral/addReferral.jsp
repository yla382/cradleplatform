
<!DOCTYPE html>
<html>

    <head>

    <meta charset="ISO-8859-1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    </head>
    <body>

        <%@ include file="../navbar.jspf" %>
        <form action="${pageContext.request.contextPath}/referral/confirmReferral" method="post">
            <div class="container w-100" style="padding: 10px">
                <div class="form-group">
                    <label for="referredHealthCentre">Health Centre referred to: </label>
                    <input type="text" class="form-control" id="referredHealthCentre" name="referredHealthCentre"><br>
                </div>
                <div class="form-group">
                    <label for="vhtName">Name of VHT: </label>
                    <input type="text" class="form-control" id="vhtName" name="vhtName"><br>
                </div>
                <div class="form-group">
                    <label for="reasonOfReferral">I have referred to you this patient for this following reasons: </label>
                    <input type="text" class="form-control" id="reasonOfReferral" name="reasonOfReferral"><br>
                </div>
                <div class="form-group">
                    <label for="actionAlreadyTaken">Action already taken: </label>
                    <input type="text" class="form-control" id="actionAlreadyTaken" name="actionAlreadyTaken"><br>
                </div>
                <div class="form-group">
                    <label for="otherInfoMessage">Other Information and Messages: </label>
                    <input type="text" class="form-control" id="otherInfoMessage" name="otherInfoMessage"><br>
                </div>
                <button type="submit" value="Submit"> Save </button>
                <button type="button"> Test Message </button>
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

    </body>


</html>