package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Chat;

public class ChatDAO {
	private static List<Chat>listOfChat = new ArrayList<>();
	private static int index = 0;
	
	public static List<Chat> getListOfChat() {
		return listOfChat;
	}
	public static void setListOfChat(List<Chat> listOfChat) {
		ChatDAO.listOfChat = listOfChat;
	}
	public static Integer addChat(Chat chat) {
		chat.setId(index++);
		listOfChat.add(chat);
		return index-1;
	}
	public static Chat getChat(int chatId) {
		return listOfChat.get(chatId);
	}
}
