package com.tj.sanguo.city.building.town;

import com.tj.sanguo.city.City;
import com.tj.sanguo.city.building.Building;

/**
 * ��Ӫ
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
		name = "��Ӫ";
		desc = "������Ӫ�ܹ��������֣�����������ʱ�䡣";
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
