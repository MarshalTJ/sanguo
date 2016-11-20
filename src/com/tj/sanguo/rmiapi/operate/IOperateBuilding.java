package com.tj.sanguo.rmiapi.operate;

import java.rmi.Remote;

public interface IOperateBuilding extends Remote {
	public void update()  throws java.rmi.RemoteException;
	public void degrade()  throws java.rmi.RemoteException;
}
