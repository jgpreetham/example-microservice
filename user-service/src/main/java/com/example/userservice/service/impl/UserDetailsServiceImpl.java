package com.example.userservice.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.userservice.dao.UserDetailsDao;
import com.example.userservice.exception.UserAlreadyExistsException;
import com.example.userservice.model.UserDetails;
import com.example.userservice.service.UserDetailsService;

@Service("userDetailsService")
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	UserDetailsDao userDetailsDao;

	/**
	 * This method is used to update the user details
	 */
	@Override
	public UserDetails updateUserDetails(long id, UserDetails user) {
		user.setUserId(id);
		Optional<UserDetails> optionalUser = userDetailsDao.findById(user.getUserId());
		if (!optionalUser.isPresent()) {
			throw new ResourceNotFoundException("User with id " + id + " not found");
		}
		optionalUser.ifPresent(u -> {
			user.setUserId(u.getUserId());
		});
		UserDetails tempUser = userDetailsDao.save(user);
		return tempUser;
	}

	/**
	 * This method is used to get the user details based on the user id
	 */
	@Override
	public UserDetails getSingleUserDetails(long id) {
		Optional<UserDetails> optionalUser = userDetailsDao.findById(id);
		if (!optionalUser.isPresent()) {
			throw new ResourceNotFoundException("User with id " + id + " not found");
		}
		UserDetails user = optionalUser.isPresent() ? optionalUser.get() : null;
		return user;
	}

	/**
	 * This method is used to get all the users
	 */
	@Override
	public List<UserDetails> getAllUsers() {
		List<UserDetails> users = userDetailsDao.findAll();
		return users;
	}

	/**
	 *This method is used to delete the user
	 */
	@Override
	public void deleteUser(long id) {
		Optional<UserDetails> optionalUser = userDetailsDao.findById(id);
		if (optionalUser.isPresent()) {
			userDetailsDao.deleteById(id);
		} else {
			throw new ResourceNotFoundException("User with id " + id + " not found");
		}

	}

	/**
	 * This method is used to create the user details
	 */
	@Override
	public UserDetails createUserDetails(UserDetails user) {
		Optional<UserDetails> optionalUser = userDetailsDao.findById(user.getUserId());
		if (optionalUser.isPresent()) {
			throw new UserAlreadyExistsException("User with id " + user.getUserId() + " already exists");
		} else {
			userDetailsDao.save(user);
		}
		return user;
	}

}
