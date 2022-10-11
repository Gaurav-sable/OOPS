//Assignment 8
//File Handling of Student Database
//23339_Gaurav Sable
//Batch :- SE11(F11)

import java.io.*;
import java.util.*;
class Files {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	//To create File
	public void CreateFile() {
		try {
			File f1 = new File("StudentData.txt");
			if (f1.createNewFile()) {
				System.out.println("File " + f1.getName() + " created Successfully!!!");
			} else {
				System.out.println("File is already exist");
			}
			System.out.println("Path = " + f1.getPath());
		} catch (IOException e) {
			System.out.println("An Error");
			e.printStackTrace();
		}
	}
	
	//To add Records into file
	public void AddRec() {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("StudentData.txt", true)));
			String Stuname, Address, s;
			int Stu_Id, rollno, div;
			float Marks;
			boolean AddMore = false;

			do {
				System.out.println("\nEnter Student Name :- ");
				Stuname = br.readLine();
				System.out.println("\nEnter Student Address :- ");
				Address = br.readLine();
				System.out.println("\nEnter Student Id :- ");
				Stu_Id = Integer.parseInt(br.readLine());
				System.out.println("\nEnter Student Rollno :- ");
				rollno = Integer.parseInt(br.readLine());
				System.out.println("\nEnter Student Div :- ");
				div = Integer.parseInt(br.readLine());
				System.out.println("\nEnter Srudent Marks :- ");
				Marks = Float.parseFloat(br.readLine());
				pw.println(Stuname + "\t" + Address + "\t" + Stu_Id + "\t" + rollno + "\t" + div + "\t" + Marks);
				System.out.println("\nRecords added Successfully!!!!\n\nDo you want to add more Records ? (yes or no)");
				s = br.readLine();
				if (s.equalsIgnoreCase("yes")) {
					AddMore = true;
					System.out.println();
				} else {
					AddMore = false;
				}
			} while (AddMore);
			pw.close();
		} catch (IOException e) {
			System.out.println("An Error Occured!!");
			e.printStackTrace();
		}
	}
	
	//To display Records from file
	public void Display() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("StudentData.txt"));
			String name;
			int i = 0;
			while ((name = br.readLine()) != null) {
				System.out.println(name);
				System.out.println("  ");
				i++;
			}
			br.close();
			System.out.println("Total no. of Lines = " + i);
		} catch (IOException e) {
			System.out.println("\nErr! File not found.");
		}
	}
	
	//To Search Records from file
	public void SearchRec() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("StudentData.txt"));
			String name;
			int flag = 0;
			Scanner sc = new Scanner(System.in);
			System.out.println("\nHow would you like to search Record\n\t1.By name\n\t2.By Rollno\n\t3.By ID\n\t4.By Div\nEnter Choice : ");
			int ch = sc.nextInt();
			switch (ch) {
			case 1 :
				System.out.println("Enter name of Student to Search : ");
				String nm = sc.next();
				while ((name = br.readLine()) != null) {
					//	String[] line = name.split("   ");
					if (name.contains(nm)) {
						System.out.println("Record Found !!!! \n" + name);
						System.out.println("  ");
						flag = 1;
						break;
					}
				}
				break;
			case 2 :
				System.out.println("Enter Rollno of Student to Search : ");
				String sRoll = sc.next();
				while ((name = br.readLine()) != null) {
					//	String[] line = name.split("   ");
					if (name.contains(sRoll)) {
						System.out.println("Record Found !!!! \n" + name);
						System.out.println("  ");
						flag = 1;
						break;
					}
				}
				break;
			case 3 :
				System.out.println("Enter Id of Student to Search : ");
				String id = sc.next();
				while ((name = br.readLine()) != null) {
					//	String[] line = name.split("   ");
					if (name.contains(id)) {
						System.out.println("Record Found !!!! \n" + name);
						System.out.println("  ");
						flag = 1;
						break;
					}
				}
				break;
			case 4 :
				System.out.println("Enter Division of Student to Search : ");
				String sdiv = sc.next();
				while ((name = br.readLine()) != null) {
					if (name.contains(sdiv)) {
						System.out.println("Record Found !!!! \n" + name);
						System.out.println("  ");
						flag = 1;
						break;
					}
				}
				break;
			}
			if (flag == 0) {
				System.out.println("Record not Found !!!");
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Err : File not found !!!");
		}
	}
	
	//To delete Records from file
	public void DeleteRec() {
		try {
			BufferedReader br1 = new BufferedReader(new FileReader("StudentData.txt"));
			PrintWriter pw1 = new PrintWriter(new BufferedWriter(new FileWriter("new1.txt")));
			Scanner sc = new Scanner(System.in);
			String name;
			int flag = 0;
			System.out.print("Enter name of Student to Delete : ");
			String Deln = sc.next();
			while ((name = br1.readLine()) != null) {
				if (!name.contains(Deln)) {
					pw1.println(name);
					flag = 0;
				} else {
					System.out.println("Record Found .");
					flag = 1;
				}
			}
			br1.close();
			pw1.close();

			File Delf = new File("StudentData.txt");
			File oldf = new File("new1.txt");
			File Ref = new File("StudentData.txt");
			if (Delf.delete()) {
				System.out.println("Deleted Succesfully!!!");
			} else {
				System.out.println("Error");
			}
			if (oldf.renameTo(Ref)) {
				System.out.println("Renamed Successfully!!!");
			} else {
				System.out.println("Error");
			}
		} catch (IOException E) {
			System.out.println("File not Found " + E);
		}
	}
	
	//To update required Records
	public void UpdateRec() {
		try {
			BufferedReader br2 = new BufferedReader(new FileReader("StudentData.txt"));
			PrintWriter pw2 = new PrintWriter(new BufferedWriter(new FileWriter("new2.txt")));
			String name;
			int flag = 0;
			Scanner s = new Scanner(System.in);
			System.out.println("Enter Rollno of Student : ");
			int sRoll = s.nextInt();
			String key = Integer.toString(sRoll);
			while ((name = br2.readLine()) != null) {
				//String [] line = name.split("   ");
				if (!name.contains(key)) {
					pw2.println(name);
					flag = 0;
				} else {
					String [] line = name.split("\t");
					System.out.println("Record Found!!!\n\t Name = " + line[0] + "\n\tAddress = " + line[1] + "\n\tId = " + line[2] + "\n\tRollno = " + line[3] + "\n\tDivision = " + line[4] + "\n\tMarks = " + line[5]);
					System.out.println("\nWhat do you want to update\n\t1.name\n\t2.Rollno\n\t3. ID\n\t4.Div\n\t5.Address\n\t6.Marks\nEnter Choice : ");
					int ch = s.nextInt();
					switch (ch) {
					case 1 :
						System.out.println("\nEnter updated name : ");
						String upn = s.next();
						pw2.println(upn + "\t" + line[1] + "\t" + line[2] + "\t" + line[3] + "\t" + line[4] + "\t" + line[5]);
						break;
					case 2 :
						System.out.println("\nEnter updated Rollno : ");
						String upr = s.next();
						pw2.println(line[0] + "\t" + line[1] + "\t" + line[2] + "\t" + upr + "\t" + line[4] + "\t" + line[5]);
						break;
					case 3 :
						System.out.print("\nEnter updated Id : ");
						String upi = s.next();
						pw2.println(line[0] + "\t" + line[1] + "\t" + upi + "\t" + line[3] + "\t" + line[4] + "\t" + line[5]);
						break;
					case 4 :
						System.out.println("\nEnter updated division : ");
						String upd = s.next();
						pw2.println(line[0] + "\t" + line[1] + "\t" + line[2] + "\t" + line[3] + "\t" + upd + "\t" + line[5]);
						break;
					case 5 :
						System.out.println("\nEnter updated Address : ");
						String upad = s.next();
						pw2.println(line[0] + "\t" + upad + "\t" + line[2] + "\t" + line[3] + "\t" + line[4] + "\t" + line[5]);
						break;
					case 6 :
						System.out.println("\nEnter updated marks : ");
						String upm = s.next();
						pw2.println(line[0] + "\t" + line[1] + "\t" + line[2] + "\t" + line[3] + "\t" + line[4] + "\t" + upm);
						break;
					}
				}
			}
			br2.close();
			pw2.close();
			File Delf = new File("StudentData.txt");
			File Oldf = new File("new2.txt");
			File Ref = new File("StudentData.txt");
			if (Delf.delete()) {
				System.out.println("Updated Successfully");
			} else {
				System.out.println("Error");
			}
			if (Oldf.renameTo(Ref)) {
				System.out.println("Renamed Successfully");
			} else {
				System.out.println("Error in Renaming");
			}
		} catch (IOException E1) {
			System.out.println("File not Found " + E1);
		}
	}
	
	//To clear everything from the file
	public void clearAll() {
		try {
			PrintWriter pw3 = new PrintWriter(new BufferedWriter(new FileWriter("StudentData.txt")));
			pw3.close();
			System.out.println("\nAll Records Cleared Successfully");
		} catch (IOException E2) {
			System.out.println("File not Found " + E2);
		}
	}
}

//Start of main
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Files fobj = new Files();
		fobj.CreateFile();
		int ch;
		while (true) {
			System.out.println("Press\n1.To Add new Record\n2.To read File Data\n3.To search Record\n4.To Delete Record\n5.To update Records\n6.To clear all records\n0.Exit");
			ch = sc.nextInt();
			if (ch == 0) {
				break;
			}
			switch (ch) {
			case 1 :
				fobj.AddRec();
				break;
			case 2 :
				fobj.Display();
				break;
			case 3 :
				fobj.SearchRec();
				break;
			case 4 :
				fobj.DeleteRec();
				break;
			case 5 :
				fobj.UpdateRec();
				break;
			case 6 :
				fobj.clearAll();
				break;
			default :
				System.out.println("Invalid Choice !!!");
			}
		}
	}
}
