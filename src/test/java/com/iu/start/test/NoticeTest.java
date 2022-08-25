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
	
//	@Test
//	public void getListTest() throws Exception{
//		
//		List<BoardDTO> ar = noticeDAO.getList();
//		assertNotEquals(0, ar.size());
//	}
//
//	@Test
//	public void  setAddTest() throws Exception{
//		for (int i=0;i<100;i++) {
//			NoticeDTO noticeDTO = new NoticeDTO();
//			
//			noticeDTO.setTitle("han" + i);
//			noticeDTO.setContents("jong" +i);
//			noticeDTO.setWriter("seok" +i);
//			
//			int result = noticeDAO.setAdd(noticeDTO);
//			
//			if(i%10 == 0) {
//				Thread.sleep(500);
//			}
//			
//		}
//		
//		System.out.println("finish!");
//	}
	
//	@Test
//	public void getCountTest() throws Exception{
//		
//		long count = noticeDAO.getCount();
//		assertEquals(103L, count);
//		
//
//	}


}
