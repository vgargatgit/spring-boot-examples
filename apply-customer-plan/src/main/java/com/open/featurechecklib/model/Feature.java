package com.open.featurechecklib.model;

import java.util.Map;
import java.util.HashMap;

public class Feature {
    private String name;
    private Map<String, Object> constraints;

    public Feature(String name) {
        this.name = name;
        this.constraints = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void addConstraint(String key, Object value) {
        constraints.put(key, value);
    }

    public Object getConstraint(String key) {
        return constraints.get(key);
    }

    public boolean isConstraintPresent(String key) {
        return constraints.containsKey(key);
    }
}