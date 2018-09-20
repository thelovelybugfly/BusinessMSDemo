package com.project.busniess.po;

public class OrdersPo {
	private int oid;
	private String onum;
	private int uid;
	private int gid;
	private int bnum;
	private String rtime;
	private int flag;
	private String gimg;
		public int getOid() {
			return oid;
		}
		public String getGimg() {
			return gimg;
		}
		public void setGimg(String gimg) {
			this.gimg = gimg;
		}
		public void setOid(int oid) {
			this.oid = oid;
		}
		public String getOnum() {
			return onum;
		}
		public void setOnum(String onum) {
			this.onum = onum;
		}
		public int getUid() {
			return uid;
		}
		public void setUid(int uid) {
			this.uid = uid;
		}
		public int getGid() {
			return gid;
		}
		public void setGid(int gid) {
			this.gid = gid;
		}
		public int getBnum() {
			return bnum;
		}
		public void setBnum(int bnum) {
			this.bnum = bnum;
		}
		public String getRtimeString() {
			return rtime;
		}
		public void setRtimeString(String rtimeString) {
			this.rtime = rtimeString;
		}
		public int getFlag() {
			return flag;
		}
		public void setFlag(int flag) {
			this.flag = flag;
		}
		
}
