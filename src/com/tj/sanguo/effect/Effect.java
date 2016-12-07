package com.tj.sanguo.effect;

import java.io.Serializable;

/**
 *  效果基类，
 *  城市，州府效果：宝石效果，特殊场景效果
 *  建筑效果：官府，仓库不同等级效果
 * @author Administrator
 *
 */
public class Effect implements Serializable {

	private static final long serialVersionUID = 1L;
	// 效果类型
	protected int type = 1;
	// 效果等级
	protected int level = 1;
	// 效果率
	protected int rate = 100;
	// 下一级效率
	protected int nextRate = 100;
	// 效果描述
	protected String desc = "";
		
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	public int getNextRate() {
		return nextRate;
	}
	public void setNextRate(int nextRate) {
		this.nextRate = nextRate;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
