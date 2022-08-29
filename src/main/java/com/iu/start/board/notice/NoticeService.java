package com.iu.start.board.notice;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.board.impl.BoardDTO;
import com.iu.start.board.impl.BoardFileDTO;
import com.iu.start.board.impl.BoardService;
import com.iu.start.util.FileManager;
import com.iu.start.util.Pager;

@Service
public class NoticeService implements BoardService{
	
	
		@Autowired 
		private NoticeDAO noticeDAO;
//		@Autowired
//		private ServletContext servletContext;
		@Autowired
		private FileManager fileManager;
	

	@Override
	public List<BoardDTO> getList(Pager pager) throws Exception {
		
		Long totalCount = noticeDAO.getCount(pager);
		pager.getNum(totalCount);
		pager.getRowNum();
		
		
		
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
	public int setAdd(BoardDTO boardDTO, MultipartFile [] files, ServletContext servletContext) throws Exception {
		int result = noticeDAO.setAdd(boardDTO);
		String path = "resources/upload/notice";
		
		for(MultipartFile multipartFile: files) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fileName = fileManager.saveFile(servletContext, path, multipartFile);
			BoardFileDTO boardFileDTO = new BoardFileDTO();
			boardFileDTO.setFileName(path);
			boardFileDTO.setOriName(multipartFile.getOriginalFilename());
			boardFileDTO.setNum(boardDTO.getNum());
			noticeDAO.setAddFile(boardFileDTO);
		}
		
		
		
//		//저장할 폴더의 실제 경로 반환
//		String realPath = servletContext.getRealPath("resources/upload/notice");
//		System.out.println("RealPath : " + realPath);
//		
//		//저장할 폴더의 정보를 가지는 자바 객체 생성
//		File file = new File(realPath);
//		
//		//file 첨부를 안할때 구분
//		
//		if(!file.exists()) {
//				file.mkdirs();
//		}
//		
//		for(MultipartFile mf: files) {
//			if(mf.isEmpty()) {
//				continue;
//			}
//			
//			//저장하는 코드
//			
//			//jpg 경로 리셋
//			file = new File(realPath);
//		
//		//중복되지 않는 파일명 생성
//		String fileName = UUID.randomUUID().toString();
//		System.out.println("fileName : " + fileName);
//		
//		Calendar ca = Calendar.getInstance();
//		Long time = ca.getTimeInMillis();
//		
//		//확장자 붙히기
//		fileName = fileName+"_"+mf.getOriginalFilename();
//		System.out.println("fileName : " + fileName);
//		
//		//HDD에 파일저장
//		//어느 폴더에 어떤 이름을 저장할 file 객체 생성
//		file = new File(file, fileName);	//폴더, 파일명
//		
//		mf.transferTo(file); //리턴타입 void이기 때문에 저장후 아무것도 안함
//		
//		BoardFileDTO boardFileDTO = new BoardFileDTO();
//		boardFileDTO.setFileName(fileName);
//		boardFileDTO.setOriName(mf.getOriginalFilename());
//		boardFileDTO.setNum(boardDTO.getNum());
//		noticeDAO.setAddFile(boardFileDTO);

//		}
//		return noticeDAO.setAdd(boardDTO);1
			return result;
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
