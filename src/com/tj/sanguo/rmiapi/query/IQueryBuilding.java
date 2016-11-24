package com.tj.sanguo.rmiapi.query;

import java.rmi.Remote;

import com.tj.sanguo.city.building.Building;
import com.tj.sanguo.monarch.Monarch;

public interface IQueryBuilding extends Remote {
	public Building queryBuilding(Monarch myself, Building building) throws java.rmi.RemoteException ;
}
