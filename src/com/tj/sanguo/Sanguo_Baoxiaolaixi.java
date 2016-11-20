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
		Monarch firstHero = new Monarch("大帅比");
		monarchManager.register(firstHero);
		
		try {
			IQueryMonarch queryMonarch = new QueryMonarchImpl(); /* 生成stub和skeleton,并返回stub代理引用 */
            /* 本地创建并启动RMI Service，被创建的Registry服务将在指定的端口上侦听到来的请求 
             * 实际上，RMI Service本身也是一个RMI应用，我们也可以从远端获取Registry:
             *     public interface Registry extends Remote;
             *     public static Registry getRegistry(String host, int port) throws RemoteException;
             */
			LocateRegistry.createRegistry(10999);
			/* 将stub代理绑定到Registry服务的URL上 */
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
