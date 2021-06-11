package com.vti.entity;

public class Position {
	private byte id;
	private String name;
	
	
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
	public void setter_name(String name)
	{
		this.name = name;
	}
}
