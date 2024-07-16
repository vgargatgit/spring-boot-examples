package com.vgarg.tutorials.spring.testing.demo.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vgarg.tutorials.spring.testing.demo.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
