package com.iu.start.bankMembers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller 
@RequestMapping(value = "/member/*")
//이 클래스는 Controller 역할, 			
//Container(생명주기)에게 이 클래스의 객체를 생성 위임

public class MemberController {
	
	// annotation
	// @ : 설명 + 실행
	
	//    /member/login	//절대경로로 작성
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(BankMembersDTO bankMembersDTO, Model model) throws Exception {
		System.out.println("DB에 로그인 실행");
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		
		bankMembersDTO = bankMembersDAO.getLogin(bankMembersDTO);
		System.out.println(bankMembersDTO);
		
		model.addAttribute("member", bankMembersDTO);
		
		// "Redirect:다시접소할 URL주소(절대경로, 상대경로)"
		
		return "home";
	}
	
	
	// join		/member/join	Get
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		System.out.println("회원가입 Get 실행");
		
		return "member/join";
	}
	
	
	//Post
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception {
		System.out.println("회원가입 Post 실행");
		
		
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		
		//String username = request.getParameter("username");
		
		
//		bankMembersDTO.setUsername("username");
//		bankMembersDTO.setPassword("pw");
//		bankMembersDTO.setName("name");
//		bankMembersDTO.setEmail("email");
//		bankMembersDTO.setPhone("phone");
		
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		System.out.println(result==1);
		
		//로그인폼 페이지로 이동
		//redirect
		
		return "redirect:../member/login";
//		return "redirect:./login";
	}
	
	
	
	//search
	//String으로 리턴하는법
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String getSearchByID() {
		
		System.out.println("검색 GET 실행");
		
		return "member/search";
	}
	
	
	//search
//	//ModelAndView로 리턴하는법
//	@RequestMapping(value = "search", method = RequestMethod.GET)
//	public ModelAndView getSearchByID() throws Exception {
//		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("member/search");
//		
//		System.out.println("검색 GET 실행");
//		return mv;
//	}
	
	
	//String으로 리턴하는법 ---
//	@RequestMapping(value = "search", method = RequestMethod.POST)
//	public String getSearchByID(String search, Model model) throws Exception {
//		
//		System.out.println("검색 POST 실행");
//		
//		BankMembersDAO bankMembersDAO = new BankMembersDAO();
//		ArrayList<BankMembersDTO> ar = bankMembersDAO.getSearchByID(search);
//		model.addAttribute("list",ar);
//		
//		return "member/list";
//	}
	
	//ModelAndView로 리턴하는법
	@RequestMapping (value = "search", method = RequestMethod.POST)
	   public ModelAndView getSearchByID(String search)throws Exception {
	      
	      BankMembersDAO bankMembersDAO = new BankMembersDAO();
	      ModelAndView mv = new ModelAndView();
	      ArrayList<BankMembersDTO> ar = bankMembersDAO.getSearchByID(search);
	      mv.setViewName("member/list");
	      mv.addObject("list", ar);
	      
	      return mv;
	   }


}
