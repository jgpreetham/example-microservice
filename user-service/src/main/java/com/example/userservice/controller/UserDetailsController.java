package com.example.userservice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.model.UserDetails;
import com.example.userservice.service.UserDetailsService;
import com.example.userservice.validator.UserIdNumeric;

@RestController
@RequestMapping("/userdetails")
@Validated
public class UserDetailsController {
	@Autowired
	private UserDetailsService userService;

	/**
	 *This method is used to get all the user details
	 */
	@GetMapping
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public List<UserDetails> getAllUsers() {
		List<UserDetails> users = userService.getAllUsers();
		return users;
	}
	
	/**
	 *This method is used to create new user details
	 * 
	 */
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public UserDetails createUser(@RequestBody UserDetails userDetails) {
		UserDetails tempUserDetails = userService.createUserDetails(userDetails);
		List<UserDetails> userDetailsList = new ArrayList<>();
		userDetailsList.add(tempUserDetails);
		return tempUserDetails;
	}

	/**
	 * This method is used to get the user details based on the user id
	 */

	@GetMapping("/{userId}")
	@PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
	public UserDetails getSingleUser(@PathVariable("userId") @UserIdNumeric String id) {
		UserDetails tempUserDetails = userService.getSingleUserDetails(Long.parseLong(id));
		List<UserDetails> userDetailsList = new ArrayList<>();
		userDetailsList.add(tempUserDetails);
		return tempUserDetails;
	}

	/**
	 * This method is used to update the user details
	 */
	@PutMapping("/{userId}")
	@PreAuthorize("hasRole('ADMIN')")
	public UserDetails updateUser(@PathVariable("userId") @UserIdNumeric String id,
			@RequestBody UserDetails userDetails) {
		UserDetails tempUserDetails = userService.updateUserDetails(Long.parseLong(id), userDetails);
		List<UserDetails> userDetailsList = new ArrayList<>();
		userDetailsList.add(tempUserDetails);
		return tempUserDetails;
	}

	/**
	 * This method is used to delete the user detyails
	 */
	@DeleteMapping("/{userId}")
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteSingleUser(@PathVariable("userId") @UserIdNumeric String id) {
		userService.deleteUser(Long.parseLong(id));
	}

}
