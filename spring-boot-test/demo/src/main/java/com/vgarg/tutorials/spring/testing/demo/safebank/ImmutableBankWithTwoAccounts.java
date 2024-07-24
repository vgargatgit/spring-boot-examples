package com.vgarg.tutorials.spring.testing.demo.safebank;

public final class ImmutableBankWithTwoAccounts {

	private final int balanceOfA;
	private final int balanceOfB;

	public ImmutableBankWithTwoAccounts(int balanceOfA, int balanceOfB) {
		this.balanceOfA = balanceOfA;
		this.balanceOfB = balanceOfB;
	}

	public ImmutableBankWithTwoAccounts atob(int amount) {
		while (true) {
			if (balanceOfA >= amount) {
				return new ImmutableBankWithTwoAccounts(balanceOfA - amount, balanceOfB + amount);
			}
		}
	}

	public ImmutableBankWithTwoAccounts btoa(int amount) {
		while (true) {
			if (balanceOfB >= amount) {
				return new ImmutableBankWithTwoAccounts(balanceOfA + amount, balanceOfB - amount);
			}
		}
	}

	@Override
	public String toString() {
		return "ImmutableBankWithTwoAccounts [BalanceOfA= " + balanceOfA + "BalanceOfB= " +balanceOfB  +"TotalBalance= " +getTotalBalance() +"]";
	}

	private int getTotalBalance() {
		return balanceOfA + balanceOfB;
	}
}