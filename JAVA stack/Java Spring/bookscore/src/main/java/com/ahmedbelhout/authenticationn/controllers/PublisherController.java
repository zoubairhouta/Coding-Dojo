package com.ahmedbelhout.authenticationn.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ahmedbelhout.authenticationn.models.Publisher;
import com.ahmedbelhout.authenticationn.services.PublisherService;

import jakarta.validation.Valid;

@Controller
public class PublisherController {

	@Autowired
	private PublisherService pubServ;

	// View Route - Display "publishers.jsp"
	@GetMapping("/publishers")
	public String allPublishers(@ModelAttribute("publisher") Publisher publisher, Model model) {
		List<Publisher> allPublishers = pubServ.findAll();
		model.addAttribute("PublishersList", allPublishers);
		return "publisher/publishers.jsp";
	}

	// Action Route - Create a Publisher
	@PostMapping("/pubs")
	public String createPublisher(@Valid @ModelAttribute("publisher") Publisher publisher,
			BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			List<Publisher> allPublishers = pubServ.findAll();
			model.addAttribute("PublishersList", allPublishers);
			return "publisher/publishers.jsp";
		} else {
			// if there are no errors, save the publisher
			pubServ.createPublisher(publisher);
			return "redirect:/publishers";
		}

	}

	// View Route - Display One Publisher
	@GetMapping("/publishers/{id}")
	public String showOne(@PathVariable("id") Long id, Model model) {
		// grab the publisher object
		Publisher selectedPublisher = pubServ.findPublisher(id);
		model.addAttribute("publisher", selectedPublisher);
		return "publisher/showOne.jsp";
	}

}