package com.tj.sanguo.client.panel.center;

import java.awt.GridLayout;

import javax.swing.JPanel;

public class MapPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public MapPanel() {
		this.setLayout(new GridLayout(9, 9, 5, 5));
	}
	
	public void refresh() {
		
		this.repaint();
	}
}
