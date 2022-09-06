package com.iu.start.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.bankBook.BankBookCommentDAO;
import com.iu.start.bankBook.BankBookCommentDTO;
import com.iu.start.util.CommentPager;

public class BankBookCommentDAOTest extends MyAbstractTest{
	
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	@Test
	public void getCommentListTest() throws Exception{
		CommentPager commentPager = new CommentPager();
		commentPager.setBookNum(3L);
		commentPager.setPage(1L);
		commentPager.getRowNum();
		List<BankBookCommentDTO> ar = bankBookCommentDAO.getCommentList(commentPager);
		assertNotEquals(0, ar.size());
	}

	@Test
	public void setCommentAdd() throws Exception{
		BankBookCommentDTO bankBookCommentDTO = new BankBookCommentDTO();
		bankBookCommentDTO.setBookNum(1659514160214L);
		bankBookCommentDTO.setContents("gkgk");
		bankBookCommentDTO.setWriter("dd");
		
		int result = bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
		assertEquals(1, result);
	}

}
