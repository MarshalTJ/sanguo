package com.tj.sanguo.monarch;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tj.sanguo.city.City;
import com.tj.sanguo.city.Position;
import com.tj.sanguo.util.CipherUtil;
import com.tj.sanguo.util.HexUtil;
import com.tj.sanguo.util.StringUtil;

public class Monarch implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected transient long ssid;
	protected String session;
	protected String name;
	protected int level = 1;
	protected int population = 2;
	protected List<City> cities = new ArrayList<>();
	protected City chooseCity = null;
	
	public Monarch(String name) {
		System.out.println("»¶Ó­¾ýÖ÷£º" + name );
		this.name = name;
		cities.add(new City(this, 0, true, 21, new Position()));
	}
	
	public void recountPopulation() {
		this.population = 0;
		for (City city : cities) {
			this.population += city.getPopulation();
		}
		
		if (this.population < 200) {
			this.level = 1;
		}
		else if (this.population < 400) {
			this.level = 2;
		}
		else if (this.population < 800) {
			this.level = 3;
		}
		else if (this.population < 1500) {
			this.level = 4;
		}
		else if (this.population < 3000) {
			this.level = 5;
		}
		else if (this.population < 4800) {
			this.level = 6;
		}
		else if (this.population < 7200) {
			this.level = 7;
		}
		else if (this.population < 10000) {
			this.level = 8;
		}
		else if (this.population < 13600) {
			this.level = 9;
		}
		else if (this.population < 18000) {
			this.level = 10;
		}
		else {
			this.level = 11;
		}
	}
	
	private void createSession() {
		session = HexUtil.encodeHexStr(CipherUtil.doEncrypt(StringUtil.padStart(String.valueOf(ssid), 8, '0'))) + HexUtil.encodeHexStr(CipherUtil.doEncrypt(name));
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public City getChooseCity() {
		return chooseCity;
	}

	public void setChooseCity(City chooseCity) {
		this.chooseCity = chooseCity;
	}

	public long getSsid() {
		return ssid;
	}

	public void setSsid(long ssid) {
		this.ssid = ssid;
		createSession();
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}
	
}
