package com.tj.sanguo.fight.soldier.wei;

import com.tj.sanguo.city.City;

public class Armored extends WeiSoldier {
	private static final long serialVersionUID = 1L;
	
	public Armored(City city, int nums) {
		super(city, nums);
		this.name = "Ìú¼×±ø";
		this.attack = 40;
		this.attackType = 0;
		this.infantryDefence = 40;
		this.knightDefenct = 50;
		this.speed = 10;
		this.costfood = 80;
		this.costWood = 100;
		this.costIron = 120;
		this.costTime = 65;
	}
}
