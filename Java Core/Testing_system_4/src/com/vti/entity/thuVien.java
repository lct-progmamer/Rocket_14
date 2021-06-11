package com.vti.entity;

public class thuVien {
	protected String maTl;
	protected String tenNxb;
	protected int soBanPhatHanh;
	
	public thuVien(String a , String b , int c)
	{
		this.maTl = a;
		this.tenNxb = b;
		this.soBanPhatHanh = c;
	}
	public String getMatl()
	{
		return this.maTl;
	}
	
}
