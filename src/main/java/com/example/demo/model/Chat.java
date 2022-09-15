package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Chat {
	private int id;
	private List<Message> chatHistory;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Chat() {
		super();
		chatHistory = new ArrayList<>();
	}
	public List<Message> getChatHistory() {
		return chatHistory;
	}
	public void setChatHistory(List<Message> chatHistory) {
		this.chatHistory = chatHistory;
	}
	public void addMessage(Message message) {
		chatHistory.add(message);
	}
	
	
}
