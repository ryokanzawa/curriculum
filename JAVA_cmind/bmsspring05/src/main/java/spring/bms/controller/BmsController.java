package spring.bms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import spring.bms.entity.Book;
import spring.bms.repository.BookRepository;

@Controller
public class BmsController {

	@Autowired
	private BookRepository bookinfo;
	
	@RequestMapping("/list")
	public ModelAndView list(ModelAndView mav) {
		Iterable<Book> book_list = bookinfo.findAll();
		
		mav.addObject("book_list", book_list);
		
		mav.setViewName("list");
		
		return mav;
	}
	
	@RequestMapping("insert")
	public ModelAndView insert(ModelAndView mav) {
		mav.setViewName("insert");
		
		return mav;
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insertPost(@ModelAttribute @Validated Book book, BindingResult result, ModelAndView mav) {
		if (result.hasFieldErrors()) {
			mav.addObject("message", "入力内容に誤りがあります");
			
			mav.setViewName("insert");
			return mav;
		}
		
		bookinfo.saveAndFlush(book);
		
		mav = new ModelAndView("redirect:/list");
		
		return mav;
	}
}
