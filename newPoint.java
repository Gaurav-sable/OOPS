import java.util.Scanner;
import java.lang.Math;
class Point {
	private double x, y, dist;
	public Point() {
		x = y = 0;
		dist = 0;
	}

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double Dist(Point p) {
		double dist = Math.sqrt(((this.x - p.x) * (this.x - p.x)) + ((this.y - p.y) * (this.y - p.y)));
		return dist;
	}
	
	public void Display(Point p){
		System.out.println("Co-ordinates of point 1 = ("+p.x+" , "+p.y+")");
	}
}


public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//Point p1 = new Point(x1, y1);
	//	Point p2 = new Point(x2, y2);
		Point p3 = new Point();
		int n;
		while (true) {
			System.out.println("Press\n\t1.To continue Calculation\n\t0.To Exit");
			n = sc.nextInt();
			if (n == 0) {
				break;
			} else {
				double x1, y1, x2, y2, len;
				System.out.println("Enter values for x and y co-ordinates of 1 st point :- ");
				x1 = sc.nextDouble();
				y1 = sc.nextDouble();
				Point p1 = new Point(x1, y1);
				p3.Display(p1);
				//System.out.println("Co-ordinates of point 1 = (" + x1 + " , " + y1 + ")");
				System.out.println("Enter values for x and y co-ordinates of 2nd point :- ");
				x2 = sc.nextDouble();
				y2 = sc.nextDouble();
				Point p2 = new Point(x2, y2);
				p3.Display(p2);
				//System.out.println("Co-ordinates of point 2 = (" + x2 + " , " + y2 + ")");

				len = p1.Dist(p2);
				System.out.println("Distance = " + len);
			}
		}
	}
}