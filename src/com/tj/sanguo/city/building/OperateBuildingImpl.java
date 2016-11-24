package com.tj.sanguo.city.building;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.tj.sanguo.city.City;
import com.tj.sanguo.city.building.village.VillageBuilding;
import com.tj.sanguo.monarch.Monarch;
import com.tj.sanguo.monarch.MonarchManager;
import com.tj.sanguo.rmiapi.operate.IOperateBuilding;

public class OperateBuildingImpl extends UnicastRemoteObject implements IOperateBuilding {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OperateBuildingImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Monarch myself, Building building) throws RemoteException {
		// TODO Auto-generated method stub
		City chooseCity = MonarchManager.INSTALL.findChooseCity(myself, building);
		Building chooseBuilding = MonarchManager.INSTALL.findChooseBuilding(chooseCity, building);
		chooseCity.addUpdateTask(chooseBuilding);
	}

	@Override
	public void degrade(Monarch myself, Building building) throws RemoteException {
		// TODO Auto-generated method stub
		City chooseCity = MonarchManager.INSTALL.findChooseCity(myself, building);
		Building chooseBuilding = MonarchManager.INSTALL.findChooseBuilding(chooseCity, building);
		chooseBuilding.setStatus(2);
		chooseCity.addDegradeTask(chooseBuilding);
	}

}
