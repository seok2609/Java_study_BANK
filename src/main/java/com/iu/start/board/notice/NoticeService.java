package com.iu.start.board.notice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.Pager;

@Service
public class NoticeService implements BoardService{
	
	
		@Autowired 
		private NoticeDAO noticeDAO;
	

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		pager.getRowNum();
		Long totalCount = noticeDAO.getCount();
		pager.getNum(totalCount);
		
		
		
//		System.out.println("Service Page : "+page);
//		Long perPage = 10L; //한페이지에 출력할 목록의 갯수
//		// 페이지에 10개씩 출력 기준
//		// page				startRow			lastRow
//		// 1				1					10
//		// 2				11					20
//		// 3				21					30
//		Long startRow = (page-1)*perPage+1;
//		Long lastRow = page*perPage;
//		
//		System.out.println("Strat Row :" +startRow);
//		System.out.println("Last Row : "+lastRow);
//		Map<String, Long> map = new HashMap<String, Long>();
//		
//		map.put("startRow", startRow);
//		map.put("lastRow", lastRow);
//		
//		/****************************
//		 * 
//		 * 글의 갯수가 총 80개
//		 * 1. 글의 총 갯수
//		 * 2. 글의 총 갯수를 이용해서 총 페이지수 구하기
//		 * 
//		 * */
//		
//		/**********************
//		 * 1. 글의 총 갯수
//		 * 
//		 */
//		Long totalCount = noticeDAO.getCount();
//		
//		/********************
//		 * 1.글의 총 페이지 수
//		 */
//		
//		Long totalPage = totalCount/perPage;
//		if(totalCount%perPage !=0) {
//			totalPage = totalPage+1;
//			totalPage++;
//		}
//		
//		/*******************
//		 * 3. totalBlock 갯수 구하기
//		 * Block	: 
//		 * perBlock : 한페이지에 출력할 번호의 수
//		 * 
//		 *******************/
//		Long perBlock = 5L;
//		Long totalBlock = totalPage/perBlock;
//		if(totalPage%perBlock != 0) {
//			totalBlock++;
//		}
//		
//		/*****************
//		 * 4. page로 현재 Block 번호 찾기
//		 * 
//		 * page			curBlock
//		 * 1			1
//		 * 2			1
//		 * 3			1
//		 * 4			1
//		 * 5			1
//		 * 6			2
//		 * ...			2
//		 * 10			2
//		 * 11			3	
//		 *****************/
//		Long curBlock = page/perBlock;
//		if(page%perBlock != 0) {
//			curBlock++;
//		}
//		
//		/******************
//		 * 5. cutBlock로 시작번호와 끝번호 알아 오기
//		 * 
//		 * curBlock		startNum	lastNum
//		 * 1			1			5
//		 * 2			6			10
//		 * 3			11			15
//		 * 4			16			20
//		 ******************/
//		Long StartNum = (curBlock-1)*perBlock+1;
//		Long lastNum = curBlock*perBlock;
	
		
		
		return noticeDAO.getList(pager);
	}

	@Override
	public BoardDTO getDetail(BoardDTO boardDTO) throws Exception {
		
		return noticeDAO.getDetail(boardDTO);
	}

	@Override
	public int setAdd(BoardDTO boardDTO) throws Exception {
		
		return noticeDAO.setAdd(boardDTO);
	}

	@Override
	public int setUpdate(BoardDTO boardDTO) throws Exception {
		
		return noticeDAO.setUpdate(boardDTO);
	}

	@Override
	public int setDelete(BoardDTO boardDTO) throws Exception {
		
		return noticeDAO.setDelete(boardDTO);
	}

}
