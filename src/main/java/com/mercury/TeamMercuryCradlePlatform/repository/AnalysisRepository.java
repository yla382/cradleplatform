package com.mercury.TeamMercuryCradlePlatform.repository;

import com.mercury.TeamMercuryCradlePlatform.model.Analysis;
import com.mercury.TeamMercuryCradlePlatform.model.Patient;
import com.mercury.TeamMercuryCradlePlatform.model.Reading;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public interface AnalysisRepository extends CrudRepository<Analysis, Long> {
    public List<Analysis> findAll();
    public Analysis findByAnalysisId(Long id);
    public Analysis findByReading(Reading reading);
    public Analysis getOneByReading(Reading reading);



    // For Patient stats
    public Integer countAllByIsGreenEqualsAndPatient(Boolean isGreen, Patient patient);
    public Integer countAllByIsYellowEqualsAndPatient(Boolean isGreen, Patient patient);
    public Integer countAllByIsRedEqualsAndPatient(Boolean isGreen, Patient patient);
}
