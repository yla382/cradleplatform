package com.mercury.TeamMercuryCradlePlatform.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercury.TeamMercuryCradlePlatform.model.AndroidReading;
import com.mercury.TeamMercuryCradlePlatform.model.Patient;
import com.mercury.TeamMercuryCradlePlatform.model.Reading;
import com.mercury.TeamMercuryCradlePlatform.repository.PatientRepository;
import com.mercury.TeamMercuryCradlePlatform.repository.ReadingRepository;
import com.twilio.twiml.MessagingResponse;
import com.twilio.twiml.messaging.Body;
import com.twilio.twiml.messaging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Controller
public class TwilioServlet {
    @Autowired
    private ReadingRepository readingRepository;
    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping(value="/receive/sms", method=RequestMethod.POST)
    public String someMethod(@RequestBody String message, @RequestParam("Body") String body, @RequestParam("From") String From) throws IOException {
        System.out.println(message);
        System.out.println("Body: " + body);

        ObjectMapper mapper = new ObjectMapper();
        List<AndroidReading> readingList = mapper.readValue(body, new TypeReference<List<AndroidReading>>(){});

        for (AndroidReading androidReading : readingList) {
            Reading reading = new Reading(androidReading);
            Patient patient = patientRepository.findByFirstNameAndLastNameAndAgeYears(androidReading.getPatientFirstName(), androidReading.getPatientLastName(), androidReading.getAgeYears());

            if(patient != null) {
                reading.setPatient(patient);
                readingRepository.save(reading);
            } else {
                reading.setPatient(new Patient(reading));
                readingRepository.save(reading);
            }
        }

        return "Good job";
    }
}