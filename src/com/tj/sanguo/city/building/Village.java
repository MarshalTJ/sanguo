package com.tj.sanguo.city.building;

import java.util.ArrayList;
import java.util.List;

import com.tj.sanguo.City;
import com.tj.sanguo.city.building.village.VillageBuilding;

/**
 * ≥«Õ‚
 * @author Administrator
 *
 */
public class Village {
	protected City city;
	protected int type;
	protected List<VillageBuilding> builds = new ArrayList<VillageBuilding>(14);
	
	public Village(City city) {
		this.city = city;
		init();
	}
	
	protected void init() {
		switch (this.city.getType()) {
		case 0:
//			builds.add(e);
			break;
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		default:
			break;
		}
	}
}
