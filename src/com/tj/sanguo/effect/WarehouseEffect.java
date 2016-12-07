package com.tj.sanguo.effect;

/**
 *  仓库效果
 * @author Administrator
 *
 */
public class WarehouseEffect extends BuildingEffect {

	private static final long serialVersionUID = 1L;

	public WarehouseEffect(int level) {
		super(level);
	}
	// 复写基类
	protected void init() {
		this.rate = 800;
		this.updateRate = 1.8f;
	}
	protected void changeLevel() {
		this.rate = 800;
		for (int i=1; i<this.level; i++) {
			this.rate = (int) (this.rate * this.updateRate);
		}
		this.nextRate = (int) (this.rate * this.updateRate);
		changeDesc();
	}
	@Override
	void changeDesc() {
		this.desc = "当前仓库容量为:" + this.rate + ",下一级仓库容量为:" + this.nextRate;
	}

}
