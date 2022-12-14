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

	@Override
	public Long getCommentListTotalCount(CommentPager commentPager) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getCommentListTotalCount", commentPager);
	}

	@Override
	public int setCommentUpdate(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		
		return sqlSession.update(NAMESPACE+"setCommentUpdate", bankBookCommentDTO);
	}

	@Override
	public int setCommentDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception {
		
		return sqlSession.delete(NAMESPACE+"setCommentDelete", bankBookCommentDTO);
	}
	
	

}
