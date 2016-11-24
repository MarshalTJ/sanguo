package com.tj.sanguo.city;

import java.io.Serializable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.tj.sanguo.city.building.Building;
import com.tj.sanguo.city.building.Town;
import com.tj.sanguo.city.building.Village;
import com.tj.sanguo.city.resource.CityResouce;
import com.tj.sanguo.effect.Effect;
import com.tj.sanguo.monarch.Monarch;

// 城市
public class City implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Monarch monarch;
	protected int number = 0;
	protected int subNumber = 0;
	protected String name;
	// 类型：0 - 446, 1 - 338, 2 - 2210, 3 - 114, 4 - 0014 
	protected int type = 0;
	protected int population = 2;
	protected boolean isCapital = false;
	protected int maxLevel = 20;
	protected Position pos;
	protected Effect effect ;
	
	protected Town town;
	protected Village village;
	
	protected BlockingQueue<Building> buildingQueue = new ArrayBlockingQueue<>(2);
	protected BlockingQueue<Building> waitQueue = new ArrayBlockingQueue<>(3);;
	
	protected CityResouce cityResouce;
	protected transient BuildingTask buildingTask1;
	protected transient BuildingTask buildingTask2;
	
	public City(Monarch monarch, int type, boolean isCaptial, int maxLevel, Position pos) {
		this.monarch = monarch;
		this.type = type;
		this.isCapital = isCaptial;
		this.maxLevel = maxLevel;
		this.pos = pos;
		
		init();
	}
	
	protected void init() {
		village = new Village(this);
		cityResouce = new CityResouce(this);
		new Thread(cityResouce).start();
		
		buildingTask1 = new BuildingTask(this);
		buildingTask2 = new BuildingTask(this);
		new Thread(buildingTask1).start();
		new Thread(buildingTask2).start();
		
	}
	
	public void addDegradeTask(Building building) {
		if (waitQueue.size() == 3) {
			throw new RuntimeException("任务队列已满");
		}
		building.degrade();
		waitQueue.add(building);
	}
	
	public void addUpdateTask(Building building) {
		if (waitQueue.size() == 3) {
			throw new RuntimeException("任务队列已满");
		}
		building.update();
		waitQueue.add(building);
	}
	
	public void buildCommit(Building building) {
		// 重新整理队列
		Building waitBuild = waitQueue.poll();
		if (waitBuild == null) {
			return;
		}
		buildingQueue.add(waitBuild);
	}
	
	public void recountPopulation() {
		this.population = 0;
		for (Building building : this.village.getBuilds()) {
			population += building.getPopulation();
		}
		
//		for (Building building : this.town.getBuilds()) {
//			population += building.getPopulation();
//		}
		this.monarch.recountPopulation();
	}
	
	public String getName() {
		return name;
	}
	public Monarch getMonarch() {
		return monarch;
	}

	public void setMonarch(Monarch monarch) {
		this.monarch = monarch;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public boolean isCapital() {
		return isCapital;
	}
	public void setCapital(boolean isCapital) {
		this.isCapital = isCapital;
	}
	public int getMaxLevel() {
		return maxLevel;
	}
	public void setMaxLevel(int maxLevel) {
		this.maxLevel = maxLevel;
	}
	public Position getPos() {
		return pos;
	}
	public void setPos(Position pos) {
		this.pos = pos;
	}
	public Effect getEffect() {
		return effect;
	}
	public void setEffect(Effect effect) {
		this.effect = effect;
	}
	public Town getTown() {
		return town;
	}
	public void setTown(Town town) {
		this.town = town;
	}
	public Village getVillage() {
		return village;
	}
	public void setVillage(Village village) {
		this.village = village;
	}
	public BlockingQueue<Building> getBuildingQueue() {
		return buildingQueue;
	}
	public void setBuildingQueue(BlockingQueue<Building> buildingQueue) {
		this.buildingQueue = buildingQueue;
	}
	public BlockingQueue<Building> getWaitQueue() {
		return waitQueue;
	}
	public void setWaitQueue(BlockingQueue<Building> waitQueue) {
		this.waitQueue = waitQueue;
	}
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public CityResouce getCityResouce() {
		return cityResouce;
	}
	public void setCityResouce(CityResouce cityResouce) {
		this.cityResouce = cityResouce;
	}
	public int getSubNumber() {
		return subNumber;
	}

	public void setSubNumber(int subNumber) {
		this.subNumber = subNumber;
	}
	
	public int getAndAddSubNumber() {
		return subNumber ++;
	}
}
