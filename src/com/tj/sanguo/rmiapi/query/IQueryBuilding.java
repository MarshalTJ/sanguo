package com.tj.sanguo.rmiapi.query;

import java.rmi.Remote;
import java.util.Set;

import com.tj.sanguo.city.City;
import com.tj.sanguo.city.building.Building;
import com.tj.sanguo.monarch.Monarch;

public interface IQueryBuilding extends Remote {
	public Building queryBuilding(Monarch myself, Building building) throws java.rmi.RemoteException ;
	public Set<Building> queryCanBuildBuilding(Monarch myself, City city) throws java.rmi.RemoteException ;
}
