package com.iu.start.bankBook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.start.util.DBConnector;

public class BankBookDAO implements BookDAO{

	
	//BookNum : 현재시간을 밀리세컨즈로 변환해서 입력
	//BookSale : 1로 입력
	@Override
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. Query문 작성
		String sql ="INSERT INTO BANKBOOK "
				+ "VALUES (?,?,?,?)"; 
		
		//3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 세팅
		st.setLong(1, bankBookDTO.getBookNum());
		st.setString(2, bankBookDTO.getBookName());
		st.setDouble(3, bankBookDTO.getBookRate());
		st.setInt(4, bankBookDTO.getBookSale());
		
		
		//5. 최종 전송 후 출력
		int result = st.executeUpdate();
		
		//6. 자원해제
		
		DBConnector.disConnect(st, con);
		
		
		return result;
	}
	
	
	//BankBook에 있는 모든 데이터를 조회  최신순으로 조회 = DESC
	@Override
	public ArrayList<BankBookDTO> getList() throws Exception {
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();
		
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. Query문 작성
		String sql = "SELECT * FROM BANKBOOK ORDER BY BOOKNUM DESC";
		
		//3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 세팅
		
		//5. 최종 전송 후 출력
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookNum(rs.getLong("BOOKNUM"));
			bankBookDTO.setBookName(rs.getString("BOOKNAME"));
			bankBookDTO.setBookRate(rs.getDouble("BOOKRATE"));
			bankBookDTO.setBookSale(rs.getInt("BOOKSALE"));
			ar.add(bankBookDTO);
		}
		
		//6. 자원해제
		
		DBConnector.disConnect(rs, st, con);
		
		return ar;
	}

	
	//어느 하나의 row의 Sale컬럼 수정
	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		//2. Query문 작성
		String sql = "UPDATE BANKBOOK SET BOOKSALE = ? WHERE  BOOKNUM = ?";
		//3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 세팅
		st.setInt(1, bankBookDTO.getBookSale());
		st.setLong(2, bankBookDTO.getBookNum());
		
		//5. 최종 전송 후 출력
		int result = st.executeUpdate();
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			bankBookDTO.setBookSale(rs.getInt("BOOKSALE"));
			bankBookDTO.setBookNum(rs.getLong("BOOKNUM"));
		}
		
		//6. 자원해제
		DBConnector.disConnect(st, con);
		
		return result;
	}


	
	//BookNum의 값으로 조회
	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		BankBookDTO bankBookDTO2 = null;
		
		//1. DB 연결
		Connection con = DBConnector.getConnection();
		
		//2. Query문 작성
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUM =?";
		
		//3. Query문 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 세팅
		st.setLong(1, bankBookDTO.getBookNum());
		
		//5. 최종 전송 후 출력
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
//			BankBookDTO bankBookDTO2 = new BankBookDTO();
			bankBookDTO2 = new BankBookDTO();
			bankBookDTO2.setBookNum(rs.getLong("BOOKNUM"));
			bankBookDTO2.setBookName(rs.getString("BOOKNAME"));
			bankBookDTO2.setBookRate(rs.getDouble("BOOKRATE"));
			bankBookDTO2.setBookSale(rs.getInt("BOOKSALE"));
			
		}
		
		//6. 자원해제
		
		DBConnector.disConnect(rs, st, con);
		
		
		return bankBookDTO2;
	}


	@Override
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		
		//DB연결
		Connection con = DBConnector.getConnection();
		
		//Query문 작성
		String sql = "UPDATE BANKBOOK SET BOOKNAME =? , BOOKRATE =? WHERE BOOKNUM =?";
		
		//QUery문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//?값 있으면 세팅
		st.setString(1, bankBookDTO.getBookName());
		st.setDouble(2, bankBookDTO.getBookRate());
		st.setLong(3, bankBookDTO.getBookNum());
		
		//최종 전송 후 출력
		int result = st.executeUpdate();
		
//		ResultSet rs = st.executeQuery();
//		
//		while(rs.next()) {
//			bankBookDTO.setBookName(rs.getString("BOOKNAME"));
//			bankBookDTO.setBookRate(rs.getDouble("BOOKRATE"));
//			bankBookDTO.setBookNum(rs.getLong("BOOKNUM"));
//		}

		//자원해제
		DBConnector.disConnect(st, con);
		
		return result;
	}


	@Override
	public int setDelete(BankBookDTO bankBookDTO) throws Exception {
		
		//DB연결
		Connection con = DBConnector.getConnection();
		
		//Query문 작성
		String sql = "DELETE BANKBOOK WHERE BOOKNUM =?";
		
		//Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//?값 있으면 세팅
		st.setLong(1, bankBookDTO.getBookNum());
		
		//최종 전송 후 출력
		int result = st.executeUpdate();
		
		//자원해제
		DBConnector.disConnect(st, con);
		
		return result;
	}
	

}
