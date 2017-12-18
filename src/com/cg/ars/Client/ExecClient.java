package com.cg.ars.Client;

import java.util.Scanner;

import com.cg.ars.dao.IExecutiveDao;
import com.cg.ars.dao.ExecutiveDaoImpl;
import com.cg.ars.exception.ArsException;
import com.cg.ars.service.ExecutiveService;
import com.cg.ars.service.ExecutiveServiveImpl;

public class ExecClient {
	public static void main(String[] args) {
		ExecutiveService f = new ExecutiveServiveImpl();
		Scanner sc = new Scanner(System.in);
		
		/*String username = "Vladimir";
		String password = "Putin";
		
		boolean g;
		try {
			g = f.verifyExecutive(username, password);
			System.out.println(g);
		} catch (ArsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try {
			System.out.println(f.viewFlightOccu());
		} catch (ArsException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
