package com.cmind.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cmind.entity.Staff;
import com.cmind.repository.StaffRepository;

@Controller
public class LogincController {
	
	@Autowired
	private StaffRepository staffinfo;
		
	@RequestMapping("/login")
	public ModelAndView login(ModelAndView mav) {
		mav.addObject("staff", new Staff());
		mav.setViewName("login");
		
		return mav;
	}
	
	/*
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView insertPost(@RequestParam("employeeId") String employeeId, @RequestParam("password") String password, ModelAndView mav) {
		
		List<Staff> staff_list = staffinfo.findByEmployeeIdAndPassword(employeeId, password);
		
		if(staff_list.size() >=1) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("list");
			mv.addObject("staff_list", staff_list);
			return mv;
		}
		
		mav.addObject("staff_list", staff_list);
		
		mav.setViewName("/login");
		
		return mav;
	}
	*/
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView insertPost(@ModelAttribute @Validated Staff staff, BindingResult result, 
			@RequestParam("employeeId") String employeeId, @RequestParam("password") String password, ModelAndView mav) {
		if (result.hasFieldErrors()) {
			mav.addObject("message", "入力内容に誤りがあります");
			
			mav.setViewName("login");
			return mav;
		}
		
		List<Staff> staff_list = staffinfo.findByEmployeeIdAndPassword(employeeId, password);
		
		if(staff_list.size() >=1) {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("list");
			mv.addObject("staff_list", staff_list);
			return mv;
		}
		
		mav.addObject("message", "入力内容に誤りがあります");
		
		mav.setViewName("login");
		return mav;
	}
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mav) {
		List<Staff> staff_list = staffinfo.findByEmployeeIdAndPassword("000001", "2022");
		
		mav.addObject("staff_list", staff_list);
		
		mav.setViewName("list");
		
		return mav;
	}
	
}