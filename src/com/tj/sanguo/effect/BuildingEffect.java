package com.tj.sanguo.effect;

public abstract class BuildingEffect extends Effect {

	private static final long serialVersionUID = 1L;
	// 升级利率
	protected float updateRate = 1.20f;
	
	public BuildingEffect() {
		this(1);
	}
	public BuildingEffect(int level) {
		this.level = level;
		this.init();
		this.changeLevel();
	}
	
	// 由子类复写
	protected void init() {
		
	}
	abstract void changeDesc();
	
	protected void changeLevel() {
		this.rate = 100;
		for (int i=1; i<this.level; i++) {
			this.rate = (int) (this.rate / this.updateRate);
		}
		this.nextRate = (int) (this.rate / this.updateRate);
		changeDesc();
	}

	public void updateLevel() {
		this.level++ ;
		this.changeLevel();
	}
	
	public void degradeLevel() {
		this.level-- ;
		this.changeLevel();
	}
	public float getUpdateRate() {
		return updateRate;
	}

	public void setUpdateRate(float updateRate) {
		this.updateRate = updateRate;
	}
	
}
