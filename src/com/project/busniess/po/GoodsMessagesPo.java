package com.project.busniess.po;

public class GoodsMessagesPo {
	private int gid;
	private String gname;
	private String photoaddress;
	private String gdescribe;
	private float price;
	private int flag;
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public String getGname() {
		return gname;
	}
	public void setGnameString(String gnameString) {
		this.gname = gnameString;
	}
	public String getPhotoaddress() {
		return photoaddress;
	}
	public void setPhotoaddress(String photoaddress) {
		this.photoaddress = photoaddress;
	}
	public String getGdescribe() {
		return gdescribe;
	}
	public void setGdescribe(String gdescribe) {
		this.gdescribe = gdescribe;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
}
