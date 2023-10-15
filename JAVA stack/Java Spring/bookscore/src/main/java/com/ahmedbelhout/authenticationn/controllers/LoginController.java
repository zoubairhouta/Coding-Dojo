package com.ahmedbelhout.authenticationn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ahmedbelhout.authenticationn.models.LoginUser;
import com.ahmedbelhout.authenticationn.models.User;
import com.ahmedbelhout.authenticationn.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

//Protected routes lezem ykounou fel les routes el koll bekhlef el get mt3 login w registration
// w session tnajjem tekhouha men ay blasa el mouhem t3addiha fi west el methode 


@Controller
public class LoginController {
	// Add once service is implemented:
	@Autowired
	private UserService userServ;
	
	// View Route - Display forms (login and register)
	@GetMapping("/")
	public String index(Model model) {

		// Bind empty User and LoginUser objects to the JSP
		// to capture the form input
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp";
	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		// TO-DO Later -- call a register method in the service
		userServ.register(newUser, result);
		// to do some extra validations and create a new user!

		if (result.hasErrors()) {
			// Be sure to send in the empty LoginUser before
			// re-rendering the page.
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		} else {

			// No errors!
			// TO-DO Later: Store their ID from the DB in session,
			// in other words, log them in.
			session.setAttribute("user_id", newUser.getId());
			return "redirect:/books";

		}
	}

	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		// Add once service is implemented:
		 User user = userServ.login(newLogin, result);

		if (result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}

		// No errors!
		// TO-DO Later: Store their ID from the DB in session,
		// in other words, log them in.
		session.setAttribute("user_id", user.getId());
		return "redirect:/books";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
