package com.iu.start.bankBook;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping(value = "/bankbook/*")

public class BankBookController {
	
	// /bankbook/list 	Get list
	
	// /bankbook/detail 	Get detail
	
	
	//Get
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("list Get 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		ArrayList<BankBookDTO> ar = bankBookDAO.getList();
		model.addAttribute("list", ar);
		
		
		
		return "bankbook/list";
	}
	
	
//	//Get
//	@RequestMapping(value = "detail", method = RequestMethod.GET)
//	public ModelAndView detail(Long bookNum) {
//		ModelAndView mv = new ModelAndView();
//		
//		System.out.println("detail Get 실행");
//		System.out.println("bookNum : " + bookNum);
//		BankBookDAO bankBookDAO = new BankBookDAO();
//		
//		//return "bankbook/detail";
//		mv.setViewName("bankbook/detail");
//		
//		return mv;
//	}
	
	//Get
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();

		System.out.println("detail Get 실행");
//		System.out.println("bookNum : " + bookNum);
		BankBookDAO bankBookDAO = new BankBookDAO();
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		
		//return "bankbook/detail";
		mv.setViewName("bankbook/detail");
		mv.addObject("dto", bankBookDTO);
		
		return mv;
	}
	
	//Get
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		System.out.println("Add page");
		
		return "bankbook/add";
	}
	
	//Post
//	@RequestMapping(value = "add", method = RequestMethod.POST)
//	public String add(BankBookDTO bankBookDTO) throws Exception {
//		
//		System.out.println("DB Insert 실행");
//		
//		System.out.println(bankBookDTO.getBookName());
//		System.out.println(bankBookDTO.getBookRate());
//		
//		BankBookDAO bankBookDAO = new BankBookDAO();
//		
//		
////		bankBookDTO.setBooknum("bookNum");
////		bankBookDTO.setBookname("bookName");
////		bankBookDTO.setBookrate("bookRate");
////		bankBookDTO.setBooksale("bookSale");
//		
//		int result = bankBookDAO.setBankBook(bankBookDTO);
//		System.out.println(result==1);
//		
//		
//		return "bankbook/add";
//	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		System.out.println("DB Insert 실행");
		
		System.out.println(bankBookDTO.getBookName());
		System.out.println(bankBookDTO.getBookRate());
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		
		mv.setViewName("redirect:./list");
		
		int result = bankBookDAO.setBankBook(bankBookDTO);
		System.out.println(result==1);
		
		return mv;
	}
	
	

}
