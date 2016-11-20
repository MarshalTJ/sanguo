package com.tj.sanguo.client.panel.center;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.tj.sanguo.city.building.Building;
import com.tj.sanguo.client.remoteinterface.RemoteInterfaceFactory;
import com.tj.sanguo.rmiapi.operate.IOperateBuilding;

public class BuildingInfoPanel extends JPanel {

	/**
	 * 
	 */
	public static BuildingInfoPanel BUILDING_INFO_PANEL = new BuildingInfoPanel();
	
	private static final long serialVersionUID = 1L;
	private Building chooseBuild = null;
	private Building oldChoose = null;
	
	private Label label = new Label();
	private JButton update = new JButton("Éý¼¶");
	private JButton degrade = new JButton("½µ¼¶");
	
	private BuildingInfoPanel() {
		this.setLayout(null);
		label.setBounds(3, 3, 550, 30);
		update.setBounds(10, 35, 100, 20);
		degrade.setBounds(120, 35, 100, 20);
		
		update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	updateBuilding(oldChoose);
            }
        });
		degrade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	degradeBuilding(oldChoose);
            }
        });
		
		this.add(label);
		this.add(update);
		this.add(degrade);
	}
	
	public void repaint(){
		if (chooseBuild == null || oldChoose == chooseBuild) {
			return;
		}
		super.repaint();
		oldChoose = chooseBuild;
		
		label.setText(oldChoose.getDesc());
	}
	
	public Building getChooseBuild() {
		return oldChoose;
	}
	public void setChooseBuild(Building chooseBuild) {
		this.chooseBuild = chooseBuild;
		repaint();
	}
	
	private void updateBuilding(Building chooseBuild) {
		IOperateBuilding remote = RemoteInterfaceFactory.getIOperateBuilding();
		try {
			remote.update();
		} catch (RemoteException e) {
			
		}
	}
	private void degradeBuilding(Building chooseBuild) {
		
	}
}
