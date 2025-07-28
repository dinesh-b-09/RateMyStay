package com.authh.repo;

import com.authh.entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<Users,Integer> {

    Users findByUsername(String userName);
}
