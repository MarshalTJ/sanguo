package com.tj.sanguo.client;

import java.awt.Label;
import java.util.concurrent.BlockingQueue;

import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tj.sanguo.city.City;
import com.tj.sanguo.city.building.Building;
import com.tj.sanguo.city.resource.CityResouce;
import com.tj.sanguo.client.holder.MonarchHolder;
import com.tj.sanguo.monarch.Monarch;
import com.tj.sanguo.resource.Food;
import com.tj.sanguo.resource.Iron;
import com.tj.sanguo.resource.Wood;
import com.tj.sanguo.util.TimeUtil;

public class RightPanel extends JPanel implements IChangeCityListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lb_buildingInfo = new JLabel("test1");
	private Label lb_resourceInfo_wood = new Label("test2");
	private Label lb_resourceInfo_iron = new Label("test2");
	private Label lb_resourceInfo_food = new Label("test2");
//	private Label lb_armyInfo = new Label();
	
	public RightPanel(Monarch myself) {
		LeftPanel.register(this);
		
		this.setLayout(null);
		lb_resourceInfo_wood.setBounds(3, 3, 390, 30);
		lb_resourceInfo_iron.setBounds(3, 43, 390, 30);
		lb_resourceInfo_food.setBounds(3, 83, 390, 30);
		lb_buildingInfo.setBounds(3, 353, 390, 100);
		
		this.add(lb_buildingInfo);
		this.add(lb_resourceInfo_wood);
		this.add(lb_resourceInfo_iron);
		this.add(lb_resourceInfo_food);
		
		changeChooseCity();
		
		new Thread(new ResourceTask()).start();
	}
	
	private void changeChooseCity() {
		super.repaint();
		
		StringBuffer buildInfo = new StringBuffer();
		BlockingQueue<Building> buildingQueue = MonarchHolder.MYSELF.getChooseCity().getBuildingQueue();
		BlockingQueue<Building> waitQueue = MonarchHolder.MYSELF.getChooseCity().getWaitQueue();
		buildInfo.append("<html>");
		if (buildingQueue != null) {
			for (Building building : buildingQueue) {
				buildInfo.append(building.getName()).append(" 正在建造,完成时间为:").append(TimeUtil.transferLongToDate(building.getStartTime() + building.getCostTime()))
				.append("<br/>");
			}
		}
		
		if (waitQueue != null) {
			for (Building building : waitQueue) {
				buildInfo.append(building.getName()).append(" 等待中")
				.append("<br/>");
			}
		}
		buildInfo.append("</html>");
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
			
			while (true) {
				refreshProductInfo();
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
				}
			}
		}
		
	}

	private void refreshProductInfo() {

		StringBuffer info_wood = new StringBuffer();
		StringBuffer info_iron = new StringBuffer();
		StringBuffer info_food = new StringBuffer();
			
		CityResouce cityResouce = MonarchHolder.MYSELF.getChooseCity().getCityResouce();
		int volumen = MonarchHolder.MYSELF.getChooseCity().getCityResouce().getVolumen();
		
		Wood ownWood = cityResouce.getOwnWoods();
		Wood productWood = cityResouce.getProductWoods();
		ownWood.add(productWood.getNums());
		
		Iron ownIron = cityResouce.getOwnIrons();
		Iron productIron = cityResouce.getProductIrons();
		ownIron.add(productIron.getNums());
		
		Food ownFood = cityResouce.getOwnFoods();
		Food productFood = cityResouce.getProductFoods();
		ownFood.add(productFood.getNums());
		
		info_wood.delete(0, info_wood.length());
		info_wood.append("  木:").append(ownWood.changeIntToShow()).append("/").append(volumen).append("/").append(productWood.getNums());
		info_iron.delete(0, info_iron.length());
		info_iron.append("  铁:").append(ownIron.changeIntToShow()).append("/").append(volumen).append("/").append(productIron.getNums());
		info_food.delete(0, info_food.length());
		info_food.append("  粮:").append(ownFood.changeIntToShow()).append("/").append(volumen).append("/").append(productFood.getNums()).append("/").append(MonarchHolder.MYSELF.getChooseCity().getPopulation());
		
		lb_resourceInfo_wood.setText(info_wood.toString());
		lb_resourceInfo_iron.setText(info_iron.toString());
		lb_resourceInfo_food.setText(info_food.toString());
	}
	
	@Override
	public void changeCity(City city) {
		// TODO Auto-generated method stub
		refreshProductInfo();
		changeChooseCity();
	}
}
