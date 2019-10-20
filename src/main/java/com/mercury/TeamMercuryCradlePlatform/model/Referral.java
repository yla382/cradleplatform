package com.mercury.TeamMercuryCradlePlatform.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "referral")
public class Referral {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "referral_id")
    private Integer referralId;

    @Column(name = "referred_health_centre")
    private String referredHealthCentre = null;

    @Column(name = "date_time_sent")
    private LocalDate dateTimeSent = LocalDate.now();

    @Column(name = "vht_name")
    private String vhtName = null;

    @Column(name = "reason_of_referral")
    private String reasonOfReferral = null;

    @Column(name = "action_already_taken")
    private String actionAlreadyTaken = null;


    @Column(name = "other_information_message")
    private String otherInformationMessage = null;

    //reading info
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "reading_id", referencedColumnName = "reading_id")
    private Reading reading;

    public Reading getReading() {
        return reading;
    }

    public void setReading(Reading reading) {
        this.reading = reading;
    }

    @Column(name = "bp_systolic")
    public Integer bpSystolic;

    @Column(name = "by_diastolic")
    public Integer bpDiastolic;

    @Column(name = "hear_rate_bpm")
    public Integer heartRateBPM;

    // patient info
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_Id", referencedColumnName = "patient_Id")
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Column(name = "first_name")
    public String firstName;

    @Column(name = "last_name")
    public String lastName;

    @Column(name = "age_years")
    public Integer ageYears;

    @Column(name = "sex")
    public Patient.Sex sex;

    @Column(name = "zone_number")
    public Integer zoneNumber;

    @Column(name = "block_number")
    public Integer blockNumber;

    @Column(name = "tank_number")
    public Integer tankNumber;

    @Column(name = "village_number")
    public Integer villageNumber;

    @Column(name = "household_number")
    public Integer householdNumber;



    public Referral() {
    }

    public Referral(String referredHealthCentre, LocalDate dateTimeSent, String vhtName, String reasonOfReferral, String actionAlreadyTaken, String otherInformationMessage) {
        this.referredHealthCentre = referredHealthCentre;
        this.dateTimeSent = dateTimeSent;
        this.vhtName = vhtName;
        this.reasonOfReferral = reasonOfReferral;
        this.actionAlreadyTaken = actionAlreadyTaken;
        this.otherInformationMessage = otherInformationMessage;
    }

    public Referral(String referredHealthCentre, LocalDate dateTimeSent, String vhtName, String reasonOfReferral, String actionAlreadyTaken, String otherInformationMessage, Patient patient) {
        this.referredHealthCentre = referredHealthCentre;
        this.dateTimeSent = dateTimeSent;
        this.vhtName = vhtName;
        this.reasonOfReferral = reasonOfReferral;
        this.actionAlreadyTaken = actionAlreadyTaken;
        this.otherInformationMessage = otherInformationMessage;
        this.patient = patient;
    }

    public Integer getReferralId() {
        return referralId;
    }

    public void setReferralId(Integer referralId) {
        this.referralId = referralId;
    }

    public String getReferredHealthCentre() {
        return referredHealthCentre;
    }

    public void setReferredHealthCentre(String referredHealthCentre) {
        this.referredHealthCentre = referredHealthCentre;
    }

    public LocalDate getDateTimeSent() {
        return dateTimeSent;
    }

    public void setDateTimeSent(LocalDate dateTimeSent) {
        this.dateTimeSent = dateTimeSent;
    }

    public String getVhtName() {
        return vhtName;
    }

    public void setVhtName(String vhtName) {
        this.vhtName = vhtName;
    }

    public String getReasonOfReferral() {
        return reasonOfReferral;
    }

    public void setReasonOfReferral(String reasonOfReferral) {
        this.reasonOfReferral = reasonOfReferral;
    }

    public String getActionAlreadyTaken() {
        return actionAlreadyTaken;
    }

    public void setActionAlreadyTaken(String actionAlreadyTaken) {
        this.actionAlreadyTaken = actionAlreadyTaken;
    }

    public String getOtherInformationMessage() {
        return otherInformationMessage;
    }

    public void setOtherInformationMessage(String otherInformationMessage) {
        this.otherInformationMessage = otherInformationMessage;
    }
}
