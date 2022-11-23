package jp.co.f1.spring.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginThymeleafController {
	@RequestMapping("/loginForm")
	public ModelAndView loginForm(ModelAndView mav) {
		mav.setViewName("login/form");
		return mav;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam String id, @RequestParam String pass, ModelAndView mav) {
		mav.addObject("id", "Your ID is " + id + ".");
		mav.addObject("pass", "PASS is " + pass + ".");
		mav.setViewName("login/success");
		return mav;
	}
}