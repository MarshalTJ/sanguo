package com.tj.sanguo.client.panel.center;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.tj.sanguo.city.City;
import com.tj.sanguo.city.building.Building;
import com.tj.sanguo.client.IChangeCityListener;
import com.tj.sanguo.client.LeftPanel;
import com.tj.sanguo.client.holder.MonarchHolder;
import com.tj.sanguo.client.remoteinterface.RemoteInterfaceFactory;
import com.tj.sanguo.rmiapi.operate.IOperateBuilding;

public class BuildingInfoPanel extends JPanel implements IChangeCityListener {

	/**
	 * 
	 */
	public static BuildingInfoPanel BUILDING_INFO_PANEL = new BuildingInfoPanel();
	
	private static final long serialVersionUID = 1L;
	private Building chooseBuild = null;
	private Building oldChoose = null;
	
	private JLabel label = new JLabel();
	private JButton update = new JButton("Éý¼¶");
	private JButton degrade = new JButton("½µ¼¶");
	
	private BuildingInfoPanel() {
		LeftPanel.register(this);
		
		this.setLayout(null);
		label.setBounds(3, 3, 550, 50);
		update.setBounds(310, 55, 100, 20);
		degrade.setBounds(420, 55, 100, 20);
		
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
		
		label.setText("<html>" + oldChoose.getDesc() + "</html>");
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
			remote.update(MonarchHolder.MYSELF,  chooseBuild);
		} catch (RemoteException e) {
			System.out.println("update building error");
		}
	}
	private void degradeBuilding(Building chooseBuild) {
		IOperateBuilding remote = RemoteInterfaceFactory.getIOperateBuilding();
		try {
			remote.degrade(MonarchHolder.MYSELF,  chooseBuild);
		} catch (RemoteException e) {
			System.out.println("degrade building error");
		}
	}

	@Override
	public void changeCity(City city) {
		// TODO Auto-generated method stub
		
	}
}
