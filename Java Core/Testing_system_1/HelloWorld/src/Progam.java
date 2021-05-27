import java.util.Date;

public class Progam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Department department1 = new Department();
		department1.id = 1;
		department1.name =  "Sale";
		
		
		Position position1 = new Position();
		position1.id = 1;
		position1.name = "Phòng 1";
		
		
		Account account1 = new Account();
		account1.id = 1;
		account1.email = "abc@gmail.com";
		account1.userName = "abc";
		account1.fullName = "Lê Văn C";
		account1.position = position1;
		account1.department = department1;
		account1.createDate =  new Date("2020/6/12");
		
		
		
		System.out.println("Thông tin account 1  : ");
		System.out.println("ID  : " + account1.id);
		System.out.println("Name  : " + account1.fullName);
		System.out.println("Email  : " + account1.email);
		System.out.println("Username  : " + account1.userName);
		System.out.println("Position Name  : " + account1.position.name);
		System.out.println("department Name : " + account1.department.name);
		
	}

}
