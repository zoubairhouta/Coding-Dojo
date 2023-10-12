package com.ahmedbelhout.burgertracker.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ahmedbelhout.burgertracker.models.Burger;
import com.ahmedbelhout.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgersController {
	@Autowired
	BurgerService burgerService;
	
	@GetMapping("/")
	public String home() {
		return "redirect:/burgers";
	}
	
	@GetMapping("/burgers")
	public String index(Model model, @ModelAttribute("burger") Burger burger) {
		
		List<Burger> burgers = burgerService.allBurgers();
        model.addAttribute("burgers", burgers);
        return "index.jsp";
	}
	 @PostMapping("/burgers")
	    public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result ,Model model) {
			List<Burger> burgers = burgerService.allBurgers();
	        model.addAttribute("burgers", burgers);
	        if (result.hasErrors()) {
	            return "index.jsp";
	        } else {
	            burgerService.createBurger(burger);
	            return "redirect:/burgers";
	        }
	    }
	
	
	
}
