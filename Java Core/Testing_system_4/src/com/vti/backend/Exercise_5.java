package com.vti.backend;


import com.vti.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Exercise_5 {
		
		public canBo add_infor()
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Nhap thong tin can bo can them ");
			System.out.print("name : ");
			String name = scanner.nextLine();
			System.out.print("age : ");
			int age = scanner.nextInt();
			canBo new_canbo = new canBo(name , age, Sex.FEMALE);
			return new_canbo;
		}
		public void find_name(List<canBo> canbos)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("input name : ");
			String name = scanner.nextLine();
			int dem = 0;
			for (canBo canBo : canbos) {
				if(canBo.getname().equals(name))
				{
					System.out.print("name : " + canBo.getname());
					System.out.print("age : " + canBo.getAge());
					System.out.print("hometown : "+canBo.getHometown());
				}
				else 
					dem++;
			}
			if(dem == canbos.size())
				System.out.println("khong co ai ten la " + name);
		}
		public void  show(List<canBo> canbos)
		{
			for (canBo canBo : canbos) {
					System.out.print("name : " + canBo.getname());
					System.out.print("age : " + canBo.getAge());
					System.out.print("hometown : "+canBo.getHometown());
			}
		}
		
		public void delete(List<canBo> canbos)
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("input name : ");
			String name = scanner.nextLine();
			for (canBo canBo : canbos) {
				if(canBo.getname().equals(name))
				{
					canbos.remove(canBo);
				}
			}
			scanner.close();
		}
		
		public void ex5_question2()
		{
			// khoi tao array list
			List<canBo> canbos = new ArrayList<canBo>();
			Scanner scanner = new Scanner(System.in);
			System.out.println("1 . Thêm cán bộ");
			System.out.println("2 . tìm kiếm cán bộ bằng tên");
			System.out.println("3 . tìm kiếm và xóa bằng tên");
			System.out.println("4 . hiện thị danh sách cán bộ");
			System.out.println("5 . kết thúc chương trình");
			
			
			System.out.println("input number " );
			int ct = scanner.nextInt();
			switch(ct)
			{
				case 1:
					canBo new_canbo = add_infor();
					canbos.add(new_canbo);
					System.out.println("Succesfull !");
					break;
				case 2:
					find_name(canbos);
					break;
				case 3:
					show(canbos);
					break;
				case 4:
					delete(canbos);
					break;
				case 5:
					return;
			}
			scanner.close();
			
			
		}

		
		
	
	public void ex5_question3()
	{
		HighSchoolStudent new_student = new HighSchoolStudent((byte)1,"nam" , "Chuyên Văn" , "Đại học công nghệ");
		System.out.println("id : " + new_student.getId());
		System.out.println("name : " + new_student.getName());
		System.out.println("class : " + new_student.getclazz());
	}
	
	
	
	public Sach add_infor_sach()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhap thong tin sach can them ");
		System.out.println("Nhap ma tai lieu  ");
		String ma = scanner.nextLine();
		System.out.println("Nhap ten nha xuat ban : ");
		String ten = scanner.nextLine();
		System.out.println("Nhap so ban phat hanh : ");
		int sol = scanner.nextInt();
		
		System.out.println("nhap ten tac gia : ");
		String tenTacGia = scanner.nextLine();
		System.out.println("Nhap so trang : ");
		int a =scanner.nextInt();
		Sach new_sach = new Sach(ma , ten , sol , tenTacGia , a);
		return new_sach;
	}
	public void find_name_sach(List<Sach> sachs)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("input ma tai lieu : ");
		String ma = scanner.nextLine();
		int dem = 0;
		for (Sach sach : sachs) {
			
			if(sach.getMatl().equals(ma))
			{
				System.out.print("ten tac gia : " + sach.getTentg());
				System.out.print("so trang : " + sach.getSoTrang());
			}
			else 
				dem++;
		}
		if(dem == sachs.size())
			System.out.println("khong co sach ma  " + ma);
	}
	public void  show_sach(List<Sach> sachs)
	{
		for (Sach sach : sachs) {
			System.out.print("ten tac gia : " + sach.getTentg());
			System.out.print("so trang : " + sach.getSoTrang());
		}
	}
	
	public void delete_sach(List<Sach> sachs)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("input matl : ");
		String ma = scanner.nextLine();
		for (Sach sach : sachs) {
			if(sach.getMatl().equals(ma))
			{
				sachs.remove(sach);
			}
		}
			scanner.close();
	}
		
	
	
	public void ex5_question4()
	{
		List<Sach> sachs = new ArrayList<Sach>();
		// khoi tao array list
		Scanner scanner = new Scanner(System.in);
		System.out.println("1 . Thêm sach");
		System.out.println("2 . tìm kiếm sach bằng tên");
		System.out.println("3 . tìm kiếm và xóa bằng tên");
		System.out.println("4 . hiện thị danh sách sach");
		System.out.println("5 . kết thúc chương trình");
		System.out.println("input number " );
		int ct = scanner.nextInt();
		switch(ct)
		{
			case 1:
				Sach new_sach = add_infor_sach();
				sachs.add(new_sach);
				System.out.println("Succesfull !");
				break;
			case 2:
				find_name_sach(sachs);
				break;
			case 3:
				show_sach(sachs);
				break;
			case 4:
				delete_sach(sachs);
				break;
			case 5:
					return;
		}
		scanner.close();
		
		
	}
}

