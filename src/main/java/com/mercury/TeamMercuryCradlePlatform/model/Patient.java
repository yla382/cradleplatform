package com.mercury.TeamMercuryCradlePlatform.model;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Patient {
    @Id
    @Column(name="patient_Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer patientId;
    private String firstName = null;
    private String lastName = null;
    private Integer ageYears = null;
    private String country = null;
    private String location = null;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="patient_Id", referencedColumnName = "patient_Id")
    private List<Reading> readings = new ArrayList<>();

    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
    private Referral referral;

    public Patient() {
    }

    public Patient(String firstName, String lastName, String country, String location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.location = location;
    }


    public Patient(String firstName, String lastName, Integer ageYears) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ageYears = ageYears;
    }


    public Patient(Reading reading){
        this.firstName = reading.firstName;
        this.lastName = reading.lastName;
        this.ageYears = reading.ageYears;

        this.readings.add(reading);
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

    public Integer getAgeYears() {
        return ageYears;
    }

    public void setAgeYears(Integer ageYears) {
        this.ageYears = ageYears;
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

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public void addReading(Reading reading){
        this.readings.add(reading);
    }


    public Referral getReferral() {
        return referral;
    }

    public void setReferral(Referral referral) {
        this.referral = referral;
    }


}