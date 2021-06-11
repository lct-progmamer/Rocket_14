package com.vti.entity;

public class Cirle {
	private double radius;
	private String color;
	
	
	public Cirle()
	{
		this.color = "red";
		this.radius = 1.0;
	}
	
	public Cirle(double a)
	{
		this.radius = a;
	}
	
	public Cirle(double a , String Color)
	{
		this.radius = a; 
		this.color = Color;
	}
	
	public double getRadius()
	{
		return this.radius;
	}
	
	public void setRadius(double a)
	{
		this.radius = a;
	}
	
	public String getColor()
	{
		return this.color;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public double getArea()
	{
		return 3.14*this.radius;
	}
	
	@Override
	public String toString() {
		return "S  =  " + this.getArea();
	}
}
