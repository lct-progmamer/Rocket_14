package com.vti.entity;
import java.time.LocalDate;
import java.util.Date;

public class Account {
	private byte id;
	private String email;
	private String userName;
	private LocalDate createDate;
	private String fullName;
	private Department department;
	private Position position;
	private Group[] groups;

	
	 public Account() {
	}
	public  Account(byte id , String email , String userName , String firtName , String lastName)
	{
		this.id =  id;
		this.email = email;
		this.userName = userName;
		this.fullName = firtName + lastName;
	}
	public Account(byte id , String email , String userName , String firtName , String lastName , Position a)
	{
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firtName + lastName;
		this.position = a;
		this.createDate = LocalDate.now();
	}

   public Account(byte id , String email , String userName , String firtName , String lastName , Position a , LocalDate date)
	{
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = firtName + lastName;
		this.position = a;
		this.createDate = LocalDate.now();
		this.createDate = date;
	}
	
    public byte getter_id()
    {
    	return this.id;
    }
    public String getter_email()
    {
    	return this.email;
    }
    public String getter_userName()
    {
    	return this.userName;
    }
    public String getter_fullName()
    {
    	return this.fullName;
    }
    public LocalDate getter_createDate()
    {
    	return this.createDate;
    }
    public Department getter_department()
    {
    	return this.department;
    }
    public Position getter_position()
    {
    	return this.position;
    }
    public Group[] getter_groups()
    {
    	return this.groups;
    }
    public void setter_id(byte a)
    {
    	this.id = a;
    }

    public void setter_email(String email)
    {
    	this.email = email;
    }
	public void setter_userName(String userName)
	{
		this.userName = userName;
	}
    public void setter_fullName(String fullName)
    {
    	this.fullName = fullName;
    }
    public void setter_departmnet(Department dpt)
    {
    	this.department = dpt;
    }
    public void setter_position(Position a)
    {
    	this.position = a;
    }
    public void setter_groups(Group[] b)
    {
    	this.groups = b;
    }
	
}
