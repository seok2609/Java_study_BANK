package com.iu.start.board.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.web.multipart.MultipartFile;

import com.iu.start.util.Pager;

public interface BoardDAO {
	
	//글목록
	public List<BoardDTO> getList(Pager pager) throws Exception;

	
	//글상세보기
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception;
	
	
	//글쓰기
	public int setAdd(BoardDTO boardDTO) throws Exception;
	
	
	//글수정
	public int setUpdate(BoardDTO boardDTO) throws Exception; 
	
	
	//글삭제
	public int setDelete(BoardDTO boardDTO) throws Exception;
	
	//글의 총 갯수 가져오기
	public Long getCount(Pager pager) throws Exception;
	
	//파일추가
	public int setAddFile(BoardFileDTO boardFileDTO) throws Exception;
	
	//파일 삭제
	public int setFileDelete(BoardFileDTO boardFileDTO) throws Exception;
	
	//파일 등록
	public BoardFileDTO getFileDetail(BoardFileDTO boardFileDTO)throws Exception;
	
}
