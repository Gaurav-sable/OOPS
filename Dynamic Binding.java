import java.util.Scanner;
import java.lang.Math;
abstract class Shape{
	double Length;
	double Breadth;
	void Compute_Area();
	Scanner s = new Scanner(System.in);
}
class Rectangle extends Shape{
	double x,y;
	Rectangle()
	{
		x = y = 0;
	}
	Rectangle(double x,double y)
	{
		this.x = x;
		this.y = y;
	}
	double length(Rectangle R)
	{
		Length = Math.sqrt((this.x-R.x)*(this.x-R.x)+(this.y-R.y)*(this.y-R.y));
		return Length;
	}
	double breadth(Rectangle R)
	{
		Breadth = Math.sqrt((this.x-R.x)*(this.x-R.x)+(this.y-R.y)*(this.y-R.y));
		return Breadth;
	}
	void Compute_Area(){
		double x1,x2,x3,y1,y2,y3;
		System.out.println("Enter co-ordinates of 1st vertex : ");
		x1 = s.nextInt();
		y1 = s.nextInt();
		System.out.println("Enter co-ordinates of 2nd vertex : ");
		x2 = s.nextInt();
		y2 = s.nextInt();
		System.out.println("Enter co-ordinates of 3rd vertex : ");
		x3 = s.nextInt();
		y3 = s.nextInt();
		Rectangle R1 = new Rectangle(x1,y1);
		Rectangle R2 = new Rectangle(x2,y2);
		Rectangle R3 = new Rectangle(x3,y3);
		double l = R1.length(R2);
		double b = R1.breadth(R3);
		System.out.println("Length of Rectangle = "+l);
		System.out.println("Breadth of Rectangle = "+b);
		System.out.println("Area of Rectangle = "+(l*b));
	}
}
public class Main {
	public static void main(String[] args) {
		Shape s;
		s = new Rectangle();
		s.Compute_Area();
	}
}