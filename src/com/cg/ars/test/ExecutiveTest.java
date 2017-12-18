package com.cg.ars.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.ars.DBUtil.DBUtil;
import com.cg.ars.dao.AdminDaoImpl;
import com.cg.ars.dao.ExecutiveDaoImpl;
import com.cg.ars.exception.ArsException;
import com.cg.ars.service.ExecutiveServiveImpl;

public class ExecutiveTest {
	private static Connection connection;
	private static ExecutiveDaoImpl edao;
	private static ExecutiveServiveImpl eservice;
	
	
	@BeforeClass
	public static void testGetConnection() throws ArsException{
		connection = DBUtil.obtainConnection();
		assertNotNull(connection);
	}
	@BeforeClass
	public static void createServiceObj() throws ArsException{
		eservice = new ExecutiveServiveImpl();
		assertNotNull(eservice);
	}
	@BeforeClass
	public static void createDaoObj() throws ArsException{
		edao = new ExecutiveDaoImpl();
		assertNotNull(edao);
	}
	@Test
	public void testverify() throws ArsException{
		try {
			String uname = "Vladimir";
			String pwd = "Putin";
			assertTrue(eservice.verifyExecutive(uname, pwd));
		} catch (Exception e) {
			throw new ArsException();}
		}
		
	public void testViewOccu() throws ArsException{
		try {
			
		} catch (Exception e) {
			throw new ArsException();
		}
	}
	

}
