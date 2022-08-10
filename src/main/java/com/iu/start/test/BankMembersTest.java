package com.iu.start.test;

import java.util.ArrayList;

import com.iu.start.bankBook.BankBookDAO;
import com.iu.start.bankBook.BankBookDTO;
import com.iu.start.bankMembers.BankMembersDAO;
import com.iu.start.bankMembers.BankMembersDTO;

public class BankMembersTest {
	
	public static void main(String[] args) {
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO = new BankBookDTO();
//		bankMembersDTO.setUsername("ABCD");
//		bankMembersDTO.setPassword("2");
//		bankMembersDTO.setName("HELLO");
//		bankMembersDTO.setEmail("dkekd");
//		bankMembersDTO.setPhone("01051151");
		
		
//		bankBookDTO.setBooknum(System.currentTimeMillis());
//		bankBookDTO.setBookname("청년통장");
//		bankBookDTO.setBookrate(2.7);
//		bankBookDTO.setBooksale(1);
		
		
		try {
//			int result = bankMembersDAO.setJoin(bankMembersDTO);
//			System.out.println(result == 1);
			
//			ArrayList<BankMembersDTO> ar = bankMembersDAO.getSearchByID("n");
//			System.out.println(ar.size()>0);
			
//			int result = bankBookDAO.setBankBook(bankBookDTO);
//			System.out.println(result == 1);
			
//			ArrayList<BankBookDTO> ar = bankBookDAO.getList();
//			System.out.println(ar);
			
			int result = bankBookDAO.setChangeSale(bankBookDTO);
			
			System.out.println(result == 1);
			bankBookDTO.setBookNum(1L);
			
			//bankBookDAO.getDetail(bankBookDTO);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
