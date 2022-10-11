//Generics Implementation
//23339_Gaurav Sable
//Batch :- SE11(F11)

import java.util.*;
import java.util.ArrayList;

//Declaring Generic Class Numbers
class Numbers<T> {
	ArrayList<T> A;      //Using Arraylist to store data
	private int count, size;
	Scanner s = new Scanner(System.in);
	
	//Constructor for Generic class
	Numbers(int size) {
		this.A = new ArrayList<T>(size);
		this.size = size;
		count = 0;
	}
	public int getcount() {
		return count;
	}
	public void Setcount(int count) {
		this.count = count;
	}
	
	//Fumction to Read Data
	public void Read(T x1) {
		A.add(x1);
	}
	
	//Function to get Data from Arraylist
	public T getarr(int x) {
		return A.get(x);
	}
	
	//Function to find out palindromes 
	public void Palindrome(String s) {
		StringBuilder s1 = new StringBuilder(s);
		if (s.equals(s1.reverse().toString())) {
			System.out.println(s);
			Setcount(getcount() + 1);
		}
	}
	
	//Function to find out Even odd nos
	public void Even_Odd() {
		T x;
		for (int i = 0; i < A.size(); i++) {
			x = A.get(i);
			if ((int)x % 2 == 0) {
				System.out.println("Even = " + x);
				Setcount(getcount() + 1);
			} else {
				System.out.println("Odd = " + x);
			}
		}
	}
	
	//Function to find out Prime nos.
	public void Prime() {
		T x;
		boolean flag = false;
		for (int i = 0; i < A.size(); i++) {
			x = A.get(i);
			for (i = 2; i < (int)x / 2; i++) {
				if ((int)x % i == 0) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				System.out.println(x);
				Setcount(getcount() + 1);
			}
		}
	}
}

//Start of main
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sw, ch, no;
		while (true) {
			System.out.println("Press\n1.To perform operations on Integers\n2.To perform Operations on Strings\n0.To terminate.");
			sw = sc.nextInt();
			if (sw == 0) {
				break;
			}
			switch (sw) {
				
				//Case 1 to perform operations on Integers
			case 1 :
				int x1;
				System.out.println("How many numbers u want to Insert ?");
				no = sc.nextInt();
				Numbers<Integer> n = new Numbers<Integer>(no);
				for (int i = 0; i < no; i++) {
					System.out.println("Enter data  " +(i+1)+" :- ");
					x1 = sc.nextInt();
					n.Read(x1);
				}
				while (true) {
					System.out.println("\nPress\n1.To print palindromes from list\n2.To print even and odd no.s\n3.To print prime no.s\n0.Exit");
					ch = sc.nextInt();
					if (ch == 0) {
						break;
					}
					switch (ch) {
					case 1 :
						int x;
						System.out.println("Palindromes from given list are :- ");
						for (int i = 0; i < no; i++) {
							x = n.getarr(i);
							String s = Integer.toString(x);
							n.Palindrome(s);
						}
						System.out.println("Total numbers of Palindromes = " + n.getcount());
						break;
					case 2 :
						n.Setcount(0);
						n.Even_Odd();
						System.out.println("Total Even No.s = " + n.getcount());
						System.out.println("Total Odd no.s = " + (no - n.getcount()));
						break;
					case 3 :
						n.Setcount(0);
						System.out.println("Prime nos are :- ");
						n.Prime();
						System.out.println("Total prime no.s = " + n.getcount());
						break;
						default :
						System.out.println("Invalid Choice.......");
					}
				}
				break;
				
				//Case 2 to perform operations on Strings
				case 2 :
				String x2;
				System.out.println("Enter no. of Expressions :- ");
				no = sc.nextInt();
				Numbers<String> s = new Numbers<String>(no);
				for(int i = 0;i<no;i++)
				{
					System.out.println("Enter Expression "+(i+1)+" :- ");
					x2 = sc.next();
					s.Read(x2);
				}
				while(true)
				{
					System.out.println("Press\n1.To print palindromes\n0.Exit");
					ch = sc.nextInt();
					if(ch == 0)
					{
						break;
					}
					switch(ch)
					{
						case 1 :
						String x;
						s.Setcount(0);
						System.out.println("Palindrome Expressions are :- ");
						for(int i = 0; i<no; i++)
						{
							x = s.getarr(i);
							s.Palindrome(x);
						}
						System.out.println("Total no. of Palindromes = "+s.getcount());
						break;
						default :
						System.out.println("Invalid Choice......");
					}
				}
				break;
				default :
				System.out.println("Invalid Choice.......");
			}
		}
	}
}