package com.example.Paying_Guest.Accomdation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Paying_Guest.Accomdation.entities.User;

import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {
static Optional<User> findByEmail(String email) {
	// TODO Auto-generated method stub
	return null;
}
}
