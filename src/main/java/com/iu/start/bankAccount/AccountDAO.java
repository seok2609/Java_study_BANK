package com.iu.start.bankAccount;

import java.util.List;

import com.iu.start.bankMembers.BankMembersDTO;

public interface AccountDAO {

	public int add(BankAccountDTO bankAccountDTO) throws Exception;
	

	public List<BankAccountDTO> getListByUserName(BankMembersDTO bankMembersDTO) throws Exception;
	
}
