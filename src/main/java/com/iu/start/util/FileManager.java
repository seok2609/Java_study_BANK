package com.iu.start.util;

import java.io.File;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

//Anotation을 이용한 클래스 객체주입
@Component
public class FileManager {
	
	//ServletContext를 주입
//	@Autowired
//	private ServletContext servletContext;
	
	//save
//	public void saveFile(ServletContext servletContext, String path) throws Exception{	
	public String saveFile(ServletContext servletContext, String path, MultipartFile multipartFile) throws Exception{
		
		//1. 실제경로
		String realPath = servletContext.getRealPath(path);
		System.out.println(realPath);
		
		//2. 폴더(directory)체크
		File file = new File(realPath);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		//3. 저장할 파일명 생성
		String fileName = UUID.randomUUID().toString();
		fileName = fileName+"_"+multipartFile.getOriginalFilename();
		
		//4. HDD에 저장
		file = new File(file, fileName);
		multipartFile.transferTo(file);
		
		
		return fileName;
	}
	
		

}
