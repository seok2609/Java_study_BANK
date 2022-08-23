package com.iu.start.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.notice.NoticeDAO;
import com.iu.start.board.notice.NoticeDTO;


public class NoticeTest extends MyAbstractTest{
	@Autowired
	private NoticeDAO noticeDAO;
	private NoticeDTO noticeDTO;
	
	@Test
	public void getListTest() throws Exception{
		
		List<BoardDTO> ar = noticeDAO.getList();
		assertNotEquals(0, ar.size());
	}
	
	@Test
	public void setAddTest() throws Exception{
		NoticeDTO noticeDTO = new NoticeDTO();
		
		noticeDTO.setTitle("안녕");
		noticeDTO.setWriter("user1");
		noticeDTO.setContents("hello");
		
		int result = noticeDAO.setAdd(noticeDTO);
		assertEquals(1, result);
		
	}

}
