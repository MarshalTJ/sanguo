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
			 /* ��RMI Registry������stub
	         * ���RMI Service���ڱ��ػ����ϣ�URL���ǣ�rmi://localhost:1099/hello
	         * ����URL���ǣ�rmi://RMIService_IP:1099/hello
	         */
//			IQueryMonarch queryMonarch = RemoteInterfaceFactory.getIQueryMonarch();
			/* ͨ��stub����Զ�̽ӿ�ʵ�� */
//			Monarch monarch = queryMonarch.queryMonarch("��˧��");
			
			IOperateMonarch operateMonarch = RemoteInterfaceFactory.getIOperateMonarch();
			Monarch monarch = operateMonarch.login("��˧��", "123456");
			
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
		
		contentPane = new JPanel();// �����������
        contentPane.setBackground(Color.white);
        setContentPane(contentPane);// Ӧ���������
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
		
		//���ڴ�����һ�����󣬲���ʲô����ʾ������  
		Sanguo_Client f = new Sanguo_Client();  
        //������һ��Ϳ�����ʾһ�����йرգ���С������󻯵İ�ť��Frame��  
        f.setVisible(true);  
        //�ټ�����һ��Ϳ�����ʾһ�������Ͻǣ�ӵ��ָ����С��Frame��  
        f.setSize(1200, 700);  
        //�ټ�����һ��Ϳ��԰�Frame�������м���  
        f.setLocationRelativeTo(null);  
        //���û����һ�䣬�ڵ���ر�Frame��ʱ�������ʵ������ִ��״̬�еģ�������һ������������İ���Դ�ͷŵ���  
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);  
	}
	
}
