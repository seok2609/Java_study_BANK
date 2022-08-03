package com.iu.start.test;

import java.util.ArrayList;

import com.iu.start.bankMembers.BankMembersDAO;
import com.iu.start.bankMembers.BankMembersDTO;

public class BankMembersTest {
	
	public static void main(String[] args) {
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		bankMembersDTO.setUsername("ABCD");
//		bankMembersDTO.setPassword("2");
//		bankMembersDTO.setName("HELLO");
//		bankMembersDTO.setEmail("dkekd");
//		bankMembersDTO.setPhone("01051151");
		
		
		try {
//			int result = bankMembersDAO.setJoin(bankMembersDTO);
//			System.out.println(result == 1);
			
			ArrayList<BankMembersDTO> ar = bankMembersDAO.getSearchByID("n");
			System.out.println(ar.size()>0);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
