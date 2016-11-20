package com.tj.sanguo.client.panel.center;

import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.tj.sanguo.city.City;
import com.tj.sanguo.city.building.village.VillageBuilding;
import com.tj.sanguo.monarch.Monarch;

public class TownPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Monarch myself = null;
	
	public TownPanel(Monarch myself) {
		this.myself = myself;
		
//		City ciry = myself.getChooseCity();
//		List<VillageBuilding> builds = ciry.getVillage().getBuilds();
//		
//		this.setLayout(new GridLayout(4, 4, 5, 5));
//		
//		for (VillageBuilding building : builds) {
//			JButton jbButton = new JButton(building.getName() + ",µÈ¼¶:" + building.getLevel());
//			this.add(jbButton);
//		}
		
		this.setLayout(new GridLayout(4, 4, 5, 5));
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++) {
				JButton jbButton = new JButton("kongbai" + i);
				this.add(jbButton);
			}
		}
	}
}
