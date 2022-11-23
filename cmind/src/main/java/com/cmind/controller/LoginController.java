package com.cmind.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cmind.entity.Staff;
import com.cmind.repository.StaffRepository;

@Controller
public class LoginController {
	
	@Autowired
	private StaffRepository staffinfo;
	
	@RequestMapping("/login")
	public ModelAndView login(ModelAndView mav) {
		mav.addObject("staff", new Staff());
		mav.setViewName("login");
		
		return mav;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView loginPost(@ModelAttribute @Validated Staff staff, BindingResult result, 
			@RequestParam("employeeId") String employeeId, @RequestParam("password") String password, ModelAndView mav) {
		if (result.hasFieldErrors()) {	
			mav.addObject("message", "入力内容に誤りがあります");
			mav.setViewName("login");
			
			return mav;
		}
		
		Staff user = staffinfo.findByEmployeeIdAndPassword(employeeId, password);
		
		if(user != null) {
			String username = user.getName();
			mav.addObject("username", username);
			mav.setViewName("top");
			
			return mav;
		}
		
		mav.addObject("message", "入力内容に誤りがあります");
		mav.setViewName("login");
		
		return mav;
	}
	
	/*
	@RequestMapping("/top")
	public ModelAndView top(ModelAndView mav) {
		mav.setViewName("top");
		
		return mav;
	}
	*/
	
	@RequestMapping("/top")
	public ModelAndView top(@RequestParam(required = false) String username, ModelAndView mav) {
		if(username == null) {
		mav.setViewName("top");
		
		return mav;
		}
		
		mav.addObject("username", username);
		mav.setViewName("top");
		
		return mav;
	}
	
	@RequestMapping("/top/{username}")
	public ModelAndView top2(@PathVariable String username, ModelAndView mav) {
			
		mav.addObject("username", username);
		mav.setViewName("top");
		
		return mav;
	}
	
}