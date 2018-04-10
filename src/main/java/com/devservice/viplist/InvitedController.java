package com.devservice.viplist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.devservice.sendEmail.EmailService;
import com.devservice.viplist.model.Invited;
import com.devservice.viplist.service.InvitedService;

@Controller
public class InvitedController {
	
	@Autowired
	private InvitedService service;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("viplist")
	public String invitedList(Model model){
		
		Iterable<Invited> invitedList = service.getAll();
		
		model.addAttribute("invited", invitedList);
		
		return "viplist";
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST )
	public String save(@RequestParam("name") String name, @RequestParam("email")String email, 
			@RequestParam("phone") String phone, Model model){
		
		Invited newInvited = new Invited(name, email, phone);
		
		service.save(newInvited);
		
		new EmailService().send(name, email);
		
		Iterable<Invited> invitedList = service.getAll();
		
		
		model.addAttribute("invitedList", invitedList);
		
		return "viplist";
		
	}

}
