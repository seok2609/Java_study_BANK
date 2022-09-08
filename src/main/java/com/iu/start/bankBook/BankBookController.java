package com.iu.start.bankBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.util.CommentPager;

import oracle.jdbc.proxy.annotation.Post;


@Controller
@RequestMapping(value = "/bankbook/*")

public class BankBookController {
	
	// /bankbook/list 	Get list
	
	// /bankbook/detail 	Get detail
	
	@Autowired
	private BankBookService bankBookService;
	
	
	//Get
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("list Get 실행");
		List<BankBookDTO> ar = bankBookService.getList();
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

		bankBookDTO = bankBookService.getDetail(bankBookDTO);
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
		

		
		mv.setViewName("redirect:./list.iu");
		
		int result = bankBookService.setBankBook(bankBookDTO);
		System.out.println(result==1);
		
		if(result==1) {
			System.out.println("추가 성공!!");
		}else {
			System.out.println("추가 실패!!");
		}
		
		return mv;
	}
	
	
	//Update	//Get	
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public ModelAndView update(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		System.out.println("업데이트 GET 실행");
		

		
		System.out.println(bankBookDTO.getBookNum());
		
		bankBookDTO = bankBookService.getDetail(bankBookDTO);
		
		mv.addObject("dto", bankBookDTO);
		mv.setViewName("bankbook/update");

		
		List<BankBookDTO> ar = bankBookService.getList();
		
		return mv;
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public ModelAndView updateInfo(BankBookDTO bankBookDTO) throws Exception {
		
		ModelAndView mv = new ModelAndView();
		
		System.out.println("업데이트 POST 실행");
		

//		BankBookDTO bankBookDTO = new BankBookDTO();
		
		int result = bankBookService.setUpdate(bankBookDTO);

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

		
		int result = bankBookService.setDelete(bankBookDTO);
		
		if(result==1) {
			System.out.println("삭제에 성공하였습니다.");
		}else {
			System.out.println("삭제에 실패하였습니다.");
		}
		
		mv.addObject("dto", bankBookDTO);
		mv.setViewName("redirect:./list.iu");
		
		return mv;
	}
	
	@RequestMapping(value="commentAdd", method = RequestMethod.GET)
	public void commentAdd() throws Exception{
		
		System.out.println("댓글 달기 GET실행");
		
	}
	
//	@RequestMapping(value = "commentAdd", method = RequestMethod.POST)
//	public ModelAndView commentAdd (BankBookCommentDTO bankBookCommentDTO) throws Exception{
//		ModelAndView mv = new ModelAndView();
//		
//		System.out.println("booknum="+bankBookCommentDTO.getBookNum());
//		
//		int result = bankBookService.setCommentAdd(bankBookCommentDTO);
//		
//		if(result>0) {
//			System.out.println("뱅크북 커멘드 성공!");
//		}else {
//			System.out.println("뱅크북 커멘드 실패!");
//		}
//		
//		mv.addObject("result", result);
//		mv.setViewName("common/ajaxResult");
//		return mv;
//	}
	

	@RequestMapping(value = "commentAdd", method = RequestMethod.POST)
	@ResponseBody
	//JSP를 안거치고 body에 바로 담아 응답으로 내보냄.
	public String commentAdd (BankBookCommentDTO bankBookCommentDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println(bankBookCommentDTO.getBookNum());
		System.out.println(bankBookCommentDTO.getWriter());
		
		System.out.println("booknum="+bankBookCommentDTO.getBookNum());
		
		int result = bankBookService.setCommentAdd(bankBookCommentDTO);
		
		String jsonResult="{\"result\":\""+result+"\"}";
		
		return jsonResult;
	}
	
//	//1. JSP 에 출력하고 결과물을 응답으로 전송
//	@RequestMapping(value = "commentList", method = RequestMethod.GET)
//	public ModelAndView commentList(CommentPager commentPager) throws Exception{
//		ModelAndView mv = new ModelAndView();
//		
//		List<BankBookCommentDTO> ar = bankBookService.getCommentList(commentPager);
//		System.out.println("CommentList");
//		System.out.println(ar.size());
//		
//		mv.addObject("commentList", ar);
//		mv.setViewName("common/commentList");
//		
//		return mv;
//		
//	}
	
	//1. JSP 에 출력하고 결과물을 응답으로 전송
	@RequestMapping(value = "commentList", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> commentList(CommentPager commentPager) throws Exception{
		
		List<BankBookCommentDTO> ar = bankBookService.getCommentList(commentPager);
		System.out.println("CommentList");
		System.out.println(ar.size());
		
		//json
		// DTO == {}
		// num =1 == {"num":1, "bookNum":123, "writer":"name"}
		// [{"num":1, "bookNum":123, "writer":"name"},{"num":1, "bookNum":123, "writer":"name"}]
		
		// return 해야할 데이터가 ar, commentPager 두개이기 때문에 JSON과 같은 KEY/VALUE 타입인 MAP으로 합쳐서 리턴해야함
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", ar);
		map.put("pager", commentPager);
		
		return map;
		
	}

	
	@PostMapping("commentUpdate")
	@ResponseBody
	//JSP를 안거치고 body에 바로 담아 응답으로 내보냄.
	public int commentUpdate(BankBookCommentDTO bankBookCommentDTO) throws Exception{

		System.out.println("댓글수정하기 POST 실행");
		System.out.println(bankBookCommentDTO.getNum());
		System.out.println(bankBookCommentDTO.getContents());
		
		int result = bankBookService.setCommentUpdate(bankBookCommentDTO);
		
		
		return result;		
	}
	
	
	
	
	
	@PostMapping("commentDelete")
	@ResponseBody
	//JSP를 안거치고 body에 바로 담아 응답으로 내보냄.
	public int setCommentDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		
		System.out.println("댓글 삭제 POST 실행");
		
		int result = bankBookService.setCommentDelete(bankBookCommentDTO);
		
		
		return result;
	}

}
