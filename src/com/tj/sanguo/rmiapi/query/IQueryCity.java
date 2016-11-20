package com.tj.sanguo.rmiapi.query;

import com.tj.sanguo.city.City;
import com.tj.sanguo.monarch.Monarch;

public interface IQueryCity {
	public Monarch queryCity(City city)  throws java.rmi.RemoteException;
	public Monarch queryMyselfCity(City city)  throws java.rmi.RemoteException;
}
