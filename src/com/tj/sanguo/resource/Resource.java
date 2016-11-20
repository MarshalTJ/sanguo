package com.tj.sanguo.resource;

/**
 * 资源基类
 * @author Administrator
 *
 */
public class Resource {
	protected int nums;
	protected String name;
	protected String desc;
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
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
