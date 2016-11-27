package com.tj.sanguo.rmiapi.query;

import java.rmi.Remote;

import com.tj.sanguo.city.City;
import com.tj.sanguo.monarch.Monarch;

public interface IQueryCity extends Remote {
	public City queryCity(Monarch myself, City city)  throws java.rmi.RemoteException;
	public City queryMyselfCity(Monarch myself, City city)  throws java.rmi.RemoteException;
}
