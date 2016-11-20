package com.tj.sanguo.city;

import java.io.Serializable;

import com.tj.sanguo.city.building.Building;

public class BuildingTask implements Runnable,Serializable {
	protected City city;
	public BuildingTask(City city) {
		this.city = city;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Building building = city.getBuildingQueue().take();
				long costTime = building.getCostTime();
				System.out.println("start build " + building.getName());
				building.startBuild();
				Thread.sleep(costTime);
				building.buildCommit();
				System.out.println("finish build " + building.getName());
			} catch (InterruptedException e) {
			}
		}
	}
}
