package com.iu.start.board.notice;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.board.impl.BoardDAO;
import com.iu.start.board.impl.BoardDTO;
import com.iu.start.util.Pager;

@Repository
public class NoticeDAO implements BoardDAO{
	
	@Autowired
	private SqlSession sqlSession;
	public final String NAMESPACE = "com.iu.start.board.notice.NoticeDAO.";

	
	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getList", pager);
	}
	

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getDetail", boardDTO);
	}
	

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"setAdd", boardDTO);
	}
	

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
	
		return sqlSession.insert(NAMESPACE+"setUpdate", boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {

		return sqlSession.insert(NAMESPACE+"setDelete", boardDTO);
	}

	@Override
	public Long getCount() throws Exception {
		
		return sqlSession.selectOne(NAMESPACE+"getCount");
	}
	
	

}
