//Case Study on Banking Solution
//23339_Gaurav Sable
//Batch : SE11(F11)

import java.util.*;
//Customer Class
class Customer {
	private String name;
	private int age;
	public void Setname(String name) {
		this.name = name;
	}
	public String getname() {
		return name;
	}
	public void Setage(int age) {
		this.age = age;
	}
	public int getage() {
		return age;
	}
}

//Abstract Account class to show the banking interface
abstract class Account {
	private double balance;
	private int accID;
	private String accType;
	private Customer c;
	void Setbalance(double bal) {
		this.balance = bal;
	}
	double getbalance() {
		return balance;
	}
	void setAccID(int Id) {
		this.accID = Id;
	}
	int getID() {
		return accID;
	}
	void setType(String accType) {
		this.accType = accType;
	}
	String getType() {
		return accType;
	}
	void setCustomer(Customer c) {
		this.c = c;
	}
	Customer getCustomer() {
		return c;
	}

	//Method to check withdrawal is possible or not according min balance criteria of bank
	public abstract boolean
	Withdraw(double amount);
}

//Saving acvount class inherited from account class
class Savingacc extends Account {
	private static double minbal = 500.0;
	public double getminbal() {
		return minbal;
	}

	//Overriding the withdrawal method from parent class
	public boolean Withdraw(double amount) {
		if (getbalance() - amount > minbal) {
			Setbalance(getbalance() - amount);
			return true;
		} else {
			return false;
		}
	}
}

//Bank class
class Bank {
	private int accountid;
	Scanner sc = new Scanner(System.in);
	Savingacc s = new Savingacc();
	Customer cnew = new Customer();

	//Method to create Saving account
	public Savingacc createAccount() {
		System.out.println("Please Enter Choice : ");
		sc.nextLine();

		System.out.print("Enter your name: ");
		String customername = sc.nextLine();
		cnew.Setname(customername);

		System.out.print("Enter your age: ");
		int customerage = sc.nextInt();
		if (customerage < 18) {
			do {
				System.out.print("Minimum age should be 18 to create an account.\nPlease enter valid age: ");
				customerage = sc.nextInt();
			} while (customerage < 18);
		}
		cnew.Setage(customerage);

		s.setCustomer(cnew);

		System.out.print("Enter your account Id: ");
		boolean flag = true;
		do {
			try {
				accountid = sc.nextInt();
				s.setAccID(accountid);
				flag = true;
			} catch (InputMismatchException e) {
				sc.nextLine();
				System.out.print("Invalid Account ID.\nEnter again : ");
				//accountid = sc.nextInt();
				flag = false;
			}
		} while (flag == false);

		System.out.print("Enter your account type (Saving or Current) : ");
		String accounttype = sc.next();
		s.setType(accounttype);

		while(flag == true) 
		{
			System.out.print("Enter balance : ");
		double balance = sc.nextDouble();
		if(balance>=0)
		{
		s.Setbalance(balance);
		if(balance<500)
		{
			System.out.println("∆ Please Note : Your Balance is less than minimum balance Rs 500.\nCharges will be applied to your transactions....");
		}
		flag = false;
		break;
		}
		else if(balance<0)
		{
			System.out.println("Balance cant be less than zero....");
		}
		}
		return s;
	}

	//Method to get withdarwal
	void getWithdrawAmount() {
		System.out.print("Enter the amount you want to withdraw: ");
		double amount = sc.nextDouble();

		//Check for transaction limit
		if (amount > 20000) {
			System.out.println("Withdrawal failed. Maximum limit of withdrawal in one transaction is Rs.20000.");
		} else {
			if (s.Withdraw(amount) == true) {
				System.out.println("Withdrawal successful. Balance is: " + s.getbalance());
			} else
				System.out.println("Sorry!!! Not enough balance\nBalance should not br less than Minimum balance which is " + s.getminbal());
		}
	}

	//Method to deposit amount
	public void depositAmount(double amount) {
		double bal = s.getbalance() + amount;
		s.Setbalance(bal);
		System.out.println("Amount deposited successfully. Balance is: " + s.getbalance());
	}

	//Method to check balance
	public void checkBalance() {
		System.out.println("Balance is: " + s.getbalance());
	}

	//Method to display account information
	public void displayAccountInformation() {
		System.out.println("Welcome " + cnew.getname() + "! Following are your account details:");
		System.out.println("Age :" + cnew.getage());
		System.out.println("Account Id: " + s.getID());
		System.out.println("Account Type: " + s.getType());
		System.out.println("Balance: " + s.getbalance());
		System.out.println("Minimum balance : " + s.getminbal());
	}
}

//Start of Main
public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Savingacc a;
		Bank b = new Bank();
		int ch;
		while (true) {
			System.out.println("\nPress\n\t1.Create Account\n\t2.Display Account\n\t3.Check Balance" + "\n\t4.Deposit Amount\n\t5.Withdraw Amount\n\t0.Exit\n=>Enter your Choice : ");
			ch = s.nextInt();
			if (ch == 0) {
				break;
			}
			switch (ch) {
			case 1 :
				a = b.createAccount();
				System.out.println("=".repeat(56));
				break;
			case 2 :
				b.displayAccountInformation();
				System.out.println("=".repeat(56));
				break;
			case 3 :
				b.checkBalance();
				System.out.println("=".repeat(56));
				break;
			case 4 :
				System.out.print("Enter the amount you want to deposit: ");
				double amount = s.nextDouble();
				b.depositAmount(amount);
				System.out.println("=".repeat(56));
				break;
			case 5 :
				b.getWithdrawAmount();
				System.out.println("=".repeat(56));
				break;
			default :
				System.out.println("Invalid Choice!!!");
				System.out.println("=".repeat(56));
				break;
			}
		}
	}
}


/*Output of Program

Press
        1.Create Account
        2.Display Account
        3.Check Balance
        4.Deposit Amount
        5.Withdraw Amount
        0.Exit
=>Enter your Choice :
1
If it ask Please Enter Choice again
1
Enter your name: Gaurav Sable
Enter your age: 17
Minimum age should be 18 to create an account.
Please enter valid age: 19
Enter your account Id: 7365281
Enter your account type: Saving
Enter balance: 2500
========================================================
Press
        1.Create Account
        2.Display Account
        3.Check Balance
        4.Deposit Amount
        5.Withdraw Amount
        0.Exit
=>Enter your Choice :
2
Welcome Gaurav Sable! Following are your account details:
Age :19
Account Id: 7365281
Account Type: Saving
Balance: 2500.0
Minimum balance : 500.0
========================================================
Press
        1.Create Account
        2.Display Account
        3.Check Balance
        4.Deposit Amount
        5.Withdraw Amount
        0.Exit
=>Enter your Choice :
3
Balance is: 2500.0
========================================================
Press
        1.Create Account
        2.Display Account
        3.Check Balance
        4.Deposit Amount
        5.Withdraw Amount
        0.Exit
=>Enter your Choice :
4
Enter the amount you want to deposit: 5000
Amount deposited successfully. Balance is: 7500.0
========================================================
Press
        1.Create Account
        2.Display Account
        3.Check Balance
        4.Deposit Amount
        5.Withdraw Amount
        0.Exit
=>Enter your Choice :
5
Enter the amount you want to withdraw: 7100
Sorry!!! Not enough balance
Balance should not br less than Minimum balance which is 500.0
========================================================
Press
        1.Create Account
        2.Display Account
        3.Check Balance
        4.Deposit Amount
        5.Withdraw Amount
        0.Exit
=>Enter your Choice :
5
Enter the amount you want to withdraw: 2500
Withdrawal successful. Balance is: 5000.0
========================================================
Press
        1.Create Account
        2.Display Account
        3.Check Balance
        4.Deposit Amount
        5.Withdraw Amount
        0.Exit
=>Enter your Choice :
2
Welcome Gaurav Sable! Following are your account details:
Age :19
Account Id: 7365281
Account Type: Saving
Balance: 5000.0
Minimum balance : 500.0
========================================================
Press
        1.Create Account
        2.Display Account
        3.Check Balance
        4.Deposit Amount
        5.Withdraw Amount
        0.Exit
=>Enter your Choice :
0

[Program finished]

*/