package com.ahmedbelhout.tripbuddy.controllers;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ahmedbelhout.tripbuddy.models.Trip;
import com.ahmedbelhout.tripbuddy.models.User;
import com.ahmedbelhout.tripbuddy.services.TripService;
import com.ahmedbelhout.tripbuddy.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
@Controller
public class TripController {
	//3ayetna leservice mt3 el user bech nest7a99ou findByid
	@Autowired
	private UserService userService;
	//3ayetna leservice mt3 el user bech nest7a99ou le custom queries mt3 trip
	@Autowired
	private TripService tripService;



	
	
	//Action Route  bech todkhol fi trip
	// Njib el object trip par id mt3 el trip elli 7ajti beha bel path variable 
	//NJib el object logged in user  bel id elli mawjoud f session 
	//Nzid fi el object logged in user f champ mt3 jointure lli howa tableau el trip hedhika 
	// UPdate user 
	// w n3awdou nab3thou les données updated ledashboard bel model model 
	//w redirect Dashboard 
	
	@RequestMapping("/dashboard/join/{id}")
	public String joinTrip(@PathVariable("id") Long id, HttpSession session, Model model) {

		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");

		Trip trip = tripService.findById(id);
		User user = userService.findById(userId);

		user.getTrips().add(trip);
		userService.updateUser(user);

		model.addAttribute("user", user);
		model.addAttribute("unassignedTrips", tripService.getUnassignedTrips(user));
		model.addAttribute("assignedTrips", tripService.getAssignedTrips(user));

		return "redirect:/dashboard";
	}
// Action Route bech tokhrej m trip 
	//njibou le trip concerné wel logged in user  b service w session
	//nfaskhou el trip m lista  	elli fi tableau el user user.getTrips().remove(trip);
	// w ki na3mlou 7aja fi tableau el jointure (many to many wala one to many)
	// lezemna zeda nsaviw el tableau elli massineh 
	// bech n3awdou najjmou narj3ou l dashboard b nafs les données lezemna n3awdou njibou men owe l jdid 
	//user w unassigned trips w assigned trips khater mezelna ki 3malna update
	@RequestMapping("/trips/cancel/{id}")
	public String leaveTrip(@PathVariable("id") Long id, HttpSession session, Model model) {

		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");

		Trip trip = tripService.findById(id);
		User user = userService.findById(userId);

		user.getTrips().remove(trip);
		userService.updateUser(user);

		model.addAttribute("user", user);
		model.addAttribute("unassignedTrips", tripService.getUnassignedTrips(user));
		model.addAttribute("assignedTrips", tripService.getAssignedTrips(user));

		return "redirect:/dashboard";
	}
//View Route 
	// Read one Trip 
	//njibou le trip mel database bel id mte3ou path Variables w session bech tvalidi el route
	//nab3thouh lel form
	@GetMapping("/trips/{id}")
	public String viewTrip(@PathVariable("id") Long id, HttpSession session, Model model) {

		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}

		Trip trip = tripService.findById(id);
		model.addAttribute("trip", trip);
		return "view_trip.jsp";
	}
//View route bech nemchiw lel edit project n3addiw feha el model model bech tjina object feregh m3ammer 
	//nal9aw el trip bel id mte3ha bel path variable w elli bech yt3amrelna el object el feregh
	// nab3thou el session 
	@GetMapping("/trips/edit/{id}")
	public String openEditTrip(@PathVariable("id") Long id, HttpSession session, Model model) {

		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}


		Trip trip = tripService.findById(id);

		model.addAttribute("trip", trip);
		return "edit_trip.jsp";
	}

	
	// Action Route 
	//Edit trip bel path variable id 
	//n3addiw feha result elli tjina mel form 
	// session protection de route 
	@PostMapping("/trips/edit/{id}")
	public String editTrip(
			@PathVariable("id") Long id, 
			@Valid @ModelAttribute("trip") Trip trip, 
			BindingResult result, 
			HttpSession session) {
//protection route
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		//nekhdhou el id mt3 logged in user m session
		Long userId = (Long) session.getAttribute("userId");

		//njibou el object kemel mt3 el user
		User user = userService.findById(userId);
//ken famma errors nrajj3ouh lel "edit_trip.jsp"
		if(result.hasErrors()) {
			return "edit_trip.jsp";
		}else {
			//nlawjou 3la el trip avant modification bel id mte3ha fel database 
			
			Trip thisTrip = tripService.findById(id);
			
			// f trip el jdida n7ottou el relationet le 9dom mel trip avant modification khater mouch mawjioudin fel form
			trip.setUsers(thisTrip.getUsers());
		//Kif kfi nzidou n7ou el user fel object el feregh khater mouch mawjoud fel les champs 
			trip.setTripCreator(user);
			
			//finalement nsaviw el trip
			tripService.updateTrip(trip);
			return "redirect:/dashboard";
		}
	}
//Bel pathvariables id w session protection route
	@RequestMapping("/trips/delete/{id}")
	public String deleteTrip(@PathVariable("id") Long id, HttpSession session) {

		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
//nlawjou 3atrip hedhika bel id 
		Trip trip = tripService.findById(id);
		//nfaskhouha  nraj3ou l database 
		tripService.deleteTrip(trip);

		return "redirect:/dashboard";
	}


//View route mt3 creation trip jdida thezz l new_trip.jsp
	//n3addiw feha object feregh trip mel instance Trip
	//w session bech na3mlou protection mt3 route w result heya elli tlem el form el m3amra  w les erreur
	//bech nesta3mlou hidden input donc b3ath bel model model il user id ba3d majebtha besession b add atribute
	@GetMapping("/trips/new")
	public String newTrip(@ModelAttribute("trip") Trip trip, HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
		Long userId = (Long) session.getAttribute("userId");

		model.addAttribute("userId", userId);
		return "new_trip.jsp";
	}
	//Action  route mt3 creation trip jdida 
	//n3addiw feha object feregh trip mel instance Trip fi souret el creation masaretchi w
	//@Valid bech nkhadmou le validations mt3 el database 
	//w session bech na3mlou protection mt3 route w result heya elli tlem el form el m3amra  w les erreur
	@PostMapping("/trips/new")
	public String addNewTrip(@Valid @ModelAttribute("trip") Trip trip, BindingResult result, HttpSession session) {
//Protection de route traj3ek l homepage 
		if(session.getAttribute("userId") == null) {
			return "redirect:/logout";
		}
//Ken famma erreur lezem narj3ou lel view page "new_trip.jsp"
		if(result.hasErrors()) {
			return "new_trip.jsp";
		}
		//
		else {
			
			//Tsavi el trip fel database mt3 trip
			tripService.addTrip(trip);

			//el Object user b session 
			Long userId = (Long) session.getAttribute("userId");
			
			User user = userService.findById(userId);
			
			//Hedhi tajouti el trip elli khla9neha l liaison de jointure elli fel user trips 
			user.getTrips().add(trip);
			//Hedhi  t updati el user  ba3d les modifications
			userService.updateUser(user);
			//narj3ou l dashboard
			return "redirect:/dashboard";
		}
	}

}
