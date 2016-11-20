package com.tj.sanguo.building.city.village;

import com.tj.sanguo.City;

public class Forestry extends VillageBuilding {

	protected String name = "林场";
	protected String desc = "生产木头";
	protected int population = 1;
	
	protected long updateCost = 80;
	protected long degradeCost = 60;
	protected float buildRate = 1.15f;
	
	protected int costFood = 50;
	protected int costWood = 30;
	protected int costIron = 50;
	protected float costRate = 1.20f;
	
	public Forestry(City city) {
		super(city);
		// TODO Auto-generated constructor stub
	}

}
