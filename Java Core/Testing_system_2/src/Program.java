import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Program {

	public static void main(String[] args) {
		
		Department department1 = new Department();
		department1.id = 1;
		department1.name =  "Sale";	
		
		Department department2 = new Department();
		department2.id = 2;
		department2.name =  "meeting room";	
		
		Department department3 = new Department();
		department3.id = 3;
		department3.name =  "human resources";		
		
		
		
		Department[] departments = new Department[] {department1 , department2 , department3};
		
		
		
		Position position1 = new Position();
		position1.id = 1;
		position1.name = "dev";
		
		Position position2 = new Position();
		position2.id = 2;
		position2.name = "marketting";
		

		
		Account account3 = new Account();
		account3.id = 3;
		account3.email = "abc@gmail.com";
		account3.userName = "abc";
		account3.fullName = "Lê Văn C";
		account3.position = position1;
		account3.department = department1;
		account3.createDate =  new Date("2020/6/12");

		
		Account account4 = new Account();
		account4.id = 4;
		account4.email = "abcefds@gmail.com";
		account4.userName = "abc";
		account4.fullName = "Lê Văn D";
		account4.position = position1;
		account4.department = department1;
		account4.createDate =  new Date("2019/6/12");
		
		
		
		Group group1 = new Group();
		group1.id = 1;
		group1.name = "bóng đá";
		group1.creator = account3;
		group1.createDate = new Date("2020/12/02");
		group1.accounts = new Account[] {account4  ,account3};
		
		Group group2 = new Group();
		group2.id = 2;
		group2.name = "music";
		group2.creator = account3;
		group2.createDate = new Date("2021/2/03");
		
		

		Group group3 = new Group();
		group3.id = 3;
		group3.name = "game";
		group3.creator = account4;
		group3.createDate = new Date("2021/6/03");
		

		Group group4 = new Group();
		group4.id = 2;
		group4.name = "racing boy";
		group4.creator = account4;
		group4.createDate = new Date("2015/2/03");
		
		
		
		
		Account account1 = new Account();
		account1.id = 1;
		account1.email = "abc@gmail.com";
		account1.userName = "abc";
		account1.fullName = "Lê Văn C";
		account1.position = position1;
		account1.department = department1;
		account1.createDate =  new Date("2020/6/12");
		account1.groups = new Group[] {group1};
		
		
		Account account2 = new Account();
		account2.id = 1;
		account2.email = "abcd@gmail.com";
		account2.userName = "abcd";
		account2.fullName = "Lê B";
		account2.position = position2;
		account2.department = department1;
		account2.createDate =  new Date("2020/6/12");
		account2.groups = new Group[] {group2 , group3 ,group4};
		
		Account account5 = new Account();
		account5.id = 5;
		account5.email = "abcd@gmail.com";
		account5.userName = "abcd";
		account5.fullName = "Lê E";
		account5.position = position1;
		account5.department = department1;
		account5.createDate =  new Date("2020/6/12");
		account5.groups = new Group[] {group3,group4,group1};
		
		Account[] accounts = new Account[] {account1 ,account2,account3,account4,account5 };
		Group[] groups = new Group[] {group1 , group2 , group3, group4};
		
		Exam exam1 = new Exam();
		exam1.id = 1;
		exam1.code = "đề 1";
		exam1.creator = account1;
		exam1.title = "câu hỏi số 1";
		exam1.duration = LocalDateTime.now();
		exam1.createDate = new Date("2020/12/2");
		
		Question question1 = new Question();
		question1.id = 1;
		question1.createDate = LocalDate.of(2021,5,6);
	

	//Exercise 1
	// question 1 	
//		question1(account2);
	//question2 :
//		question2(account2);
	//question3:
//		question3(account2);
	//question4:
//		question4(account1);
	//question5:
//		question5(group1);
	//question6:
//		question6(account2);
	//question7:
//		question7(account1);
	//question 8:
//		question8(accounts);
	//question 9:
//		question9(departments);
	//question10:
//		question10(accounts);
	//question11:
//		question11(departments);
	//question12:
//		question12(departments);
	//question13:
//		question13(accounts);
	//question14:
//		question14(accounts);
	//question15:
//		question15();
	//question16
//		question16a(accounts);
//		question16b();
	// quétion17
//		question17a(accounts);
//		question17b();
		
	// exercise 2
	//question1
//		ex2_question1();
	//question2
//		ex2_question2();
	//question3
//		ex2_question3();
	//question4
//		ex2_question4();
	//question5:
//		ex2_question5();
	//question6
//		ex2_question6(accounts);
		
	// exercise 3:
	// question1:
//		ex3_question1(exam1);
	//question2:
//		ex3_question2(exam1); 
	// question 3:
//		ex3_question3(exam1);
//	//question4:
//		ex3_question4(exam1);
	//question5:
//		ex3_question5(exam1);
	//exercise6:
	// question1
//		ex6_question1();
	// question2:
//		ex6_question2(accounts);
	//question3:
//		ex6_question3();
	// exercise 4
	//question1
//		ex4_question1();
	//question2
//		ex4_question2();
	//question3
//		ex4_question3();
	//question4
//		ex4_question4();
	//question5
//		ex4_question5();
		
		
	//exercise 5:
	//question1
//		ex5_question1();
	//question2:
//		ex5_question2();
	//question3:
//		ex5_question3();
	//question 4:
//		ex5_question4();
	//question5:
//		ex5_question5();
	//question6:
//		ex5_question6();
	//question 7:
//		ex5_question7();
	//question 8 : 
		ex5_question8();
			
		


		
		
		
		
	}
	
	public static int dem_sl(Group[] x)
	{
		int dem = 0;
		for(Group i : x) {
			dem++;
		}
		return dem;
	}
	
 	public static void question1(Account account2) {
		if(account2.department == null) {
			System.out.println("Khong co department ");
		}
		else
		{
			System.out.println( "phong ban : " + account2.department.name);
		}
	}
	
	public static void question2(Account account2) {
		int count = account2.groups.length;
		if(count == 0) {
			System.out.println("Nhân viên này chưa có group");
		}
		else if(count == 1 || count==2)
		{
			System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
		}
		else if(count == 3) {
			System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
		}
		else if(count >= 4)
		{
			System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
		}
	}
	
	public static void question3(Account account2) {
		System.out.println(" " + account2.department.id == null ? "Nhân viên này chưa có phòng ban" : "Phòng ban của nhân viên này là"  + account2.department.name);
	}
		
	public static void question4(Account account1) {
		System.out.println( account1.position.name == "dev" ? "this is a developer" : "not developer");
	}
		
	public static void question5(Group group1) {
		
		int a = group1.accounts.length;
		switch(a){
			case 1 :
					System.out.println("Nhóm có 1 thành viên");
					break;
			case 2:
					System.out.println("Nhóm có 2 thành viên");
					break;
			case 3: 
					System.out.println("Nhóm có 3 thành viên");
					break;
			default:
					System.out.println("Nhóm có nhiều thành viên");
					break;
		}
	}
	
	public static void question6(Account account2)
	{
		int a = account2.groups.length;
		
		switch(a) {
		
			case 0:
				System.out.println("Nhân viên này chưa có group");
				break;
			case 1 :
				System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
				break;
			case 2 :
				System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
				break;
			case 3 :
				System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
				break;
			default : 
				System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
				break;
		}
	}
	
	public static void question7(Account account1)
	{
		String a = account1.position.name;
		switch(a)
		{
			case "dev":
				System.out.println("Đây là Developer");
				break;
			default :
				System.out.println("Người này không phải là Developer");
				break;
		}
		
	}
	
	public static void question8(Account[] accounts)
	{
		int i = 1;
		for (Account point : accounts)
		{
			System.out.println("Account thứ " + i + " là : ");
			System.out.println("Email : " + point.email);
			System.out.println("Fullname : " + point.fullName);
			System.out.println("Department : " + point.department.name + "\n");
			i++;
		}
	}
	
	public static void question9(Department[] departments)
	{
		int i = 1;
		for(Department point : departments)
		{
			System.out.println("Phòng ban " + i + " là : ");
			System.out.println("department Id : " + point.id);
			System.out.println("department name : " + point.name + "\n");
			i++;
		}
	}

	public static void question10(Account[] x)
	{
		for(int i = 0 ; i < x.length ; i++)
		{
			int a = i+1;
			System.out.println("Account thứ " +a + " là : ");
			System.out.println("Email : " + x[i].email);
			System.out.println("Fullname : " + x[i].fullName);
			System.out.println("Department : " + x[i].department.name + "\n");
		}
	}
	
	public static void question11(Department[] x)
	{
		for(int i=0;i<x.length;i++)
		{
			int a = i+1;
			System.out.println("Phòng ban " + a + " là : ");
			System.out.println("\tId : " + x[i].id);
			System.out.println("\tName : " + x[i].name + "\n");
		}
	}
	
	public static void question12(Department[] x)
	{
		int dem = 0;
		for(int i = 0;i<x.length;i++)
		{
			dem++;
			System.out.println("Phòng ban " + dem + " là : ");
			System.out.println("department Id : " + x[i].id);
			System.out.println("department name : " + x[i].name + "\n");
			if(dem ==2)
				break;
		}
	}
	
	public static void question13(Account[] x)
	{
		for(int i = 0;i<x.length;i++)
		{
			if(i!=2)
			{
				int a = i+1;
				System.out.println("Account thứ " +a + " là : ");
				System.out.println("Id : " + x[i].id);
				System.out.println("Email : " + x[i].email);
				System.out.println("Fullname : " + x[i].fullName);
				System.out.println("Username : " + x[i].userName);
				System.out.println("Department : " + x[i].department.name);
				System.out.println("Position : "+x[i].position.id);
				System.out.println("Create Date : " + x[i].createDate);
				System.out.print("Group :  ");
				if(x[i].groups==null)
				{
					System.out.println("Account này không tham gia group nào");
					continue;
				}
				for(int j = 0 ; j<x[i].groups.length ;j++)
				{
					System.out.print(x[i].groups[j].name + " , ");	
				}
				System.out.println("\n\n");
			}
		}
	}
	
	public static void question14(Account[] x)
	{
		for(int i = 0 ; i < x.length ; i++)
		{
			if(x[i].id < 4)
			{
				int a = i+1;
				System.out.println("Account thứ " +a + " là : ");
				System.out.println("Id : " + x[i].id);
				System.out.println("Email : " + x[i].email);
				System.out.println("Fullname : " + x[i].fullName);
				System.out.println("Username : " + x[i].userName);
				System.out.println("Department : " + x[i].department.name);
				System.out.println("Position : "+x[i].position.id);
				System.out.println("Create Date : " + x[i].createDate);
				System.out.print("Group :  ");
				if(x[i].groups==null)
				{
					System.out.println("Account này không tham gia group nào");
				
				}
				else
				{
					for(int j = 0 ; j<x[i].groups.length ;j++)
					{
						System.out.print(x[i].groups[j].name + " , ");	
					}
					System.out.println("\n\n");
				}
			}
		}
	}
	
	public static void question15() {
		for(int i=1;i<=20;i++)
		{
			if(i%2==0)
			{
				System.out.printf("%d\t",i);
			}
		}
	}

	public static void question16a(Account[] x) {
		
		int i = 0;
			while(i<x.length) {
				if(x[i].id < 4)
				{
					int a = i+1;
					System.out.println("Account thứ " +a + " là : ");
					System.out.println("Id : " + x[i].id);
					System.out.println("Email : " + x[i].email);
					System.out.println("Fullname : " + x[i].fullName);
					System.out.println("Username : " + x[i].userName);
					System.out.println("Department : " + x[i].department.name);
					System.out.println("Position : "+x[i].position.id);
					System.out.println("Create Date : " + x[i].createDate);
					System.out.print("Group :  ");
					if(x[i].groups == null)
					{
						System.out.print("Account này không có group nào");
					}
					else
					{
						int j = 0;
						while(j < x[i].groups.length)
						{
							System.out.print(x[i].groups[j].name + " , ");
							j++;
						}
					}
					System.out.println("\n\n");
				}
				i++;
		}
	
	}

	public static void question16b()
	{
		int i = 1;
		while(i<=20)
		{
			if(i%2==0)
			{
				System.out.print(i + " ");
			}
			i++;
		}
	}

	public static void question17a(Account[] x)
	{
		int i = 0;
		do {
			
			if(x[i].id < 4)
			{
				int a = i+1;
				System.out.println("Account thứ " +a + " là : ");
				System.out.println("Id : " + x[i].id);
				System.out.println("Email : " + x[i].email);
				System.out.println("Fullname : " + x[i].fullName);
				System.out.println("Username : " + x[i].userName);
				System.out.println("Department : " + x[i].department.name);
				System.out.println("Position : "+x[i].position.id);
				System.out.println("Create Date : " + x[i].createDate);
				System.out.print("Group :  ");
				if(x[i].groups == null)
				{
					System.out.print("Account này không có group nào");
				}
				else
				{
					int j = 0;
					do{
						System.out.print(x[i].groups[j].name + " , ");
						j++;
					} while(j < x[i].groups.length);

				}
				System.out.println("\n\n");
			}
			i++;
			
		}while(i < x.length);
	}

	public static void question17b()
	{
		int i = 1;
		do {
			
			if(i%2==0)
				System.out.print(i + " ");
			i++;
		} while(i<=20);
	}

	public static void ex2_question1()
	{
		int a = 5;
		System.out.printf("%d" ,a);
	}

	public static void ex2_question2()
	{
		int a = 100000000;
		System.out.printf("%,d" , a);
	}
	
	public static void ex2_question3()
	{
		// khai báo kiểu float.
		float a = 5.67098f;
		System.out.printf("'%1.4f'%n",a);
	}
	
	public static void ex2_question4()
	{
		String ho , ten;
		ho  = "Nguyễn văn";
		ten = "A";
		System.out.println("Tên tôi là "+ ho + " " + ten + " và tôi đang độc thân");
	}
	
	public static void ex2_question5()
	{
		Date patern = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy  hh:mm:ss");
		String strdate = sdf.format(patern);
		System.out.println("Bây giờ là : " + strdate);
	}
	
	public static void ex2_question6(Account[] x)
	{
		
		System.out.print("Email");
		System.out.print("\t\tFullname");
		System.out.print("\tDepartment");
		for (Account point : x)
		{
			System.out.print("\n");
			System.out.printf(point.email);
			System.out.printf("%15s" ,point.fullName);
			System.out.printf("%15s" ,point.department.name);
		
		}
		
	}
	
	public static void ex3_question1(Exam a) {
		
		System.out.println("ID : " + a.id);
		System.out.println("Code : " + a.code);
		System.out.println("Title : " + a.title);
		System.out.println("Duration : " + a.duration);
		System.out.println("creator : "+a.creator.fullName);
		Locale locale  = new Locale("vi" , "VN");
		DateFormat dateformat = DateFormat.getDateInstance(DateFormat.DEFAULT , locale);
		String date = dateformat.format(a.createDate);
		System.out.print("Create Date :  " + date);
	}	
	
	public static void ex3_question2(Exam a)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println("Thời gian tạo đề thi : " + sdf.format(a.createDate));
		
	}

	public static void ex3_question3(Exam a)
	{
		
		Date date = a.createDate;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		System.out.println("Năm : " + calendar.get(calendar.YEAR));
	}

	public static void ex3_question4(Exam a)
	{
		Date date = a.createDate;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		System.out.print( calendar.get(calendar.MONTH)+1);
	}

	public static void ex3_question5(Exam a)
	{
		Date date = a.createDate;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int a1 = calendar.get(calendar.MONTH) + 1;
		System.out.print( "MM : "+ a1 +" DD : "+ calendar.DAY_OF_MONTH);
	}

	public static void ex6_question1() {
		for(int i = 1;i<10;i++)
		{
			if(i%2==0)
				System.out.print(i + " ");
		}
	}

	public static void ex6_question2(Account[] accounts)
	{
		int i = 1;
		for (Account point : accounts)
		{
			System.out.println("Account thứ " + i + " là : ");
			System.out.println("Account ID : " + point.id);
			System.out.println("Email : " + point.email);
			System.out.println("Fullname : " + point.fullName);
			System.out.println("UserName : " + point.userName);
			System.out.println("Create Date : " + point.createDate);
			System.out.println("Position  : " + point.position.name);
			System.out.println("Department : " + point.department.name);
			System.out.print("Group : ");
			if(point.groups == null)
			{
				System.out.print("Account chưa tham gia group nào !");
			}
			else
			{
				for(Group S_point : point.groups)
				{
					System.out.print(S_point.name + " , ");
				}
			}
			System.out.println("\n");
			i++;
		}
	}

	public static void ex6_question3() {
		for(int i=1;i<10;i++)
			System.out.print(i + " ");
	}
	
	public static void ex4_question1()
	{
		Random random = new Random();
		int x = random.nextInt();
		System.out.print(x);
	}
	
	public static void ex4_question2()
	{
		Random random = new Random();
		float x = random.nextInt();
		System.out.print(x);
	}

	public static void ex4_question3()
	{
		int[] a = {1,2,3,4};
		Random b = new Random();
		int c = b.nextInt();
		System.out.println("Chọn ngẫu nhiên được bạn " + c);
	}

	public static void ex4_question4()
	{
		Random a = new Random();
		int minDay = (int) LocalDate.of(1995,7,24).toEpochDay();
		int maxDay = (int) LocalDate.of(1995,12,20).toEpochDay();
		
		long randomInt = minDay + a.nextInt(maxDay - minDay);
		LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
		System.out.println(randomDay);
	}

	public static void ex4_question5()
	{
		System.out.print(LocalDate.now());
	}
	
	public static void ex5_question1()
	{
		Scanner scanner = new Scanner(System.in);
		for(int i=0;i<3;i++)
		{
			int a=i+1;
			int x;
			System.out.print("Nhập số thứ " +a+" = ");
			x = scanner.nextInt();
			System.out.println("input : "+x);
			
		}
		scanner.close();
		
	}

	public static void ex5_question2()
	{
		Scanner a = new Scanner(System.in);
		for(int i =0 ;i<2;i++)
		{
			System.out.print("Nhập số : ");
			float x =  a.nextFloat();
			System.out.println("input : "+x);
		}
		a.close();
	}

	public static void ex5_question3()
	{
		String firstName , lastName;
		Scanner a = new Scanner(System.in);
		System.out.print("Nhập họ  : ");
		firstName = a.next();
		System.out.print("Nhập tên  : ");
		lastName = a.next();
		System.out.println("Họ và tên :  " + firstName + " " + lastName);
		a.close();
	}

	public static void ex5_question4()
	{
		Scanner a = new Scanner(System.in);
		System.out.print("Nhập ngày sinh: ");
		int ns = a.nextInt();
		System.out.print("Nhập tháng sinh: ");
		int ts = a.nextInt();
		System.out.print("Nhập năm sinh: ");
		int nams = a.nextInt();
		System.out.print("BirthDay : " + ns + "/" + ts + "/" + nams);
		a.close();
	}
	
	public static void ex5_question5()
	{
		Position new_position = new Position();
		Scanner a = new Scanner(System.in);
		Account new_account = new Account();
		System.out.print("Nhập Gmail : ");
		new_account.email = a.next();
		System.out.print("Nhập UserName : ");
		new_account.userName = a.next();
		System.out.print("Nhập Fullname : ");
		new_account.fullName = a.next();
		System.out.print("Nhập position : ");
		new_position.id = a.nextByte();
		switch(new_position.id)
		{
			case 1:
				new_position.name = "Dev";
				break;
			case 2:
				new_position.name = "Test";
				break;
			case 3:
				new_position.name = "Scrum Master";
				break;
			case 4:
				new_position.name = "PM";
				break;
		}
		new_account.position = new_position;
		System.out.println("Email : " + new_account.email);
		System.out.println("Fullname : " + new_account.fullName);
		System.out.println("UserName : " + new_account.userName);
		System.out.println("UserName : " + new_account.position.id);
		System.out.println("Position  : " +new_account.position.name);
//		System.out.println("Department : " + departmentName);
		a.close();
		
	}
		
	public static void ex5_question6()
	{
		Department a = new Department();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Nhập tên : ");
		a.name = scanner.next();
		System.out.println("Department : " + a.name);
		scanner.close();
	}
	
	public static void ex5_question7()
	{
		Scanner scanner = new Scanner(System.in);
		
		while(true)
		{
			int x;
			System.out.print("input x : ");
			x = scanner.nextInt();
			if(x%2==0)
				System.out.println("X = " + x);
			else
			{
				System.out.println("Error !!! Only Even Number ");
				break;
			}
		}
		scanner.close();
	}

	public static void ex5_question8(){
		Scanner a = new Scanner(System.in);

		do {

			System.out.print("Nhập chương trình muốn thực hiện : ");
			int ct = a.nextInt();
			if(ct == 1 )
			{
				ex5_question5();
				break;
			}	
			else if(ct==2)
			{
				ex5_question6();
				break;
			}
			else {
				System.out.println("Nhập lại !");
				continue;	
			}
		}while(true);
		a.close();
	}
	
	public static void ex5_question9(Account[] accounts , Group[] groups)
	{
		
	}
}
