package pack1;
import java.time.LocalDate;
import java.util.*;
class check {
	Scanner sc = new Scanner(System.in);
	//int date, month, year;
	String s;
	public String SetDate() {
		boolean flag = false;
		while (flag == false) {
			try {
				/*date = sc.nextInt();
				month = sc.nextInt();
				year = sc.nextInt();*/
				s = sc.nextLine();
				LocalDate date1 = LocalDate.parse(s);
				//System.out.println(s);
				flag = true;
			} catch (Exception e) {
				System.out.println("Error = " + e);
				flag = false;
			}
		}
		return s;
	}
}

public class Datecheck {
	public static void main(String args[]) {
		check t = new check();
		String st;
		st = t.SetDate();
		System.out.println(st);
		
		/*LocalDate date2 = LocalDate.parse("2007-12-03");
		System.out.println(date2);
		LocalDate date3 = LocalDate.now();
		System.out.println(date3);*/
	}
}