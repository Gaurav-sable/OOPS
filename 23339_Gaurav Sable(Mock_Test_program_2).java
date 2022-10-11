//23339_Gaurav Sable
//Mock Test
//Polymorphism


import java.util.Scanner;

class Publication {
	
	//Private Data Members
	private String title;
	private float Price;
	private int Copies;
	private float Total;
	public float getTotal() {
		return Total;
	}
	public void SetTotal(float Total) {
		this.Total = Total;
	}
	public int getCopies() {
		return Copies;
	}
	public void SetCopies(int Copies) {
		this.Copies = Copies;
	}

	public String gettitle() {
		return title;
	}
	public void settitle(String title) {
		this.title = title;
	}

	public float getPrice() {
		return Price;
	}
	Scanner sc = new Scanner(System.in);

    //To read Details
	void read_publ() {

		System.out.print("Enter title : ");
		title = sc.next();
		System.out.print("Enter price:  ");
		Price = sc.nextFloat();
		System.out.print("Enter currently available copies : ");
		Copies = sc.nextInt();
	}
	
	//To Display Detail
	void Display() {
		System.out.print(title + "      |   " + Price + "     |   " + Copies);
	}

    //Common method to Override
	void Salecopy(int qty) {
		SetTotal(Total + (qty * Price));
		System.out.println("Total Publication Sale = Rs " + Total);
	}
}

//Book class Extending Publication class showing Inheritance
class Book extends Publication {
	private String Author;

    //To Read Detail of Book
	void Read_Book() {
		read_publ();
		System.out.print("Enter Author Name : ");
		Author = sc.nextLine();
		Author = sc.nextLine();
	}

    //To Order New Copies(For Shop)
	void OrderCopies(int Num) {
		SetCopies(getCopies() + Num);
		System.out.println("Successfully Ordered!!!!! \nTotal Copies Available = " + (getCopies()));
	}

    //To Display Book Detail
	void Display_Book() {
		System.out.println("Title      |   Price    |   Copies     |   Author");
		Display();
		System.out.println("            |   " + Author);
	}

    //Overridden SaleCopy method from publication class showing Polymorphism.
	void Salecopy(int qty) {
		if (qty <= getCopies()) {
			SetCopies(getCopies() - qty);
			System.out.println("You have Purchased " + qty + " Copies of Book " + gettitle() + "\nYou have to Pay Rs " + qty * getPrice());
		} else {
			System.out.println("Sorry!! Insufficient Stock...\nCurrently Available Copies = " + getCopies());
		}
		SetTotal(getTotal() + (qty * getPrice()));
	}
}


//Magazine class extending publication class showing Inheritance
class Magazine extends Publication {
	private int OrderQty;
	private String Current_Issue;

    //To Receives newly issued Copies
	void ReceiveIssue(String New_Issue) {
		System.out.println("Enter Total no. of New Copies Ordered : ");
		OrderQty = sc.nextInt();
		SetCopies(getCopies() + OrderQty);

		System.out.println("The Magazine '" + gettitle() + "' with Issue Date '" + New_Issue + "' Available !!!");
	}
	
	//To read Detail of Magazine
	void Read_Mag() {
		read_publ();
		System.out.print("Enter the Issue Date of Currently Available Copies[dd/mm/yyyy] : ");
		Current_Issue = sc.nextLine();
		Current_Issue = sc.nextLine();
	}
	
	//To Diaplay Magazine Detail
	void Display_Mag() {
		System.out.println("Title      |   Price    |   Copies     |   IssueDate");
		Display();
		System.out.println("    |   " + Current_Issue);
	}
	
	//Overridden SaleCopy method from Publication class showing polymorphism.
	void Salecopy(int qty) {
		if (qty <= getCopies()) {
			SetCopies(getCopies() - qty);
			System.out.println("You have Purchased " + qty + " Copies of Magazine " + gettitle() + "\nYou have to Pay Rs " + qty * getPrice());
		} else {
			System.out.println("Sorry!! Insufficient Stock...\nCurrently Available Copies = " + getCopies());
		}
		SetTotal(getTotal() + (qty * getPrice()));
	}

}

//Start of Main class
public class Main {
	public static void main(String[] args) {
		Scanner d = new Scanner(System.in);
		//Creation of Objects
		Book b = new Book();
		Magazine m = new Magazine();
		
		int n;
		while (true) {
			System.out.println("Choose..........\n1.Book\n2.Magazine\n3.Total Sale of Publication\n4.Total Revenue of Publication\n0.To Terminate\n" + "=".repeat(56));
			n = d.nextInt();
			if (n == 0) {
				System.out.println("\t\t\tTHANK YOU !!!! Revisit again.");
				break;
			}
			switch (n) {

			//case for Books
			case 1 :
				while (true) {
					System.out.println("\t\t\t\t\tMENU FOR BOOKS\n\nFOR USER........\n1.Enter Book Detail\t\t2.Display Book Detail\n3.Order Books\t\t\t0.Exit\n\nFOR SHOP OWNER................\n4.Order new Copies\n" +
									   "•".repeat(56));
					System.out.println("Choose your Operation : ");
					int ch;
					ch = d.nextInt();
					if (ch == 0) {
						break;
					}
					switch (ch) {
					case 1 :
						b.Read_Book();
						System.out.println("-".repeat(56) + "\n" + "-".repeat(56));
						break;
					case 2 :
						b.Display_Book();
						System.out.println("-".repeat(56) + "\n" + "-".repeat(56));
						break;
					case 3 :
						int a;
						System.out.println("How many Copies you want : ");
						a = d.nextInt();
						b.Salecopy(a);
						System.out.println("-".repeat(56) + "\n" + "-".repeat(56));
						break;
					case 4 :
						int k;
						System.out.println("Enter no. of Copies to Order : ");
						k = d.nextInt();
						b.OrderCopies(k);
						System.out.println("-".repeat(56) + "\n" + "-".repeat(56));
						break;
					default :
						System.out.println("Invalid Choice !!!");
					}
				}
				break;
				
			//case for Magazine
			case 2 :
				while (true) {
					System.out.println("\t\t\t\t\tMENU FOR MAGAZINE\n\nFOR USER........\n1.Enter Magazine Detail\t\t2.Display Magazine Detail\n3.Order Magazine\t\t\t0.Exit\n\nFOR SHOP OWNER................\n4.Receive New Issues\n"
									   +
									   "•".repeat(56));
					System.out.println("Choose your Operation : ");
					int ch;
					ch = d.nextInt();
					if (ch == 0) {
						break;
					}
					switch (ch) {
					case 1 :
						m.Read_Mag();
						System.out.println("-".repeat(56) + "\n" + "-".repeat(56));
						break;
					case 2 :
						m.Display_Mag();
						System.out.println("-".repeat(56) + "\n" + "-".repeat(56));
						break;
					case 3 :
						int q;
						System.out.println("How many Copies you want : ");
						q = d.nextInt();
						m.Salecopy(q);
						System.out.println("-".repeat(56) + "\n" + "-".repeat(56));
						break;
					case 4 :
						String k;
						System.out.println("Enter New Issue Date [dd/mm/yyyy] : ");
						k = d.nextLine();
						k = d.nextLine();
						m.ReceiveIssue(k);
						System.out.println("-".repeat(56) + "\n" + "-".repeat(56));
						break;
					default :
						System.out.println("Invalid Choice....");
					}
				}
				break;
				
			//Shows total sale of Publication
			case 3 :
				System.out.println("Total Publication Sale = Rs " + (b.getTotal() + m.getTotal()));
				break;
				
			//Shows Total revenue of publication
			case 4 :
				System.out.println("Total Revenue of Publication = Rs " + (b.getCopies() * b.getPrice() + m.getCopies() * m.getPrice()));
				break;
				
			default :
				System.out.println("Invalid Choice !!!");
			}
		}
	}
}
