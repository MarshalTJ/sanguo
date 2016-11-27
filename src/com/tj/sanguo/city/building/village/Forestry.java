package com.tj.sanguo.city.building.village;

import com.tj.sanguo.city.City;

public class Forestry extends VillageBuilding {

	public Forestry(City city) {
		super(city);
		// TODO Auto-generated constructor stub
	}
	
	protected void init() {
		super.init();
		name = "�ֳ�";
		desc = "����ľͷ";
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
		this.desc = "�ֳ�����ǰ�ȼ�Ϊ " +this.getLevel() + "���ȼ�Ϊ " + this.getCity().getMaxLevel() 
				+ "��\n ��ǰ����:" + this.getProduct() + "ÿСʱ" + "��һ������:" +  ((int) (this.getProduct() * this.getRate())) 
				+ "ÿСʱ.\n ����������Դ:ľ" + this.getCostWood() + " ��" + this.getCostIron() + " ��" + this.getCostFood()
				+ " �˿�" + this.updateNeedPopulation
			    ;
	}
}
