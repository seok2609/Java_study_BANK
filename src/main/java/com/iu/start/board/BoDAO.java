package com.iu.start.board;

import java.util.ArrayList;

public interface BoDAO {

	public ArrayList<BoardDTO> getlist() throws Exception;
	
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	
	public int add(BoardDTO boardDTO) throws Exception;
	
	public int update(BoardDTO boardDTO) throws Exception;
	
	public int delete(BoardDTO boardDTO) throws Exception;
	
	
}
