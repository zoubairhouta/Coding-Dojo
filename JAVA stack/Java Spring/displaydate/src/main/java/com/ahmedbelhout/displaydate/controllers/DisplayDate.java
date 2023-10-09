package com.ahmedbelhout.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayDate {

	
@RequestMapping("/")
	public  String pageone (Model model)
	{
	return "pageone.jsp";
	

}
@RequestMapping("/date")
public  String pagetwo (Model model)
{
	Date date=new Date();  
	SimpleDateFormat DateFor = new SimpleDateFormat(" E, dd MMM yyyy");
	
	String dateNow = DateFor.format(date);
	
	model.addAttribute("date", dateNow);
	
return "pagetwo.jsp";

}
@RequestMapping("/time")
public  String pagethree (Model model)
{
	
	Date date=new Date();  
	SimpleDateFormat DateFor = new SimpleDateFormat(" K:mm a");
	
	String dateNow = DateFor.format(date);
	
	model.addAttribute("date", dateNow);
return "pagethree.jsp";

}




}
