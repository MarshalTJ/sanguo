package com.tj.sanguo.effect;

/**
 *  �ֿ�Ч��
 * @author Administrator
 *
 */
public class WarehouseEffect extends BuildingEffect {

	private static final long serialVersionUID = 1L;

	public WarehouseEffect(int level) {
		super(level);
	}
	// ��д����
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
		this.desc = "��ǰ�ֿ�����Ϊ:" + this.rate + ",��һ���ֿ�����Ϊ:" + this.nextRate;
	}

}
