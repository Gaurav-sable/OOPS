import java.util.regex.*;
import java.util.Scanner;
public class Mo_No {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n;
		System.out.println("Enter your mobile no. : ");
		n = sc.nextLine();
		if(Pattern.matches("[789][0-9]{9}",n)){
			System.out.println("Your Mo no. is : " +n);
		}
		else{
			System.out.println("Enter Correct mo no.");}
	}
}