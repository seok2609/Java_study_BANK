package com.iu.start.test;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//**는 그 하위폴더 안에까지 읽어라 라는 뜻!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*-context.xml"})
//abstract : 상속받아서 사용해야 사용가능
public abstract class MyAbstractTest {
	
//	@Autowired
//	private SqlSession sqlSession;
//
//	@Test
//	public void test() {
//		
//		/*
//		 * assertNotNull(sqlSession);
//		 * 
//		 * fail("Not yet implemented");
//		 */
//	}
//
//	

}
