package com.tj.sanguo.client;

import java.awt.Color;
import java.rmi.RemoteException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.tj.sanguo.city.City;
import com.tj.sanguo.client.holder.MonarchHolder;
import com.tj.sanguo.client.remoteinterface.RemoteInterfaceFactory;
import com.tj.sanguo.monarch.Monarch;
import com.tj.sanguo.rmiapi.operate.IOperateMonarch;

public class Sanguo_Client extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane = null; 
	private JPanel jp_left = null;
	private JPanel jp_center = null;
	private JPanel jp_right = null;
	
	private Monarch myself = null;
	
	private Sanguo_Client() {
		try {
			 /* 从RMI Registry中请求stub
	         * 如果RMI Service就在本地机器上，URL就是：rmi://localhost:1099/hello
	         * 否则，URL就是：rmi://RMIService_IP:1099/hello
	         */
//			IQueryMonarch queryMonarch = RemoteInterfaceFactory.getIQueryMonarch();
			/* 通过stub调用远程接口实现 */
//			Monarch monarch = queryMonarch.queryMonarch("大帅比");
			
			IOperateMonarch operateMonarch = RemoteInterfaceFactory.getIOperateMonarch();
			Monarch monarch = operateMonarch.login("大帅比", "123456");
			
			myself = monarch;
			MonarchHolder.MYSELF = myself;
			
			List<City> cities = myself.getCities();
			
			for (City city : cities) {
				if (city.isCapital()) {
					myself.setChooseCity(city);
					break;
				}
			}
			
			System.out.println("Client OK");
		} catch (RemoteException e) {
			System.out.println("error");
			return;
		}
		
		contentPane = new JPanel();// 创建内容面板
        contentPane.setBackground(Color.white);
        setContentPane(contentPane);// 应用内容面板
        contentPane.setLayout(null);
        
        jp_left = new LeftPanel(myself);
		jp_left.setBounds(10, 20, 200, 600);
		jp_left.setBackground(Color.BLUE);
		contentPane.add(jp_left);
		
		jp_center = new CenterPanel(myself);
		jp_center.setBounds(230, 20, 550, 600);
		jp_center.setBackground(Color.RED);
		contentPane.add(jp_center);
		
		jp_right = new RightPanel(myself);
		jp_right.setBounds(790, 20, 400, 600);
		jp_right.setBackground(Color.YELLOW);
		contentPane.add(jp_right);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//现在创建了一个对象，不过什么都显示不出来  
		Sanguo_Client f = new Sanguo_Client();  
        //加上这一句就可以显示一个仅有关闭，最小化，最大化的按钮的Frame了  
        f.setVisible(true);  
        //再加上这一句就可以显示一个在左上角，拥有指定大小的Frame了  
        f.setSize(1200, 700);  
        //再加上这一句就可以把Frame放在最中间了  
        f.setLocationRelativeTo(null);  
        //如果没有这一句，在点击关闭Frame的时候程序其实还是在执行状态中的，加上这一句才算是真正的把资源释放掉了  
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);  
	}
	
}
