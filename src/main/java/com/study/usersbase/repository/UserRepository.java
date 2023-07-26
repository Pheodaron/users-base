package com.study.usersbase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.usersbase.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {}
