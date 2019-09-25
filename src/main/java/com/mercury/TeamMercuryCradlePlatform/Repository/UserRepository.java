package com.mercury.TeamMercuryCradlePlatform.Repository;

import com.mercury.TeamMercuryCradlePlatform.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <User, Integer>{
    User findByUserId(Integer userid);
}
