package com.iu.start.test;

import com.iu.start.bankBook.BankBookDAO;
import com.iu.start.bankBook.BankBookDTO;

public class BankBookTestMain {
	
	public static void main(String[] args) {
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO = new BankBookDTO();
		
		bankBookDTO.setBookNum(1L);
		
		try {
			//bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
			
			System.out.println(bankBookDTO != null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
