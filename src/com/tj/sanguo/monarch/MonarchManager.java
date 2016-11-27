package com.tj.sanguo.monarch;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import com.tj.sanguo.city.City;
import com.tj.sanguo.city.building.Building;
import com.tj.sanguo.city.building.village.VillageBuilding;
import com.tj.sanguo.util.CipherUtil;
import com.tj.sanguo.util.HexUtil;

public class MonarchManager {
	private Map<String, Monarch> namemonarchs = new HashMap<>();
	private Map<Long, Monarch> ssidmonarchs = new HashMap<>();
	private Map<String, String> accPwds = new HashMap<>();
	private Map<String, Monarch> accmonarchs = new HashMap<>();
	
	public static MonarchManager INSTALL = new MonarchManager();
	private MonarchManager() {
		
	}
	
	public void regist(String acc, String pwd, Monarch monarch) {
		accPwds.put(acc, pwd);
		accmonarchs.put(acc, monarch);
		register(monarch);
	}
	public boolean check(String acc, String pwd) {
		return pwd.equals(accPwds.get(acc));
	}
	
	public void register(Monarch monarch) {
		namemonarchs.put(monarch.getName(), monarch);
		ssidmonarchs.put(monarch.getSsid(), monarch);
	}
	
	public Monarch getMonarch(String name) {
		return namemonarchs.get(name);
	}
	
	public Monarch getMonarch(long ssid) {
		return ssidmonarchs.get(ssid);
	}
	
	public Monarch getMonarch(Monarch myself) {
		String enSeesion = myself.getSession().substring(0, 32);
		String ssidstr = null;
		ssidstr = CipherUtil.doDecrype(HexUtil.decodeHex(enSeesion.toCharArray()));//new String(HexUtil.decodeHex(enSeesion.toCharArray()),"UTF8");
		long ssid = Long.valueOf(ssidstr);
		return this.getMonarch(ssid);
	}
	
	public City findChooseCity(Monarch myself, City city) throws RemoteException {
		Monarch monarch = getMonarch(myself);
		City chooseCity = null;
		for (City mycity : monarch.getCities()) {
			if (mycity.getNumber() == city.getNumber()) {
				chooseCity = mycity;
				break;
			}
		}
		return chooseCity;
	}
	
	public City findChooseCity(Monarch myself, Building building) throws RemoteException {
		Monarch monarch = getMonarch(myself);
		City chooseCity = null;
		for (City city : monarch.getCities()) {
			if (city.getNumber() == building.getCity().getNumber()) {
				chooseCity = city;
				break;
			}
		}
		if (chooseCity == null) {
			throw new RemoteException("该建筑城市未找到");
		}
		return chooseCity;
	}
	public Building findChooseBuilding(City chooseCity, Building building) throws RemoteException {
		Building chooseBuilding = null;
		if (building instanceof VillageBuilding) {
			for (Building building2 : chooseCity.getVillage().getBuilds()) {
				if (building2.getNumber() == building.getNumber()) {
					chooseBuilding = building2;
					break;
				}
			}
		}
		else {
//			for (Building building2 : chooseCity.getTown().getBuilds()) {
//				if (building2.getNumber() == building.getNumber()) {
//					chooseBuilding = building2;
//					break;
//				}
//			}
		}
		return chooseBuilding;
	}
	
}
