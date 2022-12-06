import java.util.*;

class Account{
	String name;
	String userName;
	String password;
	String accountNo;
	float balance= 0f;
	int transaction = 0;
	String transactionHistory = "";
	
	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Your Name: ");
		this.name = sc.nextLine();
		System.out.println("Enter Your User Name: ");
		this.userName = sc.nextLine();
		System.out.println("Set Your Password: ");
		this.password = sc.nextLine();
		System.out.println("Enter Your Account Number: ");
		this.accountNo = sc.nextLine();
		System.out.println("REGISTRATION SUCCESSFULL");
	}
	
	public boolean login() {
		boolean isLoggedIn = false;
		Scanner sc = new Scanner(System.in);
		while( !isLoggedIn ) {
			System.out.print("\nEnter Your UserName: ");
			String User = sc.nextLine();
			if(User.equals(userName)) {
				while( !isLoggedIn) {
					System.out.println("Enter Your Password: ");
					String Password = sc.nextLine();
					if(Password.equals(password)) {
						System.out.println("Login SuccessFull");
						isLoggedIn = true;
					}
					else
						System.out.println("Incorrect Password");
				}
			}
			else {
				System.out.println("Username not found");
			}
		}
		return isLoggedIn;
	}
	
	public void withdraw() {
		System.out.println("Enter amount to be withdrawn");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try {
			if(balance >= amount) {
				transaction++;
				balance -= amount;
				System.out.println("Withdraw Successfully");
				String str = amount + " Debit\n";
				transactionHistory = transactionHistory.concat(str);
			}
			else {
				System.out.println("Insufficienct Balance");
			}
		}
		catch(Exception e) {
		}
	}
	
	public void deposit() {
		System.out.println("Enter amount to Deposit: ");
		Scanner sc = new Scanner(System.in);
		float amount = sc.nextFloat();
		try {
			if(amount <= 100000f) {
				transaction++;
				balance += amount;
				System.out.println("Deposit Successfull");
				String str = amount +" Credit\n";
				transactionHistory = transactionHistory.concat(str);
			}
			else
				System.out.println("Deposity Limit Exceeded\nLimit is 100000");
		}
		catch(Exception e) {
			
		}
	}
	
	public void transfer() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Receipients Name");
		String recName = sc.nextLine();
		System.out.print("Enter Receipients Account Number\n");
		String recAccNum = sc.nextLine();
		System.out.println("Enter Amount to be Transferred\n");
		float amount = sc.nextFloat();
		
		try {
			if(balance >= amount) {
				if(amount <= 50000f) {
					transaction++;
					balance -= amount;
					System.out.println(amount+" transferred successfully to "+recName+" with account number "+recAccNum);
					String str = amount +" tranferred to account number "+recAccNum+"\n";
					transactionHistory = transactionHistory.concat(str);
				}
				else {
					System.out.println("Transfer Limit Exceeded\nLimit is 50000.0");
				}
			}
			else {
				System.out.println("Insufficient Balance");
			}
		}
		catch(Exception e) {
			
		}
	}
	
	public void checkBalance() {
		System.out.println("Current Balance is: "+balance);
	}
	
	public void history() {
		if(transaction == 0)
			System.out.println("No Transactions Available");
		else
			System.out.println(transactionHistory);
	}
	
}





public class Task3Java {
	
	public static int takeIntegerInput(int limit) {
		int input = 0;
		boolean flag = false;
		
		while(!flag) {
			try {
				Scanner sc = new Scanner(System.in);
				input = sc.nextInt();
				flag = true;
				
				if(flag && input > limit ||input < 1) {
					System.out.println("Choose the number between 1 to "+limit);
					flag = false;
				}
			}
			catch(Exception e) {
				System.out.println("Enter Number Only");
				flag = false;
			}
			
		};
		return input;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome");
		System.out.println("Choose an option");
		System.out.println("1.Register\n2.Exit");
		int choice = takeIntegerInput(3);
		
		if(choice ==1 ) {
			Account a = new Account();
			a.register();
			while(true) {
				System.out.println("Choose an option");
				System.out.println("1. Login\n2. Exit");
				int ch = takeIntegerInput(2);
				if(ch == 1) {
					if(a.login()) {
						System.out.println("Welcome "+a.userName);
						while(true) {
							System.out.println("Choose an option");
							System.out.println("1. Withdraw\n2. Deposit\n3. Transfer\n4.Transaction History\n5. Check Balance\n6. Quit");
							int c = takeIntegerInput(6);
							switch(c) {
								case 1: a.withdraw();
										break;
								case 2: a.deposit();
										break;
								case 3: a.transfer();
										break;
								case 4: a.history();
										break;
								case 5: a.checkBalance();
										break;
								case 6: System.out.println("Thankyou for Visiting.\n");
										System.exit(0);
										break;
							}
						}
					}
				}
				else
					System.exit(0);
			}
		}
		else
			System.exit(0);
	}

}
