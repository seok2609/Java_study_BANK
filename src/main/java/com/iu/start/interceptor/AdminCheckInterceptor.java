package com.iu.start.interceptor;

import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iu.start.bankMembers.BankMembersDTO;
import com.iu.start.bankMembers.RoleDTO;

public class AdminCheckInterceptor extends HandlerInterceptorAdapter{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//1. 
		BankMembersDTO bankMembersDTO = (BankMembersDTO)request.getSession().getAttribute("member");
		
		//admin만 통과하게끔 false
		boolean check = false;
		
		for(RoleDTO roleDTO : bankMembersDTO.getRoleDTOs()) {
			System.out.println(roleDTO.getRoleNum());
			System.out.println(roleDTO.getRoleName());
			if(roleDTO.getRoleName().equals("ADMIN")) {
				check = true;
				break;
			}
		}
		
		//ADMIN이 아닐때 
		if(!check) {
			request.setAttribute("message", "권한이 없습니다");
			request.setAttribute("url", "../../../../../");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");	//jsp의 경로를 String타입으로 넣음 컨트롤러와 달리 인터널리소스를 안거치기때문에 .jsp까지 쳐야함
			view.forward(request, response);
		}
		
		
		
		return check;  
	}

}
