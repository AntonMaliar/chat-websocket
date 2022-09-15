package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

public class User {
	private int id;
	private String name;
	private String surname;
	//id recipient - id chat
	private Map<Integer, Integer>listOfChats;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Map<Integer, Integer> getListOfChats() {
		return listOfChats;
	}
	public void setListOfChats(Map<Integer, Integer> listOfChats) {
		this.listOfChats = listOfChats;
	}
	public User(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
		this.listOfChats = new HashMap<>();
	}
	public boolean chatExist(Integer recipientId) {
		return listOfChats.containsKey(recipientId);
	}
	public int getChatId(Integer recipientId) {
		return listOfChats.get(recipientId);
	}
	public void setChatId(Integer recipientId, Integer chatId) {
		listOfChats.put(recipientId, chatId);
	}
	
	
	
}	
