
import java.util.Arrays;
import java.util.Scanner;
class Books {

	String Bookname;
	String Publ;
	float cost;
	String Author[];

	void getDetail() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter name of Book  : ");
		Bookname = sc.nextLine();

		System.out.println("Enter name of publication : ");
		Publ = sc.nextLine();
		System.out.println("Enter Cost of Book : ");
		cost = sc.nextFloat();
		int k;
		System.out.print("Enter no. of Authors : ");
		k = sc.nextInt();
		Author = new String[k + 1];
		for (int j = 1; j < k; j++) {
			System.out.println("Enter name of author " + j + " : ");
			Author[j] = sc.nextLine();
			Author[j] = sc.nextLine();
		}
	}
	void Display() {
		System.out.println("Name of Book : " + Bookname + "\nName of Publication : " + Publ);
		System.out.println("Names of " + (Author.length - 1) + " Authors of Book " + Bookname + " are : ");
		for (int j = 1; j < Author.length; j++) {
			System.out.println(Author[j]);
		}
		System.out.println("Cost of Book " + Bookname + " = " + cost);
		System.out.println("---------------------××××××××××××-------------------");
	}

};
public class MyBooks {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter no. of Books : ");
		int n;
		n = s.nextInt();
		Books[] b = new Books[n];
		for (int i = 0; i < n; i++) {
			b[i] = new Books();
			b[i].getDetail();

		}
		for (int i = 0; i < n; i++) {
			System.out.println("Details of Book " + (i + 1) + " is : ");

			b[i].Display();
		}

	}
}

