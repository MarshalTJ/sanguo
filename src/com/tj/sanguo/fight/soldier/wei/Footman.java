package com.tj.sanguo.fight.soldier.wei;

import com.tj.sanguo.city.City;

public class Footman extends WeiSoldier {

	private static final long serialVersionUID = 1L;

	public Footman(City city, int nums) {
		super(city, nums);
		this.name = "²½±ø";
		this.attack = 30;
		this.attackType = 0;
		this.infantryDefence = 65;
		this.knightDefenct = 35;
		this.speed = 12;
		this.costfood = 90;
		this.costWood = 90;
		this.costIron = 110;
		this.costTime = 60;
	}

}
