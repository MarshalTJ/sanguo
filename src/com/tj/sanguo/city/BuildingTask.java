package com.tj.sanguo.city;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

import com.tj.sanguo.city.building.Building;

public class BuildingTask implements Runnable, Serializable {
	protected City city;
	public BuildingTask(City city) {
		this.city = city;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				Building building = city.getWaitQueue().take();
				long costTime = building.getCostTime();
				System.out.println("start build " + building.getName());
				city.getBuildingQueue().offer(building, 10, TimeUnit.MILLISECONDS);
				building.startBuild();
				Thread.sleep(costTime * 1000);
				city.getBuildingQueue().remove(building);
				building.buildCommit();
				System.out.println("finish build " + building.getName());
			} catch (InterruptedException e) {
			}
		}
	}
}
