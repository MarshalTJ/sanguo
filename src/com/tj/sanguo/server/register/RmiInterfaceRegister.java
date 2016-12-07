package com.tj.sanguo.server.register;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.tj.sanguo.city.server.QueryCityImpl;
import com.tj.sanguo.city.server.building.OperateBuildingImpl;
import com.tj.sanguo.city.server.building.QueryBuildingImpl;
import com.tj.sanguo.monarch.server.OperateMonarchImpl;
import com.tj.sanguo.monarch.server.QueryMonarchImpl;
import com.tj.sanguo.rmiapi.operate.IOperateBuilding;
import com.tj.sanguo.rmiapi.operate.IOperateMonarch;
import com.tj.sanguo.rmiapi.query.IQueryBuilding;
import com.tj.sanguo.rmiapi.query.IQueryCity;
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
			/* ��stub����󶨵�Registry�����URL�� */
			java.rmi.Naming.rebind("rmi://localhost:10999/queryMonarch", queryMonarch);
			
			IOperateMonarch operateMonarch = new OperateMonarchImpl();
			java.rmi.Naming.rebind("rmi://localhost:10999/operateMonarch", operateMonarch);
			
			IOperateBuilding operateBuilding = new OperateBuildingImpl();
			java.rmi.Naming.rebind("rmi://localhost:10999/operateBuilding", operateBuilding);
			
			IQueryBuilding queryBuilding = new QueryBuildingImpl();
			java.rmi.Naming.rebind("rmi://localhost:10999/queryBuilding", queryBuilding);
			
			IQueryCity queryCity = new QueryCityImpl();
			java.rmi.Naming.rebind("rmi://localhost:10999/queryCity", queryCity);
			
			System.out.println("register end");
		} catch (RemoteException | MalformedURLException e) {
			System.out.println("register error");
		}
	}
	
	
}
