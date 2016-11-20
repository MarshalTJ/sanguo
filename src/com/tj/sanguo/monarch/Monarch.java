package com.tj.sanguo.monarch;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tj.sanguo.city.City;
import com.tj.sanguo.city.Position;

public class Monarch implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected transient long ssid;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
