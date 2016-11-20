package com.tj.sanguo.city;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.tj.sanguo.monarch.Monarch;
import com.tj.sanguo.rmiapi.query.IQueryCity;

public class QueryCityImpl extends UnicastRemoteObject implements IQueryCity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected QueryCityImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Monarch queryCity(City city) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Monarch queryMyselfCity(City city) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
