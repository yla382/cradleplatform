package com.example.TeamMercuryCradlePlatform.Repository;

import com.example.TeamMercuryCradlePlatform.Model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository <User, Integer>{
    public User findByUserId(Integer userid);
}
