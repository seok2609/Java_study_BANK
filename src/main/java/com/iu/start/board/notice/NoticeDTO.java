package com.iu.start.board.notice;

import java.util.List;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardFileDTO;

public class NoticeDTO extends BoardDTO{
	
	
	private List<BoardFileDTO> boardFileDTOs;

	public List<BoardFileDTO> getBoardFileDTOs() {
		return boardFileDTOs;
	}

	public void setBoardFileDTOs(List<BoardFileDTO> boardFileDTOs) {
		this.boardFileDTOs = boardFileDTOs;
	}
	
	
}
