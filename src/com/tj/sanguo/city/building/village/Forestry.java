package com.tj.sanguo.city.building.village;

import com.tj.sanguo.city.City;

public class Forestry extends VillageBuilding {

	public Forestry(City city) {
		super(city);
		// TODO Auto-generated constructor stub
	}
	
	protected void init() {
		super.init();
		name = "林场";
		desc = "生产木头";
		population = 1;
		
		updateCost = 80;
		degradeCost = 60;
//		buildRate = 1.15f;
		
		costFood = 50;
		costWood = 30;
		costIron = 50;
//		costRate = 1.20f;
	}

	@Override
	protected void changeDesc() {
		// TODO Auto-generated method stub
		this.desc = "林场，当前等级为 " +this.getLevel() + "最大等级为 " + this.getCity().getMaxLevel() 
				+ "。\n 当前产量:" + this.getProduct() + "每小时" + "下一级产量:" +  ((int) (this.getProduct() * this.getRate())) 
				+ "每小时.\n 升级所需资源:木" + this.getCostWood() + " 铁" + this.getCostIron() + " 粮" + this.getCostFood()
				+ " 人口" + this.updateNeedPopulation
			    ;
	}
}
