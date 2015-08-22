package com.rocky.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rocky.service.TestService;
import com.rocky.vo.Account;

@Controller
public class SampleController {

	@Autowired
	private TestService testService;  
	
	@RequestMapping(value="welcome",method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		Account account = testService.getAccount("1");
		model.addAttribute("account", account);
		return "sam";
	}
	
	@RequestMapping(value="process",method = RequestMethod.GET)
	public String process(@ModelAttribute("SpringWeb")Account account, 
			   ModelMap model) {
		model.addAttribute("name", account.getName());
		model.addAttribute("id", account.getId());
		return "sam2";
	}
}