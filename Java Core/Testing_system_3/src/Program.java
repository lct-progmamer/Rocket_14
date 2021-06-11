import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class Program {

	

	public static void main(String[] args) {
		Account a1 = new Account();
		a1.Salary = 1500.435f;
		Account a2 = new Account();
		a2.Salary = 2000.5322f;
		
		
		Department department1 = new Department();
		department1.id = 1;
		department1.name = "Sale";
		
		Department department2 = new Department();
		department2.id = 2;
		department2.name = "Marketting";
		
		Department department3 = new Department();
		department3.id = 1;
		department3.name = "human rs";
		
		Department[] departments = new Department[] {department1,department2,department3};
		 
		// exercise 1
		//question1
//		ex1_question1(a1,a2);
		//question2:
//		System.out.println(ex1_question2());
		// question3
//		ex1_question3();
		//question4:
//		ex1_question4();
		
		
		// exercise 2
		//question1
//		ex2_question2();
		
		//exercise 3:
		//question1:
//		ex3_question1();
		//question2:
//		ex3_question2();
		//question3:
//		ex3_question3();
		
		//exercise 4
		//question1
//		ex4_question1();
		//question2
//		ex4_question2();
		//quétion3
//		ex4_question3();
		//question4
//		ex4_question4();
		//question5
//		ex4_question5();
	//	question6 
//		ex4_question6();
		//question7
	//	ex4_question7();
		//question8
//		ex4_question8();
		//question9
//		ex4_question9();
		//question10
//		ex4_question10();
		//question11
//		ex4_question11();
		//question12
//		ex4_question12();
		//question 13
//		ex4_question13();
		//question14
//		ex4_question14();
		//question15
//		ex4_question15();
		//question16:L
//		ex4_question16();
		
		//exercise 5
		//question1
//		ex5_question1(department1);
		//question2
//		ex5_question2(departments);
		//question3
		ex5_question3(department1);
		
		// hiện thị địa chỉ ô nhớ trong bộ nhớ của biến gọi.
//		String a = "a";
//		System.out.println(a.hashCode());
		

 
	}

	
	
	//exercise1
	public static void ex1_question1(Account a1, Account a2)
	{
		int a = (int) a1.Salary;
		int b = (int) a2.Salary;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		
	}


	
	public static int dem_so(int a)
	{
		int dem = 0;
		while(a!=0)
		{
			dem++;
			a/=10;
		}
		return dem;
	}
	
	public static int ex1_question2()
	{
		Random random = new Random();
		int a = random.nextInt(99999-0+1)+0;
		int b = 5 - dem_so(a);
		for (int i = 0; i < b; i++) {
			System.out.print("0");
		}
//		System.out.print(a);
		return a;
	}
	
	public static void ex1_question3()
	{
		int a = ex1_question2();
		int c = a%100;
		System.out.println(c);
	}

	public static void ex1_question4()
	{
		int a , b;
		Scanner scanner  = new Scanner(System.in);
		System.out.print("input the first number : ");
		a = scanner.nextInt();
		System.out.print("input the second number : ");
		b = scanner.nextInt();
		System.out.println("a/b = " + (float)a/b );
		scanner.close();
	}
	
	
	//exercise2
	public static void ex2_question2()
	{
		
		Account[] account = new Account[5];
		for (int i = 0; i < account.length; i++) {
			account[i] = new Account();
			account[i].email = "Email" + (i+1);
			account[i].userName = "User Name" + (i+1);
			account[i].fullName = "Full name" + (i+1);
			account[i].createDate =	LocalDate.now();
		}
		for (int i = 0; i < account.length; i++) {
			System.out.println("Email : " + account[i].email);
			System.out.println("UserName : " + account[i].userName);
			System.out.println("FullName : " + account[i].fullName);
			System.out.println("Create Date : " + account[i].createDate + "\n\n");
		}
	}

	
	
	//exercise3
	public static void ex3_question1()
	{
		int a = 5000;
		System.out.printf("'%1.2f'%n",(float)a);
	}

	public static void ex3_question2()
	{
		String a = "1234567";
		int c = Integer.valueOf(a);
		System.out.print(c);
	}

	public static void ex3_question3()
	{
		@SuppressWarnings("removal")
		Integer a = new Integer(1234567);
		int b = a.intValue();
		System.out.println(b);
		
	}

	
	//exercise 4
	public static int ex4_question1(String a)
	{
		int dem = 0;
		String b = a.replaceAll("\\s", " ").trim();
		for (int i = 0; i < b.length(); i++) {
			if(a.charAt(i) == ' ')
				dem++;
		}
		return dem + 1;
	}  

	
	public static void ex4_question2()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input the first String : ");
		String a = scanner.nextLine();
		System.out.println("Input the second String : ");
		String b = scanner.nextLine();
		System.out.println(a.concat(" " + b)); 
		scanner.close();
	}

	public static void ex4_question3()
	{
		Scanner scanner  = new Scanner(System.in);
		System.out.print("Input yourname :  ");
		String a = scanner.nextLine();
		if(a.charAt(0) >= 'a' && a.charAt(0) <= 'z')
		{
			// b : cat chu cai dau 
			String b = a.substring(0, 1);
			// c : cat chuoi tu chu cai dau den het
			String c = a.substring(1);
			// in hoa b va gop voi c
			a = b.toUpperCase()+c;
			System.out.println(a);
		}
		else 
			System.out.println(a);
		scanner.close();
	}

	public static void ex4_question4()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Input yourname : ");
		String a = scanner.nextLine();
		for (int i = 0; i < a.length(); i++) {
			System.out.println("kí tự "+(i+1) + " là : " + a.charAt(i));
		}
		scanner.close();
	}

	public static void ex4_question5()
	{
		Scanner scanner = new Scanner(System.in);
		// ho
		System.out.println("input your first name : ");
		String first_Name = scanner.nextLine();
		// ten
		System.out.println("input your last name : ");
		String last_Name = scanner.nextLine();
		System.out.println("Full Name : " + first_Name +" " +  last_Name );
		scanner.close();
	}

	public static void ex4_question6()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Input your full name : ");
		String full_Name = scanner.nextLine();
		full_Name.replaceAll("\\s", " ").trim();
//		System.out.print("Họ là : ");
		int dem = ex4_question1(full_Name) - 1;
		int count = 0;
		System.out.print("Họ là  : ");
		for (int j = 0; j < full_Name.length(); j++) {
			if(full_Name.charAt(j)!=' ')	
			{
				System.out.print(full_Name.charAt(j));
			}
			else
			{
				count++;
				if(count==1)
				{
					System.out.print("\nTên đệm : ");
				}
				else if(count == dem)
				{
					System.out.print("\nTên  : ");
				}
				else
					System.out.print(" ");
			}
		}
			
		scanner.close();
	}

	public static void ex4_question7()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("input your fullname : ");
		String full_Name = scanner.nextLine();
		//a
		String fix_Full_Name = full_Name.replaceAll("\\s\\s+", " ").trim();
		System.out.println(fix_Full_Name);
		// b
		String[] upper_String = fix_Full_Name.split(" ");
		for (int i = 0; i < upper_String.length; i++) {
				 String c = null , d = null;		
				 c = upper_String[i].substring(0, 1);
				 d = upper_String[i].substring(1);
				 c = c.toUpperCase();
				 System.out.print(c+d+" ");
			
		}
		scanner.close();
		
		
		
	}

	public static void ex4_question8()
	{
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "java và những người bạn";
		
		Group group2 = new Group();
		group2.id = 1;
		group2.name = "Lập trình java";
		
		Group group3 = new Group();
		group3.id = 3;
		group3.name = "python và những người bạn";
		
		Group[] groups = new Group[] {group1 , group2 , group3};
		
		String a = "java";
		
		for (int i = 0; i < groups.length; i++) {
			if(groups[i].name.contains(a)) // hàm kiểm tra str2 có trong str1 ko
				System.out.println(groups[i].name + ",");
		}
		
	}

	public static void ex4_question9()
	{
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "java";
		
		Group group2 = new Group();
		group2.id = 2;
		group2.name = "java";
		
		Group group3 = new Group();
		group3.id = 3;
		group3.name = "python";
		
		Group[] groups = new Group[] {group1 , group2 , group3};
		
		String a = "java";
		for (int i = 0; i < groups.length; i++) {
			if(groups[i].name.equals(a))
				System.out.println(groups[i].id + ",");
		}
	}

	public static void  ex4_question10()
	{
		String a = "word";
		String b = "drow";
		int j = b.length()-1;
		if(a.length() == b.length())
		{
			int dem = 0;
			for(int i = 0; i<a.length() ; i++)
			{
				if(a.charAt(i) == b.charAt(j))
					dem++;
				j--;
			}
			if(dem == a.length())
				System.out.println("OK");
			else
				System.out.println("KO");
		}
	}

	public static void ex4_question11()
	{
		String a = "aaaa aaaa";
		int dem = 0;
		for (int i = 0; i < a.length(); i++) {
			if(a.charAt(i) == 'a')
				dem++;
		}
		System.out.println("So lan xuat hien a : " + dem);
	}
	
	public static void ex4_question12()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("input the string  : ");
		String  a = scanner.nextLine();
		String b = " ";
		for(int i = a.length()-1;i>=0;i--)
		{
			b+= a.charAt(i);
		}
		System.out.print("-->"+ b.trim());
		scanner.close();
		
	}

	public static void ex4_question13()
	{
		String a = "abcdkfjjkn";
	
		for(int i = 0; i < a.length() ; i++)
		{
			if(a.charAt(i)>='1' && a.charAt(i) <='9')
			{
				System.out.println("false");
				return;
			}
		}
		System.out.println("true");
		
	}

	public static void ex4_question14()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("input the string  : ");
		String a = scanner.nextLine();
		System.out.println("input the character : ");
		String b = scanner.nextLine();
		System.out.println(a.replaceAll(b, "*"));
		scanner.close();
	}
	
	public static void ex4_question15()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("input the string  : ");
		String a = scanner.nextLine();
		int dem = ex4_question1(a);
		a = a.replaceAll("\\s", " ").trim();
		for (int i = 0; i < a.length(); i++) {
			if(a.charAt(i) == ' ')
			{
				
			}
		}
		
		scanner.close();
		
	}

	public static void ex4_question16()
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("input the string  : ");
		String a = scanner.nextLine();
		System.out.println("input the n  : ");
		int n = scanner.nextInt();
		String[] new_String = null;
		
		if(a.length()%n!=0)
			System.out.println("ko");
		else
		{
			int i = 0;
			for (; i < a.length();) {
				new_String[i] = a.substring(i, n);
				i = n;
			}
			for (int j = 0; j < new_String.length; j++) {
				System.out.println(new_String[i]);
			}
		}
		scanner.close();
			
	}
	
	// exercise 5:
	public static void ex5_question1(Department a)
	{
		System.out.println("Thông tin : ");
		System.out.println(a.toString());
	}

	
	public static void ex5_question2(Department[] a)
	{
		for (int i = 0; i < a.length; i++) {
			System.out.println("Thông tin phòng ban " + (i+1) + " : ");
			System.out.println(a[i].toString() + "\n");
		}
	}
	public static void ex5_question3(Department a)
	{
		System.out.println("Địa chỉ : " + a.hashCode());
	}
}
