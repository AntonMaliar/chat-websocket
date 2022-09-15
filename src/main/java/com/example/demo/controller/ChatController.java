package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.dao.ChatDAO;
import com.example.demo.dao.UserDAO;
import com.example.demo.model.Chat;
import com.example.demo.model.User;

@Controller
public class ChatController {
	@GetMapping("/chat")
	public String openChat(HttpServletRequest request, Model model) {
		User sender = UserDAO.getUser(Integer.parseInt(request.getParameter("senderId")));
		User recipient = UserDAO.getUser(Integer.parseInt(request.getParameter("recipientId")));
		Chat chat = null;
		
		if(sender.chatExist(recipient.getId())) {
			int chatId = sender.getChatId(recipient.getId());
			chat = ChatDAO.getChat(chatId);
		}else {
			chat = new Chat();
			int chatId = ChatDAO.addChat(chat);
			sender.setChatId(recipient.getId(), chatId);
			recipient.setChatId(sender.getId(), chatId);
		}
		model.addAttribute("chat", chat);
		model.addAttribute("sender", sender);
		return "chat";
	}
}
