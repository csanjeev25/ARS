package com.cg.ars.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.ars.DBUtil.DBUtil;
import com.cg.ars.dao.AdminDaoImpl;
import com.cg.ars.dao.CustomerDaoImpl;
import com.cg.ars.dao.IAdminDao;
import com.cg.ars.dao.ICustomerDao;
import com.cg.ars.exception.ArsException;
import com.cg.ars.service.AdminService;
import com.cg.ars.service.AdminServiceImpl;
import com.cg.ars.service.CustomerServiceImpl;
import com.cg.ars.service.ICustomerService;

public class CustomerTest {
	private static Connection connection;
	private static ICustomerDao custdao;
	private static ICustomerService custservice;
	
	
	@BeforeClass
	public static void testGetConnection() throws ArsException{
		connection = DBUtil.obtainConnection();
		assertNotNull(connection);
	}
	@BeforeClass
	public static void createServiceObj() throws ArsException{
		custservice = new CustomerServiceImpl();
		assertNotNull(custservice);
	}
	@BeforeClass
	public static void createDaoObj() throws ArsException{
		custdao = new CustomerDaoImpl();
		assertNotNull(custdao);
	}

	@Test
	public void testverify() throws ArsException{
		try {
			String uname = "nmodi@gmail.com";
			String pwd = "narmodi";
			assertTrue(custdao.verifyUser(uname, pwd));
		} catch (Exception e) {
			throw new ArsException();}
		}

	
}
