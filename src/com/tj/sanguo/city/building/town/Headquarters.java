package com.tj.sanguo.city.building.town;

import com.tj.sanguo.city.City;
import com.tj.sanguo.city.building.Building;
import com.tj.sanguo.effect.HeadquartersEffect;

/**
 * 点兵场
 * @author Administrator
 *
 */
public class Headquarters extends Building {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Headquarters(City city) {
		super(city);
		// TODO Auto-generated constructor stub
	}
	
	protected void init() {
		super.init();
		name = "点兵场";
		desc = "决定出兵队伍数量";
		population = 1;
		
		updateCost = 100;
		degradeCost = 80;
//		buildRate = 1.20f;
		
		costFood = 50;
		costWood = 50;
		costIron = 30;
//		costRate = 1.30f;
	}

	@Override
	protected void initEffect() {
		// TODO Auto-generated method stub
		this.effect = new HeadquartersEffect(this.level);
	}

}
