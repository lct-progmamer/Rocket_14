package com.vti.backend;

import java.time.LocalDate;
import java.util.Date;

import com.vti.entity.*;

public class Exercise_1 {
	public void ex1_question1()
	{
		Department department1 = new Department();
		Department department2 = new Department("Sale");

		System.out.println("Information of department 1 : ");
		System.out.println("id : " + department1.getter_id());
		System.out.println("name : " + department1.getter_name());
		System.out.println("\nInformation of department 2 : ");
		System.out.println("id : " + department2.getter_id());
		System.out.println("name : " + department2.getter_name());
		
	}

	public void ex1_question2()
	{
		Position position = new Position();
		
		
		Account account1 = new Account();
	
		
		Account account2 = new Account((byte)1,"abc@gmail.com","abc" , "le" , "tai");
		
		
		Account account3 = new Account((byte)1,"abc@gmail.com","abc" , "le" , "tai" , position);

		
		Account account4 = new Account((byte)1,"abc@gmail.com","abc" , "le" , "tai" , position ,LocalDate.of(2021, 6, 6));
		
		System.out.println("Successfull!");
		
	}

	public void ex1_question3()
	{
		Account account1  = new Account();
		Account account2 = new Account();
		Account[] accounts = new Account[] {account1 , account2};
		
		Group group1 = new Group();
		
		Group group2 = new Group("music" , account1 , accounts , new Date());
		
		String[] userName = new String[] {"abc" , "bcd" , "egh"};
		
		Group group3 = new Group("football" , account2 , userName ,new Date() );
		for (int i = 0; i < group3.getter_accounts().length; i++) {
			System.out.println(group3.getter_accounts()[i].getter_userName());
		}
		
		System.out.println("successfull !");
	}


	
}
