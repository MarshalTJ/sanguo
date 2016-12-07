package com.tj.sanguo.city.building.town;

import com.tj.sanguo.city.City;
import com.tj.sanguo.city.building.Building;
import com.tj.sanguo.effect.WarehouseEffect;

/**
 * �ֿ�
 * @author Administrator
 *
 */
public class Warehouse extends Building {

	private static final long serialVersionUID = 1L;

	public Warehouse(City city) {
		super(city);
		// TODO Auto-generated constructor stub
	}

	protected void init() {
		super.init();
		name = "�ֿ�";
		desc = "�ܹ��������вֿ�����.";
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
		this.effect = new WarehouseEffect(this.level);
	}

}
