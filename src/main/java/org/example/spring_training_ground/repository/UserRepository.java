package org.example.spring_training_ground.repository;

import org.example.spring_training_ground.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
