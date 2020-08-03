package com.example.userservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userservice.model.UserDetails;

@Repository
public interface UserDetailsDao extends JpaRepository<UserDetails, Long> {

}
