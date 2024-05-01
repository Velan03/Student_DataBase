package dto;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import dao.StudentDAO;

public class StudentDriver extends StudentDAO {

	static Scanner sc = new Scanner(System.in);

	static int id;
	static String name, email, password;
	static double marks;

	public static void main(String[] args) {
		
		StudentDAO s=new StudentDAO();
		
		boolean repeat=true;
		
		do {
			System.out.println("\n1.Add Student : ");
			System.out.println("2.Show All Student : ");
			System.out.println("3.Search by Student ID : ");
			System.out.println("4.Update Student : ");
			System.out.println("5.Delete Student by Id: ");
			System.out.println("6.Fetch By Email : ");
			
			System.out.print("\nEnter the input here : \n");
			int option=sc.nextInt();
			
			switch (option) {
			case 1:
				//StudentDAO s=new StudentDAO();
				//int id, String name, String email, String password, double marks
				s.saveStudent(new Student(103,"Santhos","san@gmail.com","555",25));
				s.saveStudent(new Student(104,"Sudhakar","sud@gmail.com","4561",24));
				System.out.println("Data Saved");
				
				System.out.print("Enter the student name : ");
				//String name=sc.nextLine();
				
				System.out.print("Enter the student email : ");
				//String name=sc.nextLine();
				
				System.out.print("Enter the student password : ");
				//String name=sc.nextLine();
				
				System.out.print("Enter the student mark : ");
				//double name=sc.nextDouble();
				
				//s.saveStudent(new Student(104,name,"san@gmail.com","4561",24));
				
				LinkedList<Student> lid1 =(LinkedList<Student>)s.getAllStudent();
				
				Student stc=(Student)lid1.getLast();
				int idadd=stc.getId();
				
				break;
			case 2:
				List<Student> list= s.getAllStudent();
				System.out.println(list);
				break;
			case 3:
				System.out.print("Enter the id here : ");
				int id=sc.nextInt();
				
				Student st=new Student(id,name,email,password,marks);
				//s.saveStudent(st);
				s.fetchById(id);
				break;
			case 4:
				
				Student st1=fetchMain();
				//System.out.println(st1);
				
				System.out.println("which data need to update : ");
				System.out.println("1.name\n2.email\n3.password\n4.marks");
				int option1=sc.nextInt();
				
				switch (option1) {
				case 1:
					
					Student st2=new Student();
					
					sc.nextLine();
					System.out.print("Enter the new name here : ");
					String name=sc.nextLine();
					
					st2.setId(st1.getId());
					st2.setName(name);
					st2.setEmail(st1.getEmail());
					st2.setPassword(st1.getPassword());
					st2.setMarks(st1.getMarks());
					
					s.updateStudent(st2);
					
					break;
				case 2:
					
					sc.nextLine();
					System.out.print("Enter the new email here : ");
					String email=sc.nextLine();
					
					Student st3=new Student();
					
					st3.setId(st1.getId());
					st3.setName(st1.getName());
					st3.setEmail(email);
					st3.setPassword(st1.getPassword());
					st3.setMarks(st1.getMarks());
					
					s.updateStudent(st3);
					
					break;
				case 3:
					
					sc.nextLine();
					System.out.print("Enter the new password here : ");
					String password=sc.nextLine();
					
					Student st4=new Student();
					
					st4.setId(st1.getId());
					st4.setName(st1.getName());
					st4.setEmail(st1.getEmail());
					st4.setPassword(password);
					st4.setMarks(st1.getMarks());
					
					s.updateStudent(st4);
					
					break;
				case 4:
					
					System.out.print("Enter the marks here : ");
					double marks=sc.nextDouble();
					
					Student st5=new Student();
					
					st5.setId(st1.getId());
					st5.setName(st1.getName());
					st5.setEmail(st1.getEmail());
					st5.setPassword(st1.getPassword());
					st5.setMarks(marks);
					
					s.updateStudent(st5);
					
					break;

				default:
					break;
				}
				
				//Student st1=new Student(id1,name,email,password,marks);
				//s.saveStudent(st1);
				
				break;
			case 5:
				
				System.out.print("Enter the Student id to update : ");
				int id3=sc.nextInt();
				
				Student st2=new Student(id3,name,email,password,marks);
				//s.saveStudent(st);
				
				s.deleteById(id3);
				break;
				
			case 6:
				
				System.out.print("Enter the Student eamil to updfetchate : ");
				int femail=sc.nextInt();
				
				break;
			default:
				System.out.println("default block is running");
				break;
			}
			
		} while (repeat);
		
		
		
	}

	public static Student fetchMain() {

		StudentDAO s = new StudentDAO();

		System.out.print("Enter the student id here to fetch: ");
		int id = sc.nextInt();

		Student st = new Student(id, name, email, password, marks);

		return s.fetchById(id);
	}

}
