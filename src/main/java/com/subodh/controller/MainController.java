package com.subodh.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.subodh.model.User;

@Controller
public class MainController {
	
	 @Value("${countries}")
	    private List<String> countries;

	    @Value("${gender}")
	    private List<String> genders;

	    @Value("${skills}")
	    private List<String> skills;

	@GetMapping("/home/{name}")
	public String home(@PathVariable String name ,Model model) {
		model.addAttribute("username", name);
		model.addAttribute("date", new Date());
		return "home";
	}
	@GetMapping("/show_form")
	public String showform(Model model) {
		User user = new User();
		model.addAttribute("userObj", user);
        model.addAttribute("countries", countries);
        model.addAttribute("genders", genders);
        model.addAttribute("skills", skills);
		return "user";
	}
//	@GetMapping("/show_form")
//	public String showform(Model model) {
//		User user = new User();
//		user.setFirstName("1");
//		user.setFirstName("subodh");
//		user.setLastname("nagarkar");
//		user.setEmail("subodh@gmail.com");
//		model.addAttribute("userObj", user);
//		return "user";
//	}
	
	@PostMapping("/processForm")
	public String processForm(@ModelAttribute("userObj") User user ,Model model) {
		model.addAttribute("firstName", user.getFirstName());
		model.addAttribute("lastName", user.getLastName());
		model.addAttribute("email", user.getEmail());
		model.addAttribute("uId", user.getUId());
		 model.addAttribute("country", user.getCountry());
	        model.addAttribute("gender", user.getGender());
	        model.addAttribute("userSkills", user.getUserSkills());
		return "confirm";
	}
	
	@PostMapping("/processForm2")
	public String processForm2(@RequestParam String firstName,String lastName,String email,Model model) {
		model.addAttribute("firstName", firstName);
		model.addAttribute("lastName", lastName);
		model.addAttribute("emailid", email);
		
		return "confirm";
	}

}
