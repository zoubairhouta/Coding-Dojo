package com.ahmedbelhout.authenticationn.services;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.ahmedbelhout.authenticationn.models.LoginUser;
import com.ahmedbelhout.authenticationn.models.User;
import com.ahmedbelhout.authenticationn.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	// TO-DO: Write register and login methods!
	public User register(User newUser, BindingResult result) {
		// TO-DO: Additional validations!
		// Reject if email is taken (present in database)
		Optional<User> potentialUser = userRepo.findByEmail(newUser.getEmail());
		if (potentialUser.isPresent()) {
			result.rejectValue("email", "registerError", "email is taken");
		}
		if (!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("password", "registerError", "paswords does not match");
		}
		if (result.hasErrors()) {
			return null;
		} else {
			// hash and set password, save user to DB
			String hashPW = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashPW);
			// SAVE TO DB
			return userRepo.save(newUser);
		}

	}

	public User login(LoginUser newLoginObject, BindingResult result) {
		// TO-DO: Additional validations!
		// find if the user is in the DB
		Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "loginErrors", "email is not found");
		}else {
			User user = potentialUser.get();
			if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
				result.rejectValue("password", "loginErrors", "invalid password");
			}
			if(result.hasErrors()) {
				return null;
			}else {
				return user;
			}
			
		}
		
		return null;
	}
	
	// find by id
	public User findById(Long id) {
		Optional<User> maybeUser = userRepo.findById(id);
		if(maybeUser.isPresent()) {
			return maybeUser.get();
		}else { 
			return null;
		}
	}
}