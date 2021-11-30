
public class bankAccount {
	//class variable that will store the final Balance when debit/credit has been done
	static double saveTransaction;
	//instance variables - set to private to be available only when object created
	private double Balance;
	private double transactionAmount;
	//constructor with two parameters
	public bankAccount(double accBalance, double newTransactionAmount) {
		Balance = accBalance;
		transactionAmount = newTransactionAmount;
	}
	public bankAccount(double accBalance) {
		Balance = accBalance;
	}
	//setters and getters
	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {
		Balance = balance;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	//method to debit account
	public double debitAccount() {
		double newBalance = getBalance() - getTransactionAmount();
		return newBalance;
	}
	//method to credit account
	public double creditAccount() {
		double newBalance = getBalance() + getTransactionAmount();
		return newBalance;
	}
	//method to display new balance
	public String displayBalance(double newBalance) {
		return ("Your new Balance is Rs" + String.format("%.2f",newBalance));
	}
}
//derived class
class Interest extends bankAccount{
	//overridden constructor containing only one parameter
	public Interest(double accBalance) {
		//call constructor from Base class
		super(accBalance);
	}
	//method to add a value to the new Balance
	public double Adjust() {
		double updatedBalance = saveTransaction + (saveTransaction*0.05);
		return updatedBalance;
	}
	//overridden display method
	public String displayBalance(double newBalance) {
		System.out.println("Your balance has been updated. " + "\r\n" + "Adding Interest to your account." 
				+ "\r\n" + "Interest credited is Rs" + String.format("%.2f",(saveTransaction*0.05))); 
		return ("Your new Balance is Rs" + String.format("%.2f",newBalance) + 
				"\r\n" + "Thank you for making business with us.");
	}
}
	