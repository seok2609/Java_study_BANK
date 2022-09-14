package com.iu.start.board.notice;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.bankMembers.BankMembersDTO;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired 
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "notice";
	}
	
	//글목록
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("글목록 GET 실행");
		System.out.println(pager);
		
		System.out.println(pager.getKind());
		System.out.println(pager.getSearch());
		
//		System.out.println("Page : "+ page);
//		
		List<BoardDTO> ar = noticeService.getList(pager);
		
		mv.addObject("pager", pager);
		mv.addObject("list", ar);
//		mv.addObject("board", "Notice");
		mv.setViewName("board/list");
		
//		if(ar.size() != 0 ) {
//			throw new Exception();
//		}
		
		return mv;
	}
	
	//글조회
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public String getDetail(BoardDTO boardDTO, Model model) throws Exception{

		boardDTO = noticeService.getDetail(boardDTO);
		model.addAttribute("boardDTO", boardDTO);
		
		return "board/detail";
	}
	
	
	//글작성
	// 로그인 한사람만 글작성할 수 있도록 session을 줘서 로그인한사람은 리턴으로 글쓰기페이지, 비로그인은 로그인페이지로 리턴
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public String setAdd(HttpSession session) throws Exception{
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		
		if(bankMembersDTO != null) {
			return "board/add";
		}else {
			return"redirect:../member/login.iu";
		}
		
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO, MultipartFile [] files, HttpSession session) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setAdd(boardDTO, files, session.getServletContext());
		
		String message = "글 작성 실패";
		if(result>0) {
			message = "글 작성 성공!";
			
		}

		mv.addObject("result", result);
		mv.addObject("message", message);
		mv.addObject("url", "list.iu");
		
		mv.setViewName("common/result");
		
//		if(result == 1) {
//			System.out.println("글 작성 성공!!");
//		}else {
//			System.out.println("글 작성 실패!!");
//		}
		
		return mv;
	}
	
	
	//글수정
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public ModelAndView setUpdate(BoardDTO boardDTO, ModelAndView mv) throws Exception{
		boardDTO = noticeService.getDetail(boardDTO);
		
		mv.addObject("boardDTO", boardDTO);
		mv.setViewName("board/update");
		
		return mv;
		
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public String setUpdate(BoardDTO boardDTO) throws Exception{
		
		int result = noticeService.setUpdate(boardDTO);
		
		if(result == 1) {
			System.out.println("수정에 성공하였습니다!!");
		}else {
			System.out.println("수정에 실패하였습니다!!");
		}
		
		return "redirect:./detail.iu?num="+boardDTO.getNum();
	}
	
	
	//글삭제
	@RequestMapping(value = "delete.iu", method = RequestMethod.GET)
	public String setDelete(BoardDTO boardDTO) throws Exception{
		
		int result = noticeService.setDelete(boardDTO);
		
		if(result == 1) {
			System.out.println("삭제에 성공하였습니다!");
		}else {
			System.out.println("삭제에 실패하였습니다!");
		}
		
		return "redirect:./list.iu";
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView exceptionTest() {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("errors/error_404");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView exceptionTest2(Exception e) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("errors/error_404");
		return mv;
	}
	
}
