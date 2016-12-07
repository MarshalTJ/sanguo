package com.tj.sanguo.fight.bandit;

import java.util.ArrayList;
import java.util.List;

import com.tj.sanguo.Position;

/**
 * NPC 山寨
 * @author Administrator
 *
 */
public class BanditsNest extends Position {

	private static final long serialVersionUID = 1L;
	protected int level = 1;
	// 山寨中拥有的资源量
	protected int resource = 100;
	List<Bandit> bandits =  new ArrayList<Bandit>();
	
	public BanditsNest(int level) {
		super();
		this.level = level;
		init();
	}

	private void init() {
		switch (level) {
		case 1:
			bandits.add(new Bandit1(10));
			resource = 100;
			break;
		case 2:
			bandits.add(new Bandit1(9));
			bandits.add(new Bandit2(9));
			resource = 200;
			break;
		case 3:
			bandits.add(new Bandit1(15));
			bandits.add(new Bandit2(20));
			bandits.add(new Bandit3(15));
			resource = 400;
			break;
		case 4:
			bandits.add(new Bandit1(20));
			bandits.add(new Bandit2(20));
			bandits.add(new Bandit3(50));
			resource = 700;
			break;
		case 5:
			bandits.add(new Bandit1(30));
			bandits.add(new Bandit2(40));
			bandits.add(new Bandit3(50));
			bandits.add(new Bandit4(20));
			resource = 1000;
			break;
		case 6:
			bandits.add(new Bandit1(40));
			bandits.add(new Bandit2(60));
			bandits.add(new Bandit3(60));
			bandits.add(new Bandit4(40));
			resource = 1500;
			break;
		case 7:
			bandits.add(new Bandit1(80));
			bandits.add(new Bandit2(90));
			bandits.add(new Bandit3(80));
			bandits.add(new Bandit4(80));
			resource = 2200;
			break;
		case 8:
			bandits.add(new Bandit1(100));
			bandits.add(new Bandit2(110));
			bandits.add(new Bandit3(100));
			bandits.add(new Bandit4(90));
			bandits.add(new Bandit5(50));
			resource = 3400;
			break;
		case 9:
			bandits.add(new Bandit1(100));
			bandits.add(new Bandit2(110));
			bandits.add(new Bandit3(120));
			bandits.add(new Bandit4(80));
			bandits.add(new Bandit5(100));
			resource = 4200;
			break;
		case 10:
			bandits.add(new Bandit1(130));
			bandits.add(new Bandit2(50));
			bandits.add(new Bandit3(180));
			bandits.add(new Bandit4(110));
			bandits.add(new Bandit5(160));
			resource = 4800;
			break;
		default:
			break;
		}
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getResource() {
		return resource;
	}

	public void setResource(int resource) {
		this.resource = resource;
	}

	public List<Bandit> getBandits() {
		return bandits;
	}

	public void setBandits(List<Bandit> bandits) {
		this.bandits = bandits;
	}
	
}
