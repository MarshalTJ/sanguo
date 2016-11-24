package com.tj.sanguo.client;

import java.awt.Label;
import java.util.concurrent.BlockingQueue;

import javax.swing.JPanel;

import com.tj.sanguo.city.building.Building;
import com.tj.sanguo.city.resource.CityResouce;
import com.tj.sanguo.monarch.Monarch;
import com.tj.sanguo.resource.Food;
import com.tj.sanguo.resource.Iron;
import com.tj.sanguo.resource.Wood;
import com.tj.sanguo.util.TimeUtil;

public class RightPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Label lb_buildingInfo = new Label("test1");
	private Label lb_resourceInfo = new Label("test2");
//	private Label lb_armyInfo = new Label();
	
	private Monarch myself = null;
	
	public RightPanel(Monarch myself) {
		this.myself = myself;
		
		this.setLayout(null);
		lb_resourceInfo.setBounds(3, 3, 190, 300);
		lb_buildingInfo.setBounds(3, 353, 190, 300);
		
		this.add(lb_buildingInfo);
		this.add(lb_resourceInfo);
		
//		changeChooseCity();
		
		new Thread(new ResourceTask()).start();
	}
	
	public void changeChooseCity() {
		super.repaint();
		
		StringBuffer buildInfo = new StringBuffer();
		BlockingQueue<Building> buildingQueue = this.myself.getChooseCity().getBuildingQueue();
		BlockingQueue<Building> waitQueue = this.myself.getChooseCity().getWaitQueue();
		if (buildingQueue != null) {
			for (Building building : buildingQueue) {
				buildInfo.append(building.getName()).append(" 正在建造,完成时间为:").append(TimeUtil.transferLongToDate(building.getStartTime() + building.getCostTime()))
				.append("\r\n");
			}
		}
		
		if (waitQueue != null) {
			for (Building building : waitQueue) {
				buildInfo.append(building.getName()).append(" 等待中")
				.append("\r\n");
			}
		}
		
		lb_buildingInfo.setText(buildInfo.toString());
	}
	
	class BuildingTask implements Runnable {
		@Override
		public void run() {
			StringBuffer info = new StringBuffer();
			
		}
	}
	
	class ResourceTask implements Runnable {
		@Override
		public void run() {
			StringBuffer info = new StringBuffer();
			while (true) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
				}
				CityResouce cityResouce = myself.getChooseCity().getCityResouce();
				int volumen = myself.getChooseCity().getCityResouce().getVolumen();
				
				Wood ownWood = cityResouce.getOwnWoods();
				Wood productWood = cityResouce.getProductWoods();
				ownWood.add(productWood.getNums());
				
				Iron ownIron = cityResouce.getOwnIrons();
				Iron productIron = cityResouce.getProductIrons();
				ownIron.add(productIron.getNums());
				
				Food ownFood = cityResouce.getOwnFoods();
				Food productFood = cityResouce.getProductFoods();
				ownFood.add(productFood.getNums());
				
				info.reverse();
				info.append("  木:").append(ownWood.changeIntToShow()).append("/").append(volumen).append("/").append(productWood.changeIntToShow())
				    .append("  铁:").append(ownIron.changeIntToShow()).append("/").append(volumen).append("/").append(productIron.changeIntToShow())
				    .append("  粮:").append(ownFood.changeIntToShow()).append("/").append(volumen).append("/").append(productFood.changeIntToShow()).append("/").append(myself.getChooseCity().getPopulation());
				
				lb_resourceInfo.setText(info.toString());
			}
		}
		
	}
}
