package com.tj.sanguo.treasure.equipment;

import com.tj.sanguo.treasure.Treasure;

/**
 * װ�� ����
 * @author Administrator
 *
 */
public class Equipment extends Treasure {

	private static final long serialVersionUID = 1L;
	// װ��Ч��ֵ
	protected int value = 0;
	// װ���ȼ�
	protected int level = 1;
	// װ��Ʒ�ʣ� 1 ��ͨ�� 2 ������ 3 ��ͭ�� 4������ 5�ƽ�
	protected int quality = 1;
	// װ���ӳɣ�ÿһ���ӳ�10%
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
