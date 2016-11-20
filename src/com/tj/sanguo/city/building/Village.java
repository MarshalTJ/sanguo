package com.tj.sanguo.city.building;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.tj.sanguo.city.City;
import com.tj.sanguo.city.building.village.Farmland;
import com.tj.sanguo.city.building.village.Forestry;
import com.tj.sanguo.city.building.village.Ironmine;
import com.tj.sanguo.city.building.village.VillageBuilding;

/**
 * ≥«Õ‚
 * @author Administrator
 *
 */
public class Village implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected City city;
	protected int type;
	protected List<VillageBuilding> builds = new ArrayList<VillageBuilding>(14);
	
	public Village(City city) {
		this.city = city;
		init();
	}
	
	protected void init() {
		int forestryNum = 4;
		int ironNum = 4;
		int farmNum = 6;
		
		switch (this.city.getType()) {
		case 0:// 4 4 6
			forestryNum = 4;
			ironNum = 4;
			farmNum = 6;
			break;
		case 1: // 3 3 8
			forestryNum = 3;
			ironNum = 3;
			farmNum = 8;
			break;
		case 2: // 2 2 10
			forestryNum = 2;
			ironNum = 2;
			farmNum = 10;
			break;
		case 3: // 1 1 12
			forestryNum = 2;
			ironNum = 2;
			farmNum = 10;
			break;
		case 4:// 0 0 14
			forestryNum = 0;
			ironNum = 0;
			farmNum = 14;
			break;
		default:
			forestryNum = 4;
			ironNum = 4;
			farmNum = 6;
			break;
		}
		
		for (int i=0; i<forestryNum; i++) {
			builds.add(new Forestry(this.city));
		}
		for (int i=0; i<ironNum; i++) {
			builds.add(new Ironmine(this.city));
		}
		for (int i=0; i<farmNum; i++) {
			builds.add(new Farmland(this.city));
		}
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public List<VillageBuilding> getBuilds() {
		return builds;
	}

	public void setBuilds(List<VillageBuilding> builds) {
		this.builds = builds;
	}
}
