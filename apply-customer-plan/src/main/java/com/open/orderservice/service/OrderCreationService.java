package com.open.orderservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.open.featurechecklib.annotation.FeatureCheck;
import com.open.orderservice.OrderserviceApplication;
import com.open.orderservice.request.OrderRequest;
import com.open.orderservice.request.User;

@Service
public class OrderCreationService {
	private static final Logger logger = LoggerFactory.getLogger(OrderserviceApplication.class);

    @FeatureCheck(featureName = "ORDER_LINE_ITEMS", constraintKey = "max")
    public void createOrder(OrderRequest order, User user) {        
    	logger.info("OrderRequest processed");
    }
    
}
