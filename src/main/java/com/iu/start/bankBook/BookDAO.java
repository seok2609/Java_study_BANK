package com.iu.start.bankBook;

import java.util.ArrayList;

public interface BookDAO {
	
	//BankBook Table에 INSERT
	
	//BookNum : 현재시간을 밀리세컨즈로 변환해서 입력
	//BookSale : 1로 입력
	
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception;
	
	
	//BankBook에 있는 모든 데이터를 조회  최신순으로 조회 = DESC
	public ArrayList<BankBookDTO> getList() throws Exception;
	
	
	//어느 하나의 row의 Sale컬럼 수정
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception;
	
	
	//BookNum의 값으로 조회
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception;
}
