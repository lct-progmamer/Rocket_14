package com.vti.entity;

public class tapChi extends thuVien{
	
	private int soPhatHanh;
	private int thangPhatHanh;
	
	public tapChi(String a, String b, int c , int d , int e) {
		super(a, b, c);
		this.soPhatHanh  = d;
		this.thangPhatHanh =e;
	}
}
