package com.mercury.TeamMercuryCradlePlatform.Model;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

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

    public Patient() {
    }

    public Patient(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
        readings.add(reading);
    }
}