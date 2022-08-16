package com.iu.start.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.iu.start.util.DBConnector;

public class BoardDAO implements BoDAO {

	@Override
	public ArrayList<BoardDTO> getlist() throws Exception {
		
		ArrayList<BoardDTO> ar = new ArrayList<BoardDTO>();
		//1. DB연결
		Connection con  = DBConnector.getConnection();
		
		//2. Query문 작성
		String sql = "SELECT BOARDNUM, BOARDNAME, BOARDWRITER, BOARDDATE, BOARDVIEW FROM BOARD";
		
		//3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 있으면 셋팅
		
		//5. 최종결과 처리후 전송
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BoardDTO boardDTO = new BoardDTO();
			
			boardDTO.setBoardNum(rs.getLong("BOARDNUM"));
			boardDTO.setBoardName(rs.getString("BOARDNAME"));
			boardDTO.setBoardWriter(rs.getString("BOARDWRITER"));
			boardDTO.setBoardDate(rs.getDate("BOARDDATE"));
			boardDTO.setBoardView(rs.getLong("BOARDVIEW"));
//			System.out.println(boardDTO.getBoardNum());
			ar.add(boardDTO);
		}
		
		//6. 자원해제
		DBConnector.disConnect(rs, st, con);
		
		return ar;
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		BoardDTO boardDTO2 = null;
		
		//1. DB연결
		Connection con = DBConnector.getConnection();
		
		//2. Query문 작성
		String sql = "SELECT * FROM BOARD WHERE BOARDNUM =?";
		
		//3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 있으면 세팅
		st.setLong(1, boardDTO.getBoardNum());
		
		//5. 최종 결과 처리 후 전송
		ResultSet rs = st.executeQuery();
		
		
		if(rs.next()) {
			boardDTO2 = new BoardDTO();
			boardDTO2.setBoardNum(rs.getLong("BOARDNUM"));
			boardDTO2.setBoardName(rs.getString("BOARDNAME"));
			boardDTO2.setBoardWriter(rs.getString("BOARDWRITER"));
			boardDTO2.setBoardDate(rs.getDate("BOARDDATE"));
			boardDTO2.setBoardView(rs.getLong("BOARDVIEW"));
			boardDTO2.setBoardContents(rs.getString("BOARDCONTENTS"));
			
		}
		//6. 자원해제
		DBConnector.disConnect(rs, st, con);
		
		return boardDTO2;
	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		//1. DB연결
		Connection con = DBConnector.getConnection();
		
		//2. Query문 작성
		String sql = "INSERT INTO BOARD VALUES (BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE, ?)";
		
		//3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 있으면 세팅
		st.setString(1, boardDTO.getBoardName());
		st.setString(2, boardDTO.getBoardContents());
		st.setString(3, boardDTO.getBoardWriter());
		st.setLong(4, boardDTO.getBoardView());
		
		//5. 최종 결괴 처리 후 전송
		int result = st.executeUpdate();
		
		
		
		//6. 자원해제
		DBConnector.disConnect(st, con);
		
		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		//1. DB연결
		Connection con = DBConnector.getConnection();
		
		//2. Query문 작성
		String sql = "UPDATE BOARD SET BOARDNAME = ?, BOARDCONTENTS =?  WHERE  BOARDNUM = ?";
		
		//3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		
		//4. ?값 있으면 세팅
		st.setString(1, boardDTO.getBoardName());
		st.setString(2, boardDTO.getBoardContents());
		st.setLong(3, boardDTO.getBoardNum());
		
		//5. 최종 결과 처리 후 전송
		int result = st.executeUpdate();
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			boardDTO.setBoardName(rs.getString("BOARDNAME"));
			boardDTO.setBoardContents(rs.getString("BOARDCONTENTS"));
			boardDTO.setBoardNum(rs.getLong("BOARDNUM"));
		}
		
		//6. 자원해제
		DBConnector.disConnect(st, con);
		
		return result;
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		//1. DB연결
		Connection con = DBConnector.getConnection();
		
		//2. Query문 작성
		String sql = "DELETE BOARD WHERE BOARDNUM =?";
				
		//3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
				
		//4. ?값 있으면 세팅
		st.setLong(1, boardDTO.getBoardNum());
				
		//5. 최종 결과 처리 후 전송
		int result = st.executeUpdate();
				
		//6. 자원해제
		
		DBConnector.disConnect(st, con);
		return result;
	}
	
	
	
	

}
