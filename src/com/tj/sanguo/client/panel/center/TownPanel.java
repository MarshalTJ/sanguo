package com.tj.sanguo.client.panel.center;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.tj.sanguo.city.City;
import com.tj.sanguo.city.building.Building;
import com.tj.sanguo.client.holder.MonarchHolder;
import com.tj.sanguo.client.remoteinterface.RemoteInterfaceFactory;
import com.tj.sanguo.monarch.Monarch;
import com.tj.sanguo.rmiapi.query.IQueryBuilding;

public class TownPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Monarch myself = null;
	
	CanBuildsPanel jp_canBuild = new CanBuildsPanel();
	
	public TownPanel(Monarch myself) {
		this.myself = myself;
		this.setLayout(new GridLayout(4, 4, 5, 5));
		jp_canBuild.setBounds(0, 0, 200, 80);
		
		refresh();
	}
	public void refresh() {
		this.removeAll();
		jp_canBuild.setVisible(false);
		
		City city = MonarchHolder.MYSELF.getChooseCity();
		List<Building> builds = city.getTown().getBuilds();
		
		for (Building building : builds) {
			JButton jbButton = new JButton(building.getName() + ",等级:" + building.getLevel());
			this.add(jbButton);
			jbButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	queryBuildingInfo(building);
	            }
	        });
		}
		
		for (int i=builds.size(); i<16; i++) {
			JButton jbButton = new JButton("空地");
			this.add(jbButton);
			jbButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	queryBuildingInfo(null);
	            }
	        });
		}
		
		this.repaint();
	}
	private void queryBuildingInfo(Building building) {
		IQueryBuilding iRemote = RemoteInterfaceFactory.getIQueryBuilding();
		// 如果选择空地，则让其选择可建造建筑
		if (building == null) {
			try {
				Set<Building> canBuilds = iRemote.queryCanBuildBuilding(myself, myself.getChooseCity());
				jp_canBuild.setCanBuilds(canBuilds);
				jp_canBuild.setVisible(true);
			} catch (RemoteException e) {
				System.out.println(e);
			}
		}
		
		try {
			building = iRemote.queryBuilding(MonarchHolder.MYSELF, building);
		} catch (RemoteException e) {
			System.out.println(e);
		}
		BuildingInfoPanel.BUILDING_INFO_PANEL.setChooseBuild(building);
	}
	
	private void buildNewBuilding(Building building) {
		building.setCity(MonarchHolder.MYSELF.getChooseCity());
		refresh();
	}
	
	class CanBuildsPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		Set<Building> canBuilds = null;
		void setCanBuilds(Set<Building> canBuilds) {
			this.canBuilds = canBuilds;
		}
		public void refresh() {
			this.removeAll();
			
			for (Building building : canBuilds) {
				JButton jbButton = new JButton(building.getName());
				this.add(jbButton);
				jbButton.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		            	buildNewBuilding(building);
		            }
		        });
			}
			
			this.repaint();
		}
	}
}
