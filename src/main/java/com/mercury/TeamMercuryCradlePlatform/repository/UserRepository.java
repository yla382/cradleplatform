package com.mercury.TeamMercuryCradlePlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mercury.TeamMercuryCradlePlatform.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUserId(Integer userid);
    public List<User> findAll();
}
