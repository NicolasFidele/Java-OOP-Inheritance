import java.util.Scanner;

public class Bank {

	public static void main(String[] args) {
		//user input
		Scanner Bal = new Scanner(System.in);
		System.out.print("Please enter Account Balance: ");  
		double actualBalance= Bal.nextDouble();  
		
		Scanner TT = new Scanner(System.in);
		System.out.print("Enter Transaction Type. [1] for Debit, [2] for Credit: ");
		//next() method returns the user input as a string, chatAt(0) method returns the first character in that string.
		char choice = TT.next().charAt(0);   
		//user chooses between 1 or 2
		switch(choice) {
		//if '1' is chosen
		case '1':
			Scanner Debit = new Scanner(System.in);
			System.out.print("Enter the debit amount: ");
			double transactionAmount = Debit.nextDouble();  
			bankAccount transac1 = new bankAccount(actualBalance, transactionAmount);  //call constructor
			double amount = transac1.debitAccount();         //call method to debit account
			System.out.println(transac1.displayBalance(amount));    //call method display
			bankAccount.saveTransaction = amount;   ///set class variable to value of new balance
			break;  //terminate sequence - important so that if also 2nd case is true it doesn't consider also the second case
		//if '2' is chosen
		case '2':
			Scanner Credit = new Scanner(System.in);
			System.out.print("Enter the debit amount: ");
			double transactionAmount2 = Credit.nextDouble();  
			bankAccount transac2 = new bankAccount(actualBalance, transactionAmount2); //call constructor
			double amount2 = transac2.creditAccount();    //call method to credit account
			System.out.println(transac2.displayBalance(amount2));   //call method display
			bankAccount.saveTransaction = amount2;  //set class variable to value of new balance
			break;  
		}
		//create object finalTransac to instantiate Derived class
		Interest finalTransac = new Interest(bankAccount.saveTransaction);
		//store return value of method Adjust into variable
		double finalTransaction = finalTransac.Adjust();
		//use variable as parameter in overridden displayBalance method
		System.out.println(finalTransac.displayBalance(finalTransaction));
	}

}
