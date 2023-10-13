package com.ahmedbelhout.dojoandninja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ahmedbelhout.dojoandninja.models.Dojo;
import com.ahmedbelhout.dojoandninja.models.Ninja;
import com.ahmedbelhout.dojoandninja.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	@Autowired
	private DojoService dojoService;

	@GetMapping("/fff")
	public String home() {
		return "index.jsp";
	}

	@GetMapping("/")
	public String dojocreate(Model model, @ModelAttribute("dojo") Dojo dojo) {
		return "newDojo.jsp";
	}

	@PostMapping("/dojo/new")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo,	BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "showDojo.jsp";
		} else {
			dojoService.createDojo(dojo);
			return "redirect:/ninjas/new";
		}
	}

}
