package com.tj.sanguo.fight.soldier.wei;

import com.tj.sanguo.city.City;

public class LightCavalry extends WeiSoldier {

	private static final long serialVersionUID = 1L;

	public LightCavalry(City city, int nums) {
		super(city, nums);
		this.name = "ÇáÆï±ø";
		this.attack = 120;
		this.attackType = 1;
		this.infantryDefence = 100;
		this.knightDefenct = 80;
		this.speed = 26;
		this.population = 3;
		this.backpack = 35;
		this.costfood = 200;
		this.costWood = 260;
		this.costIron = 200;
		this.costTime = 150;
	}
	
}
