package com.tj.sanguo.effect;

/**
 * �ٸ�Ч��
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
		this.desc = "��ǰ��������ʱ��Ϊ:" + this.rate + ",��һ����������ʱ��Ϊ:" + this.nextRate;
	}
}
