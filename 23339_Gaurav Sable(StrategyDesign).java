//Strategy Design Pattern
//23339_Gaurav Sable
//Batch :- SE11(F11)

import java.util.*;

//Class to get items details that are purchased
class Item {
	private String code;
	private float Price;
	Item(String code, float Price) {
		this.code = code;
		this.Price = Price;
	}
	public String getcode() {
		return code;
	}
	public float getPrice() {
		return Price;
	}
}

//To collect items in an arraylist
class ShoppingCart {
	List <Item> items;
	
	//Initialising arraylist
	ShoppingCart() {
		this.items = new ArrayList<Item>();
	}
	
	//adding items to arraylist
	public void addItem(Item item) {
		this.items.add(item);
	}
	
	//Remove items from arraylist
	public void removeItem(Item item) {
		this.items.remove(item);
	}
	
	//Calculates total sum prices of items stored in arraylist 
	public int calculateTotal() {
		int sum = 0;
		for (Item i : items) {
			sum += i.getPrice();
		}
		return sum;
	}
	
	//Choose payment strategy to make payment
	public void pay(PaymentStrategy paymentMethod) {
		int amount = calculateTotal();
		paymentMethod.pay(amount);
	}
}

//PaymentStrategy interface
interface PaymentStrategy {
	public void pay(int amount);
}

//Implements Paypal payment strategy
class PaypalStrategy implements PaymentStrategy {
	private String emailId;
	private String password;
	
	//Get required detail to make payment
	PaypalStrategy(String email, String pwd) {
		this.emailId = email;
		this.password = pwd;
	}
	
	//Done the payment
	public void pay(int amount) {
		System.out.println(amount + " paid using Paypal.");
	}
}

//Implements Credit/debit card payment strategy
class CreditCardStrategy implements PaymentStrategy {
	private String name;
	private double cardNumber;
	private int cvv;
	private String dateOfExpiry;
	
	//Get required details to make payment
	CreditCardStrategy(String nm, double ccNum, int cvv,
					   String expiryDate) {
		this.name = nm;
		this.cardNumber = ccNum;
		this.cvv = cvv;
		this.dateOfExpiry = expiryDate;
	}
	
	//Pay using card
	public void pay(int amount) {
		System.out.println(amount + " paid with credit/debit card");
	}
}

//Implements Bitcoin payment strategy
class BitCoin implements PaymentStrategy {
	private String Address;
	
	//Get required Detail to make payment
	BitCoin(String Address) {
		this.Address = Address;
	}
	
	//Pay using bitcoin
	public void pay(int amount) {
		System.out.println(amount + " Payment Done!!! \nBitcoin wallet address =  " + Address);
	}
}

//Start of main class 
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ShoppingCart s = new ShoppingCart();
		int n, ch;
		String Icode;
		float cost;
		
		//Get the details and no of items purchased
		System.out.println("\t\t***Welcome to ShoppingCart***\n");
		System.out.println("Enter no. of items purchased : ");
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.print("Enter code of item " + (i + 1) + " : ");
			Icode = sc.next();
			System.out.print("Enter Price of item " + (i + 1) + " : Rs ");
			cost = sc.nextInt();
			Item i1 = new Item(Icode, cost);
			s.addItem(i1);
		}
		
		//Chooses the payment strategy
		System.out.println("\nChoose Payment Method\n\t1.CreditCard\n\t2.Paypal\n\t3.BitCoin\nEnter Choice : ");
		ch = sc.nextInt();
		switch (ch) {
		case 1 :
			String nm, doe;
			int cvv;
			double cn;
			System.out.print("\tCard holder Name :: ");
			nm = sc.nextLine();
			nm = sc.nextLine();
			System.out.print("\tCard Number :: ");
			cn = sc.nextDouble();
			System.out.print("\tEnter cvv :: ");
			cvv = sc.nextInt();
			System.out.print("\tCard Expire Date :: ");
			doe = sc.next();
			s.pay(new CreditCardStrategy(nm, cn, cvv, doe));
			break;
		case 2 :
			String email, pass;
			System.out.print("\tEnter Email :: ");
			email = sc.next();
			System.out.print("\tPassWord :: ");
			pass = sc.next();
			s.pay(new PaypalStrategy(email, pass));
			break;
		case 3 :
			String ad;
			System.out.print("\tEnter Address :: ");
			ad = sc.next();
			s.pay(new BitCoin(ad));
			break;
		default :
			System.out.println("Invalid Choice!!!");
		}
		System.out.println("\n******Thank You!!!******");
	}
}