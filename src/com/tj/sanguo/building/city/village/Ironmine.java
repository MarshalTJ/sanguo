package com.tj.sanguo.building.city.village;

import com.tj.sanguo.City;

public class Ironmine extends VillageBuilding {

	protected String name = "Ìú¿ó";
	protected String desc = "Éú²úÌú¿ó";
	protected int population = 2;
	
	protected long updateCost = 100;
	protected long degradeCost = 80;
	protected float buildRate = 1.20f;
	
	protected int costFood = 50;
	protected int costWood = 50;
	protected int costIron = 30;
	protected float costRate = 1.20f;
	
	public Ironmine(City city) {
		super(city);
		// TODO Auto-generated constructor stub
	}

	protected void updateChangePopulation() {
		if (this.level <= 5) {
			this.population += 2;
		}
		else if (this.level <= 10) {
			this.population += 3;
		}
		else if (this.level <= 15) {
			this.population += 4;
		}
		else {
			this.population += 5;
		}
	}
	
	protected void degradeChangePopulation() {
		if (this.level < 5) {
			this.population -= 2;
		}
		else if (this.level < 10) {
			this.population -= 3;
		}
		else if (this.level < 15) {
			this.population -= 4;
		}
		else {
			this.population -= 5;
		}
	}
}
