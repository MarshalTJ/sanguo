package com.tj.sanguo.map;

import com.tj.sanguo.Position;

/**
 * ƽԭ�յ�
 * @author Administrator
 *
 */
public class Flatland extends Position {

	private static final long serialVersionUID = 1L;
	protected int type;
	public Flatland(int type, Position pos) {
		super(pos.getX(), pos.getY());
		this.type = type;
	}

}
