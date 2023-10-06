package com.ahmedbelhout.hellohuman;



import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HumanController {
	
    @RequestMapping("/")
    public String index(@RequestParam(value="name", required=false) String name,@RequestParam(value="last_name", required=false) String last_name,@RequestParam(value="times", required=false) int times) {
	 if(times<=0)
	  {
			return "Hello Human";
	 }
	 else {
		   	if(name != null && last_name !=null) {
				return ("Hello " + name +" " + last_name).repeat(times);
			}else if(name != null) {
					return ("Hello " + name).repeat(times);
			}
			else {
				return "Hello Human";
			}
		}
		 
		 
	 }
	 
    	
    	
 
}