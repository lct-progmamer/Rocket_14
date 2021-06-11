package com.vti.entity;

public class Student {
	private byte id;
	private String name;
	private String hometown;
	private float diemtb;
	
	
	public Student(String name , String hometown)
	{
		this.name = name;
		this.hometown = hometown;
		this.diemtb = 0;
	}
	public float get_point()
	{
		return this.diemtb;
	}
	
	public void setter_diemtb(float diem)
	{
		this.diemtb = diem;
	}
	
	public  void add_diem(float diem)
	{
		this.diemtb += diem;
	}
	
	public void  show_infor()
	{
		if(this.diemtb < 4)
			System.out.println("Yếu");
		else if(this.diemtb <6)
			System.out.println("Trung Bình");
		else if(this.diemtb < 8)
			System.out.println("Khá");
		else 
			System.out.println("Giỏi");
	
	}
	
	
}
