package com.iu.start.bankMembers;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller 
@RequestMapping(value = "/member/*")
//이 클래스는 Controller 역할, 			
//Container(생명주기)에게 이 클래스의 객체를 생성 위임

public class MemberController {
	
	
	@Autowired
	private BankMembersService bankMembersService;
	
	@GetMapping("agree.iu")
	public String getAgree() throws Exception {

		return "member/agree";
	}
	
	
	// annotation
	// @ : 설명 + 실행
	
	//    /member/login	//절대경로로 작성
	@RequestMapping(value = "login.iu", method = RequestMethod.GET)
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login";
	}
	
	@RequestMapping(value = "login.iu", method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request, BankMembersDTO bankMembersDTO, Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("DB에 로그인 실행");
		
		bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
		System.out.println(bankMembersDTO);
		HttpSession session = request.getSession();
		session.setAttribute("member", bankMembersDTO);
		
		model.addAttribute("member", bankMembersDTO);
		
		int result = 0;
		String message = "로그인 실패";
		String url = "./login.iu";
		if(bankMembersDTO!=null) {
			result = 1;
			message = "로그인 성공";
			url = "../";
		}
		
		mv.addObject("result", result);
		mv.addObject("message", message);
		mv.addObject("url", url);
		mv.setViewName("common/result");
		
		// "redirect:다시접속할 URL주소(절대경로, 상대경로)"
		
		return mv;
	}
	
	
	//로그아웃
	@RequestMapping(value = "logout.iu", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		
		return "redirect:../";
	}
	
	
	// join		/member/join	Get
	@RequestMapping(value = "join.iu", method = RequestMethod.GET)
	public String join() {
		System.out.println("회원가입 Get 실행");
		
		return "member/join";
	}
	
	
	//Post
	@RequestMapping(value = "join.iu", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO, MultipartFile photo, HttpSession session) throws Exception {
		System.out.println("회원가입 Post 실행");
		System.out.println(photo);
		System.out.println("upload 파일명 : " + photo.getOriginalFilename());
		System.out.println("upload 파라미터명 : " + photo.getName());
		System.out.println("upload 파일크기 : " + photo.getSize());
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		
		//String username = request.getParameter("username");
		
		
//		bankMembersDTO.setUsername("username");
//		bankMembersDTO.setPassword("pw");
//		bankMembersDTO.setName("name");
//		bankMembersDTO.setEmail("email");
//		bankMembersDTO.setPhone("phone");
		
		int result = bankMembersService.setJoin(bankMembersDTO, photo, session.getServletContext());
//		System.out.println(result==1);
		
		//로그인폼 페이지로 이동
		//redirect
		
		return "redirect:../member/login.iu";
//		return "redirect:./login";
	}
	
	
	
	//search
	//String으로 리턴하는법
	@RequestMapping(value = "search.iu", method = RequestMethod.GET)
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
	@RequestMapping (value = "search.iu", method = RequestMethod.POST)
	   public ModelAndView getSearchByID(String search)throws Exception {
	      ModelAndView mv = new ModelAndView();
	      System.out.println("검색 POST 실행");
	      List<BankMembersDTO> ar = bankMembersService.getSearchByID(search);
	      mv.setViewName("member/list");
	      mv.addObject("list", ar);
	      
	      return mv;
	   }
	
	
	@RequestMapping(value = "myPage.iu", method = RequestMethod.GET)
	public ModelAndView getMyPage(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("마이페이지 GET실행");

		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
//		Map<String, Object> map = bankMembersService.getMyPage(bankMembersDTO);
		bankMembersDTO = bankMembersService.getMyPage(bankMembersDTO);
		
		mv.setViewName("member/myPage");
//		mv.addObject("map",map);
		mv.addObject("dto", bankMembersDTO);
		return mv;
	}
	


}
