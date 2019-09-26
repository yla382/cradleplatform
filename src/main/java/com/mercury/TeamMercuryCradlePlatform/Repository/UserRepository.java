package com.mercury.TeamMercuryCradlePlatform.Repository;

import com.mercury.TeamMercuryCradlePlatform.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository <User, Integer>{
    public User findByUserId(Integer userid);
}
