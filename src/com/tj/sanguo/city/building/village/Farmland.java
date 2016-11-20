package com.tj.sanguo.city.building.village;

import com.tj.sanguo.city.City;

public class Farmland extends VillageBuilding {

	public Farmland(City city) {
		super(city);
	}
	
	protected void init() {
		super.init();
		this.name = "ũ��";
		this.desc = "������ʳ";
		
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
		this.desc = "ũ���ǰ�ȼ�Ϊ " +this.getLevel() + "���ȼ�Ϊ " + this.getCity().getMaxLevel() 
					+ "��\n ��ǰ����:" + this.getProduct() + "ÿСʱ" + "��һ������:" +  ((int) (this.getProduct() * this.getRate())) 
					+ "ÿСʱ.\n ����������Դ:ľ" + this.getCostWood() + " ��" + this.getCostIron() + " ��" + this.getCostFood()
					+ " �˿�" + this.updateNeedPopulation
				    ;
	}
	
}
