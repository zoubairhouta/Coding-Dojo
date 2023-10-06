package com.ahmedbelhout.daikichiroutes;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DakichiController {
	@RequestMapping("")
	public String welcome()
	{
		return "Welcome!";
		
	}
	@RequestMapping("/today")
	public String today()
	{
		return "Today you will find luck in all your endeavors!";
		
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrow()
	{
		return "Tomorrow, an opportunity will arise , so be sure to be open to new ideas !";
		
	}
	
	
	

	@RequestMapping("/travel/{city}")
    public String showTravel( @PathVariable("city") String mdina){
    	return "You will soon travel to "+ mdina + "!";
    }
	@RequestMapping("/lotto/{number}")
    public String showLotto( @PathVariable("number") int  lottoNum){
    	return lottoNum % 2 == 0 ? " You will take a grand journey in the near future, but be weary of tempting offers" : " You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
    }
	
}
