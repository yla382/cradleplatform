package com.example.TeamMercuryCradlePlatform.Repository;

import com.example.TeamMercuryCradlePlatform.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository <User, Integer>{
    User findByUserId(Integer userid);

}
