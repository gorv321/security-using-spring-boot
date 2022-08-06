package com.learn.sevices;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

import com.learn.models.User;
@Service
public class UserService {

	List<User> list=new ArrayList<>();

	public UserService(List<User> list) {
		super();
		this.list = list;
	}
	public UserService() {
		list.add(new User("abc","abc","abc@gmail.com"));
		list.add(new User("zyx","zyx","abc@gmail.com"));
		list.add(new User("xyz","xyz","abc@gmail.com"));
	}
	public List<User> getAllUsers(){
		return this.list;}
		
	
	public User getUser(String username) {
		return this.list.stream().filter((user)->user.getUsername().equals(username)).findAny().orElse(null);
		
	}
	public User addUser(User user) {
		this.list.add(user);
		return user;
	}
	
}
