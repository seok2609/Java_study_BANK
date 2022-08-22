package com.iu.start.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.iu.start.bankAccount.BankAccountDAO;
import com.iu.start.bankAccount.BankAccountDTO;
import com.iu.start.bankMembers.BankMembersDTO;

public class AccountTestDAO extends MyAbstractTest {


	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	@Test
	public void getListTest()throws Exception{
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		bankMembersDTO.setUserName("id1");
		List<BankAccountDTO> ar = bankAccountDAO.getListByUserName(bankMembersDTO);
		//assertNotEquals(0, ar.size());
		assertEquals(0, ar.size());
	}

}
