package com.mercury.TeamMercuryCradlePlatform.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mercury.TeamMercuryCradlePlatform.Model.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    public User findByUserId(Integer userid);
    public List<User> findAll();
//    @Modifying
//    @Query
//            ("update user u set u.first_name = :firstName, u.last_name = :lastName, u.email = :email, u.password = :password, u.roles = :roles where u.user_id = id")
//    public User updateUser(Integer id, User user);
}
