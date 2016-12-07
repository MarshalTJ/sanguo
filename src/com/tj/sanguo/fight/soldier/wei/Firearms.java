package com.tj.sanguo.fight.soldier.wei;

import com.tj.sanguo.city.City;

public class Firearms extends WeiSoldier {

	private static final long serialVersionUID = 1L;

	public Firearms(City city, int nums) {
		super(city, nums);
		this.name = "»ðÇ¹ÊÖ";
		this.attack = 70;
		this.attackType = 0;
		this.infantryDefence = 35;
		this.knightDefenct = 25;
		this.speed = 14;
		this.costfood = 100;
		this.costWood = 120;
		this.costIron = 140;
		this.costTime = 75;
		this.backpack = 14;
	}

}
