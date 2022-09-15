package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.User;

public class UserDAO {
	private static List<User>listOfUsers = new ArrayList<>();
	private static int index = 0;
	
	static {
		addUser(new User("anton","maliar"));
		addUser(new User("sergiy","koval"));
	}
	
	public static List<User> getListOfUsers() {
		return listOfUsers;
	}
	public static void setListOfUsers(List<User> listOfUsers) {
		UserDAO.listOfUsers = listOfUsers;
	}
	public static void addUser(User user) {
		user.setId(index++);
		listOfUsers.add(user);
	}
	public static User getUser(int userId) {
		return listOfUsers.get(userId);
	}
	public static List<User> listOfRecipients(int senderId){
		List<User>list = new ArrayList<>();
		list.addAll(listOfUsers);
		list.remove(senderId);
		return list;
	}
	
}	
