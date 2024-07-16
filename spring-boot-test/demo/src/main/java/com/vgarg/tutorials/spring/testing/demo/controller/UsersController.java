package com.vgarg.tutorials.spring.testing.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vgarg.tutorials.spring.testing.demo.entity.User;

@RestController
public class UsersController {

	 @GetMapping("/app-users")
	 public ResponseEntity<User> getUser() {
		User user = User.builder().firstName("John").lastName("Doe").build(); 
		return ResponseEntity.ok(user);
	 }
}
