package com.tj.sanguo.effect;

import java.io.Serializable;

/**
 *  Ч�����࣬
 *  ���У��ݸ�Ч������ʯЧ�������ⳡ��Ч��
 *  ����Ч�����ٸ����ֿⲻͬ�ȼ�Ч��
 * @author Administrator
 *
 */
public class Effect implements Serializable {

	private static final long serialVersionUID = 1L;
	// Ч������
	protected int type = 1;
	// Ч���ȼ�
	protected int level = 1;
	// Ч����
	protected int rate = 100;
	// ��һ��Ч��
	protected int nextRate = 100;
	// Ч������
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
