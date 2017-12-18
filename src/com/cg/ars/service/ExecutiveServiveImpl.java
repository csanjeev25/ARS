package com.cg.ars.service;

import java.util.List;

import com.cg.ars.bean.FlightInformation;
import com.cg.ars.dao.IExecutiveDao;
import com.cg.ars.dao.ExecutiveDaoImpl;
import com.cg.ars.exception.ArsException;

public class ExecutiveServiveImpl implements ExecutiveService {
	IExecutiveDao edao;
	public ExecutiveServiveImpl() {
		edao = new ExecutiveDaoImpl();
	}

	@Override
	public boolean verifyExecutive(String userName, String password)
			throws ArsException {
		
		return edao.verifyExecutive(userName, password);
	}

	@Override
	public List<FlightInformation> viewFlightOccu() throws ArsException {
		return edao.viewFlightOccu();
	}

}
