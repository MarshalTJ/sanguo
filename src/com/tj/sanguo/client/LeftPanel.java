package com.tj.sanguo.client;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.tj.sanguo.monarch.Monarch;

public class LeftPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Monarch myself = null;
	
	JButton headImg = new JButton();
	JButton jb1 = new JButton();
	
	public LeftPanel(Monarch myself) {
		this.myself = myself;
		
		this.setLayout(null);
		jb1.setName("����1");
		jb1.setText("����1");
		jb1.setBounds(5, 50, 190, 30);
		this.add(jb1);
		
		headImg.setName("ͷ��");
		headImg.setText("ͷ��");
		headImg.setBounds(5, 10, 190, 30);
		this.add(headImg);
	}
}
