package com.vti.entity;

public class Account1 {
	private String id;
	private String name;
	private int balance;
	
	
	public Account1(String a , String b , int c)
	{
		this.id = a;
		this.name = b;
		this.balance = c;
	}
	
	public String getID()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getBalance()
	{
		return this.balance;
	}
	
	
	
}
