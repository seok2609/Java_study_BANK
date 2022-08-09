package com.iu.start.bankMembers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller 
@RequestMapping(value = "/member/*")
//이 클래스는 Controller 역할, 			
//Container(생명주기)에게 이 클래스의 객체를 생성 위임

public class MemberController {
	
	// annotation
	// @ : 설명 + 실행
	
	//    /member/login	//절대경로로 작성
	@RequestMapping(value = "login")
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login";
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
		
		return "member/join";
	}


}
