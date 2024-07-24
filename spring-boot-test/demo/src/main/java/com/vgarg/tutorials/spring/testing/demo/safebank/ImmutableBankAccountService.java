package com.vgarg.tutorials.spring.testing.demo.safebank;

import java.util.concurrent.atomic.AtomicReference;

public class ImmutableBankAccountService {
	private final AtomicReference<ImmutableBankWithTwoAccounts> bankRef;

	public ImmutableBankAccountService(int balanceofa, int balanceofb) {
		bankRef = new AtomicReference<>(new ImmutableBankWithTwoAccounts(balanceofa, balanceofb));
	}

	public boolean atob(int amount) {

			ImmutableBankWithTwoAccounts currentBank = bankRef.get();

			ImmutableBankWithTwoAccounts updatedBank = currentBank.atob(amount);
			if (bankRef.compareAndSet(currentBank, updatedBank)) {
				System.out.println("atob done" +updatedBank);
				return true; // transaction successful
			} else {
				System.out.println("atob failed" +updatedBank);
				return false;
			}
		
	}

	public boolean btoa(int amount) {
		while (true) {
			ImmutableBankWithTwoAccounts currentBank = bankRef.get();

			ImmutableBankWithTwoAccounts updatedBank = currentBank.btoa(amount);			
			if (bankRef.compareAndSet(currentBank, updatedBank)) {
				System.out.println("btoa done"+updatedBank);
				return true; // transaction successful
			} else {
				System.out.println("btoa failed"+updatedBank);
				return false; // transaction successful
				
			}
		}
	}

	public String getBalance() {
		return bankRef.get().toString();
	}

}