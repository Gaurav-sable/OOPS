import java.util.Scanner;
class Publication {
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

	void read_publ() {

		System.out.print("Enter title : ");
		title = sc.next();
		System.out.print("Enter price:  ");
		Price = sc.nextFloat();
		System.out.print("Enter currently available copies : ");
		Copies = sc.nextInt();
	}
	void Display() {
		System.out.print(title + "      |   " + Price + "     |   " + Copies);
	}

	void Salecopy(int qty) {
		SetTotal(Total + (qty * Price));
		System.out.println("Total Publication Sale = Rs " + Total);
	}
}
class Book extends Publication {
	private String Author;

	void Read_Book() {
		read_publ();
		System.out.print("Enter Author Name : ");
		Author = sc.nextLine();
		Author = sc.nextLine();
	}

	void OrderCopies(int Num) {
		SetCopies(getCopies() + Num);
		System.out.println("Successfully Ordered!!!!! \nTotal Copies Available = " + (getCopies()));

	}

	void Display_Book() {
		System.out.println("Title      |   Price    |   Copies     |   Author");
		Display();
		System.out.println("            |   " + Author);
	}

	void Salecopy(int qty) {
		if (qty <= getCopies()) {
			SetCopies(getCopies() - qty);
			System.out.println("You have Purchased " + qty + " Copies of Book " + gettitle() + "\nYou have to Pay Rs " + qty * getPrice());
		} else {
			System.out.println("Sorry!! Insufficient Stock...");
		}
		SetTotal(getTotal() + (qty * getPrice()));

	}
}
class Magazine extends Publication {
	private int OrderQty;
	private String Current_Issue;

	void ReceiveIssue(String New_Issue) {
		System.out.println("Enter Total no. of New Copies Ordered : ");
		OrderQty = sc.nextInt();
		SetCopies(getCopies() + OrderQty);

		System.out.println("The Magazine '" + gettitle() + "' with Issue Date '" + New_Issue + "' Available !!!");
	}
	void Read_Mag() {
		read_publ();
		System.out.print("Enter the Issue Date of Currently Available Copies[dd/mm/yyyy] : ");
		Current_Issue = sc.nextLine();
		Current_Issue = sc.nextLine();
	}
	void Display_Mag() {
		System.out.println("Title      |   Price    |   Copies     |   IssueDate");
		Display();
		System.out.println("    |   " + Current_Issue);
	}
	void Salecopy(int qty) {
		if (qty <= getCopies()) {
			SetCopies(getCopies() - qty);
			System.out.println("You have Purchased " + qty + " Copies of Magazine " + gettitle() + "\nYou have to Pay Rs " + qty * getPrice());
		} else {
			System.out.println("Sorry!! Insufficient Stock...");
			SetTotal(getTotal() + (qty * getPrice()));
		}
	}

}

public class Main {
	public static void main(String[] args) {
		Scanner d = new Scanner(System.in);
		Book b[] = new Book[10];
		Magazine m = new Magazine();
		int n;
		while (true) {
			System.out.println("Choose..........\n1.Book\n2.Magazine\n3.Total Sale of Publication\n4.Total Revenue of Publication\n0.To Terminate\n" + "=".repeat(56));
			n = d.nextInt();
			if (n == 0) {
				break;
			}
			switch (n) {
			case 1 :
				int nb;
				System.out.println("Enter no. of Books available : ");
				nb = d.nextInt();
				while (true) {
					System.out.println("\t\t\t\t\tMENU FOR BOOKS\n\nFOR USER........\n1.Enter Book Detail\t\t2.Display Book Detail\n3.Order Books\t\t\t0.Exit\n\nFOR SHOP OWNER................\n4.Order new Copies\n" +
									   "•".repeat(56));
					System.out.println("Choose your Operation : ");
					int ch;
					ch = d.nextInt();
					if (ch == 0) {
						break;
					} else if (ch == 1) {
						for (int i = 0; i < nb; i++) {
							b[i] = new Book();
							System.out.println("Enter Detail of Book " + (i + 1));
							b[i].Read_Book();
							System.out.println("-".repeat(56) + "\n" + "-".repeat(56));
						}
					} else if (ch == 2) {
						for (int i = 0; i < nb; i++) {
							System.out.println("Detail of Book " + (i + 1));
							b[i].Display_Book();
							System.out.println("-".repeat(56) + "\n" + "-".repeat(56));
						}
					} else if (ch == 3) {
						int a;
						String Bname;
						System.out.println("Enter name of Book you want : ");
						Bname = d.nextLine();
						Bname = d.nextLine();
						for (int i = 0; i < nb; i++) {
							if (b[i].gettitle().equals(Bname)) {
								System.out.println("How many Copies you want : ");
								a = d.nextInt();
								b[i].Salecopy(a);
							} else {
								System.out.println("Sorry !!! This Book is not Available.");
							}
							System.out.println("-".repeat(56) + "\n" + "-".repeat(56));
						}
					} else if (ch == 4) {
						String bname;
						int k;
						System.out.println("Enter name of Book to order : ");
						bname = d.nextLine();
						bname = d.nextLine();
						for (int i = 0; i < nb; i++) {
							if (b[i].gettitle().equals(bname)) {
								System.out.println("Enter no. of Copies to Order : ");
								k = d.nextInt();
								b[i].OrderCopies(k);
							} else {
								System.out.println("This Book is not in your Store.\nContinue the order.........");
								nb = nb + 1;
								b[i + 1] = new Book();
								b[i + 1].Read_Book();
								System.out.println("Enter no. of Copies to Order : ");
								k = d.nextInt();
								b[i + 1].OrderCopies(k);
								break;
							}
							System.out.println("-".repeat(56) + "\n" + "-".repeat(56));
						}
					} else {
						System.out.println("Invalid Choice !!!");
					}
				}
				break;
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
			/*case 3 :
				System.out.println("Total Publication Sale = Rs " + (b.getTotal() + m.getTotal()));
				break;
			case 4 :
				System.out.println("Total Revenue of Publication = Rs " + (b.getCopies() * b.getPrice() + m.getCopies() * m.getPrice()));*/
				default :
				System.out.println("Invalid Choice.......");
			}
		}
	}
}


/* OutPut

Choose..........
1.Book
2.Magazine
3.Total Sale of Publication
4.Total Revenue of Publication
0.To Terminate
========================================================1
                                        MENU FOR BOOKS

FOR USER........
1.Enter Book Detail             2.Display Book Detail
3.Order Books                   0.Exit

FOR SHOP OWNER................
4.Order new Copies
••••••••••••••••••••••••••••••••••••••••••••••••••••••••
Choose your Operation :
1
Enter title : Elements
Enter price:  100
Enter currently available copies : 10
Enter Author Name : Prashant_J
----------------------------------------------------------------------------------------------------------------                                        MENU FOR BOOKS

FOR USER........
1.Enter Book Detail             2.Display Book Detail
3.Order Books                   0.Exit

FOR SHOP OWNER................
4.Order new Copies
••••••••••••••••••••••••••••••••••••••••••••••••••••••••
Choose your Operation :
2
Title      |   Price    |   Copies     |   Author
Elements      |   100.0     |   10            |   Prashant_J
----------------------------------------------------------------------------------------------------------------                                        MENU FOR BOOKS

FOR USER........
1.Enter Book Detail             2.Display Book Detail
3.Order Books                   0.Exit

FOR SHOP OWNER................
4.Order new Copies
••••••••••••••••••••••••••••••••••••••••••••••••••••••••
Choose your Operation :
3
How many Copies you want :
12
Sorry!! Insufficient Stock...
----------------------------------------------------------------------------------------------------------------                                        MENU FOR BOOKS

FOR USER........
1.Enter Book Detail             2.Display Book Detail
3.Order Books                   0.Exit

FOR SHOP OWNER................
4.Order new Copies
••••••••••••••••••••••••••••••••••••••••••••••••••••••••
Choose your Operation :
3
How many Copies you want :
5
You have Purchased 5 Copies of Book Elements
You have to Pay Rs 500.0
----------------------------------------------------------------------------------------------------------------                                        MENU FOR BOOKS

FOR USER........
1.Enter Book Detail             2.Display Book Detail
3.Order Books                   0.Exit

FOR SHOP OWNER................
4.Order new Copies
••••••••••••••••••••••••••••••••••••••••••••••••••••••••
Choose your Operation :
2
Title      |   Price    |   Copies     |   Author
Elements      |   100.0     |   5            |   Prashant_J
----------------------------------------------------------------------------------------------------------------                                        MENU FOR BOOKS

FOR USER........
1.Enter Book Detail             2.Display Book Detail
3.Order Books                   0.Exit

FOR SHOP OWNER................
4.Order new Copies
••••••••••••••••••••••••••••••••••••••••••••••••••••••••
Choose your Operation :
4
Enter no. of Copies to Order :
10
Successfully Ordered!!!!!
Total Copies Available = 15
----------------------------------------------------------------------------------------------------------------                                        MENU FOR BOOKS

FOR USER........
1.Enter Book Detail             2.Display Book Detail
3.Order Books                   0.Exit

FOR SHOP OWNER................
4.Order new Copies
••••••••••••••••••••••••••••••••••••••••••••••••••••••••
Choose your Operation :
0
Choose..........
1.Book
2.Magazine
3.Total Sale of Publication
4.Total Revenue of Publication
0.To Terminate
========================================================2
                                        MENU FOR MAGAZINE

FOR USER........
1.Enter Magazine Detail         2.Display Magazine Detail
3.Order Magazine                        0.Exit

FOR SHOP OWNER................
4.Receive New Issues
••••••••••••••••••••••••••••••••••••••••••••••••••••••••
Choose your Operation :
1
Enter title : Express
Enter price:  20
Enter currently available copies : 30
Enter the Issue Date of Currently Available Copies[dd/mm/yyyy] : 12/09/2021
----------------------------------------------------------------------------------------------------------------                                        MENU FOR MAGAZINE

FOR USER........
1.Enter Magazine Detail         2.Display Magazine Detail
3.Order Magazine                        0.Exit

FOR SHOP OWNER................
4.Receive New Issues
••••••••••••••••••••••••••••••••••••••••••••••••••••••••
Choose your Operation :
2
Title      |   Price    |   Copies     |   IssueDate
Express      |   20.0     |   30    |   12/09/2021
----------------------------------------------------------------------------------------------------------------                                        MENU FOR MAGAZINE

FOR USER........
1.Enter Magazine Detail         2.Display Magazine Detail
3.Order Magazine                        0.Exit

FOR SHOP OWNER................
4.Receive New Issues
••••••••••••••••••••••••••••••••••••••••••••••••••••••••
Choose your Operation :
3
How many Copies you want :
35
Sorry!! Insufficient Stock...
----------------------------------------------------------------------------------------------------------------                                        MENU FOR MAGAZINE

FOR USER........
1.Enter Magazine Detail         2.Display Magazine Detail
3.Order Magazine                        0.Exit

FOR SHOP OWNER................
4.Receive New Issues
••••••••••••••••••••••••••••••••••••••••••••••••••••••••
Choose your Operation :
3
How many Copies you want :
26
You have Purchased 26 Copies of Magazine Express
You have to Pay Rs 520.0
----------------------------------------------------------------------------------------------------------------                                        MENU FOR MAGAZINE

FOR USER........
1.Enter Magazine Detail         2.Display Magazine Detail
3.Order Magazine                        0.Exit

FOR SHOP OWNER................
4.Receive New Issues
••••••••••••••••••••••••••••••••••••••••••••••••••••••••
Choose your Operation :
2
Title      |   Price    |   Copies     |   IssueDate
Express      |   20.0     |   4    |   12/09/2021
----------------------------------------------------------------------------------------------------------------                                        MENU FOR MAGAZINE

FOR USER........
1.Enter Magazine Detail         2.Display Magazine Detail
3.Order Magazine                        0.Exit

FOR SHOP OWNER................
4.Receive New Issues
••••••••••••••••••••••••••••••••••••••••••••••••••••••••
Choose your Operation :
4
Enter New Issue Date [dd/mm/yyyy] :
06/10/2021
Enter Total no. of New Copies Ordered :
36
The Magazine 'Express' with Issue Date ''06/10/2021" Available !!!
----------------------------------------------------------------------------------------------------------------                                        MENU FOR MAGAZINE

FOR USER........
1.Enter Magazine Detail         2.Display Magazine Detail
3.Order Magazine                        0.Exit

FOR SHOP OWNER................
4.Receive New Issues
••••••••••••••••••••••••••••••••••••••••••••••••••••••••
Choose your Operation :
2
Title      |   Price    |   Copies     |   IssueDate
Express      |   20.0     |   40    |   12/09/2021
----------------------------------------------------------------------------------------------------------------                                        MENU FOR MAGAZINE

FOR USER........
1.Enter Magazine Detail         2.Display Magazine Detail
3.Order Magazine                        0.Exit

FOR SHOP OWNER................
4.Receive New Issues
••••••••••••••••••••••••••••••••••••••••••••••••••••••••
Choose your Operation :
0
Choose..........
1.Book
2.Magazine
3.Total Sale of Publication
4.Total Revenue of Publication
0.To Terminate
========================================================3
Total Publication Sale = Rs 1900.0
Choose..........
1.Book
2.Magazine
3.Total Sale of Publication
4.Total Revenue of Publication
0.To Terminate
========================================================4
Total Revenue of Publication = Rs 2300.0
Choose..........
1.Book
2.Magazine
3.Total Sale of Publication
4.Total Revenue of Publication
0.To Terminate
========================================================0

[Program finished]*/