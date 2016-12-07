package com.tj.sanguo.effect;

public class HeadquartersEffect extends BuildingEffect {

	private static final long serialVersionUID = 1L;
	
	public HeadquartersEffect(int level) {
		super(level);
	}
	
	protected void changeLevel() {
		if (this.level < 2) {
			this.rate = 1;
		}
		else if (this.level <= 5) {
			this.rate = 2;
		}
		else if (this.level <= 7) {
			this.rate = 3;
		}
		else if (this.level <= 10) {
			this.rate = 4;
		}
		else if (this.level <= 12) {
			this.rate = 5;
		}
		else if (this.level <= 15) {
			this.rate = 6;
		}
		else if (this.level <= 17) {
			this.rate = 7;
		}
		else if (this.level <= 20) {
			this.rate = 8;
		}
		changeDesc();
	}
	@Override
	void changeDesc() {
		if (this.level < 2) {
			nextRate = 2;
		}
		else if (this.level < 5) {
			nextRate = 5;
		}
		else if (this.level < 7) {
			nextRate = 7;
		}
		else if (this.level < 10) {
			nextRate = 10;
		}
		else if (this.level < 12) {
			nextRate = 12;
		}
		else if (this.level < 15) {
			nextRate = 15;
		}
		else if (this.level < 17) {
			nextRate = 17;
		}
		else if (this.level < 20) {
			nextRate = 20;
		}
		this.desc = "当前出兵数量为:" + this.rate + ",点兵场达到 " + this.nextRate + " 级,出兵数量会再加1个";
	}
}
