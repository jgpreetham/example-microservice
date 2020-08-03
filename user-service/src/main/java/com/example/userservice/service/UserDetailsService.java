package com.example.userservice.service;

import java.util.List;

import com.example.userservice.model.UserDetails;

public interface UserDetailsService {
	public UserDetails createUserDetails(UserDetails user);

	public List<UserDetails> getAllUsers();

	public UserDetails updateUserDetails(long id, UserDetails user);

	public UserDetails getSingleUserDetails(long id);

	public void deleteUser(long id);

}
