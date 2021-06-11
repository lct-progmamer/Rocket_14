package com.vti.entity;

public class HighSchoolStudent extends Student1 {
	byte id;
	String name;
	String clazz;
	String desiredUniversity;
	
	public HighSchoolStudent(byte id , String name , String clazz , String dream_university)
	{
		super(id, name);
		this.clazz = clazz;
		this.desiredUniversity = dream_university;
	}
	public String getclazz()
	{
		return this.clazz;
	}
}
