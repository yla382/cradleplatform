package com.mercury.TeamMercuryCradlePlatform.Service;

import com.mercury.TeamMercuryCradlePlatform.model.EmailAdmin;
import com.mercury.TeamMercuryCradlePlatform.model.SMSAdmin;

import javax.validation.constraints.Email;

public class ContactService {
    private EmailAdmin emailAdmin;
    private SMSAdmin smsAdmin;

    public ContactService() {
        emailAdmin = new EmailAdmin();
        smsAdmin = new SMSAdmin();
    }

    public ContactService(EmailAdmin emailAdmin, SMSAdmin smsAdmin) {
        this.emailAdmin = emailAdmin;
        this.smsAdmin = smsAdmin;
    }

    public void sendMessage(String contactType, String email, String phoneNumber, String subject, String text) {
        if(contactType.equals("email")) {
            emailAdmin.sendEmail(email, subject, text);
        } else {
            smsAdmin.sendText(phoneNumber, subject, text);
        }
    }
}
