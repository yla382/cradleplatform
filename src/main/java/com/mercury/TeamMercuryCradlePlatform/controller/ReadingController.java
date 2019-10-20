package com.mercury.TeamMercuryCradlePlatform.controller;

import com.mercury.TeamMercuryCradlePlatform.model.Patient;
import com.mercury.TeamMercuryCradlePlatform.model.Reading;
import com.mercury.TeamMercuryCradlePlatform.model.ReadingAnalysis;
import com.mercury.TeamMercuryCradlePlatform.repository.PatientRepository;
import com.mercury.TeamMercuryCradlePlatform.repository.ReadingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/reading")
public class ReadingController {

    private PatientRepository patientRepository;
    private ReadingRepository readingRepository;

    ReadingController(PatientRepository patientRepository, ReadingRepository readingRepository){
        this.patientRepository = patientRepository;
        this.readingRepository = readingRepository;
    }

    // Create a new reading
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public ModelAndView readingPage(){
        return new ModelAndView("/reading/create");
    }


    // Produce the analysis after creating a reading
    @RequestMapping(value = "/analysis", method = RequestMethod.POST)
    public @ResponseBody ModelAndView readingAnalysisPage(
            Reading reading,
            @RequestParam(value = "otherSymptoms", defaultValue = "") String otherSymptoms) {
        reading.dateTimeTaken = ZonedDateTime.now();

        if(reading.symptoms.size() == 0){
            reading.symptoms.add("No Symptoms (patient healthy)");
        }
        else{
            if(!otherSymptoms.isEmpty()){
                reading.symptoms.add(otherSymptoms);
            }
        }

        ModelAndView modelAndView = new ModelAndView("/reading/analysis");
        modelAndView.addObject("reading", reading);

        return modelAndView;

    }

    // Save the reading to the db
    @RequestMapping(value = "/analysis/save", method = RequestMethod.POST)
    public String saveReadingToDB(Reading reading, @RequestParam(value = "dateTimeTaken") String timeTaken, @RequestParam(value = "gestationalAgeUnit") String value) {

        // Need to manually set these fields again otherwise it saves it as null in db
        reading.gestationalAgeUnit = Reading.GestationalAgeUnit.valueOf(value);
        reading.dateTimeTaken = ZonedDateTime.parse(timeTaken);
        reading.dateUploadedToServer = ZonedDateTime.now();

        // If a patient exists with the same first, last and age then link this reading to the existing patient, else create new patient
        Patient patient = patientRepository.findByFirstNameAndLastNameAndAgeYears(reading.firstName, reading.lastName, reading.ageYears);

        if(patient != null){
            reading.setPatient(patient);
            readingRepository.save(reading);
        }
        else{
            reading.setPatient(new Patient(reading));
            readingRepository.save(reading);
        }

        return "/reading/all";
    }


    // View all readings
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ModelAndView getAllUsers(){
        return setUpAllReadingModel();
    }

    // Save a reading after editing from the view all readings table
    @RequestMapping(value = "/all/edit", method = RequestMethod.POST)
    public ModelAndView getAllReadings(Reading reading){
        this.readingRepository.save(reading);
        return setUpAllReadingModel();
    }

    // Edit a reading with the given id
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView getUserWithId(@PathVariable long id){
        Reading reading = this.readingRepository.findByReadingId(id);
        return new ModelAndView("/reading/editReading").addObject("reading", reading);
    }

    // Delete a reading with the given id
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.POST)
    public ModelAndView deleteUserWithId(@PathVariable long id){
        this.readingRepository.delete(this.readingRepository.findByReadingId(id));
        return setUpAllReadingModel();
    }

    // Create a model for view all readings and pass in a List of reading objects
    private ModelAndView setUpAllReadingModel(){
        return new ModelAndView("/reading/all").addObject("readingList", this.readingRepository.findAll());
    }

}
