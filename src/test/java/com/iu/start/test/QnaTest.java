package com.iu.start.test;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.notice.NoticeDAO;
import com.iu.start.board.notice.NoticeDTO;
import com.iu.start.board.qna.QnaDAO;
import com.iu.start.board.qna.QnaDTO;


public class QnaTest extends MyAbstractTest{

	@Autowired
	private QnaDAO qnaDAO;
	private NoticeDAO noticeDAO;
	
//	@Test
//	public void getListTest() throws Exception{
//		
//		List<BoardDTO> ar = qnaDAO.getList();
//		assertNotEquals(0, ar.size());
//	}
//	
//	@Test
//	public void setAddTest() throws Exception{
//		QnaDTO qnaDTO = new QnaDTO();
//		
//		qnaDTO.setTitle("이이이이이이");
//		qnaDTO.setWriter("user2");
//		qnaDTO.setContents("galeldldl");
//		
//		int result = qnaDAO.setAdd(qnaDTO);
//		assertEquals(1, result);
//		
//	}
	
//	@Test
//	public void setReplyTest() throws Exception{
//		QnaDTO qnaDTO = new QnaDTO();
//		
//		qnaDTO.setTitle("asdfs");
//		qnaDTO.setContents("sdfhhw1");
//		qnaDTO.setWriter("hs");
//		
//		int result = qnaDAO.setReply(qnaDTO);
//		assertEquals(1, result);
//		
//	}
	
	}
