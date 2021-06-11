package com.vti.entity;

public class KySu extends canBo{
	private String nganhDaoTao;
	
	public KySu(String name ,  int age , Sex sex ,String NDT)
	{
		super(name , age , sex);
		this.nganhDaoTao = NDT;
	}
}
