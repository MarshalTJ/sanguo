package com.tj.sanguo.client;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.tj.sanguo.city.City;
import com.tj.sanguo.client.panel.center.BuildingInfoPanel;
import com.tj.sanguo.client.panel.center.MapPanel;
import com.tj.sanguo.client.panel.center.TownPanel;
import com.tj.sanguo.client.panel.center.VillagePanel;
import com.tj.sanguo.monarch.Monarch;

public class CenterPanel extends JPanel implements IChangeCityListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JTabbedPane jtb=new JTabbedPane(JTabbedPane.TOP);
	
	TownPanel jp_town = null;
	VillagePanel jp_village = null;
	MapPanel jp_map = new MapPanel();
	
	JPanel jp_center_bottom = BuildingInfoPanel.BUILDING_INFO_PANEL;
	
	public CenterPanel(Monarch myself) {
		LeftPanel.register(this);
		
		jp_town = new TownPanel(myself);
		jp_village = new VillagePanel(myself);
		
		setLayout(null); 
		jtb.setBounds( 0, 0, 550, 520);	
		jtb.setTabPlacement(JTabbedPane.TOP);
//		jtb.setTabLayoutPolicy(JTabbedPane.WRAP_TAB_LAYOUT);
		jtb.addTab("城内", jp_town);
		jtb.addTab("城外", jp_village);
		jtb.addTab("地图", jp_map);
		
		this.add(jtb);
		
		jp_center_bottom.setBounds(0, 525, 550, 80);
		this.add(jp_center_bottom);
	}

	@Override
	public void changeCity(City city) {
		jp_town.refresh();
		jp_village.refresh();
		jtb.setSelectedIndex(1);
	}
}
