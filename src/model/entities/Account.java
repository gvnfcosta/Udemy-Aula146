package model.entities;

import model.exceptions.DomainException;

public class Account {
	
	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account() {
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}
	
	
	public void deposit(double amount) {
		this.balance += amount;
	}
	
	public void withdraw(double amount) {
		validateWithdraw(amount);
		balance -= amount;
	}
		
		
	private void validateWithdraw(double amount) {
		if (amount > getWithdrawLimit()) {
			throw new DomainException ("The amount exceeds withdraw limit");
		}
		if (amount > getBalance()) {
			throw new DomainException ("Not enough balance");
		}
/*
  		if (amount >= balance && amount < balance + withdrawLimit) {
 			throw new DomainException ("Not enough balance");
		}else if (amount >= balance + withdrawLimit) {
			throw new DomainException ("The amount exceeds withdraw limit");
		}
		this.balance -= amount;
*/
	}


}
