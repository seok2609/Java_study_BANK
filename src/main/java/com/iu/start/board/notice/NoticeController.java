package com.iu.start.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {
	
	@Autowired 
	private NoticeService noticeService;
	
	@ModelAttribute("board")
	public String getBoard() {
		return "Notice";
	}
	
	//글목록
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("글목록 GET 실행");
		System.out.println(pager.getPage());
		
		System.out.println(pager.getKind());
		System.out.println(pager.getSearch());
		
//		System.out.println("Page : "+ page);
//		
		List<BoardDTO> ar = noticeService.getList(pager);
		
		mv.addObject("pager", pager);
		mv.addObject("list", ar);
//		mv.addObject("board", "Notice");
		mv.setViewName("board/list");
		
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
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public String setAdd() throws Exception{
		
		return "board/add";
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public ModelAndView setAdd(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		int result = noticeService.setAdd(boardDTO);
		

		mv.setViewName("redirect:./list.iu");
		
		if(result == 1) {
			System.out.println("글 작성 성공!!");
		}else {
			System.out.println("글 작성 실패!!");
		}
		
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
	
	
}
