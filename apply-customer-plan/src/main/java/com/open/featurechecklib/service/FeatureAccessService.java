package com.open.featurechecklib.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.open.featurechecklib.model.Feature;
import com.open.featurechecklib.model.SubscriptionPlan;

@Service
public class FeatureAccessService {
	
	@Autowired
	Map<String, SubscriptionPlan> plans;

    public boolean isFeatureAvailable(String planName, String featureName, String constraintKey, Object value) {
        SubscriptionPlan plan = plans.get(planName);
        if (plan == null) return false;

        Feature feature = plan.getFeature(featureName);
        if (feature == null) return false;

        if (!feature.isConstraintPresent(constraintKey)) return false;

        Object constraintValue = feature.getConstraint(constraintKey);
        return value.equals(constraintValue);
    }

    public Object getFeatureConstraint(String planName, String featureName, String constraintKey) {
    	
        SubscriptionPlan plan = plans.get(planName);
        if (plan == null) return null;

        Feature feature = plan.getFeature(featureName);
        if (feature == null) return null;

        return feature.getConstraint(constraintKey);
    }
}

