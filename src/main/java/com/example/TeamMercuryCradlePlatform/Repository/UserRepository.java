package com.example.TeamMercuryCradlePlatform.Repository;

import com.example.TeamMercuryCradlePlatform.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUserId(Integer userid);
}
