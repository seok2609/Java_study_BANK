package com.iu.start.bankBook;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
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
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();

		System.out.println("detail Get 실행");
//		System.out.println("bookNum : " + bookNum);
		BankBookDAO bankBookDAO = new BankBookDAO();
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		//System.out.println(bankBookDTO.getBookNum());
		
		//return "bankbook/detail";
		mv.setViewName("bankbook/detail");
		mv.addObject("dto", bankBookDTO);
		
		return mv;
	}
	
	//Add
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
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
	
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		System.out.println("DB Insert 실행");
		
		System.out.println(bankBookDTO.getBookName());
		System.out.println(bankBookDTO.getBookRate());
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		
		mv.setViewName("redirect:./list.iu");
		
		int result = bankBookDAO.setBankBook(bankBookDTO);
		System.out.println(result==1);
		
		return mv;
	}
	
	
	//Update	//Get	
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public ModelAndView update(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		System.out.println("업데이트 GET 실행");
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		
		System.out.println(bankBookDTO.getBookNum());
		
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		
		mv.addObject("dto", bankBookDTO);
		mv.setViewName("bankbook/update");

		
		ArrayList<BankBookDTO> ar = bankBookDAO.getList();
		
		return mv;
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public ModelAndView updateInfo(BankBookDTO bankBookDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println("업데이트 POST 실행");
		
		BankBookDAO bankBookDAO = new BankBookDAO();
//		BankBookDTO bankBookDTO = new BankBookDTO();
		
		int result = bankBookDAO.setUpdate(bankBookDTO);

		if(result==1) {
			System.out.println("업데이트 성공");
		}else {
			System.out.println("실패");
		}
		
		mv.addObject("dto", bankBookDTO);
		mv.setViewName("redirect:./detail.iu?bookNum="+bankBookDTO.getBookNum());
		
		return mv;
	}
	
	
	//Delete	//Get
	@RequestMapping(value = "delete.iu", method = RequestMethod.GET)
	public ModelAndView delete(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		System.out.println("delete GET 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		
		int result = bankBookDAO.setDelete(bankBookDTO);
		
		if(result==1) {
			System.out.println("삭제에 성공하였습니다.");
		}else {
			System.out.println("삭제에 실패하였습니다.");
		}
		
		mv.addObject("dto", bankBookDTO);
		mv.setViewName("redirect:./list.iu");
		
		return mv;
	}
	

}
