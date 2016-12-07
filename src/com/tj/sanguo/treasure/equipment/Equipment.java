package com.tj.sanguo.treasure.equipment;

import com.tj.sanguo.treasure.Treasure;

/**
 * 装备 基类
 * @author Administrator
 *
 */
public class Equipment extends Treasure {

	private static final long serialVersionUID = 1L;
	// 装备效果值
	protected int value = 0;
	// 装备等级
	protected int level = 1;
	// 装备品质： 1 普通， 2 黑铁， 3 青铜， 4白银， 5黄金。
	protected int quality = 1;
	// 装备加成：每一级加成10%
	protected int additionLevel = 0;
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getQuality() {
		return quality;
	}
	public void setQuality(int quality) {
		this.quality = quality;
	}
	public int getAdditionLevel() {
		return additionLevel;
	}
	public void setAdditionLevel(int additionLevel) {
		this.additionLevel = additionLevel;
	}
}
