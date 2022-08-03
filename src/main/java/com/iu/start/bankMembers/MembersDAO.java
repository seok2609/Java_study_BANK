package com.iu.start.bankMembers;

import java.util.ArrayList;

public interface MembersDAO {
	
	//BankMembers 회원가입
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception;
	
	
	//검색어를 입력해서 ID를 abc 순으로 찾기
	public ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception;

}
