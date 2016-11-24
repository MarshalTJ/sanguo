package com.tj.sanguo.server.register;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.tj.sanguo.city.building.OperateBuildingImpl;
import com.tj.sanguo.city.building.QueryBuildingImpl;
import com.tj.sanguo.monarch.OperateMonarchImpl;
import com.tj.sanguo.monarch.QueryMonarchImpl;
import com.tj.sanguo.rmiapi.operate.IOperateBuilding;
import com.tj.sanguo.rmiapi.operate.IOperateMonarch;
import com.tj.sanguo.rmiapi.query.IQueryBuilding;
import com.tj.sanguo.rmiapi.query.IQueryMonarch;

public class RmiInterfaceRegister {
	public RmiInterfaceRegister()
	{
		registerInterface();
	}
	
	private void registerInterface() {
		try {
			LocateRegistry.createRegistry(10999);
			IQueryMonarch queryMonarch = new QueryMonarchImpl(); /* ����stub��skeleton,������stub�������� */
	        /* ���ش���������RMI Service����������Registry������ָ���Ķ˿����������������� 
	         * ʵ���ϣ�RMI Service����Ҳ��һ��RMIӦ�ã�����Ҳ���Դ�Զ�˻�ȡRegistry:
	         *     public interface Registry extends Remote;
	         *     public static Registry getRegistry(String host, int port) throws RemoteException;
	         */
			/* ��stub�����󶨵�Registry�����URL�� */
			java.rmi.Naming.rebind("rmi://localhost:10999/queryMonarch", queryMonarch);
			
			IOperateMonarch operateMonarch = new OperateMonarchImpl();
			java.rmi.Naming.rebind("rmi://localhost:10999/operateMonarch", operateMonarch);
			
			IOperateBuilding operateBuilding = new OperateBuildingImpl();
			java.rmi.Naming.rebind("rmi://localhost:10999/operateBuilding", operateBuilding);
			
			IQueryBuilding queryBuilding = new QueryBuildingImpl();
			java.rmi.Naming.rebind("rmi://localhost:10999/queryBuilding", queryBuilding);
			
			System.out.println("register end");
		} catch (RemoteException | MalformedURLException e) {
			System.out.println("register error");
		}
	}
	
	
}