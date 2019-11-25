package com.mercury.TeamMercuryCradlePlatform.Service;

import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class TwilioServlet {
    @RequestMapping(value="/receive/sms", method=RequestMethod.POST)
    public String someMethod(@RequestBody String message, @RequestParam("Body") String body) {
        System.out.println(message);
        System.out.println("THIS IS THE BODY: " + body);


        // Create a TwiML response and add our friendly message.
        Body messageBody = new Body.Builder(message).build();
        Message sms = new Message.Builder().body(messageBody).build();
        MessagingResponse twiml = new MessagingResponse.Builder().message(sms).build();

        return twiml.toXml();
    }
//    public String service(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String body = request.getParameter("Body");
//        String message = "Message";
//        if (body.equals("hello")) {
//            // Say hi
//            message = "Hi there!";
//        } else if (body.equals("bye")) {
//            // Say goodbye
//            message = "Goodbye!";
//        }
//
//        // Create a TwiML response and add our friendly message.
//        Body messageBody = new Body.Builder(message).build();
//        Message sms = new Message.Builder().body(messageBody).build();
//        MessagingResponse twiml = new MessagingResponse.Builder().message(sms).build();
//
//        response.setContentType("application/xml");
//
//        try {
//            response.getWriter().print(twiml.toXml());
//        } catch (TwiMLException e) {
//            e.printStackTrace();
//        }
//    }
}