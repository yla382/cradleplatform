package com.mercury.TeamMercuryCradlePlatform.model;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SMSAdmin {
    private static final String ACCOUNT_SID = "AC5da00db224e5944c1adfc31a4cc2ed39";
    private static final String AUTH_TOKEN = "86455d383ee3936f2c485493feb01111";
    private static final String TEST_ACCOUNT_SID = "ACf642c0a453d01157ee42aa2709057541";
    private static final String TEST_AUTH_TOKEN = "ce8c1b5402a404d8367d057e51f27331";
    private static final String TWILIO_NUMBER = "+12078020179";

    public SMSAdmin() {

    }

    private String createText(String subject, String text) {
        return "Subject: " + subject + "\n\n" + text;
    }

    public void sendText(String phoneNumber, String subject, String text) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(
                new PhoneNumber(phoneNumber),
                new PhoneNumber(TWILIO_NUMBER),
                createText(subject, text))
                .create();
    }

    public void testSendText(String phoneNumber, String subject, String text) {
        Twilio.init(TEST_ACCOUNT_SID, TEST_AUTH_TOKEN);
        Message message = Message.creator(
                new PhoneNumber(phoneNumber),
                new PhoneNumber(TWILIO_NUMBER),
                createText(subject, text))
                .create();
    }
}

