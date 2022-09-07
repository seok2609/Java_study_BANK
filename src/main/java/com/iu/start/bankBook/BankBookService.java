package com.iu.start.bankBook;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.util.CommentPager;

@Service
public class BankBookService {
	
	@Autowired
	private BankBookDAO bankBookDAO;
	@Autowired
	private BankBookCommentDAO bankBookCommentDAO;
	
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setBankBook(bankBookDTO);
	}
	
	
	//BankBook에 있는 모든 데이터를 조회  최신순으로 조회 = DESC
	public List<BankBookDTO> getList() throws Exception{
		return bankBookDAO.getList();
	}
	
	
	//어느 하나의 row의 Sale컬럼 수정
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setChangeSale(bankBookDTO);
	}
	
	
	//BookNum의 값으로 조회
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.getDetail(bankBookDTO);
	}
	
	
	//수정
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setUpdate(bankBookDTO);
	}
	
	//삭제
	public int setDelete(BankBookDTO bankBookDTO) throws Exception{
		return bankBookDAO.setDelete(bankBookDTO);
	}
	
	//댓글달기
	public int setCommentAdd(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		return bankBookCommentDAO.setCommentAdd(bankBookCommentDTO);
	}
	
	public List<BankBookCommentDTO> getCommentList(CommentPager commentPager) throws Exception{
		commentPager.getRowNum();
		Long totalCount = bankBookCommentDAO.getCommentListTotalCount(commentPager);
		commentPager.makePage(totalCount);
		return bankBookCommentDAO.getCommentList(commentPager);
	}
	
	//댓글 수정하기
	public int setCommentUpdate(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		
		return bankBookCommentDAO.setCommentUpdate(bankBookCommentDTO);
	}
	
	//댓글 삭제하기
	public int setCommentDelete(BankBookCommentDTO bankBookCommentDTO) throws Exception{
		
		return bankBookCommentDAO.setCommentDelete(bankBookCommentDTO);
	}
	

}
