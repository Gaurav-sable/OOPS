import java.util.Scanner;
class CoursePortal{
		String Name;
		String Email;
		String College;
		String Contact;
		String Cname;
		String Tname;
		int ToC;
		float FeeoC;
		int Capacity;
		int EnrolledS;
		int Type;
		
		void Registration(){
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter 0-->Student  or 1 -->Teacher : ");
			Type = sc.nextInt();
			System.out.print("Enter your Name : ");
			Name = sc.nextLine();
	        
		
			System.out.print("Enter your Email : ");
			Email = sc.nextLine();
			System.out.print("Enter your College Name : ");
			College = sc.nextLine();
			System.out.print("Enter your Contact No. : ");
			Contact = sc.nextLine();
		}
		void Display(){
			System.out.println("Your Registration is Done with Following Details : \nName : "+Name+"\nEmail : "+Email+"\nCollegeName : "+College+"\nContact : "+Contact);
		}
}
public class Courses{
		public static void main(String[] args){
			CoursePortal p = new CoursePortal();
			p.Registration();
			p.Display();
		}
}
		
			
		
		
		