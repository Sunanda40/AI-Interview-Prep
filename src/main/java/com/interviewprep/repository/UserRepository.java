package com.interviewprep.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interviewprep.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);

}
