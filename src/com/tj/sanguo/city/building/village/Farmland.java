package com.tj.sanguo.city.building.village;

import com.tj.sanguo.City;

public class Farmland extends VillageBuilding {

	protected String name = "农田";
	protected String desc = "生产粮食";
	protected int population = 0;
	
	protected long updateCost = 40;
	protected long degradeCost = 30;
	protected float buildRate = 1.10f;
	
	protected int costFood = 20;
	protected int costWood = 50;
	protected int costIron = 50;
	protected float costRate = 1.20f;
	
	public Farmland(City city) {
		super(city);
		// TODO Auto-generated constructor stub
	}
	
	protected void updateChangePopulation() {
		if (this.level <= 5) {
			this.population += 0;
		}
		else if (this.level <= 10) {
			this.population += 1;
		}
		else if (this.level <= 15) {
			this.population += 2;
		}
		else {
			this.population += 3;
		}
	}
	
	protected void degradeChangePopulation() {
		if (this.level < 5) {
			this.population -= 0;
		}
		else if (this.level < 10) {
			this.population -= 1;
		}
		else if (this.level < 15) {
			this.population -= 2;
		}
		else {
			this.population -= 3;
		}
	}
	
}
