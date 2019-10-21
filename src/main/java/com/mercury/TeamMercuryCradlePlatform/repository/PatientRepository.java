package com.mercury.TeamMercuryCradlePlatform.repository;

import com.mercury.TeamMercuryCradlePlatform.model.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
    public List<Patient> findAll();
    @Query("SELECT c FROM Patient c WHERE c.patientId = id")
    Patient findByPatientId(@Param("id") Long id);

    @Query("SELECT c FROM Patient c WHERE c.firstName LIKE %?1%")
    List<Patient> findAllByFirstNameLike(String firstName);

    Patient findByFirstNameAndLastNameAndAgeYears(String firstName, String lastName, Integer ageYears);
    Boolean existsByFirstNameAndLastNameAndAgeYears(String firstName, String lastName, Integer agYears);


    @Query("SELECT c FROM Patient c WHERE c.lastName LIKE %?1%")
    List<Patient> findAllByLastNameLike(String lastName);

}
