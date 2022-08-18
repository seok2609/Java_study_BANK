package com.iu.start.bankAccount;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {
	
	@Autowired
	private BankAccountDAO bankAccountDAO;
	
	public int add(BankAccountDTO bankAccountDTO) throws Exception{
		return bankAccountDAO.add(bankAccountDTO);
	}
}
