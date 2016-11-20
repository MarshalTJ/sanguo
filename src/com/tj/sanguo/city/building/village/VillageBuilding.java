package com.tj.sanguo.city.building.village;

import com.tj.sanguo.city.City;
import com.tj.sanguo.city.building.Building;

public abstract class VillageBuilding extends Building {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int product = 5;
	protected float rate = 1.10f;
	
	public VillageBuilding(City city) {
		super(city);
		// TODO Auto-generated constructor stub
	}

	protected void changeEffect() {
		product = 20;
		for (int i=1; i<this.level; i++) {
			this.product *= rate;
		}
		
		changeDesc();
//		this.city.getCityResouce()
	}

//	protected abstract void changeDesc();
	
	public int getProduct() {
		return product;
	}

	public void setProduct(int product) {
		this.product = product;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}
}
