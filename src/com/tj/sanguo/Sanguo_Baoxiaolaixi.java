package com.tj.sanguo;

import com.tj.sanguo.monarch.Monarch;
import com.tj.sanguo.monarch.server.MonarchManager;
import com.tj.sanguo.server.register.RmiInterfaceRegister;

public class Sanguo_Baoxiaolaixi {
	MonarchManager monarchManager = MonarchManager.INSTALL;
	RmiInterfaceRegister register = new RmiInterfaceRegister();
	
	public Sanguo_Baoxiaolaixi() {
		
	}
	
	public void start() {
		// TODO Auto-generated method stub
		Monarch firstHero = new Monarch("´óË§±È");
		monarchManager.register(firstHero);
	}
	
	public static void main(String[] args) {
		Sanguo_Baoxiaolaixi server = new Sanguo_Baoxiaolaixi();
		server.start();
	}

}
