package com.example.TeamMercuryCradlePlatform.Model;

import javax.persistence.Entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer patientId;
    private String country = null;
    private String location = null;
    private String firstName = null;
    private String lastName = null;
    private String trafficLight = null; //Green, Yellow, Red
    private String sex = null;
    private Float weight = null;
    private Float height = null;
    private Boolean isPregnant = null;
    private Short gestationalAge = null;
    private String diagnostics = null;
    private String treatment = null;
    private String symptoms = null;
    private String drugHistory = null;
    private String medicalHistory = null;

    public Patient() {
    }

    public Patient(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getPatientId() {
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

    public Float getWeight() {
        return weight;
    }

    public Float getHeight() {
        return height;
    }

    public Boolean getPregnant() {
        return isPregnant;
    }

    public Short getGestationalAge() {
        return gestationalAge;
    }

    public String getDiagnostics() {
        return diagnostics;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getDrugHistory() {
        return drugHistory;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setPatientId(int patientId) {
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

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public void setDrugHistory(String drugHistory) {
        this.drugHistory = drugHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

}