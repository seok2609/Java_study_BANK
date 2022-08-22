package com.iu.start.bankAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.bankMembers.BankMembersDTO;
import com.iu.start.util.DBConnector;

@Repository
public class BankAccountDAO implements AccountDAO {
	
	@Autowired 
	private SqlSession sqlSession;
	public final String NAMESPACE = "com.iu.start.bankAccount.BankAccountDAO.";

	@Override
	public int add(BankAccountDTO bankAccountDTO) throws Exception {
//		//DB연결
//		Connection con = DBConnector.getConnection();
//		
//		//Query문 작성
//		String sql = "INSERT INTO BANKACCOUNT VALUES (ACCOUNT_SEQ.NEXTVAL, ?, ?, SYSDATE)";
//		
//		//Query문 미리 전송
//		PreparedStatement st = con.prepareStatement(sql);
//		
//		//?값 있으면 세팅
//		st.setString(1, bankAccountDTO.getUserName());
//		st.setLong(2, bankAccountDTO.getBookNum());
//		
//		//최종 결과 처리후 전송
//		int result = st.executeUpdate();
//		
//		
//		//자원해제
//		DBConnector.disConnect(st, con);
		
		return sqlSession.insert(NAMESPACE+"add",bankAccountDTO);
	}

	@Override
	public List<BankAccountDTO> getListByUserName(BankMembersDTO bankMembersDTO) throws Exception {
		return sqlSession.selectList(NAMESPACE+"getListByUserName", bankMembersDTO);
	}

	
	
	

}
