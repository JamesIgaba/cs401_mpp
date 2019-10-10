package prob2;

public class CheckingAccount extends Account{
	private double balance;
	private double monthlyFee;
	private String acctId;
	
	public CheckingAccount(String acctId, double fee, double startBalance) {
		this.acctId = acctId;
		this.monthlyFee = fee;
		this.balance = startBalance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getMonthlyFee() {
		return monthlyFee;
	}

	public void setMonthlyFee(double monthlyFee) {
		this.monthlyFee = monthlyFee;
	}

	public String getAcctId() {
		return acctId;
	}

	public void setAcctId(String acctId) {
		this.acctId = acctId;
	}
	
	public double computeUpdatedBalance() {
		double balance = getBalance();
		balance -= (getMonthlyFee());
		return balance;
	}

}
