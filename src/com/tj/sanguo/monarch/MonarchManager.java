package com.tj.sanguo.monarch;

import java.util.HashMap;
import java.util.Map;

public class MonarchManager {
	private Map<String, Monarch> namemonarchs = new HashMap<>();
	private Map<Long, Monarch> ssidmonarchs = new HashMap<>();
	private Map<String, String> accPwds = new HashMap<>();
	private Map<String, Monarch> accmonarchs = new HashMap<>();
	
	public static MonarchManager INSTALL = new MonarchManager();
	private MonarchManager() {
		
	}
	
	public void regist(String acc, String pwd, Monarch monarch) {
		accPwds.put(acc, pwd);
		accmonarchs.put(acc, monarch);
		register(monarch);
	}
	public boolean check(String acc, String pwd) {
		return pwd.equals(accPwds.get(acc));
	}
	
	public void register(Monarch monarch) {
		namemonarchs.put(monarch.getName(), monarch);
		ssidmonarchs.put(monarch.getSsid(), monarch);
	}
	
	public Monarch getMonarch(String name) {
		return namemonarchs.get(name);
	}
	
	public Monarch getMonarch(long ssid) {
		return ssidmonarchs.get(ssid);
	}
}
