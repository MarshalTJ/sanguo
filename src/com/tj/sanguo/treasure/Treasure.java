package com.tj.sanguo.treasure;

import java.io.Serializable;

/**
 *  ������� ����
 * @author Administrator
 *
 */
public class Treasure implements Serializable {

	private static final long serialVersionUID = 1L;
	protected String name;
	protected String desc;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
