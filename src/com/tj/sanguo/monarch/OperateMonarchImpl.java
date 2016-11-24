package com.tj.sanguo.monarch;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.tj.sanguo.rmiapi.operate.IOperateMonarch;

public class OperateMonarchImpl extends UnicastRemoteObject implements IOperateMonarch {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OperateMonarchImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Monarch login(String user, String password) throws RemoteException {
		// TODO Auto-generated method stub
		Monarch monarch = MonarchManager.INSTALL.getMonarch(user);
		if (monarch == null) {
			throw new RemoteException("用户不存在");
		}
		if (!"123456".equals(password)) {
			throw new RemoteException("账号或密码错误");
		}
		
		monarch.setSsid((long) Math.random() * 99999999);
		return monarch;
	}

	@Override
	public Monarch regist(String name) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
