package com.tj.sanguo.city;

import java.io.Serializable;

/**
 * 坐标位置
 * @author Administrator
 *
 */
public class Position implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int x;
	protected int y;
	
//	protected statas ;所属州郡
	public Position() {
		this.x = (int)(Math.random() * 800);
		this.y = (int)(Math.random() * 800);
	}
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
