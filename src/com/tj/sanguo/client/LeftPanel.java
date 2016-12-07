package com.tj.sanguo.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.tj.sanguo.city.City;
import com.tj.sanguo.client.holder.MonarchHolder;
import com.tj.sanguo.client.remoteinterface.RemoteInterfaceFactory;
import com.tj.sanguo.monarch.Monarch;
import com.tj.sanguo.rmiapi.operate.IOperateMonarch;
import com.tj.sanguo.rmiapi.query.IQueryCity;

public class LeftPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Monarch myself = null;
	
	JButton headImg = new JButton();
	JButton[] jb_cities = null;
	
	static List<IChangeCityListener> changeCityListeners = new ArrayList<IChangeCityListener>();
	
	public LeftPanel(Monarch myself) {
		this.setLayout(null);
		
		this.myself = myself;
		
		headImg.setName("头像");
		headImg.setText("头像");
		headImg.setBounds(5, 10, 190, 30);
		headImg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	refreshCities();
            }
        });
		this.add(headImg);
		
		refreshCities();
		changeCity(myself.getChooseCity());
		
	}
	
	public static void register(IChangeCityListener listener) {
		changeCityListeners.add(listener);
	}
	
	private void changeCity(City city) {
		IQueryCity iqueryCity = RemoteInterfaceFactory.getIQueryCity();
		try {
			myself.setChooseCity(iqueryCity.queryMyselfCity(myself, city));
		} catch (RemoteException e) {
			System.out.println("change city error");
		}
		
		for (IChangeCityListener listener : changeCityListeners) {
			listener.changeCity(city);
		}
	}
	private void refreshCities() {
		this.removeAll();
		this.add(headImg);
		IOperateMonarch operateMonarch = RemoteInterfaceFactory.getIOperateMonarch();
		Monarch monarch = null;
		try {
			monarch = operateMonarch.login("大帅比", "123456");
			myself = monarch;
			MonarchHolder.MYSELF = myself;
		} catch (RemoteException e) {
			System.out.println("refreshCities error");
		}
		
		List<City> cities = myself.getCities();
		jb_cities = new JButton[cities.size()];
		
		for (int i=0; i < cities.size() ; i++ ){
			City city = cities.get(i);
			if (city.isCapital()) {
				myself.setChooseCity(city);
			}
			JButton jb_city = new JButton(city.getName());
//			jb_city.setName("城市1");
//			jb_city.setText("城市1");
			jb_city.setBounds(5, 50 + (i * 30), 190, 30);
			
			jb_city.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	changeCity(city);
	            }
	        });
			this.add(jb_city);
		}
	}
}
