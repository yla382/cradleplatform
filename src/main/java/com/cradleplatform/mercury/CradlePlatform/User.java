package com.cradleplatform.mercury.CradlePlatform;

import java.util.List;

enum UserType {
    VHT,
    HealthWorker,
    Admin
}

public class User {
    private String userId;
    private String country;
    private String location;
    private String firstName;
    private String lastName;
    private String sex;
    private UserType type;
    private List<PatientList> patientList;

    public User() {
    }

    public String getUserId() {
        return userId;
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

    public String getSex() {
        return sex;
    }

    public UserType getType() {
        return type;
    }

    public List<PatientList> getPatientList() {
        return patientList;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public void setPatientList(List<PatientList> patientList) {
        this.patientList = patientList;
    }
}

