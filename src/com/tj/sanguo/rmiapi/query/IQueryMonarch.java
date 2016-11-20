package com.tj.sanguo.rmiapi.query;

import java.rmi.Remote;

import com.tj.sanguo.monarch.Monarch;

public interface IQueryMonarch extends Remote {
	public Monarch queryMonarch(String name)  throws java.rmi.RemoteException;
	public Monarch queryMyself(Monarch myself)  throws java.rmi.RemoteException;
}
