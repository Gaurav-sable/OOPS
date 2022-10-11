//23339_Gaurav Sable
//Exception Handling

import java.util.*;
public class TestExc {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(System.in);
		float [] arr = new float[2];
		int ch;
		while(true)
		{
			System.out.println("Press\n1.To divide\n0.To Terminate\nEnter Choice :- ");
			sc.next();
			System.out.println("Enter Choice :- ");
			ch = sc.nextInt();
			if(ch == 0)
			{
				break;
			}
			else if(ch == 1)
			{
			System.out.println("\n"+"=".repeat(56)+"\nLet's Start the Division of two no.s\nFor Division.. Take care of :-\n\t1) Enter Integers only.\n\t2) Array is of size 2 only so index can't be greater than this.\n\t3) Denominator can't be zero.\n\nIf any of above conditions become false then the program will automatically terminate with an Error\n"+"=".repeat(56)+"\n\n");
				System.out.println("Enter Num1 and Num2 : ");
				try {
					for (int i = 0; i < 2; i++) {
						arr[i] = sc.nextFloat();
					}
					System.out.println("\n"+"_".repeat(20)+"\nYou have Entered : ");
					for (int i = 0; i < 2; i++) {
						System.out.println("Num" + (i + 1) + " = " + arr[i]);
					}
					System.out.println("\n"+"•".repeat(56));
					try {
						int i, j;
						System.out.println("Enter Numerator to be Num(1 or 2) = ");
						i = sc.nextInt();
						System.out.println("Enter Denominator to be Num(1 or 2) = ");
						j = sc.nextInt();
						try {
							float Division;
							Division = arr[i - 1] / arr[j - 1];
							System.out.println("Answer of Division = " + Division);
						} catch (Exception e2) {
							System.out.println("Err! can't be Divided by zero \n" + e2);
						}
					} catch (Exception e1) {
						System.out.println("Index cannot be greater than 2 \n" + e1);
					}
				} catch (Exception e) {
					System.out.println("Numbers you have Entered are not Integers!!!\nPlease Enter Correctly........\n" + e);
				}
			}
		}
	}
}