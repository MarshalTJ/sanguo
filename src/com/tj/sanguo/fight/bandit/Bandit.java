package com.tj.sanguo.fight.bandit;

import com.tj.sanguo.fight.Fighter;

/**
 *  NPC ÍÁ·Ë»ùÀà
 * @author Administrator
 *
 */
public class Bandit extends Fighter {

	private static final long serialVersionUID = 1L;
	protected int nums = 0;
	
	public Bandit(int nums) {
		this.nums = nums;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
}
