package com.vti.entiy;

import java.util.Scanner;

public class News implements INews{
	private int ID;
	private String Title;
	private String PublishDate;
	private String Author;
	private String content;
	private float AverageRate;
	
	
	public News()
	{
		
	}
	
	public News(String title ,String PublishDate , String author , String content)
	{
		this.Title = title;
		this.PublishDate = PublishDate;
		this.Author = author;
		this.content = content;
	}
	
	public int getId()
	{
		return this.ID;
	}
	public String gettitle()
	{
		return this.Title;
	}
	public String get_PublishDate()
	{
		return this.PublishDate;
	}
	public String get_Author()
	{
		return this.Author;
	}
	public String get_content()
	{
		return this.content;
	}
	public float get_avg()
	{
		return this.AverageRate;
	}
	public void set_id(int a)
	{
		this.ID = a;
	}
	public void set_Author(String a)
	{
		this.Author = a;
	}
	public void set_content(String a)
	{
		this.content = a;
	}
	@Override
	public void Display() {
		System.out.println("title : " + this.Title);
		System.out.println("PublishDate" + this.PublishDate);
		System.out.println("Author : " + this.Author);
		System.out.println("Content : " + this.content);
		System.out.println("AverageRate : "+this.AverageRate);	
	}
	@Override
	public float Calculate() {
		Scanner scanner = new Scanner(System.in);
		int[] Rates = new int[3];
		for (int i = 0; i < 3; i++) {
			System.out.println("input Rates[" + (i+1) +"] = ");
			Rates[i] = scanner.nextInt();
		}
		int temp = 0;
		for (int i = 0; i < 3; i++) {
			temp += Rates[i];
		}
		this.AverageRate = (float) temp/3;
		scanner.close();
		return this.AverageRate;
	}
	

}
