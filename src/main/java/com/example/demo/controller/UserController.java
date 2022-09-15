package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;

@Controller
public class UserController {
	@GetMapping("/")
	public String welcomePage(Model model) {
		model.addAttribute("listOfUsers", UserDAO.getListOfUsers());
		return "index";
	}
	@PostMapping("/create-new-user")
	public String createUser(HttpServletRequest request) {
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		UserDAO.addUser(new User(name,surname));
		return "redirect:/";
	}
	@GetMapping("/user-profile")
	public String openProfile(HttpServletRequest request, Model model) {
		User user = UserDAO.getUser(Integer.parseInt(request.getParameter("id")));
		model.addAttribute("user", user);
		model.addAttribute("listOfRecipients", UserDAO.listOfRecipients(user.getId()));
		return "user-profile";
	}
}

