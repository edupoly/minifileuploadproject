package com.edupoly.practice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.edupoly.practice.entity.User;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
