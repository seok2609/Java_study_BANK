package com.iu.start.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/error/*")
public class FrontErrorController {
	
	@GetMapping("error400")
	public ModelAndView errer400() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		System.out.println("Parameter가 틀림");
		mv.setViewName("errors/error_404");
		return mv;
		
	}
	@GetMapping("error500")
	public ModelAndView errer500() throws Exception{
		ModelAndView mv = new ModelAndView();
		
		System.out.println("Server Exception 발생");
		mv.setViewName("errors/error_404");
		return mv;
		
	}
}
