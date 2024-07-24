package com.open.orderservice.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.open.featurechecklib.model.Feature;
import com.open.featurechecklib.model.SubscriptionPlan;

@Configuration
public class PlanConfiguration {
	
	@Bean
	public Map<String, SubscriptionPlan> plans() {
		// This bean can also be fetched from a remote service that centrally manages features
        // Define features with constraints
        Feature freeOrderFeature = new Feature("ORDER_LINE_ITEMS");
        freeOrderFeature.addConstraint("min", 0);
        freeOrderFeature.addConstraint("max", 3);

        Feature silverOrderFeature = new Feature("ORDER_LINE_ITEMS");
        silverOrderFeature.addConstraint("min", 3);
        silverOrderFeature.addConstraint("max", 6);

        // Define subscription plans and add features to them
        SubscriptionPlan freePlan = new SubscriptionPlan("Free");
        freePlan.addFeature(freeOrderFeature);

        SubscriptionPlan silverPlan = new SubscriptionPlan("Silver");
        silverPlan.addFeature(silverOrderFeature);

        // Store plans in a map
        Map<String, SubscriptionPlan> plans = new HashMap<>();
        plans.put(freePlan.getName(), freePlan);
        plans.put(silverPlan.getName(), silverPlan);

        return plans;
    }
}
