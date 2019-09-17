package com.cradleplatform.mercury.CradlePlatform;

import java.util.List;
import java.util.stream.Collectors;

//filtering functions not all added

public class PatientList {
    private List<Patient> patients;

    public PatientList(List<Patient> patients) {
        this.patients = patients;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void deletePatient(Patient patient) {
        patients.removeIf(p -> p.getPatientId().
                equals(patient.getPatientId()));
    }

    public Patient findPatient (String patientId) {
        return patients.stream().
                filter(p-> patientId.equals(p.getPatientId())).
                findFirst().orElse(null);
    }

    public List<Patient> filterPatientsbyCountry(String country) {
        List<Patient> filteredPatients = patients.stream().
                filter(p -> p.getCountry().equals(country)).
                collect(Collectors.toList());
        return filteredPatients;
    }

    public List<Patient> filterPatientsbyfirstName(String firstName) {
        List<Patient> filteredPatients = patients.stream().
                filter(p -> p.getFirstName().equals(firstName)).
                collect(Collectors.toList());
        return filteredPatients;
    }

    public List<Patient> filterPatientsbylastName(String lastName) {
        List<Patient> filteredPatients = patients.stream().
                filter(p -> p.getLastName().equals(lastName)).
                collect(Collectors.toList());
        return filteredPatients;
    }
}

