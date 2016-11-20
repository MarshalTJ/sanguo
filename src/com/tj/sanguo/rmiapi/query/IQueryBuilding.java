package com.tj.sanguo.rmiapi.query;

import java.rmi.Remote;

import com.tj.sanguo.city.building.Building;

public interface IQueryBuilding extends Remote {
	public Building queryBuilding(Building building) throws java.rmi.RemoteException ;
}
