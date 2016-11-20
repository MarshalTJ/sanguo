package com.tj.sanguo;

import java.util.Queue;

import com.sun.scenario.effect.Effect;
import com.tj.sanguo.building.city.Building;
import com.tj.sanguo.building.city.Position;
import com.tj.sanguo.building.city.Town;
import com.tj.sanguo.building.city.Village;

// 城市
public class City {
	protected String name;
	// 类型：0 - 446, 1 - 338, 2 - 2210, 3 - 114, 4 - 0014 
	protected int type;
	protected int population;
	protected boolean isCapital = false;
	protected int maxLevel = 20;
	protected Position pos;
	protected Effect effect ;
	
	protected Town town;
	protected Village village;
	
	protected Queue<Building> buildingQueue;
	protected Queue<Building> waitQueue;
	
	
	
	public String getName() {
		return name;
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
	public Queue<Building> getBuildingQueue() {
		return buildingQueue;
	}
	public void setBuildingQueue(Queue<Building> buildingQueue) {
		this.buildingQueue = buildingQueue;
	}
	public Queue<Building> getWaitQueue() {
		return waitQueue;
	}
	public void setWaitQueue(Queue<Building> waitQueue) {
		this.waitQueue = waitQueue;
	}
}
