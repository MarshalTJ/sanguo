package com.tj.sanguo.monarch;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.tj.sanguo.rmiapi.operate.IOperateMonarch;

public class OperateMonarchImpl extends UnicastRemoteObject implements IOperateMonarch {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected OperateMonarchImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Monarch login(String user, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Monarch regist(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
