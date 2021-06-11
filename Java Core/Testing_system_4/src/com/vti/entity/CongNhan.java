package com.vti.entity;

public class CongNhan extends canBo{
	private int bac;
	
	public CongNhan(String name ,  int age , Sex sex , int bac )
	{
		super(name , age , sex);
		this.bac = 1;
	}
}
