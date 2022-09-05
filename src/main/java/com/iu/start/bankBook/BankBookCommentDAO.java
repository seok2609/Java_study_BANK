package com.iu.start.bankBook;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BankBookCommentDAO implements CommentDAO{

	@Autowired
	private SqlSession sqlSession;
	public final String NAMESPACE = "com.iu.start.bankBook.BankBookCommentDAO.";
	
	@Override
	public int setComment(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		
		
		
		return sqlSession.insert(NAMESPACE+"setComment",bankBookCommentDTO);
	}
	
	

}
