package com.vti.entity;

public class canBo {
	protected String name;
	protected int age;
	protected  Sex sex;
	protected String hometown;

	

	public canBo(String name , int age , Sex male)
	{
		this.name = name;
		this.age = age;
		this.sex = male;
	}
	public String getname() {
		return this.name;
	}
	public int getAge()
	{
		return this.age;
	}
	public String getHometown()
	{
		return this.hometown;
	}
	public Sex getSex()
	{
		return this.sex;
	}
	
}
