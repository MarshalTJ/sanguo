package com.tj.sanguo.rmiapi.operate;

import java.rmi.Remote;

import com.tj.sanguo.city.building.Building;
import com.tj.sanguo.monarch.Monarch;

public interface IOperateBuilding extends Remote {
	public void update(Monarch myself, Building building)  throws java.rmi.RemoteException;
	public void degrade(Monarch myself, Building building)  throws java.rmi.RemoteException;
}
