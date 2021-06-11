package com.vti.backend;

import com.vti.entiy.News;

import java.util.Scanner;

public class MyNews {

	public  void quesion1() {
		menu();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input number : ");
		int ct = scanner.nextInt();
		switch(ct)
		{
			case 1:
				question1();
				break;
			case 2:
				question2();
				break;
			case 3:
				News news = new News();
				news.Calculate();
				news.Display();
			case 4:
				return;	
		}
		scanner.close();

	}
	public static void question1()
	{
		Scanner scanner  = new Scanner(System.in);
		System.out.print("input title : ");
		String title = scanner.nextLine();
		System.out.println("input PublishDate : ");
		String PublishDate = scanner.nextLine();
		System.out.println("input Author : ");
		String Author = scanner.nextLine();
		System.out.println("input content : ");
		String content = scanner.nextLine();
		News news = new News(title , PublishDate , Author ,content);
		news.Calculate();
		System.out.println("Successfull !");
		scanner.close();
	}

	public static void question2()
	{
		Scanner scanner  = new Scanner(System.in);
		System.out.print("input title : ");
		String title = scanner.nextLine();
		System.out.println("input PublishDate : ");
		String PublishDate = scanner.nextLine();
		System.out.println("input Author : ");
		String Author = scanner.nextLine();
		System.out.println("input content : ");
		String content = scanner.nextLine();
		News news = new News(title , PublishDate , Author ,content);
		news.Calculate();
		news.Display();
		scanner.close();
	}
	
	public static void menu()
	{
		System.out.println("1. Create Object and init");
		System.out.println("2. Do Display method");
		System.out.println("3. Do Calculate mehthod and Display method");
		System.out.println("4. Exit !");
	}
	
}
