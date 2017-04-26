package spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController 
{
	@GetMapping("/welcome")
	public String welcome(Model model) 
	{
		model.addAttribute("firstName", "Elizabeth");
		model.addAttribute("name", "John Doe");
		return "welcomeMessage";
	}
	
	public void doStuff(Model model){
		model.addAttribute("firstName", "Pete");
	}
}
