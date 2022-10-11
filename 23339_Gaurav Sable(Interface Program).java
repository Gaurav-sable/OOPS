//23339_Gaurav Sable
//Interface Assignment 5

import java.util.*;

//interface class Vehicle
interface Vehicle {
	void GearChange();
	void SpeedUp();
	void ApplyBrakes();
	Scanner s = new Scanner(System.in);
}

//Implementation of class Bicycle
class Bicycle implements Vehicle {
	int Gear, Speed;
	Bicycle() {
		Gear = 1;
		Speed = 5;
		System.out.println("Your Journey on Bicycle has Started Succesfully!!!\nCurrently it is in.......\n\t Gear : " + Gear + "\n\t Speed : " + Speed + "Km/Hr.\n" + "_".repeat(56) + "\n");
	}

	//Gear Change method for Bicycle
	public void GearChange() {
		String ch;
		int n;
		System.out.println("There are Max 4 Gears Available and Currently you are in Gear " + Gear + "\n");
		System.out.println("Press \n1.To Gear Up\n0.To Gear Down\n" + "-".repeat(25));
		n = s.nextInt();
		if (n == 1) {
			if (Gear < 5) {
				Gear = Gear + 1;
				Speed = Speed + 10;
				System.out.println("Gear Up Successfully!!! \nNow you are in.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + "Km/Hr");
			} else {
				System.out.println("Gear Limit cannot be Exceed more than " + Gear);
			}
		}
		if (n == 0) {
			Gear = Gear - 1;
			if (Gear == 0) {
				while (Speed != 0) {
					Speed = Speed - 5;
					System.out.println("You are on Neutral .\nDecreasing Speed : " + Speed);
				}
				System.out.println("Bicycle Stopped !!!");
			} else {
				Speed = Speed - 20;
				if(Speed<0)
				{
					Speed = 0;
				}
				System.out.println("Gear Down Succesfully !!! \nNow....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
			}
		}

	}

	//Speed Up method for Bicycle
	public void SpeedUp() {
		int Inc;
		String ch;
		System.out.println("*Note that : \nMax. Speed limit for your Bicycle is 70 Km/Hr But it is safe upto 50 Km/Hr only.\nYour Current Speed is " + Speed + " Km/Hr\n");
		System.out.println("How much Speed you want to Increase ?");
		Inc = s.nextInt();
		if (Gear == 0) {
			System.out.println("Please Gear Up Firstly.");
		} else if (Gear == 1 && (Speed + Inc) <= 20 && (Speed + Inc) >= 0) {
			Speed = Speed + Inc;
			System.out.println("Speed Up Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 1 && ((Speed + Inc) > 20 || (Speed + Inc) < 0)) {
			System.out.println("Please Gear Up first to reach this Speed.");
		} else if (Gear == 2 && (Speed + Inc) <= 35 && (Speed + Inc) >= 10) {
			Speed = Speed + Inc;
			System.out.println("Speed Up Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 2 && ((Speed + Inc) > 35 || (Speed + Inc) < 10)) {
			System.out.println("Please adjust Gear Accordingly");
		} else if (Gear == 3 && (Speed + Inc) <= 50 && (Speed + Inc) >= 25) {
			Speed = Speed + Inc;
			System.out.println("Speed Up Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 3 && ((Speed + Inc) > 50 || (Speed + Inc) < 25)) {
			System.out.println("Please adjust Gear Accordingly.");
		} else if (Gear == 4 && (Speed + Inc) <= 70 && (Speed + Inc) >= 40) {
			if ((Speed + Inc) <= 50) {
				Speed = Speed + Inc;
				System.out.println("Speed Up Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
			}
			if ((Speed + Inc) > 50 && (Speed + Inc) <= 70) {
				Speed = Speed + Inc;
				System.out.println("Speed Up Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
				System.out.println("***Alert :- You have Exceeded Safe Speed Limit***");
			}
		} else if (Gear == 4 && (Speed + Inc) < 40) {
			System.out.println("Please adjust Gear Accordingly");
		} else if ((Speed + Inc) > 70) {
			System.out.println("You cant exceed Max Speed Limit.");
		}

	}

	//Apply Brakes method for Bicycle
	public void ApplyBrakes() {
		int Dec;
		System.out.println("How much Decrease in Speed u want ?");
		Dec = s.nextInt();
		if (Gear == 0) {
			Speed = 0;
			System.out.println("You are already at Rest.");
		}
		if (Speed < Dec) {
			Speed = 0;
			System.out.println("You are at Rest.");
		} else if (Gear == 1 && (Speed - Dec) <= 20 && (Speed - Dec) >= 0) {
			Speed = Speed - Dec;
			System.out.println("Breaks Applied Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 1 && ((Speed - Dec) > 20 || (Speed - Dec) < 0)) {
			System.out.println("Please adjust your Gears");
		} else if (Gear == 2 && (Speed - Dec) <= 35 && (Speed - Dec) >= 10) {
			Speed = Speed - Dec;
			System.out.println("Breaks Applied Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 2 && ((Speed - Dec) > 35 || (Speed - Dec) < 10)) {
			System.out.println("Please adjust your Gears");
		} else if (Gear == 3 && (Speed - Dec) <= 50 && (Speed - Dec) >= 25) {
			Speed = Speed - Dec;
			System.out.println("Breaks Applied Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 3 && ((Speed - Dec) > 50 || (Speed - Dec) < 25)) {
			System.out.println("Please adjust your Gear.");
		} else if (Gear == 4 && (Speed - Dec) <= 70 && (Speed - Dec) >= 40) {
			if ((Speed - Dec) <= 50) {
				Speed = Speed - Dec;
				System.out.println("Breaks Applied Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
			}
			if ((Speed - Dec) > 50 && (Speed - Dec) <= 70) {
				Speed = Speed - Dec;
				System.out.println("Breaks Applied Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr\n\n***Alert :- You are still in Exceeded Safe Speed Limit***");
			}
		} else if (Gear == 4 && ((Speed - Dec) > 70 || (Speed - Dec) < 40)) {
			System.out.println("Please adjust your Gear");
		}
	}
}


//Implementation of Bike Class
class Bike implements Vehicle {
	int Gear, Speed;
	Bike() {
		Gear = 1;
		Speed = 10;
		System.out.println("Your Journey on Bike has Started Succesfully!!!\nCurrently it is in.......\n\t Gear : " + Gear + "\n\t Speed : " + Speed + "Km/Hr.\n"+"_".repeat(56));
	}

	//Gear Change method for Bike
	public void GearChange() {
		int n;
		System.out.println("There are Max 5 Gears Available and Currently you are in Gear " + Gear + "\n");
		System.out.println("Press \n1.To Gear Up\n0.To Gear Down\n" + "-".repeat(25));
		n = s.nextInt();
		if (n == 1) {
			if (Gear <= 5) {
				Gear = Gear + 1;
				Speed = Speed + 30;
				System.out.println("Gear Up Successfully!!! \nNow you are in.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + "Km/Hr");
			} else {
				System.out.println("Gear Limit cannot be Exceed more than " + Gear);
			}
		}
		if (n == 0) {
			Gear = Gear - 1;
			if (Gear == 0) {
				while (Speed != 0) {
					Speed = Speed - 5;
					System.out.println("You are on Neutral .\nDecreasing Speed : " + Speed);
				}
				System.out.println("Bicycle Stopped !!!");
			} else {
				Speed = Speed - 30;
				if(Speed < 0)
				{
					Speed = 0;
				}
				System.out.println("Gear Down Succesfully !!! \nNow....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
			}
		}

	}

	//Speed Up method for Bike
	public void SpeedUp() {
		int Inc;
		String ch;
		System.out.println("*Note that : \nMax. Speed limit for your Bike is 150 Km/Hr But it is safe upto 120 Km/Hr only.\nYour Current Speed is " + Speed + " Km/Hr\n");
		System.out.println("How much Speed you want to Increase ?");
		Inc = s.nextInt();
		if (Gear == 0) {
			System.out.println("Please Gear Up Firstly.");
		} else if (Gear == 1 && (Speed + Inc) <= 30 && (Speed + Inc) >= 0) {
			Speed = Speed + Inc;
			System.out.println("Speed Up Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 1 && ((Speed + Inc) > 30 || (Speed + Inc) < 0)) {
			System.out.println("Please Gear Up first to reach this Speed.");
		} else if (Gear == 2 && (Speed + Inc) <= 60 && (Speed + Inc) >= 10) {
			Speed = Speed + Inc;
			System.out.println("Speed Up Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 2 && ((Speed + Inc) > 60 || (Speed + Inc) < 10)) {
			System.out.println("Please adjust Gear Accordingly");
		} else if (Gear == 3 && (Speed + Inc) <= 90 && (Speed + Inc) >= 40) {
			Speed = Speed + Inc;
			System.out.println("Speed Up Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 3 && ((Speed + Inc) > 90 || (Speed + Inc) < 40)) {
			System.out.println("Please adjust Gear Accordingly.");
		} else if (Gear == 4 && (Speed + Inc) <= 120 && (Speed + Inc) >= 70) {
			Speed = Speed + Inc;
			System.out.println("Speed Up Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 4 && ((Speed + Inc) > 120 || (Speed + Inc) < 70)) {
			System.out.println("Please adjust Gear Accordingly.");
		} else if (Gear == 5 && (Speed + Inc) <= 150 && (Speed + Inc) >= 100) {
			if ((Speed + Inc) <= 120) {
				Speed = Speed + Inc;
				System.out.println("Speed Up Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
			}
			if ((Speed + Inc) > 120 && (Speed + Inc) <= 150) {
				Speed = Speed + Inc;
				System.out.println("Speed Up Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
				System.out.println("***Alert :- You have Exceeded Safe Speed Limit***");
			}
		} else if (Gear == 5 && (Speed + Inc) < 100) {
			System.out.println("Please adjust Gear Accordingly");
		} else if ((Speed + Inc) > 150) {
			System.out.println("You cant exceed Max Speed Limit.");
		}

	}

	//ApplyBrakes method for Bike
	public void ApplyBrakes() {
		int Dec;
		System.out.println("How much Decrease in Speed u want ?");
		Dec = s.nextInt();
		if (Gear == 0) {
			Speed = 0;
			System.out.println("You are already at Rest.");
		}
		if ((Speed - Dec) < 0) {
			Speed = 0;
			System.out.println("You are at Rest.");
		} else if (Gear == 1 && (Speed - Dec) <= 30 && (Speed - Dec) >= 0) {
			Speed = Speed - Dec;
			System.out.println("Breaks Applied Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 1 && ((Speed - Dec) > 30 || (Speed - Dec) < 0)) {
			System.out.println("Please adjust your Gears");
		} else if (Gear == 2 && (Speed - Dec) <= 60 && (Speed - Dec) >= 10) {
			Speed = Speed - Dec;
			System.out.println("Breaks Applied Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 2 && ((Speed - Dec) > 60 || (Speed - Dec) < 10)) {
			System.out.println("Please adjust your Gears");
		} else if (Gear == 3 && (Speed - Dec) <= 90 && (Speed - Dec) >= 40) {
			Speed = Speed - Dec;
			System.out.println("Breaks Applied Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 3 && ((Speed - Dec) > 90 || (Speed - Dec) < 40)) {
			System.out.println("Please adjust your Gear.");
		} else if (Gear == 4 && (Speed - Dec) <= 120 && (Speed - Dec) >= 70) {
			Speed = Speed - Dec;
			System.out.println("Breaks Applied Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 4 && ((Speed - Dec) > 120 || (Speed - Dec) < 70)) {
			System.out.println("Please adjust your Gear.");
		} else if (Gear == 5 && (Speed - Dec) <= 150 && (Speed - Dec) >= 100) {
			if ((Speed - Dec) <= 120) {
				Speed = Speed - Dec;
				System.out.println("Breaks Applied Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
			}
			if ((Speed - Dec) > 120 && (Speed - Dec) <= 150) {
				Speed = Speed - Dec;
				System.out.println("Breaks Applied Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr\n\n***Alert :- You are still in Exceeded Safe Speed Limit***");
			}
		} else if (Gear == 5 && (Speed - Dec) < 100) {
			System.out.println("Please adjust your Gear");
		}
	}
}


//implementing class Car
class Car implements Vehicle {
	int Gear, Speed;
	Car() {
		Gear = 1;
		Speed = 10;
		System.out.println("Your Journey in Car has Started Succesfully!!!\nCurrently it is in.......\n\t Gear : " + Gear + "\n\t Speed : " + Speed + "Km/Hr.\n"+"_".repeat(56));
	}

	//Gear Change method for Car
	public void GearChange() {
		String ch;
		int n;
		System.out.println("There are Max 6 Gears Available and Currently you are in Gear " + Gear + "\n");
		System.out.println("Press \n1.To Gear Up\n0.To Gear Down\n" + "-".repeat(25));
		n = s.nextInt();
		if (n == 1) {
			if (Gear <= 5) {
				Gear = Gear + 1;
				Speed = Speed + 40;
				System.out.println("Gear Up Successfully!!! \nNow you are in.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + "Km/Hr");
			} else {
				System.out.println("Gear Limit cannot be Exceed more than " + Gear);
			}
		}
		if (n == 0) {
			Gear = Gear - 1;
			if (Gear == 0) {
				while (Speed != 0) {
					Speed = Speed - 5;
					System.out.println("You are on Neutral .\nDecreasing Speed : " + Speed);
				}
				System.out.println("Bicycle Stopped !!!");
			} else {
				Speed = Speed - 40;
				if(Speed < 0)
				{
					Speed = 0;
				}
				System.out.println("Gear Down Succesfully !!! \nNow....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
			}
		}

	}

	//Speed Up method for Car
	public void SpeedUp() {
		int Inc;
		String ch;
		System.out.println("*Note that : \nMax. Speed limit for your Car is 240 Km/Hr But it is safe upto 200 Km/Hr only.\nYour Current Speed is " + Speed + " Km/Hr\n");
		System.out.println("How much Speed you want to Increase ?");
		Inc = s.nextInt();
		if (Gear == 0) {
			System.out.println("Please Gear Up Firstly.");
		} else if (Gear == 1 && (Speed + Inc) <= 40 && (Speed + Inc) >= 0) {
			Speed = Speed + Inc;
			System.out.println("Speed Up Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 1 && ((Speed + Inc) > 40 || (Speed + Inc) < 0)) {
			System.out.println("Please Gear Up first to reach this Speed.");
		} else if (Gear == 2 && (Speed + Inc) <= 80 && (Speed + Inc) >= 15) {
			Speed = Speed + Inc;
			System.out.println("Speed Up Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 2 && ((Speed + Inc) > 80 || (Speed + Inc) < 15)) {
			System.out.println("Please adjust Gear Accordingly");
		} else if (Gear == 3 && (Speed + Inc) <= 120 && (Speed + Inc) >= 55) {
			Speed = Speed + Inc;
			System.out.println("Speed Up Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 3 && ((Speed + Inc) > 120 || (Speed + Inc) < 55)) {
			System.out.println("Please adjust Gear Accordingly.");
		} else if (Gear == 4 && (Speed + Inc) <= 160 && (Speed + Inc) >= 95) {
			Speed = Speed + Inc;
			System.out.println("Speed Up Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 4 && ((Speed + Inc) > 160 || (Speed + Inc) < 95)) {
			System.out.println("Please adjust Gear Accordingly.");
		} else if (Gear == 5 && (Speed + Inc) <= 200 && (Speed + Inc) >= 135) {
			Speed = Speed + Inc;
			System.out.println("Speed Up Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 5 && ((Speed + Inc) > 200 || (Speed + Inc) < 135)) {
			System.out.println("Please adjust Gear Accordingly.");
		} else if (Gear == 6 && (Speed + Inc) <= 240 && (Speed + Inc) >= 175) {
			if ((Speed + Inc) <= 200) {
				Speed = Speed + Inc;
				System.out.println("Speed Up Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
			}
			if ((Speed + Inc) > 200 && (Speed + Inc) <= 240) {
				Speed = Speed + Inc;
				System.out.println("Speed Up Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
				System.out.println("***Alert :- You have Exceeded Safe Speed Limit***");
			}
		} else if (Gear == 6 && (Speed + Inc) < 175) {
			System.out.println("Please adjust Gear Accordingly");
		} else if ((Speed + Inc) > 240) {
			System.out.println("You cant exceed Max Speed Limit.");
		}

	}

	//Apply Brakes method for Car
	public void ApplyBrakes() {
		int Dec;
		System.out.println("How much Decrease in Speed u want ?");
		Dec = s.nextInt();
		if (Gear == 0) {
			Speed = 0;
			System.out.println("You are already at Rest.");
		}
		if ((Speed - Dec) < 0) {
			Speed = 0;
			System.out.println("You are at Rest.");
		} else if (Gear == 1 && (Speed - Dec) <= 40 && (Speed - Dec) >= 0) {
			Speed = Speed - Dec;
			System.out.println("Breaks Applied Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 1 && ((Speed - Dec) > 40 || (Speed - Dec) < 0)) {
			System.out.println("Please adjust your Gears");
		} else if (Gear == 2 && (Speed - Dec) <= 80 && (Speed - Dec) >= 15) {
			Speed = Speed - Dec;
			System.out.println("Breaks Applied Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 2 && ((Speed - Dec) > 35 || (Speed - Dec) < 15)) {
			System.out.println("Please adjust your Gears");
		} else if (Gear == 3 && (Speed - Dec) <= 120 && (Speed - Dec) >= 55) {
			Speed = Speed - Dec;
			System.out.println("Breaks Applied Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 3 && ((Speed - Dec) > 120 || (Speed - Dec) < 55)) {
			System.out.println("Please adjust your Gear.");
		} else if (Gear == 4 && (Speed - Dec) <= 160 && (Speed - Dec) >= 95) {
			Speed = Speed - Dec;
			System.out.println("Breaks Applied Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 4 && ((Speed - Dec) > 160 || (Speed - Dec) < 95)) {
			System.out.println("Please adjust your Gear.");
		} else if (Gear == 5 && (Speed - Dec) <= 200 && (Speed - Dec) >= 135) {
			Speed = Speed - Dec;
			System.out.println("Breaks Applied Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
		} else if (Gear == 5 && ((Speed - Dec) > 200 || (Speed - Dec) < 135)) {
			System.out.println("Please adjust your Gear.");
		} else if (Gear == 6 && (Speed - Dec) <= 240 && (Speed - Dec) >= 175) {
			if ((Speed - Dec) <= 200) {
				Speed = Speed - Dec;
				System.out.println("Breaks Applied Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr");
			}
			if ((Speed - Dec) > 200 && (Speed - Dec) <= 240) {
				Speed = Speed - Dec;
				System.out.println("Breaks Applied Successfully!!!\nYou are now at.....\n\tGear : " + Gear + "\n\tSpeed : " + Speed + " Km/Hr\n\n***Alert :- You are still in Exceeded Safe Speed Limit***");
			}
		} else if (Gear == 6 && (Speed - Dec) < 175) {
			System.out.println("Please adjust your Gear");
		}
	}
}


//Main Method
public class Main {
	public static void main(String[] args) {
		int n, k;
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Lets Start the Journey............\nSelect your Vehicle\n\n\t1.Bicycle\t\t\t2.Bike\n\t3.Car\t\t\t0.Terminate\n\n" + "•".repeat(56));
			n = sc.nextInt();
			if (n == 0) {
				break;
			}
			switch (n) {
			case 1 :
				Bicycle B = new Bicycle();
				while (true) {
					System.out.println("Press\n1.Change Gear\t\t\t2.Speed Up\n3.Apply Brakes\t\t\t0.Return to Main Menu\n\n" + "=".repeat(56));
					k = sc.nextInt();
					if (k == 0) {
						break;
					}
					switch (k) {
					case 1 :
						B.GearChange();
						System.out.println("\n" + "=".repeat(56));
						break;
					case 2 :
						B.SpeedUp();
						System.out.println("\n" + "=".repeat(56));
						break;
					case 3 :
						B.ApplyBrakes();
						System.out.println("\n" + "=".repeat(56));
						break;
					}
				}
				break;
			case 2 :
				Bike b = new Bike();
				while (true) {
					System.out.println("Press\n1.Change Gear\t\t\t2.Speed Up\n3.Apply Brakes\t\t\t0.Return to Main Menu\n\n" + "=".repeat(56));
					k = sc.nextInt();
					if (k == 0) {
						break;
					}
					switch (k) {
					case 1 :
						b.GearChange();
						System.out.println("\n" + "=".repeat(56));
						break;
					case 2 :
						b.SpeedUp();
						System.out.println("\n" + "=".repeat(56));
						break;
					case 3 :
						b.ApplyBrakes();
						System.out.println("\n" + "=".repeat(56));
						break;
					}
				}
				break;
			case 3 :
				Car c = new Car();
				while (true) {
					System.out.println("Press\n1.Change Gear\t\t\t2.Speed Up\n3.Apply Brakes\t\t\t0.Return to Main Menu\n\n" + "=".repeat(56));
					k = sc.nextInt();
					if (k == 0) {
						break;
					}
					switch (k) {
					case 1 :
						c.GearChange();
						System.out.println("\n" + "=".repeat(56));
						break;
					case 2 :
						c.SpeedUp();
						System.out.println("\n" + "=".repeat(56));
						break;
					case 3 :
						c.ApplyBrakes();
						System.out.println("\n" + "=".repeat(56));
						break;
					}
				}
				break;
			}
		}
	}
}


//Output of the program

/*
Lets Start the Journey............
Select your Vehicle

        1.Bicycle                       2.Bike
        3.Car                   0.Terminate

••••••••••••••••••••••••••••••••••••••••••••••••••••••••1
Your Journey on Bicycle has Started Succesfully!!!
Currently it is in.......
         Gear : 1
         Speed : 5Km/Hr.
________________________________________________________
Press
1.Change Gear                   2.Speed Up
3.Apply Brakes                  0.Return to Main Menu

========================================================1
There are Max 4 Gears Available and Currently you are in Gear 1

Press
1.To Gear Up
0.To Gear Down
-------------------------
0
You are on Neutral .
Decreasing Speed : 0
Bicycle Stopped !!!

========================================================Press
1.Change Gear                   2.Speed Up
3.Apply Brakes                  0.Return to Main Menu

========================================================1
There are Max 4 Gears Available and Currently you are in Gear 0

Press
1.To Gear Up
0.To Gear Down
-------------------------
1
Gear Up Successfully!!!
Now you are in.....
        Gear : 1
        Speed : 10Km/Hr

========================================================Press
1.Change Gear                   2.Speed Up
3.Apply Brakes                  0.Return to Main Menu

========================================================1
There are Max 4 Gears Available and Currently you are in Gear 1

Press
1.To Gear Up
0.To Gear Down
-------------------------
1
Gear Up Successfully!!!
Now you are in.....
        Gear : 2
        Speed : 20Km/Hr

========================================================Press
1.Change Gear                   2.Speed Up
3.Apply Brakes                  0.Return to Main Menu

========================================================2
*Note that :
Max. Speed limit for your Bicycle is 70 Km/Hr But it is safe upto 50 Km/Hr only.
Your Current Speed is 20 Km/Hr

How much Speed you want to Increase ?
15
Speed Up Successfully!!!
You are now at.....
        Gear : 2
        Speed : 35 Km/Hr

========================================================Press
1.Change Gear                   2.Speed Up
3.Apply Brakes                  0.Return to Main Menu

========================================================3
How much Decrease in Speed u want ?
30
Please adjust your Gears

========================================================Press
1.Change Gear                   2.Speed Up
3.Apply Brakes                  0.Return to Main Menu

========================================================1
There are Max 4 Gears Available and Currently you are in Gear 2

Press
1.To Gear Up
0.To Gear Down
-------------------------
0
Gear Down Succesfully !!!
Now....
        Gear : 1
        Speed : 15 Km/Hr

========================================================Press
1.Change Gear                   2.Speed Up
3.Apply Brakes                  0.Return to Main Menu

========================================================3
How much Decrease in Speed u want ?
20
You are at Rest.

========================================================Press
1.Change Gear                   2.Speed Up
3.Apply Brakes                  0.Return to Main Menu

========================================================0
Lets Start the Journey............
Select your Vehicle

        1.Bicycle                       2.Bike
        3.Car                   0.Terminate

••••••••••••••••••••••••••••••••••••••••••••••••••••••••2
Your Journey on Bike has Started Succesfully!!!
Currently it is in.......
         Gear : 1
         Speed : 10Km/Hr.
________________________________________________________Press
1.Change Gear                   2.Speed Up
3.Apply Brakes                  0.Return to Main Menu

========================================================1
There are Max 5 Gears Available and Currently you are in Gear 1

Press
1.To Gear Up
0.To Gear Down
-------------------------
1
Gear Up Successfully!!!
Now you are in.....
        Gear : 2
        Speed : 40Km/Hr

========================================================Press
1.Change Gear                   2.Speed Up
3.Apply Brakes                  0.Return to Main Menu

========================================================1
There are Max 5 Gears Available and Currently you are in Gear 2

Press
1.To Gear Up
0.To Gear Down
-------------------------
1
Gear Up Successfully!!!
Now you are in.....
        Gear : 3
        Speed : 70Km/Hr

========================================================Press
1.Change Gear                   2.Speed Up
3.Apply Brakes                  0.Return to Main Menu

========================================================2
*Note that :
Max. Speed limit for your Bike is 150 Km/Hr But it is safe upto 120 Km/Hr only.
Your Current Speed is 70 Km/Hr

How much Speed you want to Increase ?
30
Please adjust Gear Accordingly.

========================================================Press
1.Change Gear                   2.Speed Up
3.Apply Brakes                  0.Return to Main Menu

========================================================2
*Note that :
Max. Speed limit for your Bike is 150 Km/Hr But it is safe upto 120 Km/Hr only.
Your Current Speed is 70 Km/Hr

How much Speed you want to Increase ?
20
Speed Up Successfully!!!
You are now at.....
        Gear : 3
        Speed : 90 Km/Hr

========================================================Press
1.Change Gear                   2.Speed Up
3.Apply Brakes                  0.Return to Main Menu

========================================================3
How much Decrease in Speed u want ?
30
Breaks Applied Successfully!!!
You are now at.....
        Gear : 3
        Speed : 60 Km/Hr

========================================================Press
1.Change Gear                   2.Speed Up
3.Apply Brakes                  0.Return to Main Menu

========================================================0
Lets Start the Journey............
Select your Vehicle

        1.Bicycle                       2.Bike
        3.Car                   0.Terminate

••••••••••••••••••••••••••••••••••••••••••••••••••••••••3
Your Journey in Car has Started Succesfully!!!
Currently it is in.......
         Gear : 1
         Speed : 10Km/Hr.
________________________________________________________Press
1.Change Gear                   2.Speed Up
3.Apply Brakes                  0.Return to Main Menu

========================================================2
*Note that :
Max. Speed limit for your Car is 240 Km/Hr But it is safe upto 200 Km/Hr only.
Your Current Speed is 10 Km/Hr

How much Speed you want to Increase ?
30
Speed Up Successfully!!!
You are now at.....
        Gear : 1
        Speed : 40 Km/Hr

========================================================Press
1.Change Gear                   2.Speed Up
3.Apply Brakes                  0.Return to Main Menu

========================================================1
There are Max 6 Gears Available and Currently you are in Gear 1

Press
1.To Gear Up
0.To Gear Down
-------------------------
1
Gear Up Successfully!!!
Now you are in.....
        Gear : 2
        Speed : 80Km/Hr

========================================================Press
1.Change Gear                   2.Speed Up
3.Apply Brakes                  0.Return to Main Menu

========================================================3
How much Decrease in Speed u want ?
50
Breaks Applied Successfully!!!
You are now at.....
        Gear : 2
        Speed : 30 Km/Hr

========================================================Press
1.Change Gear                   2.Speed Up
3.Apply Brakes                  0.Return to Main Menu

========================================================1
There are Max 6 Gears Available and Currently you are in Gear 2

Press
1.To Gear Up
0.To Gear Down
-------------------------
0
Gear Down Succesfully !!!
Now....
        Gear : 1
        Speed : 0 Km/Hr

========================================================Press
1.Change Gear                   2.Speed Up
3.Apply Brakes                  0.Return to Main Menu

========================================================0
Lets Start the Journey............
Select your Vehicle

        1.Bicycle                       2.Bike
        3.Car                   0.Terminate

••••••••••••••••••••••••••••••••••••••••••••••••••••••••0

[Program finished]
*/