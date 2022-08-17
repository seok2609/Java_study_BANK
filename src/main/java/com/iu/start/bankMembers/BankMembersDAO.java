package com.iu.start.bankMembers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iu.start.util.DBConnector;

@Repository
public class BankMembersDAO implements MembersDAO {
	
	@Autowired
	private SqlSession sqlSession;
	public final String NAMESPACE = "com.iu.start.bankMembers.BankMembersDAO.";
	
	@Override
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		
//		//1. DB연결
//		Connection con = DBConnector.getConnection();
//				
//		//2. Query문 작성
//		String sql = "INSERT INTO BANKMEMBERS "
//					+ "VALUES (?,?,?,?,?)";
//		
//		//3. Query문 미리 전송
//		PreparedStatement st = con.prepareStatement(sql);
//				
//		//4. ?값 처리
//		st.setString(1, bankMembersDTO.getUserName());
//		st.setString(2, bankMembersDTO.getPassWord());
//		st.setString(3, bankMembersDTO.getName());
//		st.setString(4, bankMembersDTO.getEmail());
//		st.setString(5, bankMembersDTO.getPhone());
//				
//		//5. 최종 전송 후 출력
//		int result = st.executeUpdate();
//				
//		//6. 자원해제
//		DBConnector.disConnect(st, con);
		
		return sqlSession.insert(NAMESPACE+"setJoin",bankMembersDTO);
	}

	@Override
	public List<BankMembersDTO> getSearchByID(String search) throws Exception {
//		ArrayList<BankMembersDTO> ar = new ArrayList<BankMembersDTO>();
//		//1. DB 연결
//		Connection con = DBConnector.getConnection();
//		
//		//2. Query문 작성
//		String sql = "SELECT * FROM BANKMEMBERS WHERE USERNAME LIKE ? ORDER BY USERNAME ASC";
//		
//		//3. Query문 미리 전송
//		PreparedStatement st = con.prepareStatement(sql);
//		
//		//4. ?값 세팅
//		st.setString(1, "%"+search+"%");
//		
//		
//		//5. 최종 전송 후 출력
//		ResultSet rs = st.executeQuery();
//		
//		while(rs.next()) {
//			BankMembersDTO bankMembersDTO = new BankMembersDTO();
//			bankMembersDTO.setUserName(rs.getString("USERNAME"));
//			bankMembersDTO.setPassWord(rs.getString("PASSWORD"));
//			bankMembersDTO.setName(rs.getString("NAME"));
//			bankMembersDTO.setEmail(rs.getString("EMAIL"));
//			bankMembersDTO.setPhone(rs.getString("PHONE"));
//			ar.add(bankMembersDTO);
//		}
//		//6. 자원해제
//		
//		DBConnector.disConnect(rs, st, con);
		
		return sqlSession.selectList(NAMESPACE+"getSearchByID",search);
	}
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {
		
//		//DB연결
//		Connection con = DBConnector.getConnection(); 
//		
//		//Query문 작성
//		String sql = "SELECT USERNAME, NAME FROM BANKMEMBERS WHERE USERNAME=? and PASSWORD =?";
//		
//		//Query문 미리전송
//		PreparedStatement st = con.prepareStatement(sql);
//		
//		//?값 있으면 세팅
//		st.setString(1, bankMembersDTO.getUserName());
//		st.setString(2, bankMembersDTO.getPassWord());
//		
//		//최종 결과 처리후 전송
//		ResultSet rs = st.executeQuery();
//		
//		
//		if(rs.next()) {
//			bankMembersDTO = new BankMembersDTO();
//			bankMembersDTO.setUserName(rs.getString("USERNAME"));
//			bankMembersDTO.setName(rs.getString("NAME"));
//		}else {
//			bankMembersDTO = null;
//			//return = null;
//		}
//		
//		//자원해제
//		DBConnector.disConnect(rs, st, con);
		System.out.println(bankMembersDTO.getUserName());
		System.out.println(bankMembersDTO.getPassWord());
		
		
		return sqlSession.selectOne(NAMESPACE+"getLogin", bankMembersDTO);
	}
	
	
	
}
