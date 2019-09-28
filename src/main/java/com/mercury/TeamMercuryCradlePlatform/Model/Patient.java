package com.mercury.TeamMercuryCradlePlatform.Model;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Set;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private Set<Reading> readings;

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



}