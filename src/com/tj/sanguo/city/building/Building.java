package com.tj.sanguo.city.building;

import com.tj.sanguo.City;

/**
 * 建筑物
 * @author Administrator
 *
 */
public class Building {
	protected City city;
	protected String name;
	protected String desc;
	protected int level = 1;
	protected int population = 1;
	// 建筑物当前状态：0 无，1 升级， 2 降级
	protected int status = 0;
	protected long startTime;
	protected long updateCost = 100;
	protected long degradeCost = 80;
	protected float buildRate = 1.15f;
	
	protected int costFood = 100;
	protected int costWood = 100;
	protected int costIron = 100;
	protected float costRate = 1.30f;
	
	public Building(City city) {
		this.city = city;
		init();
	}
	
	protected void init() {
		this.startTime = System.currentTimeMillis();
	}
	
	public void update() {
		check();
		costResouce();
		this.startTime = System.currentTimeMillis();
	}
	
	public void degrade() {
		this.startTime = System.currentTimeMillis();
	}
	
	public void updateCommit() {
		this.level ++;
		this.updateChangePopulation();
		this.updateChangeCostTime();
		this.changeEffect();
	}
	
	public void degradeCommit() {
		this.level --;
		this.degradeChangePopulation();
		this.degradeChangeCostTime();
		this.changeEffect();
	}
	
	protected void changeEffect() {
		
	}
	
	protected void updateChangeCostTime() {
		this.updateCost = (long) (updateCost * buildRate);
	}
	
	protected void degradeChangeCostTime() {
		this.degradeCost = (long) (degradeCost / buildRate);
	}
	
	protected void updateChangePopulation() {
		if (this.level <= 5) {
			this.population += 1;
		}
		else if (this.level <= 10) {
			this.population += 2;
		}
		else if (this.level <= 15) {
			this.population += 3;
		}
		else {
			this.population += 4;
		}
	}
	
	protected void degradeChangePopulation() {
		if (this.level < 5) {
			this.population -= 1;
		}
		else if (this.level < 10) {
			this.population -= 2;
		}
		else if (this.level < 15) {
			this.population -= 3;
		}
		else {
			this.population -= 4;
		}
	}
	
	protected void check() {
//		checkResource();
//		checkPopulation();
//		checkCondition();
	}
	
	protected void costResouce() {
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getStartTime() {
		return startTime;
	}
	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
	public long getUpdateCost() {
		return updateCost;
	}
	public void setUpdateCost(long updateCost) {
		this.updateCost = updateCost;
	}
	public long getDegradeCost() {
		return degradeCost;
	}
	public void setDegradeCost(long degradeCost) {
		this.degradeCost = degradeCost;
	}
	public float getBuildRate() {
		return buildRate;
	}
	public void setBuildRate(float buildRate) {
		this.buildRate = buildRate;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public int getCostFood() {
		return costFood;
	}

	public void setCostFood(int costFood) {
		this.costFood = costFood;
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

	public float getCostRate() {
		return costRate;
	}

	public void setCostRate(float costRate) {
		this.costRate = costRate;
	}
	
}
