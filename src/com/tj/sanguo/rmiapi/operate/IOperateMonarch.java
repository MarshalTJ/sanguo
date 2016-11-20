package com.tj.sanguo.rmiapi.operate;

import java.rmi.Remote;

import com.tj.sanguo.monarch.Monarch;

public interface IOperateMonarch extends Remote {
	public Monarch login(String user, String password)  throws java.rmi.RemoteException;
	public Monarch regist(String name)  throws java.rmi.RemoteException;
	
}
