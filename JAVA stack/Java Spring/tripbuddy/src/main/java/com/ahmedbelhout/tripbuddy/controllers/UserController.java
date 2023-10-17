package com.ahmedbelhout.tripbuddy.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ahmedbelhout.tripbuddy.models.LoginUser;
import com.ahmedbelhout.tripbuddy.models.User;
import com.ahmedbelhout.tripbuddy.services.TripService;
import com.ahmedbelhout.tripbuddy.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
@Controller
public class UserController {
	@Autowired
	private UserService userService;
//famma des liens bech nest7a9ou fehom el logic mt3 el trips 
	@Autowired
	private TripService tripService;

	
	
	// hedhi el home page mt3 el project naba3thoulha 2 Objects
	//el object louleni el newUser instance mel User elli fih les validations el koll w les champs el kolls 
	// el objects el theni el newLogin elli bech ntastiw bih el login fi nafs el page 
	
	@GetMapping("/")
	public String index(Model model) {
	    model.addAttribute("newUser", new User());
	    model.addAttribute("newLogin", new LoginUser());
	    return "index.jsp";
	}

	
	//Action route for registering 
	//nab3thou Object feregh User newUser b @ModelAttribute("newUser")  w nzidou 
	//@Valid bech yefhem el sts el validations  
	//w BindingResult result yched el ta3mira  elli jetou mel form w les erreurs elli m3aha
	//Model model bech najjmou nekhdmou bel form nzidou les champs elli ya7kiw m3a database 
	// HttpSession session bech najjmou nekhdou b session w na3tiw lel logged in user token
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, 
			BindingResult result, Model model, HttpSession session) {

		
	
		//Hedhi el logic mt3 service register savi fel object el fere5 elli jebtou mel model newUser b result
	    User user = userService.register(newUser, result);
	  //Ken famma errors de preference  lezemna nrajj3ou l nafs el page bech les erreurs nrawhom ken famma 
	    // W en + lezemna n3awdou n3addiw Object fergh
	    if(result.hasErrors()) {
	        model.addAttribute("newLogin", new LoginUser());
	        return "index.jsp";
	    }
	    
	    //Ken kollchay jawou behy net3addew na3tiw lel user session esmha userId
	    session.setAttribute("userId", user.getId());

	    return "redirect:/dashboard";
	}

	
	//Action Route for login 
	//nab3thou Object feregh LoginUser newLogin @ModelAttribute("newLogin")  w nzidou 
	//@Valid bech yefhem el sts el validations  
	//w BindingResult result yched el ta3mira  elli jetou mel form w les erreurs elli m3aha
	//Model model bech najjmou nekhdmou bel form nzidou les champs elli ya7kiw m3a database 
	// HttpSession session bech najjmou nekhdou b session w na3tiw lel logged in user token
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
			BindingResult result, Model model, HttpSession session) {
		//Hedhi el logic mt3 service login tsavi fel object el fere5 elli jebtou mel model newLogin b result
		User user = userService.login(newLogin, result);
		//Ken famma errors de preference  lezemna nrajj3ou l nafs el page bech les erreurs nrawhom ken famma 
	    // W en + lezemna n3awdou n3addiw Object fergh
	    if(result.hasErrors() || user==null) {
	        model.addAttribute("newUser", new User());
	        return "index.jsp";
	    }
	    
	    //na3tiw lel user session esmha userId na3tiwha valeur mt3 el id mte3ou el aslaneya fel database 
	    
	    session.setAttribute("userId", user.getId());
	  //Ken kollchay jawou behy net3addew lel dashboard 
	    return "redirect:/dashboard";
	}

	// Logout tokhrej logout  ba3d mata3mel invalidate l session w nrajj3ou lel page d'acceuil
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null); 
	    return "redirect:/";
	}
	
	// View Route lel dashboard lezmou ykoun protected howa les routes el koll akhta mt3 el homepage 
	@GetMapping("/dashboard")
	public String dashboard(HttpSession session, Model model) {

		//hehdeya el protection nchouf itha famma session wala lé bel userId
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
	//tjib el id me session elli heya bidha el id mt3 el user fe database 
		Long userId = (Long) session.getAttribute("userId");
		//nesta3mlou el logic mt3 service bech nal9aw  Object uer kemel  par id 
		User user = userService.findById(userId);
//N3addiw el user comme "user" bech najjmou nesta3mlouha fi dashboard.jsp par ex user.firstName
		model.addAttribute("user", user);
		
		//n3addiw el logic mt3 service mt3el trips unassigned en utilisant el sercice comme "unassignedTrips" wenajjmou nesta3mlou zeda f dashboad
		model.addAttribute("unassignedTrips", tripService.getUnassignedTrips(user));
		
		//n3addiw el logic mt3 service mt3el trips unassigned en utilisant el sercice comme "assignedTrips" wenajjmou nesta3mlou zeda f dashboad

		model.addAttribute("assignedTrips", tripService.getAssignedTrips(user));

		return "dashboard.jsp";
	}
	
	
}
