package com.tj.sanguo;

import java.io.Serializable;

/**
 * ����λ��: ���к�ɽկ���Լ������ĵ�
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
	
//	protected statas ;�����ݿ�
	// һ���ݿ���ΧΪ��200 * 200����ʼ���м�4���ݿ����� 200 - 600 ��Χ������ĺ�����չ��
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
