package com.cradleplatform.mercury.CradlePlatform;
import java.util.List;

//patientReading and followUpdate not included

public class Patient {
    private String patientId;
    private String country;
    private String location;
    private String firstName;
    private String lastName;
    private String trafficLight;
    private String sex;
    private float weight;
    private float height;
    private Boolean isPregnant;
    private short gestationalAge;
    private String diagnostics;
    private String treatment;
    private List<String> symptoms;
    private String drugHistory;
    private String medicalHistory;

    public Patient() {  //Not too sure how we will generate the patient id
    }

    public String getPatientId() {
        return patientId;
    }

    public String getCountry() {
        return country;
    }

    public String getLocation() {
        return location;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTrafficLight() {
        return trafficLight;
    }

    public String getSex() {
        return sex;
    }

    public float getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }

    public Boolean getPregnant() {
        return isPregnant;
    }

    public short getGestationalAge() {
        return gestationalAge;
    }

    public String getDiagnostics() {
        return diagnostics;
    }

    public String getTreatment() {
        return treatment;
    }

    public List<String> getSymptoms() {
        return symptoms;
    }

    public String getDrugHistory() {
        return drugHistory;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTrafficLight(String trafficLight) {
        this.trafficLight = trafficLight;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public void setPregnant(Boolean pregnant) {
        isPregnant = pregnant;
    }

    public void setGestationalAge(short gestationalAge) {
        this.gestationalAge = gestationalAge;
    }

    public void setDiagnostics(String diagnostics) {
        this.diagnostics = diagnostics;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public void setSymptoms(List<String> symptoms) {
        this.symptoms = symptoms;
    }

    public void setDrugHistory(String drugHistory) {
        this.drugHistory = drugHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }
}

