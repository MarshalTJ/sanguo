package com.tj.sanguo.monarch;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.tj.sanguo.rmiapi.query.IQueryMonarch;

public class QueryMonarchImpl extends UnicastRemoteObject implements IQueryMonarch {

	private static final long serialVersionUID = 4077329331699640331L;
	
	public QueryMonarchImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Monarch queryMonarch(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return MonarchManager.INSTALL.getMonarch(name);
	}

	@Override
	public Monarch queryMyself(Monarch myself) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
