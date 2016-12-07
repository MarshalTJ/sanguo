package com.tj.sanguo.city.server.building;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Set;

import com.tj.sanguo.city.City;
import com.tj.sanguo.city.building.Building;
import com.tj.sanguo.monarch.Monarch;
import com.tj.sanguo.monarch.server.MonarchManager;
import com.tj.sanguo.rmiapi.query.IQueryBuilding;

public class QueryBuildingImpl extends UnicastRemoteObject implements IQueryBuilding {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QueryBuildingImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Building queryBuilding(Monarch myself, Building building) throws RemoteException {
		City chooseCity = MonarchManager.INSTALL.findChooseCity(myself, building);
		Building chooseBuilding = MonarchManager.INSTALL.findChooseBuilding(chooseCity, building);
		return chooseBuilding;
	}

	@Override
	public Set<Building> queryCanBuildBuilding(Monarch myself, City city) throws RemoteException {
		City chooseCity = MonarchManager.INSTALL.findChooseCity(myself, city);
		// TODO Auto-generated method stub
		return chooseCity.getTown().getCanbuilds();
	}
}
