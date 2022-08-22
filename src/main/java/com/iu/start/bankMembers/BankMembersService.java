package com.iu.start.bankMembers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.bankAccount.BankAccountDAO;
import com.iu.start.bankAccount.BankAccountDTO;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception{
		return bankMembersDAO.getLogin(bankMembersDTO);
	}
	
	
	//BankMembers 회원가입
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception{
		return bankMembersDAO.setJoin(bankMembersDTO);
	}
	
	
	//검색어를 입력해서 ID를 abc 순으로 찾기
	public List<BankMembersDTO> getSearchByID(String search) throws Exception{
		return bankMembersDAO.getSearchByID(search);
	}
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception{

		
		//List<BankAccountDTO> ar = bankAccountDAO.getListByUserName(bankMembersDTO);
		bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
		
		return bankMembersDAO.getMyPage(bankMembersDTO);
	}
	
	

}
