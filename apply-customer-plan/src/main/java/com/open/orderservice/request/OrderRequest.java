package com.open.orderservice.request;

import com.open.featurechecklib.model.FeatureUsage;
import com.open.featurechecklib.model.FeatureUsageProvider;

public class OrderRequest implements FeatureUsageProvider {
    private final int lineItemsCount;

    public OrderRequest(int lineItemsCount) {
        this.lineItemsCount = lineItemsCount;
    }

    @Override
    public FeatureUsage getFeatureUsage() {
        return new FeatureUsage("ORDER_LINE_ITEMS", lineItemsCount);
    }

    public int getLineItems() {
        return lineItemsCount;
    }

}
