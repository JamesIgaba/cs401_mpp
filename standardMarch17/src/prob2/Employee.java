package prob2;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	String name;
	private List<Account> list = new ArrayList<>();
	public Employee(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}

	public void addAccount(Account acct) {
		list.add(acct);
	}
	
	
	public double computeUpdatedBalanceSum() {
		double sum = 0;
		for(Account a: list)
			sum+=a.computeUpdatedBalance();
		return sum;
	}
}
