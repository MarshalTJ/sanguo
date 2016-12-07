package com.tj.sanguo.city.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.tj.sanguo.city.City;
import com.tj.sanguo.monarch.Monarch;
import com.tj.sanguo.monarch.server.MonarchManager;
import com.tj.sanguo.rmiapi.query.IQueryCity;

public class QueryCityImpl extends UnicastRemoteObject implements IQueryCity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QueryCityImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public City queryCity(Monarch myself, City city) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public City queryMyselfCity(Monarch myself, City city) throws RemoteException {
		// TODO Auto-generated method stub
		City chooseCity = MonarchManager.INSTALL.findChooseCity(myself, city);
		return chooseCity;
	}
	
}
