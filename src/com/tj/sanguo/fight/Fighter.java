package com.tj.sanguo.fight;

import java.io.Serializable;

/**
 *  ս���ߣ��������佫�����������������
 * @author Administrator
 *
 */
public class Fighter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected String name = "ս����";
	// �������ͣ�1 �﹥��2 ��������
	protected int attackType = 0;
	// ����
	protected int attack = 10;
	// ��������
	protected int infantryDefence = 10;
	// ��ʿ����
	protected int knightDefenct = 10;
	// �ٶ�
	protected int speed = 10;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAttackType() {
		return attackType;
	}
	public void setAttackType(int attackType) {
		this.attackType = attackType;
	}
	public int getAttack() {
		return attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public int getInfantryDefence() {
		return infantryDefence;
	}
	public void setInfantryDefence(int infantryDefence) {
		this.infantryDefence = infantryDefence;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getKnightDefenct() {
		return knightDefenct;
	}
	public void setKnightDefenct(int knightDefenct) {
		this.knightDefenct = knightDefenct;
	}
}
