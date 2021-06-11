package com.vti.entity;

public class Department {

	private byte id;
	private String name;

	public  Department()
	{
		this.id = 0;
		this.name = "null";
	}
	public Department(String nameDepartment)
	{
		this.id = 0;
		this.name = nameDepartment;
	}
	public byte getter_id()
	{
		return this.id;
	}
	public String getter_name()
	{
		return this.name;
	}
	public void setter_id(byte a)
	{
		this.id = a;
	}
	public void setter_name(String Name)
	{
		this.name = Name;
	}

	
	
}
