package com.tj.sanguo.client.remoteinterface;

import java.rmi.Naming;

import com.tj.sanguo.rmiapi.operate.IOperateBuilding;
import com.tj.sanguo.rmiapi.operate.IOperateCity;
import com.tj.sanguo.rmiapi.operate.IOperateMonarch;
import com.tj.sanguo.rmiapi.query.IQueryBuilding;
import com.tj.sanguo.rmiapi.query.IQueryCity;
import com.tj.sanguo.rmiapi.query.IQueryMonarch;

public class RemoteInterfaceFactory {
	public static IQueryMonarch getIQueryMonarch() {
		IQueryMonarch remote = null;
		try {
			remote = (IQueryMonarch) Naming.lookup("rmi://localhost:10999/queryMonarch");
		} catch (Exception e) {
			System.out.println("RemoteInterfaceFactory.getIQueryMonarch error");
		}
		return remote;
	}
	public static IQueryCity getIQueryCity() {
		IQueryCity remote = null;
		try {
			remote = (IQueryCity) Naming.lookup("rmi://localhost:10999/queryCity");
		} catch (Exception e) {
			System.out.println("RemoteInterfaceFactory.getIQueryMonarch error");
		}
		return remote;
	}
	
	public static IQueryBuilding getIQueryBuilding() {
		IQueryBuilding remote = null;
		try {
			remote = (IQueryBuilding) Naming.lookup("rmi://localhost:10999/querybuilding");
		} catch (Exception e) {
			System.out.println("RemoteInterfaceFactory.getIQueryMonarch error");
		}
		return remote;
	}
	
	public static IOperateBuilding getIOperateBuilding() {
		IOperateBuilding remote = null;
		try {
			remote = (IOperateBuilding) Naming.lookup("rmi://localhost:10999/operateBuilding");
		} catch (Exception e) {
			System.out.println("RemoteInterfaceFactory.getIQueryMonarch error");
		}
		return remote;
	}
	public static IOperateCity getIOperateCity() {
		IOperateCity remote = null;
		try {
			remote = (IOperateCity) Naming.lookup("rmi://localhost:10999/operateCity");
		} catch (Exception e) {
			System.out.println("RemoteInterfaceFactory.getIQueryMonarch error");
		}
		return remote;
	}
	public static IOperateMonarch getIOperateMonarch() {
		IOperateMonarch remote = null;
		try {
			remote = (IOperateMonarch) Naming.lookup("rmi://localhost:10999/operateMonarch");
		} catch (Exception e) {
			System.out.println("RemoteInterfaceFactory.getIQueryMonarch error");
		}
		return remote;
	}
}
