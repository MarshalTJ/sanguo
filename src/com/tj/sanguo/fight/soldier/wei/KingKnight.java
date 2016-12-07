package com.tj.sanguo.fight.soldier.wei;

import com.tj.sanguo.city.City;

public class KingKnight extends WeiSoldier {
	
	private static final long serialVersionUID = 1L;

	public KingKnight(City city, int nums) {
		super(city, nums);
		this.name = "»Æ½ðÆïÊ¿";
		this.attack = 180;
		this.attackType = 1;
		this.infantryDefence = 140;
		this.knightDefenct = 140;
		this.speed = 22;
		this.population = 4;
		this.backpack = 20;
		this.costfood = 300;
		this.costWood = 360;
		this.costIron = 450;
		this.costTime = 200;
	}
	
}
