package com.mercury.TeamMercuryCradlePlatform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mercury.TeamMercuryCradlePlatform.Model.User;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUserId(Integer userid);
}
