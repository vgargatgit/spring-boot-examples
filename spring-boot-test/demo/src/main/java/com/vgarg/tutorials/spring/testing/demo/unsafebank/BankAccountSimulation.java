package com.vgarg.tutorials.spring.testing.demo.unsafebank;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BankAccountSimulation {
	
	public static void main(String[] args) throws InterruptedException {
		
        BankWithTwoAccounts bank = new BankWithTwoAccounts(1000, 1000); // Initial balance

        Runnable atobTask = () -> {
            for (int i = 0; i < 100; i++) {
            	bank.atob(10);
            }
        };

        Runnable btoaTask = () -> {
            for (int i = 0; i < 100; i++) {
            	bank.btoa(10);
            }
        };

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // Start multiple deposit and withdraw threads
        for (int i = 0; i < 5; i++) {
            executorService.submit(atobTask);
            executorService.submit(btoaTask);
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("Final balance: " + bank);
    }
}

