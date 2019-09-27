package com.mercury.TeamMercuryCradlePlatform.Repository;

import com.mercury.TeamMercuryCradlePlatform.Model.Reading;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReadingRepository extends CrudRepository<Reading, Long> {
}
