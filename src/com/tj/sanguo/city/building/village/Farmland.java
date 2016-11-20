package com.tj.sanguo.city.building.village;

import com.tj.sanguo.city.City;

public class Farmland extends VillageBuilding {

	public Farmland(City city) {
		super(city);
	}
	
	protected void init() {
		super.init();
		this.name = "农田";
		this.desc = "生产粮食";
		
		population = 0;
		
		updateCost = 40;
		degradeCost = 30;
		buildRate = 1.10f;
		
		costFood = 20;
		costWood = 50;
		costIron = 50;
		costRate = 1.20f;
	}
	
	protected void updateChangePopulation() {
		this.population += updateNeedPopulation;
		
		if (this.level < 5) {
			this.updateNeedPopulation = 0;
		}
		else if (this.level < 10) {
			this.updateNeedPopulation = 1;
		}
		else if (this.level < 15) {
			this.updateNeedPopulation = 2;
		}
		else {
			this.updateNeedPopulation = 3;
		}
	}
	
	protected void degradeChangePopulation() {
		if (this.level < 5) {
			this.updateNeedPopulation -= 0;
		}
		else if (this.level < 10) {
			this.updateNeedPopulation -= 1;
			
		}
		else if (this.level < 15) {
			this.updateNeedPopulation -= 2;
		}
		else {
			this.updateNeedPopulation -= 3;
		}
		this.population -= updateNeedPopulation;
	}
	
	@Override
	protected void changeDesc() {
		this.desc = "农田，当前等级为 " +this.getLevel() + "最大等级为 " + this.getCity().getMaxLevel() 
					+ "。\n 当前产量:" + this.getProduct() + "每小时" + "下一级产量:" +  ((int) (this.getProduct() * this.getRate())) 
					+ "每小时.\n 升级所需资源:木" + this.getCostWood() + " 铁" + this.getCostIron() + " 粮" + this.getCostFood()
					+ " 人口" + this.updateNeedPopulation
				    ;
	}
	
}
