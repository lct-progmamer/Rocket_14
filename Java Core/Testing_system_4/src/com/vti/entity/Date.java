package com.vti.entity;

public class Date {
	private int day;
	private int month;
	private int year;
	
	public Date(int a,  int b , int c)
	{
		this.day = a;
		this.month = b;
		this.year = c;
	}
	
	public int getDay()
	{
		return this.day;
	}
	public int getMonth()
	{
		return this.month;
	}
	public int getYear()
	{
		return this.year;
	}
	
	public void setDay(int a)
	{
		this.day = a;
	}
	public void setMonth(int a)
	{
		this.month = a;
	}
	public void setYear(int a)
	{
		this.year = a;
	}
	
	@Override
	public String toString() {
		return "Date : " + this.day + "/" + this.month + "/" + this.year;
	}
	
	public boolean isLeapYear()
	{
		int is_leap_year = 0;
		if(this.year % 400 ==0)
			is_leap_year++;
		if(this.year %4 ==0 && this.year %100 != 0)
			is_leap_year++;
		if(is_leap_year == 2)
			return true;
		return false;	
	}
	
	
}
