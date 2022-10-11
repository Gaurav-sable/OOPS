//23339_Gaurav Sable
//Assignment 3
//Inheritance


import java.util.regex.*;
import java.util.Scanner;
class Employee {

	String Emp_name;
	String Emp_Id;
	String Address;
	String Email_id;
	String Mo_no;
	double BP, DA, HRA, PF, SCF;
	boolean flag = true;
	public void GetDetail() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter name of Employee : ");
		Emp_name = sc.nextLine();
		System.out.print("Enter Id of Employee(Name_Id) : ");
		Emp_Id = sc.nextLine();
		System.out.print("Enter Address of Employee : ");
		Address = sc.nextLine();
		System.out.print("Enter Email Id of Employee : ");
		while (flag == true) {
			flag = true;
			Email_id = sc.nextLine();
			if (Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)[a-z]+(?:\\.[a-zA-Z0-9-]+)*$", Email_id)) {
				flag = false;
			} else {
				System.out.print("\nEnter email correctly : ");
				flag = true;
			}
		}
		System.out.print("\nEnter Contact no. of Employee : ");
		while (flag == true) {
			flag = true;
			Mo_no = sc.nextLine();
			Mo_no = sc.nextLine();
			if (Pattern.matches("[6789][0-9]{9}", Mo_no)) {
				flag = false;
			} else {
				System.out.print("Enter Correct mo no.");
				flag = true;
			}
		}
	}
};
class Programmer extends Employee {
	public void getDetail() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Basic pay of Employee : ");
		BP = sc.nextFloat();
		DA = 0.97 * BP;
		HRA = 0.1 * BP;
		PF = 0.12 * BP;
		SCF = 0.01 * BP;
		System.out.println("________________________________________________________");
	}
	void Display() {
		System.out.print("\n************Personal Detail*************\nName of Employee : " + Emp_name + "\nEmployee_Id : " + Emp_Id + "\nAddress of Employee : " + Address + "\nEmail Id of Employee : " +
						 Email_id + "\nContact no. of Employee : " +
						 Mo_no);
		System.out.println("\n***********Salary Detail**********\nBasic pay : " + BP + "\nDA = " + DA + "\nHRA = " + HRA + "\nPF = " + PF + "\nSCF = " + SCF + "\n**Gross Salary = " +
						   (BP + DA + HRA) + "\n***Net Salary : " + (BP + DA + HRA - PF - SCF));
		System.out.println("________________________________________________________");
	}
};
class TeamLead extends Programmer {



};
class AssistantProjectManager extends Programmer {

};
class ProjectManager extends Programmer {

};

public class Company {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Programmer p[] = new Programmer[10];
		TeamLead T[] = new TeamLead[20];
		AssistantProjectManager A[] = new AssistantProjectManager[10];
		ProjectManager P[] = new ProjectManager[10];
		int n, i, ch;

		while (true) {

			System.out.println("Press\n1.To Enter and Display the Detail of Programmer Employee\n2.To Enter and Display the Detail of TeamLead Employee\n3.To Enter and Display the Detail of Assistant Project Manager\n4.To Enter and Display the Detail of Project Managers\n0.Exit");
			System.out.print("Choose your Operation :- ");
			ch = s.nextInt();
			if (ch == 0) {
				break;
			}
			switch (ch) {
			case 1 :
				System.out.println("Enter the no. of programmers : ");
				n = s.nextInt();
				for (i = 0; i < n; i++) {
					p[i] = new Programmer();
					System.out.println("Enter the Detail of Programmer " + (i + 1) + " : ");
					p[i].GetDetail();
					p[i].getDetail();
				}
				for (i = 0; i < n; i++) {
					System.out.println("Displaying the Detail of programmer " + (i + 1) + " : ");
					p[i].Display();

				}
				break;
			case 2 :
				System.out.print("Enter the no. of Team Leaders : ");
				n = s.nextInt();
				for (i = 0; i < n; i++) {
					T[i] = new TeamLead();
					System.out.println("Enter the Detail of Team Leader " + (i + 1) + " : ");
					T[i].GetDetail();
					T[i].getDetail();
				}
				for (i = 0; i < n; i++) {
					System.out.println("Displaying the Detail of Team Leader " + (i + 1) + " : ");
					T[i].Display();
				}
				break;
			case 3 :
				System.out.print("Enter the no. of Assistent Project Managers : ");
				n = s.nextInt();
				for (i = 0; i < n; i++) {
					A[i] = new AssistantProjectManager();
					System.out.println("Enter the Detail of Manager " + (i + 1) + " : ");
					A[i].GetDetail();
					A[i].getDetail();
				}
				for (i = 0; i < n; i++) {
					System.out.println("Displaying the Detail of Manager " + (i + 1) + " : ");
					A[i].Display();
				}
				break;
			case 4 :
				System.out.print("Enter the no. of Project Managers : ");
				n = s.nextInt();
				for (i = 0; i < n; i++) {
					P[i] = new ProjectManager();
					System.out.println("Enter the Detail of Project Manager " + (i + 1) + " : ");
					P[i].GetDetail();
					P[i].getDetail();
				}
				for (i = 0; i < n; i++) {
					System.out.println("Displaying the Detail of Project Manager " + (i + 1) + " : ");
					P[i].Display();
				}
				break;
			}
		}
	}
}