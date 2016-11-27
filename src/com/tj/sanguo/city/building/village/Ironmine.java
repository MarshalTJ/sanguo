package com.tj.sanguo.city.building.village;

import com.tj.sanguo.city.City;

public class Ironmine extends VillageBuilding {

	public Ironmine(City city) {
		super(city);
		// TODO Auto-generated constructor stub
	}
	
	protected void init() {
		super.init();
		name = "����";
		desc = "��������";
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
		this.desc = "���󣬵�ǰ�ȼ�Ϊ " +this.getLevel() + "���ȼ�Ϊ " + this.getCity().getMaxLevel() 
				+ "��\n ��ǰ����:" + this.getProduct() + "ÿСʱ" + "��һ������:" +  ((int) (this.getProduct() * this.getRate())) 
				+ "ÿСʱ.\n ����������Դ:ľ" + this.getCostWood() + " ��" + this.getCostIron() + " ��" + this.getCostFood()
				+ " �˿�" + this.updateNeedPopulation
			    ;
	}
}
