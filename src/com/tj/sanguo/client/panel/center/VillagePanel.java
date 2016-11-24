package com.tj.sanguo.client.panel.center;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.tj.sanguo.city.City;
import com.tj.sanguo.city.building.Building;
import com.tj.sanguo.city.building.village.VillageBuilding;
import com.tj.sanguo.client.remoteinterface.RemoteInterfaceFactory;
import com.tj.sanguo.monarch.Monarch;
import com.tj.sanguo.rmiapi.query.IQueryBuilding;

public class VillagePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Monarch myself = null;
	
	public VillagePanel(Monarch myself) {
		this.myself = myself;
		
		City ciry = myself.getChooseCity();
		List<VillageBuilding> builds = ciry.getVillage().getBuilds();
		
		this.setLayout(new GridLayout(4, 4, 5, 5));
		
		for (VillageBuilding building : builds) {
			JButton jbButton = new JButton(building.getName() + ",�ȼ�:" + building.getLevel());
			this.add(jbButton);
			jbButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	queryBuildingInfo(building);
	            }
	        });
		}
	}
	private void queryBuildingInfo(Building building) {
		IQueryBuilding iRemote = RemoteInterfaceFactory.getIQueryBuilding();
		try {
			building = iRemote.queryBuilding(myself, building);
		} catch (RemoteException e) {
			System.out.println(e);
		}
		BuildingInfoPanel.BUILDING_INFO_PANEL.setChooseBuild(building);
		BuildingInfoPanel.BUILDING_INFO_PANEL.repaint();
	}
}
