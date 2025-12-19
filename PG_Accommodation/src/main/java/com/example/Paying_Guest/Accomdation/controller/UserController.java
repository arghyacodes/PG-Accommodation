package com.example.Paying_Guest.Accomdation.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Paying_Guest.Accomdation.entities.User;
import com.example.Paying_Guest.Accomdation.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {
private final UserRepository userRepo;
public UserController(UserRepository userRepo) {
this.userRepo = userRepo;
}
@GetMapping
public List<User> getAll() {
return userRepo.findAll();
}
@GetMapping("/{id}")
public User getById(@PathVariable Long id) {
return userRepo.findById(id).orElseThrow();
}
}