package com.tj.sanguo.fight.soldier;

import com.tj.sanguo.city.City;
import com.tj.sanguo.fight.Fighter;

/**
 * ʿ��
 * @author Administrator
 *
 */
public class Soldier extends Fighter {

	private static final long serialVersionUID = 1L;
	// �佫���ڳ��С�
	protected City city;
	// �ñ������������Ǽ��ɵ�������ɣ�����������Ƿ���Ҫ��ȡ��city��
	protected int nums;
	// ������������Ҫ����Դ
	protected int costWood = 100;
	protected int costIron = 100;
	protected int costfood = 100;
	// ʿ��ռ�˿���
	protected int population = 1;
	// ��������ʿ������Ҫ��ʱ�೤ʱ��
	protected int costTime = 60;
	// ����ʿ��Я���������������Ӷ���Դ����
	protected int backpack = 10;
//	// ʿ���ȼ��������������̵ȼ�һ��
//	protected int level = 1;
	public Soldier(City city, int nums) {
		this.city = city;
		this.nums = nums;
	}
	public City getCity() {
		return city;
	}
	public void setCity(City city) {
		this.city = city;
	}
	public int getCostWood() {
		return costWood;
	}
	public void setCostWood(int costWood) {
		this.costWood = costWood;
	}
	public int getCostIron() {
		return costIron;
	}
	public void setCostIron(int costIron) {
		this.costIron = costIron;
	}
	public int getCostfood() {
		return costfood;
	}
	public void setCostfood(int costfood) {
		this.costfood = costfood;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public int getCostTime() {
		return costTime;
	}
	public void setCostTime(int costTime) {
		this.costTime = costTime;
	}
	public int getBackpack() {
		return backpack;
	}
	public void setBackpack(int backpack) {
		this.backpack = backpack;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
}
