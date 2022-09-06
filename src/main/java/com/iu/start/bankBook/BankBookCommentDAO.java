package com.iu.start.bankBook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.util.CommentPager;

@Repository
public class BankBookCommentDAO implements CommentDAO{

	@Autowired
	private SqlSession sqlSession;
	public final String NAMESPACE = "com.iu.start.bankBook.BankBookCommentDAO.";
	
	@Override
	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		
		
		
		return sqlSession.insert(NAMESPACE+"setCommentAdd",bankBookCommentDTO);
	}

	@Override
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager) throws Exception {
	
		return sqlSession.selectList(NAMESPACE+"getCommentList", commentPager);
	}
	
	

}
