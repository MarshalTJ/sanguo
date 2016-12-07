package com.tj.sanguo.fight.soldier;

import com.tj.sanguo.city.City;
import com.tj.sanguo.fight.Fighter;

/**
 * 士兵
 * @author Administrator
 *
 */
public class Soldier extends Fighter {

	private static final long serialVersionUID = 1L;
	// 武将所在城市。
	protected City city;
	// 该兵种数量，还是集成到这里面吧，后面视情况是否需要提取到city中
	protected int nums;
	// 生产单个兵需要的资源
	protected int costWood = 100;
	protected int costIron = 100;
	protected int costfood = 100;
	// 士兵占人口数
	protected int population = 1;
	// 生产单个士兵，需要耗时多长时间
	protected int costTime = 60;
	// 单个士兵携带能力，（可以掠夺资源数）
	protected int backpack = 10;
//	// 士兵等级，跟城市铁匠铺等级一样
//	protected int level = 1;
	public Soldier(City city, int nums) {
		this.city = city;
		this.nums = nums;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public int getCostWood() {
		return costWood;
	}
	public void setCostWood(int costWood) {
		this.costWood = costWood;
	}
	public int getCostIron() {
		return costIron;
	}
	public void setCostIron(int costIron) {
		this.costIron = costIron;
	}
	public int getCostfood() {
		return costfood;
	}
	public void setCostfood(int costfood) {
		this.costfood = costfood;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public int getCostTime() {
		return costTime;
	}
	public void setCostTime(int costTime) {
		this.costTime = costTime;
	}
	public int getBackpack() {
		return backpack;
	}
	public void setBackpack(int backpack) {
		this.backpack = backpack;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
}
