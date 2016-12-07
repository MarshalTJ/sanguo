package com.tj.sanguo.effect;

/**
 * 官府效果
 * @author Administrator
 *
 */
public class OfficialEffect extends BuildingEffect {

	private static final long serialVersionUID = 1L;
	public OfficialEffect(int level) {
		super(level);
	}
	@Override
	void changeDesc() {
		this.desc = "当前建筑花费时间为:" + this.rate + ",下一级建筑话费时间为:" + this.nextRate;
	}
}
