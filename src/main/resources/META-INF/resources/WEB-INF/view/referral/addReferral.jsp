<%@ page import="com.mercury.TeamMercuryCradlePlatform.model.Referral" %> 
<%@ page import="com.mercury.TeamMercuryCradlePlatform.model.Reading" %>
<%@ page import="com.mercury.TeamMercuryCradlePlatform.model.ReadingAnalysis" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
  <% String firstName = (String) session.getAttribute("firstName"); String
  lastName = (String) session.getAttribute("lastName"); Integer ageYears =
  (Integer) session.getAttribute("ageYears"); Integer bpSystolic = (Integer)
  session.getAttribute("bpSystolic"); Integer bpDiastolic = (Integer)
  session.getAttribute("bpDiastolic"); Integer heartRateBPM = (Integer)
  session.getAttribute("heartRateBPM"); String analysis = (String)
  session.getAttribute("analysis");
  Reading reading = (Reading) request.getAttribute("reading"); %>

  <head>
    <meta charset="utf-8" />
    <title>Add Referral</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css" />
    <link rel="stylesheet" href="/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/create-referral.css" />
    <link
      rel="stylesheet"
      href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
      integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
      crossorigin="anonymous"
    />
  </head>

  <body>
    
        <div class="main-container">
                <%@ include file="../navbar/navbar.jspf" %>
                <div class="content-container">
                    <div class="content-header">
                        Add A Referral
                    </div>
                    <div class="create-reading-container">
                        <main class="my-form">
                            <div class="container">
                                <form action="${pageContext.request.contextPath}/reading/analysis"
                                method="post"
                                id="form">

                                    <div class="form-group row">
                                        <div class="col-sm-6 row">
                                            <label for="referredHealthCentre" class="col-sm-4 col-form-label create-reading-label">HEALTH CENTRE</label>
                                            <div class="col-sm-7">
                                                <input type="text" id="referredHealthCentre" class="reading-field" name="referredHealthCentre" placeholder="Health Centre">
                                            </div>
                                        </div>
                                        <div class="col-sm-6 row">
                                                <label for="vhtName" class="col-sm-4 offset-sm-1 col-form-label create-reading-label">VHT</label>
                                                <div class="col-sm-7">
                                                    <input type="text" id="vhtName" class="reading-field" name="vhtName" placeholder="Name Of VHT">
                                                </div>
                                        </div>
                                    </div>

                                    <div class="form-group row" style="margin-top: 50px">
                                        <div class="col-sm-6 row">
                                            <label for="firstName" class="col-sm-4 col-form-label create-reading-label">FIRST NAME</label>
                                            <div class="col-sm-7">
                                                <input type="text" id="firstName" class="reading-field" name="firstName" placeholder="First Name">
                                            </div>
                                        </div>
                                        <div class="col-sm-6 row">
                                                <label for="lastName" class="col-sm-4 offset-sm-1 col-form-label create-reading-label">LAST NAME</label>
                                                <div class="col-sm-7">
                                                    <input type="text" id="lastName" class="reading-field" name="lastName" placeholder="Last Name">
                                                </div>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                            <div class="col-sm-6 row">
                                                <label for="ageYears" class="col-sm-4 col-form-label create-reading-label">AGE</label>
                                                <div class="col-sm-7">
                                                    <input type="text" id="ageYears" class="reading-field" name="ageYears" placeholder="Age">
                                                </div>
                                            </div>
                                            <div class="col-sm-6 row">
                                                    <label for="sex" class="col-sm-4 offset-sm-1 col-form-label create-reading-label">SEX</label>
                                                    <div class="col-sm-7">
                                                      <select class="form-control" id="sex" name="sex">
                                                        <option value="FEMALE">FEMALE</option>
                                                        <option value="MALE">MALE</option>
                                                      </select>
                                                    </div>
                                                </div>
                                        </div>
                                    
                                        <div class="form-group row">
                                                <div class="col-sm-6 row">
                                                    <label for="zoneNumber" class="col-sm-4 col-form-label create-reading-label">ZONE #</label>
                                                    <div class="col-sm-7">
                                                        <input type="text" id="zoneNumber" class="reading-field" name="zoneNumber" placeholder="Zone Number">
                                                    </div>
                                                </div>
                                                <div class="col-sm-6 row">
                                                        <label for="lastName" class="col-sm-4 offset-sm-1 col-form-label create-reading-label">VILLAGE #</label>
                                                        <div class="col-sm-7">
                                                            <input type="text" id="villageNumber" class="reading-field" name="villageNumber" placeholder="Village Number">
                                                        </div>
                                                </div>
                                            </div>


                                            <div class="form-group row" style="margin-top: 50px">
                                              <div class="col-sm-6 row">
                                                  <label for="bpSystolic" class="col-sm-4 col-form-label create-reading-label">SYSTOLIC</label>
                                                  <div class="col-sm-7">
                                                      <input type="text" id="bpSystolic" class="reading-field" name="bpSystolic" placeholder="Systolic">
                                                  </div>
                                              </div>
                                              <div class="col-sm-6" style="position:absolute; right: 0;">
                                                <div class="form-group row">
                                                        <div class="col-sm-3 text-right" style="padding-top: 30px;">
                                                                <img src="/images/<%=ReadingAnalysis.analyze(reading).getTrafficLightImg()%>.png" alt="<%=ReadingAnalysis.analyze(reading).getTrafficLightImg()%>">
                                                            </div>
                                                            <div class="col-sm-3" style="padding-top: 30px">
                                                                <c:if test="<%= ReadingAnalysis.analyze(reading).getArrowDirection() != null %>">
                                                                    <img src="/images/<%=ReadingAnalysis.analyze(reading).getArrowDirection()%>.png" alt="<%=ReadingAnalysis.analyze(reading).getArrowDirection()%>">
                                                                </c:if>
                                                            </div>
                                                </div>
                                                </div>
                                          </div>

                                          <div class="form-group row">
                                            <div class="col-sm-6 row">
                                                <label for="bpDiastolic" class="col-sm-4 col-form-label create-reading-label">DIASTOLIC</label>
                                                <div class="col-sm-7">
                                                    <input type="text" id="bpDiastolic" class="reading-field" name="bpDiastolic" placeholder="Diastolic">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group row">
                                          <div class="col-sm-6 row">
                                              <label for="heartRateBPM" class="col-sm-4 col-form-label create-reading-label">HEART RATE</label>
                                              <div class="col-sm-7">
                                                  <input type="text" id="heartRateBPM" class="reading-field" name="heartRateBPM" placeholder="Heart Rate">
                                              </div>
                                          </div>
                                        </div>
                                          
 

                                    <div class="form-group row" style="margin-top: 50px">
                                            <div class="col-sm-12 row">
                                                <label for="reasonOfReferral" class="col-sm-2 col-form-label create-reading-label">REASON OF REFERRAL</label>
                                                <div class="col-sm-6">
                                                    <textarea rows="2" type="text" id="reasonOfReferral" class="reading-textarea" name="reasonOfReferral" placeholder="Reason Of Referral"></textarea>
                                                </div>
                                            </div>
                                        </div>


                                      <div class="form-group row">
                                          <div class="col-sm-12 row">
                                              <label for="actionAlreadyTaken" class="col-sm-2 col-form-label create-reading-label">ACTION TAKEN</label>
                                              <div class="col-sm-6">
                                                  <textarea rows="2" type="text" id="actionAlreadyTaken" class="reading-textarea" name="actionAlreadyTaken" placeholder="Action Taken"></textarea>
                                              </div>
                                          </div>
                                      </div>

                                      <div class="form-group row">
                                        <div class="col-sm-12 row">
                                            <label for="otherInfoMessage" class="col-sm-2 col-form-label create-reading-label">OTHER</label>
                                            <div class="col-sm-6">
                                                <textarea rows="2" type="text" id="otherInfoMessage" class="reading-textarea" name="otherInfoMessage" placeholder="Other Symptoms"></textarea>
                                            </div>
                                        </div>
                                    </div>


                                    <input
                                    type="hidden"
                                    name="${_csrf.parameterName}"
                                    value="${_csrf.token}"
                                    />
                                    <div class="col-md-3 offset-md-9">
                                        <div class="offset-md-2">
                                            <button type="submit" class="btn-submit">
                                                Submit
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                    </div>
                </div>
                </main>
            </div>
        </div>
    </div>














    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <form
      action="${pageContext.request.contextPath}/referral/confirmReferral"
      method="post"
    >
      <div class="container w-100" style="padding: 10px">
        <div class="form-group">
          <div class="row">
            <div class="col">
              <label for="referredHealthCentre"
                >Health Centre referred to:
              </label>
              <input
                required
                type="text"
                class="form-control"
                id="referredHealthCentre"
                name="referredHealthCentre"
              /><br />
            </div>

            <%--vht--%>
            <div class="col">
              <label for="vhtName">Name of VHT: </label>
              <input
                required
                type="text"
                class="form-control"
                id="vhtName"
                name="vhtName"
              /><br />
            </div>
          </div>
        </div>

        <%--Patient Info--%>
        <div class="form-group">
          <div class="row">
            <div class="col">
              <label for="firstName">First Name: </label>
              <input
                required
                type="text"
                class="form-control"
                id="firstName"
                name="firstName"
                disabled
                value="<%=firstName%>"
              /><br />
            </div>
            <div class="col">
              <label for="lastName">Last Name: </label>
              <input
                required
                type="text"
                class="form-control"
                id="lastName"
                name="lastName"
                disabled
                value="<%=lastName%>"
              /><br />
            </div>
            <div class="col">
              <label for="ageYears">Age: </label>
              <input
                required
                type="number"
                class="form-control"
                id="ageYears"
                name="ageYears"
                disabled
                value="<%=ageYears%>"
              /><br />
            </div>
            <div class="col">
              <label for="sex">Sex: </label>
              <select class="form-control" id="sex" name="sex">
                <option value="FEMALE">FEMALE</option>
                <option value="MALE">MALE</option>
              </select>
            </div>
          </div>
        </div>
        <div class="form-group">
          <div class="row">
            <div class="col">
              <label for="zoneNumber">Zone Number: </label>
              <input
                type="number"
                class="form-control"
                id="zoneNumber"
                name="zoneNumber"
                required="required"
                pattern="[0-9]{1,5}"
              />
            </div>
            <div class="col">
              <label for="villageNumber">Village Number: </label>
              <input
                type="number"
                class="form-control"
                id="villageNumber"
                name="villageNumber"
                required="required"
                pattern="[0-9]{1,5}"
              />
            </div>
          </div>
        </div>
        <div class="form-group">
          <div class="row">
            <div class="col">
              <label for="bpSystolic">Blood Pressure Systolic: </label>
              <input
                type="number"
                class="form-control"
                id="bpSystolic"
                name="bpSystolic"
                disabled
                value="<%=bpSystolic%>"
              />
            </div>
            <div class="col">
              <label for="bpDiastolic">Blood Pressure Diastolic: </label>
              <input
                type="number"
                class="form-control"
                id="bpDiastolic"
                name="bpDiastolic"
                disabled
                value="<%=bpDiastolic%>"
              />
            </div>
            <div class="col">
              <label for="heartRateBPM">Heart Rate: </label>
              <input
                type="number"
                class="form-control"
                id="heartRateBPM"
                name="heartRateBPM"
                disabled
                value="<%=heartRateBPM%>"
              />
            </div>
            <div class="col">
              <label for="analysis">Reading Analysis: </label>
              <input
                type="text"
                class="form-control"
                id="analysis"
                name="analysis"
                disabled
                value="<%=analysis%>"
              />
            </div>
          </div>
        </div>

        <%--referral reason--%>
        <div class="form-group">
          <label for="reasonOfReferral"
            >I have referred to you this patient for this following reasons:
          </label>
          <input
            required
            type="text"
            class="form-control"
            id="reasonOfReferral"
            name="reasonOfReferral"
          /><br />
        </div>
        <%--action taken--%>
        <div class="form-group">
          <label for="actionAlreadyTaken">Action already taken: </label>
          <input
            required
            type="text"
            class="form-control"
            id="actionAlreadyTaken"
            name="actionAlreadyTaken"
          /><br />
        </div>
        <%--other message--%>
        <div class="form-group">
          <label for="otherInfoMessage">Other Information and Messages: </label>
          <input
            required
            type="text"
            class="form-control"
            id="otherInfoMessage"
            name="otherInfoMessage"
          /><br />
        </div>

        <button type="submit" value="Submit">Submit</button>
      </div>
      <input
        type="hidden"
        name="${_csrf.parameterName}"
        value="${_csrf.token}"
      />
    </form>

    <script
      src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
      integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
      integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
      integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
