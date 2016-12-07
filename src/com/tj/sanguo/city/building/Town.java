package com.tj.sanguo.city.building;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.tj.sanguo.city.City;
import com.tj.sanguo.city.building.town.Barracks;
import com.tj.sanguo.city.building.town.Headquarters;
import com.tj.sanguo.city.building.town.Official;
import com.tj.sanguo.city.building.town.Warehouse;

public class Town implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected City city;
	protected List<Building> builds = new ArrayList<Building>(16);
	protected Set<Building> canbuilds = new HashSet<Building>();
	
	public Town(City city) {
		this.city = city;
		init();
	}
	
	protected void init() {
		builds.add(new Official(this.city));
		builds.add(new Headquarters(this.city));
		builds.add(new Warehouse(this.city));
		changeCanBuilds();
	}
	// 更改能够建筑的建筑物列表。 1.如点兵场到3级，可以建设兵营；2.如果拆除点兵场，则不能建设兵营；3.如果建设兵营，则不能再建设兵营；
	private void changeCanBuilds() {
//		canbuilds.add(new Warehouse(null));
		canbuilds.add(new Barracks(null));
	}
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<Building> getBuilds() {
		return builds;
	}

	public void setBuilds(List<Building> builds) {
		this.builds = builds;
	}

	public Set<Building> getCanbuilds() {
		return canbuilds;
	}

	public void setCanbuilds(Set<Building> canbuilds) {
		this.canbuilds = canbuilds;
	}
	
}
