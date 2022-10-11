import java.util.*;
import java.util.ArrayList;
class Numbers<T> {
	private int count;
	Scanner s = new Scanner(System.in);
	Numbers()
	{
		count = 0;
	}
	public int getcount()
	{
		return count;
	}
	public void Setcount(int count)
	{
		this.count = count;
	}
	public void Palindrome(int x) {
		String s = Integer.toString(x);
		StringBuilder s1 = new StringBuilder(s);
		if (s.equals(s1.reverse().toString())) {
			System.out.println(x);
			Setcount(getcount()+1);
		}
	}
	public void Even_Odd(int x)
	{
		if(x%2 == 0)
		{
			System.out.println("Even = "+x);
			Setcount(getcount()+1);
		}
		else{
			System.out.println("Odd = "+x);
		}
	}
	public void Prime(int x)
	{
		boolean flag = false;
		for(int i = 2;i<x/2;i++)
		{
			if(x%i == 0)
			{
				flag = true;
				break;
			}
		}
		if(!flag)
		{
			System.out.println(x);
			Setcount(getcount()+1);
		}
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Numbers<Integer> n = new Numbers<Integer>();
		ArrayList<Integer> Numbers = new ArrayList<Integer>();
		int ch, no, x1;
		System.out.println("How many numbers u want to Insert ?");
		no = sc.nextInt();
		for (int i = 0; i < no; i++) {
			x1 = sc.nextInt();
			Numbers.add(x1);
		}
		while (true) {
			System.out.println("\nPress\n1.To print palindromes from list\n2.To print even and odd no.s\n3.To print prime no.s\n0.Exit");
			ch = sc.nextInt();
			if (ch == 0) {
				break;
			}
			switch (ch) {
			case 1 :
				for (int i = 0; i < Numbers.size(); i++)
				{
					n.Palindrome(Numbers.get(i));
				}
				System.out.println("Total numbers of Palindromes = " + n.getcount());
				break;
				case 2 :
				n.Setcount(0);
				for(int i = 0; i<Numbers.size();i++)
				{
					n.Even_Odd(Numbers.get(i));
				}
				System.out.println("Total Even No.s = "+n.getcount());
				System.out.println("Total Odd no.s = "+(Numbers.size() - n.getcount()));
				break;
				case 3 :
				n.Setcount(0);
				for(int i = 0; i<Numbers.size();i++)
				{
					n.Prime(Numbers.get(i));
				}
				System.out.println("Total prime no.s = "+n.getcount());
				break;
			}
		}
	}
}