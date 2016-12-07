package com.tj.sanguo;

import java.io.Serializable;

/**
 * 坐标位置: 城市和山寨，以及其他的点
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
	// 一个州郡范围为：200 * 200，初始给中间4个州郡，即 200 - 600 范围，另外的后续扩展；
	public Position() {
		this.x = (int)(Math.random() * 400);
		this.y = (int)(Math.random() * 400);
	}
	
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public static Position createPosition() {
		Position position = new Position((int)(Math.random() * 400), (int)(Math.random() * 400));
		return position;
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
