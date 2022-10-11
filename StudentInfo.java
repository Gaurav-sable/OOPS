import java.util.Scanner;
class Student
{
	static int rollno=23300;
	String name;
	float marks;
	int std;
	
	Student(){
	
		
		
	}
	void EnterDetails(){
		rollno++;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your Name : ");
		name = sc.nextLine();
		System.out.print("Enter your Marks : ");
		marks = sc.nextFloat();
		System.out.print("Enter your class : ");
		std = sc.nextInt();
		System.out.println("______________________");
	}
	void Display(){
		System.out.println("Name = "+name+" \nRollno = "+rollno+" \nMarks = "+marks+" \nClass = "+std);
		System.out.println("--------------------×××××××××××-------------------");
	}
};
public class StudentInfo{
	public static void main(String[] args){
		
		Student p = new Student();
		while(true){
		p.EnterDetails();
		p.Display();
		
		}
	}
}

		
