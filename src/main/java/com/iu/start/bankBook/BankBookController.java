package com.iu.start.bankBook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping(value = "/bankbook/*")

public class BankBookController {
	
	// /bankbook/list 	Get list
	
	// /bankbook/detail 	Get detail
	
	
	//Get
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list() {
		System.out.println("list Get 실행");
		
		return "bankbook/list";
	}
	
	
	//Get
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(Long booknum) {
		System.out.println("detail Get 실행");
		System.out.println("booknum : " + booknum);
		
		return "bankbook/detail";
	}
	
	//Get
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		System.out.println("Add page");
		
		return "bankbook/add";
	}
	
	//Post
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(BankBookDTO bankBookDTO) throws Exception {
		
		System.out.println("DB Insert 실행");
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		
		
//		bankBookDTO.setBooknum("booknum");
//		bankBookDTO.setBookname("bookname");
//		bankBookDTO.setBookrate("bookrate");
//		bankBookDTO.setBooksale("booksale");
		
		int result = bankBookDAO.setBankBook(bankBookDTO);
		System.out.println(result==1);
		
		return "bankbook/add";
		
	}

}
