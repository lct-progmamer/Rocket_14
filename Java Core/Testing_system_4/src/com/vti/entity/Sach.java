package com.vti.entity;

public class Sach extends thuVien{
	private String tenTg;
	private int soTrang;
	
	public Sach(String a , String b , int c , String d , int e)
	{
		super(a, b, c);
		this.tenTg = d;
		this.soTrang = e;
	}
	public String getTentg()
	{
		return this.tenTg;
	}
	public int getSoTrang()
	{
		return this.soTrang;
	}
}
