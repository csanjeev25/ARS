package com.cg.ars.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.ars.DBUtil.DBUtil;
import com.cg.ars.dao.IAdminDao;
import com.cg.ars.dao.AdminDaoImpl;
import com.cg.ars.dao.ExecutiveDaoImpl;
import com.cg.ars.exception.ArsException;
import com.cg.ars.service.AdminService;
import com.cg.ars.service.AdminServiceImpl;
import com.cg.ars.service.ExecutiveServiveImpl;

public class AdminTest {
	private static Connection connection;
	private static IAdminDao adao;
	private static AdminService aservice;
	
	
	@BeforeClass
	public static void testGetConnection() throws ArsException{
		connection = DBUtil.obtainConnection();
		assertNotNull(connection);
	}
	@BeforeClass
	public static void createServiceObj() throws ArsException{
		aservice = new AdminServiceImpl();
		assertNotNull(aservice);
	}
	@BeforeClass
	public static void createDaoObj() throws ArsException{
		adao = new AdminDaoImpl();
		assertNotNull(adao);
	}

	@Test
	public void testverify() throws ArsException{
		try {
			String uname = "Donald";
			String pwd = "Trump";
			assertFalse(adao.veriyfAdmin(uname, pwd));
		} catch (Exception e) {
			throw new ArsException();}
		}

}
