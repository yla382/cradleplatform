package com.mercury.TeamMercuryCradlePlatform.model;

import com.twilio.Twilio;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.type.PhoneNumber;
import org.springframework.web.bind.annotation.RequestMapping;

import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.TwiMLException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

//    public void sendText(String phoneNumber, String subject, String text) {
//        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
//        Message message = Message.creator(
//                new PhoneNumber(phoneNumber),
//                new PhoneNumber(TWILIO_NUMBER),
//                createText(subject, text))
//                .create();
//    }
//
//    public void testSendText(String phoneNumber, String subject, String text) {
//        Twilio.init(TEST_ACCOUNT_SID, TEST_AUTH_TOKEN);
//        Message message = Message.creator(
//                new PhoneNumber(phoneNumber),
//                new PhoneNumber(TWILIO_NUMBER),
//                createText(subject, text))
//                .create();
//    }

    @RequestMapping(value = "/receive/sms", produces="application/xml")
    public void receiveSms(HttpServletRequest request, HttpServletResponse response) {
        Twilio.init(TEST_ACCOUNT_SID, TEST_AUTH_TOKEN);
        String body = request.getParameter("Body");
        System.out.println(body);

        String message = "Hello world";

        // Create a TwiML response and add our friendly message.
        Body messageBody = new Body.Builder(message).build();
        Message sms = new Message.Builder().body(messageBody).build();
        MessagingResponse twiml = new MessagingResponse.Builder().message(sms).build();

        response.setContentType("application/xml");

        try {
            response.getWriter().print(twiml.toXml());
        } catch (TwiMLException | IOException e) {
            e.printStackTrace();
        }

    }


}

