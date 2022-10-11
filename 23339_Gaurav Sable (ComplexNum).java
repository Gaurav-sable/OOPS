import java.util.Scanner;
class Complex
{
	float real,imag;
	public Complex(){
		real=imag=0;
	}
	
	
	
	public Complex(float r,float i){
		this.real=r;
		this.imag=i;
	}
	
	
	
	public Complex add(Complex c){
		Complex temp1 = new Complex();
		temp1.real = this.real + c.real;
		temp1.imag = this.imag + c.imag;
		return temp1;
		
	}
	
	
	
	public Complex substract(Complex c){
		Complex temp2 = new Complex();
		temp2.real = this.real - c.real;
		temp2.imag = this.imag - c.imag;
		return temp2;
	}
	
	
	
	public Complex multiply(Complex c){
		Complex temp3 = new Complex();
		temp3.real = (this.real * c.real)-(this.imag*c.imag);
		temp3.imag = (this.real * c.imag)+(this.imag*c.real);
		return temp3;
	}
	
	
	
	public Complex divide(Complex c){
		Complex temp4 = new Complex();
		temp4.real =( (this.real*c.real)+(this.imag*c.imag))/((c.real*c.real)+(c.imag*c.imag));
		temp4.imag = ((this.imag*c.real)-(this.real*c.imag))/((c.real*c.real)+(c.imag*c.imag));
		return temp4;
	}
	
	
	
	public void display(Complex c){
		System.out.println("("+c.real+")" + "+" +"("+ c.imag+")" +"i");
	}
}




public class ComplexNum{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		float real1,real2,imag1,imag2;
		System.out.println("Enter Real and Imaginary values for 1st Complex Number : \n");
		real1 = sc.nextFloat();
		imag1 = sc.nextFloat();
		System.out.println("1st Complex Num is : "+ "("+real1 +")"+" + "+ "("+imag1 +")"+"i");
		System.out.println("Enter Real and Imaginary values for 2nd Cimplex Num : \n");
		real2 = sc.nextFloat();
		imag2 = sc.nextFloat();
		System.out.println("2nd Complex Num is : "+"("+real2+")"+" + "+"("+imag2+")"+"i");
		System.out.println("-----------------××××××××××××××--------------------\n");
		Complex C1 = new Complex(real1 ,imag1);
		Complex C2 = new Complex(real2,imag2);
		Complex C3 = new Complex();
		
		
		while(true){
			System.out.println("Press \n0.Exit\n1.Add\n2.Substract\n3.Multiply\n4.Divide");
			System.out.println("Choose your Operation : ");
			int n;
			n = sc.nextInt();
			if(n==0){
				break;
			}
			switch(n){
				case 1 :
				C3 = C1.add(C2);
				System.out.println("Result for Addition : ");
				C3.display(C3);
				System.out.println("-----------------××××××××××××××--------------------\n");
				break;
				
				case 2 :
				C3 = C1.substract(C2);
				System.out.println("Result for Substraction : ");
				C3.display(C3);
				System.out.println("-----------------××××××××××××××--------------------\n");
				break;
				
				case 3 : 
				C3 = C1.multiply(C2);
				System.out.println("Result for Multiplication : ");
				C3.display(C3);
				System.out.println("-----------------××××××××××××××--------------------\n");
				break;
				
				case 4 :
				C3 = C1.divide(C2);
				System.out.println("Result for Division : ");
				C3.display(C3);
				System.out.println("-----------------××××××××××××××--------------------\n");
				break;
				
				default :
				System.out.println("Choose from above.");
			}
		}
	}
}


/*
Program Output :- 
1st Complex Num = 2+5i
2nd Complex Num = 4+3i

Addition Result = 6+8i
Substraction Result = (-2)+2i
Multiplication Result = (-7)+26i
Division Result = (0.92)+(0.56)i
*/
			


