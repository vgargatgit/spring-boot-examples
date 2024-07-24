package com.open.featurechecklib.model;

import java.util.HashMap;
import java.util.Map;

public class SubscriptionPlan {
    private String name;
    private Map<String, Feature> features;

    public SubscriptionPlan(String name) {
        this.name = name;
        this.features = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addFeature(Feature feature) {
        features.put(feature.getName(), feature);
    }

    public Feature getFeature(String featureName) {
        return features.get(featureName);
    }
}
