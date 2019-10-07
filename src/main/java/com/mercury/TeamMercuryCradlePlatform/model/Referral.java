package com.mercury.TeamMercuryCradlePlatform.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

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
    private LocalDateTime dateTimeSent = LocalDateTime.now();

    @Column(name = "vht_name")
    private String vhtName = null;

    @Column(name = "reason_of_referral")
    private String reasonOfReferral = null;

    @Column(name = "action_already_taken")
    private String actionAlreadyTaken = null;

//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "reading")
//    private Reading reading;
//
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "patient")
//    private Patient patient;

    public Referral() {
    }

    public Referral(String referredHealthCentre, LocalDateTime dateTimeSent, String vhtName, String reasonOfReferral, String actionAlreadyTaken) {
        this.referredHealthCentre = referredHealthCentre;
        this.dateTimeSent = dateTimeSent;
        this.vhtName = vhtName;
        this.reasonOfReferral = reasonOfReferral;
        this.actionAlreadyTaken = actionAlreadyTaken;
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

    public LocalDateTime getDateTimeSent() {
        return dateTimeSent;
    }

    public void setDateTimeSent(LocalDateTime dateTimeSent) {
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

}
