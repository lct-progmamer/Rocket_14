package com.vti.entity;

public abstract class Student1 extends Person{
	byte id;
	String name;
	
	public Student1(byte id, String name)
	{
		super(name);
		this.id = id;
	}
	public byte getId()
	{
		return this.id;
	}
	
}
