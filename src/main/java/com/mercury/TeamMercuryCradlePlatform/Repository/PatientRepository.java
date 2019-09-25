package com.mercury.TeamMercuryCradlePlatform.Repository;

import com.mercury.TeamMercuryCradlePlatform.Model.Patient;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Integer> {
    @Query("SELECT c FROM Patient c WHERE c.firstName LIKE %?1%")
    List<Patient> findAllByFirstNameLike(String firstName);

}
