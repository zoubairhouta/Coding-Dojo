package com.ahmedbelhout.omnikujiform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;


@Controller
public class OmikujiFormController {
	
	// Redirect to /omikuji
	@RequestMapping("/")
	public String index() {
		return "redirect:/omikuji";
	}
	//Display
	@RequestMapping("/omikuji")
	public String form() {
		return "form.jsp";
	}
	// Action
	@RequestMapping(value="/processForm", method=RequestMethod.POST)
	public String processForm(@RequestParam(value="number") Integer number,
								@RequestParam(value="city") String city,
								@RequestParam(value="person") String person,
								@RequestParam(value="hobby") String hobby,
								@RequestParam(value="livingThing") String livingThing,
								@RequestParam(value="messege") String messege,
								HttpSession session) {
		// add form data in session
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("livingThing", livingThing);
		session.setAttribute("messege", messege);
		
		// Always use "Redirect" for POST / do not render jsp file!
		return "redirect:/omikuji/show";
	}
	// Display
	@RequestMapping("/omikuji/show")
	public String show() {
		return "show.jsp";
	}
	
	
}