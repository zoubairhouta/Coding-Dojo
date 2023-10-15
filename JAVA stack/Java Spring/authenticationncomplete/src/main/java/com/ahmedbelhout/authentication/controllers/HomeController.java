package com.ahmedbelhout.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ahmedbelhout.authentication.models.LoginUser;
import com.ahmedbelhout.authentication.models.User;
import com.ahmedbelhout.authentication.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

//Protected routes lezem ykounou fel les routes el koll bekhlef el get mt3 login w registration
// w session tnajjem tekhouha men ay blasa el mouhem t3addiha fi west el methode 


@Controller
public class HomeController {
    
    // Add once service is implemented:
	//Awel 7aja el services wel repositories yetgaddou
	
	
	// @Autowired feha dependency injection Bech nesta3mlou el repo fi west userServ 
	//@Autowired is used to inject objects into other objects. 
	//This allows for loose coupling between components and helps to keep code more maintainable
     @Autowired
     private UserService userServ;
    
     
     //Famma 2 methodes famma Post w Get 
     //Hedheya el view Route mt3 Login w registration
    @GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
    	//Nab3thou modelet ferghin wennajmou zeda nesta3mlou modelattribute
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "index.jsp";
    }
    
    
    
    //Fel method mt3 post mapping Nab3thou
    // Object Feregh esmou newUser elli howa instance mel User newUser
    //Nab3thou result elli heya testori les erreurs 
    //Nab3thou el Model model bech tnajjem tzid fel form mel database  w tet3amel m3aha
    //session bech ta3ref chkoun mlogi
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
        // TO-DO Later -- call a register method in the service 
    	//Hedhi tetgad f service el logic mt3 el registration
    	//el object el feregh newUser elli b3athtou bech yarja3li m3ebbi ndakhlou fil userSer.register w n9ayed el sayed
    	userServ.register(newUser, result);
        // to do some extra validations and create a new user!
        
        if(result.hasErrors()) {
            // Be sure to send in the empty LoginUser before 
            // re-rendering the page.
        	//Khater el pag feha 2 components el login w registration w yestanna feyaa dima feretour fi 2 components
            model.addAttribute("newLogin", new LoginUser());
            return "index.jsp";
        }
        
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
        
        //Ba3d maya3mel registration toul ya3mel login
    	session.setAttribute("user_id", newUser.getId());

        return "redirect:/home";
    }
    
    
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
        User user = userServ.login(newLogin, result);
    	//Khater el pag feha 2 components el login w registration w yestanna feyaa dima feretour fi 2 components
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            
            return "index.jsp";
        }
    
        // No errors! 
        // TO-DO Later: Store their ID from the DB in session, 
        // in other words, log them in.
    	session.setAttribute("user_id", user.getId());
        return "redirect:/home";
    }
    // El Logic lt3 el logout tfassakh toul mel session bel session .invalidate
    @GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
    
    @GetMapping("/home")
	public String home(HttpSession session) {
		
// securisi el route tekhou el user_id m session wetchoufha mawjouda wala l"
Long userId = (Long) session.getAttribute("user_id");

//protect routes
// ken mouch mawjouda traj3ou lel login 
if(userId == null)
{
	return "redirect:/";
	
}
else {
	
	return "home.jsp";
}
	}
    
    
}

