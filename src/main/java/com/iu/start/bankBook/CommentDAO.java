package com.iu.start.bankBook;

import java.util.List;

import com.iu.start.util.CommentPager;

public interface CommentDAO {
	
	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception;
	
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager) throws Exception;
}
