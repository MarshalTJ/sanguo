package com.tj.sanguo.city.resource;

import java.io.Serializable;
import java.util.List;

import com.tj.sanguo.city.City;
import com.tj.sanguo.city.building.village.Farmland;
import com.tj.sanguo.city.building.village.Forestry;
import com.tj.sanguo.city.building.village.Ironmine;
import com.tj.sanguo.city.building.village.VillageBuilding;
import com.tj.sanguo.resource.Food;
import com.tj.sanguo.resource.Iron;
import com.tj.sanguo.resource.Wood;

/**
 * 城市资源基类
 * @author Administrator
 *
 */
public class CityResouce implements Runnable,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected City city;
	// 拥有的铁木粮
	protected Wood ownWoods = new Wood();
	protected Food ownFoods = new Food();
	protected Iron ownIrons = new Iron();
	
	// 铁木粮产量(每秒)
	protected Wood productWoods = new Wood();
	protected Food productFoods = new Food();
	protected Iron productIrons = new Iron();
	
	protected int volumen = 800;
	
	public CityResouce(City city) {
		this.city = city;
		init();
	}
	
	public void reCountProduct() {
		int forestrySum = 0;
		int ironSum = 0;
		int foodSum = 0;
		List<VillageBuilding> resourceBuilds = this.city.getVillage().getBuilds();
		for (VillageBuilding building : resourceBuilds) {
			if (building instanceof Forestry) {
				forestrySum += building.getProduct();
			}
			else if (building instanceof Ironmine) {
				ironSum += building.getProduct();
			}
			else if (building instanceof Farmland) {
				foodSum += building.getProduct();
			}
		}
		productWoods.setNums(forestrySum / 60f);
		productIrons.setNums(ironSum / 60f);
		productFoods.setNums(foodSum / 60f);
	}
	
	protected void init() {
		ownWoods.setNums(200);
		ownFoods.setNums(200);
		ownIrons.setNums(200);
		reCountProduct();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
			}
			ownWoods.add(productWoods.getNums());
			ownFoods.add(productFoods.getNums());
			ownIrons.add(productIrons.getNums());
			if (volumen < ownWoods.getNums()) {
				ownWoods.setNums(volumen);
			}
			if (volumen < ownFoods.getNums()) {
				ownFoods.setNums(volumen);
			}
			if (volumen < ownIrons.getNums()) {
				ownIrons.setNums(volumen);
			}
//			System.out.println("wood,iron,food is :" + ownWoods.getNums() + ", " + ownIrons.getNums() + ", " + ownFoods.getNums());
		}
	}
	
	public Wood getOwnWoods() {
		return ownWoods;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public void setOwnWoods(Wood ownWoods) {
		this.ownWoods = ownWoods;
	}
	public Food getOwnFoods() {
		return ownFoods;
	}
	public void setOwnFoods(Food ownFoods) {
		this.ownFoods = ownFoods;
	}
	public Iron getOwnIrons() {
		return ownIrons;
	}
	public void setOwnIrons(Iron ownIrons) {
		this.ownIrons = ownIrons;
	}
	public Wood getProductWoods() {
		return productWoods;
	}
	public void setProductWoods(Wood productWoods) {
		this.productWoods = productWoods;
	}
	public Food getProductFoods() {
		return productFoods;
	}
	public void setProductFoods(Food productFoods) {
		this.productFoods = productFoods;
	}
	public Iron getProductIrons() {
		return productIrons;
	}
	public void setProductIrons(Iron productIrons) {
		this.productIrons = productIrons;
	}

	public int getVolumen() {
		return volumen;
	}

	public void setVolumen(int volumen) {
		this.volumen = volumen;
	}
}
