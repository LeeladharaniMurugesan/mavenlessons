package com.chainsys.mavenlessons.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chainsys.mavenlessons.entity.User;
import com.chainsys.mavenlessons.repository.UserRepository;
@Service
public class UserServices {

	@Autowired
	private UserRepository Repo;
	public void addUser(User user) {
		Repo.save(user);
	}
	public User findUserById(int id) {
		return Repo.findById(id);
	}
	public List<User> getUsers(){
		return Repo.findAll();
	}
	public void modifyUser(User user) {
//		TODO: validate User.id before uRepo.save()
		Repo.save(user);
	}
	public void deleteUserById(int id) {
		Repo.deleteById(id);
	} 
}