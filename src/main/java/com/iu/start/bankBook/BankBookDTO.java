package com.iu.start.bankBook;

import java.sql.Timestamp;

public class BankBookDTO {
	
	private Long booknum;
	private String bookname;
	private Double bookrate;
	private Integer booksale;
	
	
	public long getBooknum() {
		return booknum;
	}
	public void setBooknum(long l) {
		this.booknum = l;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public double getBookrate() {
		return bookrate;
	}
	public void setBookrate(double bookrate) {
		this.bookrate = bookrate;
	}
	public int getBooksale() {
		return booksale;
	}
	public void setBooksale(int booksale) {
		this.booksale = booksale;
	}
	
	

}
