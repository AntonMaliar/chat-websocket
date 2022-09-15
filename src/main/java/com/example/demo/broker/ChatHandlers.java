package com.example.demo.broker;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.demo.dao.ChatDAO;
import com.example.demo.model.Chat;
import com.example.demo.model.Message;

@Controller
public class ChatHandlers {
	@MessageMapping("/{chatId}")
	@SendTo("/my-broker/{chatId}")
	  public Message greeting(Message message, @Header("chatId")int chatId) throws Exception {
		Chat chat = ChatDAO.getChat(chatId);
		message.setDate(DateFormat.getInstance().format(new Date()));
		chat.addMessage(message);
	    return message;
	  }
}
