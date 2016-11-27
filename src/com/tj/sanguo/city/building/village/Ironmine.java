package com.tj.sanguo.city.building.village;

import com.tj.sanguo.city.City;

public class Ironmine extends VillageBuilding {

	public Ironmine(City city) {
		super(city);
		// TODO Auto-generated constructor stub
	}
	
	protected void init() {
		super.init();
		name = "铁矿";
		desc = "生产铁矿";
		population = 2;
		
		updateCost = 100;
		degradeCost = 80;
//		buildRate = 1.20f;
		
		costFood = 50;
		costWood = 50;
		costIron = 30;
//		costRate = 1.30f;
	}
	
	protected void updateChangePopulation() {
		this.population += updateNeedPopulation;
		
		if (this.level < 5) {
			this.updateNeedPopulation = 2;
		}
		else if (this.level < 10) {
			this.updateNeedPopulation = 3;
		}
		else if (this.level < 15) {
			this.updateNeedPopulation = 4;
		}
		else {
			this.updateNeedPopulation = 5;
		}
		
//		if (this.level <= 5) {
//			this.population += 2;
//		}
//		else if (this.level <= 10) {
//			this.population += 3;
//		}
//		else if (this.level <= 15) {
//			this.population += 4;
//		}
//		else {
//			this.population += 5;
//		}
	}
	
	protected void degradeChangePopulation() {
		if (this.level < 5) {
			this.updateNeedPopulation -= 2;
		}
		else if (this.level < 10) {
			this.updateNeedPopulation -= 3;
			
		}
		else if (this.level < 15) {
			this.updateNeedPopulation -= 4;
		}
		else {
			this.updateNeedPopulation -= 5;
		}
		this.population -= updateNeedPopulation;
	}

	@Override
	protected void changeDesc() {
		// TODO Auto-generated method stub
		this.desc = "铁矿，当前等级为 " +this.getLevel() + "最大等级为 " + this.getCity().getMaxLevel() 
				+ "。\n 当前产量:" + this.getProduct() + "每小时" + "下一级产量:" +  ((int) (this.getProduct() * this.getRate())) 
				+ "每小时.\n 升级所需资源:木" + this.getCostWood() + " 铁" + this.getCostIron() + " 粮" + this.getCostFood()
				+ " 人口" + this.updateNeedPopulation
			    ;
	}
}
