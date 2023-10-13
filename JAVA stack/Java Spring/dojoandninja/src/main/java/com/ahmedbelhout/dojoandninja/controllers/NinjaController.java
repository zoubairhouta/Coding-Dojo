package com.ahmedbelhout.dojoandninja.controllers;

import java.util.List;

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
import com.ahmedbelhout.dojoandninja.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {

	@Autowired
	NinjaService ninjaService;
	@Autowired
	DojoService dojoService;

	@GetMapping("/ninjas/new")
	public String dojocreate(Model model, @ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> dojos = dojoService.findAll();
		model.addAttribute("dojos", dojos);
		return "newNinja.jsp";
	}

	@PostMapping("/ninja/new")
	public String createNewNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {

		if (result.hasErrors()) {
			List<Dojo> dojos = dojoService.findAll();
			model.addAttribute("dojos", dojos);
			return "newNinja.jsp";
		} else {
			Ninja ninj = ninjaService.createNinja(ninja);
			String path = "redirect:/index/"+ninj.getDojo().getId();
			return path;
		}
	}
	@GetMapping("/index/{id}")
	public String index (@PathVariable("id") Long id,Model model)
	{
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "index.jsp";
	}

}
