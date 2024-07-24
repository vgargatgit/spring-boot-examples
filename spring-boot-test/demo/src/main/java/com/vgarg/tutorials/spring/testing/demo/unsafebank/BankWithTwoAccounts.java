package com.vgarg.tutorials.spring.testing.demo.unsafebank;

public class BankWithTwoAccounts {
    private int balanceOfA;
    private int balanceOfB;
    
    public BankWithTwoAccounts(int balanceOfA, int balanceOfB) {
        this.balanceOfA = balanceOfA;
        this.balanceOfB = balanceOfB;
    }

    public void atob(int amount) {
        while (true) {
        	if (balanceOfA >= amount) {
        		this.balanceOfA -= amount;
        		this.balanceOfB += amount;
        		return;
        	}
        }
    }

    public void btoa(int amount) {
        while (true) {
        	if (balanceOfB >= amount) {
        		this.balanceOfB -= amount;
        		this.balanceOfA += amount;
        		return;
        	}
        }
    }

	@Override
	public String toString() {
		return "BankWithTwoAccounts [BalanceOfA= " + balanceOfA + "BalanceOfB= " +balanceOfB  +"TotalBalance= " +getTotalBalance() +"]";
	}

	private int getTotalBalance() {
		return balanceOfA + balanceOfB;
	}
        
}

