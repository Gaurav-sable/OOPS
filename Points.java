import java.util.Scanner;
import java.lang.Math;
class Point {
	private int x, y;
	public int getx() {
		return x;
	}
	public void setx(int x) {
		this.x = x;
	}
	public int gety() {
		return y;
	}
	public void sety(int y) {
		this.y = y;
	}
}

	public class TwoPoints {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			Point p1 = new Point();
			Point p2 = new Point();
			int x1, y1, x2, y2;
			System.out.println("Enter values of x and y co-ordinates of Point p1:  ");
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			System.out.println("Enter values of x and y co-ordinates of Point p2:  ");
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			p1.setx(x1);
			p1.sety(y1);
			p2.setx(x2);
			p2.sety(y2);
			System.out.println("Co-ordinates of point p1 : (x1,y1) = " + p1.getx() +" , "+ p1.gety());
			System.out.println("Co-ordinates of point p2 : (x,y) =  " + p2.getx()+" , " + p2.gety());
			int dist = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
			System.out.println("Distance between p1 and p2 = "+Math.sqrt(dist));
      }
	}
	
	
