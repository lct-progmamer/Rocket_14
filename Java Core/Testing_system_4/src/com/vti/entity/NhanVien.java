package com.vti.entity;

public class NhanVien extends canBo{

	private String congViec;
	
	public NhanVien(String name ,  int age , Sex sex ,String Cv)
	{
		super(name , age , sex);
		this.congViec = Cv;
	}
}
