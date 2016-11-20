package com.tj.sanguo.resource;

import java.io.Serializable;

/**
 * 资源基类
 * @author Administrator
 *
 */
public class Resource implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected float nums;
	protected String name;
	protected String desc;
	
	public void add(float n) {
		this.nums += n;
	}
	
	public float getNums() {
		return nums;
	}
	public void setNums(float nums) {
		this.nums = nums;
	}
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
