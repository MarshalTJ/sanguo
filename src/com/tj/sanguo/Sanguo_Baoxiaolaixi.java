package com.tj.sanguo;

import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import com.tj.sanguo.monarch.Monarch;
import com.tj.sanguo.monarch.MonarchManager;
import com.tj.sanguo.monarch.QueryMonarchImpl;
import com.tj.sanguo.rmiapi.query.IQueryMonarch;

public class Sanguo_Baoxiaolaixi {
	MonarchManager monarchManager = MonarchManager.INSTALL;
	
	public Sanguo_Baoxiaolaixi() {
		
	}
	
	public void start() {
		// TODO Auto-generated method stub
		Monarch firstHero = new Monarch("��˧��");
		monarchManager.register(firstHero);
		
		try {
			IQueryMonarch queryMonarch = new QueryMonarchImpl(); /* ����stub��skeleton,������stub�������� */
            /* ���ش���������RMI Service����������Registry������ָ���Ķ˿����������������� 
             * ʵ���ϣ�RMI Service����Ҳ��һ��RMIӦ�ã�����Ҳ���Դ�Զ�˻�ȡRegistry:
             *     public interface Registry extends Remote;
             *     public static Registry getRegistry(String host, int port) throws RemoteException;
             */
			LocateRegistry.createRegistry(10999);
			/* ��stub����󶨵�Registry�����URL�� */
			java.rmi.Naming.rebind("rmi://localhost:10999/queryMonarch", queryMonarch);
			
			System.out.println("server start");
		} catch (RemoteException | MalformedURLException e) {
			System.out.println("server error");
		}
	}
	
	public static void main(String[] args) {
		Sanguo_Baoxiaolaixi server = new Sanguo_Baoxiaolaixi();
		server.start();
	}

}
