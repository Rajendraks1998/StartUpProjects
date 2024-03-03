package com.wipro.ClinicSystem.dao;

public class AdminDao {
	private String adminname;
	private String adminpassword;
	public AdminDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AdminDao(String adminname, String adminpassword) {
		super();
		this.adminname = adminname;
		this.adminpassword = adminpassword;
	}
	@Override
	public String toString() {
		return "AdminDao [adminname=" + adminname + ", adminpassword=" + adminpassword + "]";
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	
	
}
