package com.groupwithprojects.Task_Springboot.repositories;

import com.groupwithprojects.Task_Springboot.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository  extends JpaRepository<User, Long> {
    Optional<User> findFirstByEmail(String UserName);
}
