package com.tj.sanguo.city.building.town;

import com.tj.sanguo.city.City;
import com.tj.sanguo.city.building.Building;

/**
 * 兵营
 * @author Administrator
 *
 */
public class Barracks extends Building {

	private static final long serialVersionUID = 1L;
	public Barracks(City city) {
		super(city);
		// TODO Auto-generated constructor stub
	}
	protected void init() {
		super.init();
		name = "兵营";
		desc = "升级兵营能够造更多兵种，并减少征兵时间。";
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
	protected void changeDesc() {
		// TODO Auto-generated method stub
		
	}
	protected void initEffect() {
		
	}
}
