package com.iu.start.bankMembers;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iu.start.bankAccount.BankAccountDAO;
import com.iu.start.bankAccount.BankAccountDTO;
import com.iu.start.file.FileDTO;
import com.iu.start.util.FileManager;

@Service
public class BankMembersService {
	
	@Autowired
	private BankMembersDAO bankMembersDAO;
//	@Autowired
//	private ServletContext servletContext;
	@Autowired
	private BankAccountDAO bankAccountDAO;
	@Autowired
	private FileManager fileManager;
	
	
	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception{
		return bankMembersDAO.getLogin(bankMembersDTO);
	}
	
	
	//BankMembers 회원가입
	public int setJoin(BankMembersDTO bankMembersDTO, MultipartFile photo, ServletContext servletContext) throws Exception{
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		String path = "resources/upload/member";
		String fileName = fileManager.saveFile(servletContext, path, photo);
		
		if(!photo.isEmpty()) {
			BankMembersFileDTO bankMembersFileDTO = new BankMembersFileDTO();
			bankMembersFileDTO.setFileName(fileName);
			bankMembersFileDTO.setOriName(photo.getOriginalFilename());
			bankMembersFileDTO.setUserName(bankMembersDTO.getUserName());
			bankMembersDAO.setAddFile(bankMembersFileDTO);
			
			
		}
		
//		//	1.	HDD에 파일을 저장
//		//	파일 저장시 파일의 경로는 Tomcat 기준이 아니라 OS의 기준으로 설정
//		//	1) 파일저장 위치
//		//		/resources/upload/member
//		
//		//	2) 저장할 폴더의 실제 경로 반환(OS 기준)
//		String realPath = servletContext.getRealPath("resources/upload/member");
//		System.out.println("RealPath : " + realPath);
//		
//		//	3) 저장할 폴더의 정보를 가지는 자바 객체 생성
//		File file = new File(realPath);
//		
//		//	*** File 첨부가 없을 때 구분
////		if(photo.getSize()!=0) {}
//		if(!photo.isEmpty()) {
//			
//			
//			if(!file.exists()) {
//				file.mkdirs();
//			}
//			
//			//	4) 중복되지 않는 파일명 생성
//			//		--시간, java api,...
//			String fileName = UUID.randomUUID().toString();
//			System.out.println("fileName : " + fileName);
//			
//			Calendar ca = Calendar.getInstance();
//			Long time = ca.getTimeInMillis();
//			
//			//확장자 붙히기
//			fileName = fileName+"_"+photo.getOriginalFilename();
//			System.out.println("fileName : " + fileName);	
//			
//			//	5. HDD에 파일저장
//			//	어느 폴더에 어떤 이름을 저장할 File 객체 생성
//			file = new File(file, fileName);
//			//		1)MultipartFile 클래스의 transferTo 메서드 사용
//			photo.transferTo(file); // 리턴타입 void이기때문에 저장하고 아무것도 안함
//			
//			//		2)FileCopyUtils 클래스의 copy 메서드 사용
//
//			//	2. 	저장된 파일정보를 DB에 저장
//			BankMembersFileDTO bankMembersFileDTO = new BankMembersFileDTO();
//			bankMembersFileDTO.setFileName(fileName);
//			bankMembersFileDTO.setOriName(photo.getOriginalFilename());
//			bankMembersFileDTO.setUserName(bankMembersDTO.getUserName());
//			
//			bankMembersDAO.setAddFile(bankMembersFileDTO);
//			
//			
//		}//isEmpty 끝
		
		
		return result;
	}
	
	
	//검색어를 입력해서 ID를 abc 순으로 찾기
	public List<BankMembersDTO> getSearchByID(String search) throws Exception{
		return bankMembersDAO.getSearchByID(search);
	}
	
	public BankMembersDTO getMyPage(BankMembersDTO bankMembersDTO) throws Exception{

		
		//List<BankAccountDTO> ar = bankAccountDAO.getListByUserName(bankMembersDTO);
		bankMembersDTO = bankMembersDAO.getMyPage(bankMembersDTO);
		
		return bankMembersDAO.getMyPage(bankMembersDTO);
	}
	
	

}
