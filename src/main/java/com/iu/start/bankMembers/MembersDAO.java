package com.iu.start.bankMembers;

import java.util.List;

public interface MembersDAO {
	
	//BankMembers 회원가입
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception;
	
	
	//검색어를 입력해서 ID를 abc 순으로 찾기
	public List<BankMembersDTO> getSearchByID(String search) throws Exception;

}
