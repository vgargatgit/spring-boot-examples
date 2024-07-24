package com.open.orderservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

import com.open.featurechecklib.exception.FeatureAccessException;
import com.open.orderservice.request.OrderRequest;
import com.open.orderservice.request.User;
import com.open.orderservice.service.OrderCreationService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableLoadTimeWeaving
@ComponentScan(basePackages = { "com.open.orderservice", "com.open.featurechecklib" })
public class OrderserviceApplication implements CommandLineRunner {

	@Autowired
	private OrderCreationService service;
	
	private static final Logger logger = LoggerFactory.getLogger(OrderserviceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OrderserviceApplication.class, args);
	}

	@Override
	public void run(String... args) {
		
		testRunWithUserAndItems("Free", 3);
		testRunWithUserAndItems("Free", 5);
		testRunWithUserAndItems("Silver", 5);
	}

	private void testRunWithUserAndItems(String plan, int noOfItems) {
		OrderRequest orderRequest = new OrderRequest(noOfItems);

		try {
			User freeUser = new User(plan);
			service.createOrder(orderRequest, freeUser);
		} catch (FeatureAccessException e) {
			logger.debug("Failed to create order: {}", e.getMessage());
		}		
	}
}