package com.open.orderservice.request;

import com.open.featurechecklib.model.PlanProvider;

public class User implements PlanProvider {
	
	private final String plan;
	
	public User(String plan) {
		this.plan = plan;
	}
	
	@Override
	public String getPlan() {
		return plan;
	}
	
}
