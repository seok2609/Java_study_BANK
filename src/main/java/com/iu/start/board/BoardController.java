package com.iu.start.board;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.bankBook.BankBookDAO;
import com.iu.start.bankBook.BankBookDTO;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {
	
	//list Get
	
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public String getlist(Model model) throws Exception{
		BoardDAO boardDAO = new BoardDAO();
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		
		System.out.println("Board List Get실행");
		
		
		ar = boardDAO.getlist();
//		System.out.println(ar);
//		System.out.println(ar.get(0));
		
		model.addAttribute("list", ar);
		
		return "board/list";
		
	}
	
	//Detail GET
	
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public ModelAndView getdetail(BoardDTO boardDTO) throws Exception {
		ModelAndView mv = new ModelAndView();

		System.out.println("Board detail Get 실행");

		BoardDAO boardDAO = new BoardDAO();
		boardDTO = boardDAO.getDetail(boardDTO);

		
		mv.addObject("dto", boardDTO);
		mv.setViewName("board/detail");
		
		return mv;
	}
	
	// Add GET
	
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public String add() throws Exception{
		System.out.println("Board add GET 실행");
		
		return "board/add";
		
	}
	
	//Add POST
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public ModelAndView add(BoardDTO boardDTO) throws Exception{
		BoardDAO boardDAO = new BoardDAO();
		ModelAndView mv = new ModelAndView();
		
		
		mv.addObject("dto", boardDTO);
		mv.setViewName("redirect:./list.iu");
		
		int result = boardDAO.add(boardDTO);
		System.out.println(result==1);
		
		if(result==1) {
			System.out.println("추가에 성공하였습니다!");
		}else {
			System.out.println("추가에 실패하였습니다!");
		}
		
		return mv;
	}
	
	//UPDATE GET
	
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public String update() throws Exception{
		System.out.println("Board 수정하기 GET 실행");
		
		return "board/update";
	}
	
	//UPDATE POST
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public ModelAndView update(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("Board 수정하기 POST 실행");
		
		BoardDAO boardDAO = new BoardDAO();
		int result = boardDAO.update(boardDTO);
		System.out.println(result==1);
		
		mv.addObject("dto", boardDTO);
		mv.setViewName("redirect:./list.iu?boardNum="+boardDTO.getBoardNum());
		
		
		if(result == 1) {
			System.out.println("수정에 성공하였습니다!!");
		}else {
			System.out.println("수정에 실패하였습니다!!");
		}
		
		return mv;
	}
	
	//DELETE GET
	@RequestMapping(value = "delete.iu", method = RequestMethod.GET)
	public ModelAndView delete(BoardDTO boardDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		
		System.out.println("Board 삭제 GET 실행");
		BoardDAO boardDAO = new BoardDAO();
		
		int result = boardDAO.delete(boardDTO); 
		
		
		if(result == 1) {
			System.out.println("삭제에 성공하였습니다!!");
		}else {
			System.out.println("삭제에 실패 하였습니다!!");
		}
		
		mv.addObject("dto", boardDTO);
		mv.setViewName("redirect:./list.iu");
		
		return mv;
	}

}
