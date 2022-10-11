//Dynamic Binding Assignment 4
//23339_Gaurav Sable

import java.util.*;
abstract class Shape {
	private double Dim1, Dim2;

	double getDim1() {
		return Dim1;
	}
	void SetDim1(double Dim1) {
		this.Dim1 = Dim1;
	}
	double getDim2() {
		return Dim2;
	}
	void SetDim2(double Dim2) {
		this.Dim2 = Dim2;
	}
	
	abstract void Compute_Area();
	
	void Read() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Dimension 1(in m) : ");
		Dim1 = sc.nextDouble();
		System.out.println("Enter Dimension 2(in m) : ");
		Dim2 = sc.nextDouble();
	}
}


class Triangle extends Shape {
	double Area;
	Triangle(){};
	Triangle(double Base, double Height)
	{
		SetDim1(Base);
		SetDim2(Height);
	}
	void Compute_Area() {
		Area = getDim1() * getDim2();
		System.out.println("Area of triangle : "+Area+" sq.m\n"+"=".repeat(56));
	}
}


class Rectangle extends Shape {
	double Area;
	void Compute_Area() {
		Read();
		Area = getDim1() * getDim2();
		System.out.println("Area of triangle : "+Area+"sq.m\n"+"=".repeat(56));
	}
}


public class Main {
	public static void main(String[] args) {
		int n;
		Scanner s = new Scanner(System.in);
		Shape S;
		while (true) {
			System.out.println("\n\t MENU\n\t\t1.Triangle\n\t\t2.Rectangle\n\t\t0.Exit\n" + "=".repeat(56) + "\nChoice : ");
			n = s.nextInt();
			if (n == 0) {
				break;
			}
			switch (n) {
			case 1 :
			double a, b;
			System.out.println("Enter Base of Triangle(in m) : ");
			a = s.nextDouble();
			System.out.println("Enter Height of Triangle(in m) : ");
			b = s.nextDouble();
				S = new Triangle(a,b);
				S.Compute_Area();
				break;
			case 2 :
				S = new Rectangle();
				S.Compute_Area();
				break;
			default :
				System.out.println("Invalid Choice.");
			}
		}
	}
}



/*OutPut of Program

         MENU
                1.Triangle
                2.Rectangle
                0.Exit
========================================================Choice :
1
Enter Base of Triangle(in m) :
4.5
Enter Height of Triangle(in m) :
8.2
Area of triangle : 36.9 sq.m
========================================================
         MENU
                1.Triangle
                2.Rectangle
                0.Exit
========================================================Choice :
2
Enter Dimension 1(in m) :
23.4
Enter Dimension 2(in m) :
54.1
Area of triangle : 1265.94sq.m
========================================================
         MENU
                1.Triangle
                2.Rectangle
                0.Exit
========================================================Choice :
0

[Program finished]
*/