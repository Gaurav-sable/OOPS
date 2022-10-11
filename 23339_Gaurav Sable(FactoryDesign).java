//FactoryDesignPattern
//23339_Gaurav Sable
//Batch :- SE11(F11)

import java.util.*;

//Defining enum of various cars
enum CarType {
	SMALL, SEDAN, LUXURY;
}

//Defing abstract car class 
abstract class Car {
	private CarType model = null;
	public Car(CarType model) {
		this.model = model;
		arrangeParts();
	}
	public CarType getmodel() {
		return model;
	}
	public void Setmodel(CarType model) {
		this.model = model;
	}
	private void arrangeParts() {
		System.out.println("Car is Processing with Part Arrangements!!!");
	}
	
	//Defining abstract Functions
	public abstract void Construct();
	public abstract void accessories();
}

//Inheriting Luxury class from car
class Luxury extends Car {
	Luxury() {
		super(CarType.LUXURY);
		Construct();
		accessories();
	}
	
	//Overriding abstract Construct function
	public void Construct() {
		System.out.println("Constructing Luxury Car!!!");
	}
	
	//Overriding abstract accessories function.
	public void accessories()
	{
		System.out.println("*********Details**********\n"+"-".repeat(56));
		System.out.println("Belongs to Mercedes-Benz");
		System.out.println("Name of Car- H247 GLA-Class, subcompact luxury crossover (2020–present)");
		System.out.println("Color- Black/White/Orange/Red");
		System.out.println("Fuel- Diesel");
		System.out.println("Gears- Auto");
		System.out.println("Types of Tyres- Alloy Wheels");
		System.out.println("Airbags- Present");
		System.out.println("Back Wiper-Present ");
		System.out.println("Side Mirror- Two");
		System.out.println("Touch Screen Music Player");
		System.out.println("Roof Window- YES");
		System.out.println("Automotive Garbage Cans");
		System.out.println("Automotice Air Freshner");
		System.out.println("Button Start");
		System.out.println("-".repeat(56));
	}
}

//Inheriting Seadn class from abstract class Car
class Sedan extends Car {
	Sedan() {
		super(CarType.SEDAN);
		Construct();
		accessories();
	}
	
	//Overriding construct method
	public void Construct() {
		System.out.println("Constructing Sedan Car!!!");
	}
	
	//Overriding accessories method
	public void accessories()
	{
		System.out.println("*********Details**********\n"+"-".repeat(56));
		System.out.println("Belongs to SEDAN");
		System.out.println("Name of Car- Honda City");
		System.out.println("Color- Black/White/Orange/Red");
		System.out.println("Fuel- Petrol/Diesel");
		System.out.println("Gears- Auto/Manual");
		System.out.println("Types of Tyres- Alloy Wheels");
		System.out.println("Airbags- YES");
		System.out.println("Back Wiper- YES");
		System.out.println("Side Mirror- Two");
		System.out.println("Touch Screen Music Player- YES");
		System.out.println("Roof Window");
		System.out.println("-".repeat(56));
	}
}

//Inheriting SmallCar class from abstract Car class 
class SmallCar extends Car {
	SmallCar() {
		super(CarType.SMALL);
		Construct();
		accessories();
	}
	
	//Overriding Construct method
	public void Construct() {
		System.out.println("Constructing Small Car!!!");
	}
	//Overriding accessories method
	public void accessories(){
		System.out.println("*********Details**********\n"+"-".repeat(56));
		System.out.println("Name - Tata Nano");
		System.out.println("Color- Black/White/Orange/Red");
		System.out.println("Fuel- Petrol");
		System.out.println("Gears- Manual");
		System.out.println("Types of Tyres- Alloy Wheels");
		System.out.println("Airbags");
		System.out.println("Back Wiper");
		System.out.println("Side Mirror- Two");
		System.out.println("Touch Screen Music Player");
		System.out.println("-".repeat(56));
	}
}

//Car factory class to switch between implementations of various enem classes
class CarFactory {
	public static Car buildCar(CarType model) {
		Car c = null;
		switch (model) {
		case SMALL:
			c = new SmallCar();
			break;
		case SEDAN:
			c = new Sedan();
			break;
		case LUXURY:
			c = new Luxury();
			break;
		default:
			System.out.println("Invalid Choice !!!");
		}
		return c;
	}
}

//Start of main class
public class FactoryDesignPattern {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int ch;
		while (true) {
			System.out.println("\nTo know about the cars \nPress\n\t1. For Small car\n\t2.For Sedan Car\n\t3.For Luxury Car\n\t0.Exit\nEnter Choice : ");
			ch = s.nextInt();
			if(ch == 0)
			{
				break;
			}
			switch (ch) {
			case 1 :
			System.out.println("=".repeat(56));
				System.out.println(CarFactory.buildCar(CarType.SMALL));
				System.out.println("=".repeat(56));
				break;
			case 2 :
			System.out.println("=".repeat(56));
				System.out.println(CarFactory.buildCar(CarType.SEDAN));
				System.out.println("=".repeat(56));
				break;
			case 3 :
			System.out.println("=".repeat(56));
				System.out.println(CarFactory.buildCar(CarType.LUXURY));
				System.out.println("=".repeat(56));
				break;
			default :
				System.out.println("Invalid Choice!!!");
			}
		}
	}
}
