package com.vti.entity;

public class Bao extends thuVien{
	
	private int ngayPhatHanh;
	
	public Bao(String a, String b, int c , int d) {
		super(a, b, c);
		this.ngayPhatHanh = d;
	}

}
