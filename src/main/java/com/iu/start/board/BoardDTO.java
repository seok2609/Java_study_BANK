package com.iu.start.board;

import java.sql.Date;

public class BoardDTO {
	
	private Long boardNum;
	private String boardName;
	private String boardContents;
	private String boardWriter;
	private Date boardDate;
	private Long boardView;
	
	
	public Long getBoardNum() {
		return boardNum;
	}
	public void setBoardNum(Long boardNum) {
		this.boardNum = boardNum;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getBoardContents() {
		return boardContents;
	}
	public void setBoardContents(String boardContents) {
		this.boardContents = boardContents;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public Long getBoardView() {
		return boardView;
	}
	public void setBoardView(Long boardView) {
		this.boardView = boardView;
	}
	

}
