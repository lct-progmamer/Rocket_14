package com.vti.entity;
import java.util.Date;

public class Group {
	private byte id;
	private String name;
	private Account creator;
	private Date createDate;
	private Account[] accounts;
	
	public Group(){
		
	}
	public Group(String groupName , Account creator , Account[] accounts , Date date)
	{
		this.name = groupName;
		this.creator = creator;
		this.accounts = accounts;
		this.createDate = date;
	
	}
	
	public Group(String groupName , Account creator , String[] userName , Date date)
	{
		this.name = groupName;
		this.creator = creator;
		this.accounts = new Account[userName.length];
		for (int i = 0; i < userName.length; i++) {
			this.accounts[i] =new Account();
			this.accounts[i].setter_userName(userName[i]);
		}
		this.createDate = date;
		
	
	}
	public byte getter_id()
	{
		return this.id;
	}
	public String getter_name()
	{
		return this.name;
	}
	public Date getter_date()
	{
		return this.createDate;
	}
	public Account getter_creator()
	{
		return this.creator;
	}
	public Account[] getter_accounts()
	{
		return this.accounts;
	}
	public void setter_id(byte a)
	{
		this.id = a;
	}
	public void setter_name(String Name)
	{
		this.name = Name;
	}
	public void setter_createDate(Date time)
	{
		this.createDate = time;
	}
	public void setter_creator(Account account)
	{
		this.creator = account;
	}
	public void setter_accounts(Account[] accounts)
	{
		this.accounts = accounts;
	}
	
	
}
