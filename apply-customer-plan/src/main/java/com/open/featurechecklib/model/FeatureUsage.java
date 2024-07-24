package com.open.featurechecklib.model;

public class FeatureUsage {
    private String featureName;
    private int usage;

    public FeatureUsage(String featureName, int usage) {
        this.featureName = featureName;
        this.usage = usage;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }
}
